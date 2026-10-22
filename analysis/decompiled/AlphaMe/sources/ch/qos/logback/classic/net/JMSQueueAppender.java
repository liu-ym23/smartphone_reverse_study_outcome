package ch.qos.logback.classic.net;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.net.JMSAppenderBase;
import ch.qos.logback.core.spi.PreSerializationTransformer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.Context;
import javax.naming.NamingException;

/* loaded from: classes.dex */
public class JMSQueueAppender extends JMSAppenderBase<ILoggingEvent> {
    static int SUCCESSIVE_FAILURE_LIMIT = 3;
    String qcfBindingName;
    String queueBindingName;
    QueueConnection queueConnection;
    QueueSender queueSender;
    QueueSession queueSession;
    int successiveFailureCount = 0;
    private PreSerializationTransformer<ILoggingEvent> pst = new LoggingEventPreSerializationTransformer();

    public String getQueueBindingName() {
        return this.queueBindingName;
    }

    public QueueConnection getQueueConnection() {
        return this.queueConnection;
    }

    public String getQueueConnectionFactoryBindingName() {
        return this.qcfBindingName;
    }

    public QueueSender getQueueSender() {
        return this.queueSender;
    }

    public QueueSession getQueueSession() {
        return this.queueSession;
    }

    public void setQueueBindingName(String str) {
        this.queueBindingName = str;
    }

    public void setQueueConnectionFactoryBindingName(String str) {
        this.qcfBindingName = str;
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() throws NamingException {
        try {
            Context contextBuildJNDIContext = buildJNDIContext();
            QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) lookup(contextBuildJNDIContext, this.qcfBindingName);
            String str = this.userName;
            if (str != null) {
                this.queueConnection = queueConnectionFactory.createQueueConnection(str, this.password);
            } else {
                this.queueConnection = queueConnectionFactory.createQueueConnection();
            }
            this.queueSession = this.queueConnection.createQueueSession(false, 1);
            this.queueSender = this.queueSession.createSender((Queue) lookup(contextBuildJNDIContext, this.queueBindingName));
            this.queueConnection.start();
            contextBuildJNDIContext.close();
        } catch (Exception e4) {
            addError("Error while activating options for appender named [" + this.name + "].", e4);
        }
        if (this.queueConnection == null || this.queueSession == null || this.queueSender == null) {
            return;
        }
        super.start();
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public synchronized void stop() {
        try {
            if (this.started) {
                this.started = false;
                try {
                    QueueSession queueSession = this.queueSession;
                    if (queueSession != null) {
                        queueSession.close();
                    }
                    QueueConnection queueConnection = this.queueConnection;
                    if (queueConnection != null) {
                        queueConnection.close();
                    }
                } catch (Exception e4) {
                    addError("Error while closing JMSAppender [" + this.name + "].", e4);
                }
                this.queueSender = null;
                this.queueSession = null;
                this.queueConnection = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ch.qos.logback.core.AppenderBase
    public void append(ILoggingEvent iLoggingEvent) {
        if (isStarted()) {
            try {
                ObjectMessage objectMessageCreateObjectMessage = this.queueSession.createObjectMessage();
                objectMessageCreateObjectMessage.setObject(this.pst.transform(iLoggingEvent));
                this.queueSender.send(objectMessageCreateObjectMessage);
                this.successiveFailureCount = 0;
            } catch (Exception e4) {
                int i4 = this.successiveFailureCount + 1;
                this.successiveFailureCount = i4;
                if (i4 > SUCCESSIVE_FAILURE_LIMIT) {
                    stop();
                }
                addError("Could not send message in JMSQueueAppender [" + this.name + "].", e4);
            }
        }
    }
}
