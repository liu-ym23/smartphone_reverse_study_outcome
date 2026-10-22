package ch.qos.logback.classic.net;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.net.JMSAppenderBase;
import ch.qos.logback.core.spi.PreSerializationTransformer;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.NamingException;

/* loaded from: classes.dex */
public class JMSTopicAppender extends JMSAppenderBase<ILoggingEvent> {
    static int SUCCESSIVE_FAILURE_LIMIT = 3;
    String tcfBindingName;
    String topicBindingName;
    TopicConnection topicConnection;
    TopicPublisher topicPublisher;
    TopicSession topicSession;
    int successiveFailureCount = 0;
    private PreSerializationTransformer<ILoggingEvent> pst = new LoggingEventPreSerializationTransformer();

    public String getTopicBindingName() {
        return this.topicBindingName;
    }

    public TopicConnection getTopicConnection() {
        return this.topicConnection;
    }

    public String getTopicConnectionFactoryBindingName() {
        return this.tcfBindingName;
    }

    public TopicPublisher getTopicPublisher() {
        return this.topicPublisher;
    }

    public TopicSession getTopicSession() {
        return this.topicSession;
    }

    public void setTopicBindingName(String str) {
        this.topicBindingName = str;
    }

    public void setTopicConnectionFactoryBindingName(String str) {
        this.tcfBindingName = str;
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() throws NamingException {
        try {
            Context contextBuildJNDIContext = buildJNDIContext();
            TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory) lookup(contextBuildJNDIContext, this.tcfBindingName);
            String str = this.userName;
            if (str != null) {
                this.topicConnection = topicConnectionFactory.createTopicConnection(str, this.password);
            } else {
                this.topicConnection = topicConnectionFactory.createTopicConnection();
            }
            this.topicSession = this.topicConnection.createTopicSession(false, 1);
            this.topicPublisher = this.topicSession.createPublisher((Topic) lookup(contextBuildJNDIContext, this.topicBindingName));
            this.topicConnection.start();
            contextBuildJNDIContext.close();
        } catch (Exception e4) {
            addError("Error while activating options for appender named [" + this.name + "].", e4);
        }
        if (this.topicConnection == null || this.topicSession == null || this.topicPublisher == null) {
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
                    TopicSession topicSession = this.topicSession;
                    if (topicSession != null) {
                        topicSession.close();
                    }
                    TopicConnection topicConnection = this.topicConnection;
                    if (topicConnection != null) {
                        topicConnection.close();
                    }
                } catch (Exception e4) {
                    addError("Error while closing JMSAppender [" + this.name + "].", e4);
                }
                this.topicPublisher = null;
                this.topicSession = null;
                this.topicConnection = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ch.qos.logback.core.AppenderBase
    public void append(ILoggingEvent iLoggingEvent) {
        if (isStarted()) {
            try {
                ObjectMessage objectMessageCreateObjectMessage = this.topicSession.createObjectMessage();
                objectMessageCreateObjectMessage.setObject(this.pst.transform(iLoggingEvent));
                this.topicPublisher.publish(objectMessageCreateObjectMessage);
                this.successiveFailureCount = 0;
            } catch (Exception e4) {
                int i4 = this.successiveFailureCount + 1;
                this.successiveFailureCount = i4;
                if (i4 > SUCCESSIVE_FAILURE_LIMIT) {
                    stop();
                }
                addError("Could not publish message in JMSTopicAppender [" + this.name + "].", e4);
            }
        }
    }
}
