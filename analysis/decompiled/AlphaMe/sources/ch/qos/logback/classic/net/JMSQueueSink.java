package ch.qos.logback.classic.net;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.util.ContextInitializer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Properties;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import n3.AbstractC0782c;

/* loaded from: classes.dex */
public class JMSQueueSink implements MessageListener {
    private Logger logger = (Logger) AbstractC0782c.d(JMSTopicSink.class);

    public JMSQueueSink(String str, String str2, String str3, String str4) {
        try {
            Properties properties = new Properties();
            properties.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            properties.put("java.naming.provider.url", "tcp://localhost:61616");
            InitialContext initialContext = new InitialContext(properties);
            QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) lookup(initialContext, str);
            PrintStream printStream = System.out;
            printStream.println("Queue Cnx Factory found");
            Queue queue = (Queue) initialContext.lookup(str2);
            printStream.println("Queue found: " + queue.getQueueName());
            QueueConnection queueConnectionCreateQueueConnection = queueConnectionFactory.createQueueConnection(str3, str4);
            printStream.println("Queue Connection created");
            queueConnectionCreateQueueConnection.createQueueSession(false, 1).createConsumer(queue).setMessageListener(this);
            queueConnectionCreateQueueConnection.start();
            printStream.println("Queue Connection started");
        } catch (Exception e4) {
            this.logger.error("Could not read JMS message.", (Throwable) e4);
        }
    }

    public static void main(String[] strArr) throws Exception {
        String str;
        String str2;
        if (strArr.length < 2) {
            usage("Wrong number of arguments.");
        }
        String str3 = strArr[0];
        String str4 = strArr[1];
        if (strArr.length == 4) {
            str = strArr[2];
            str2 = strArr[3];
        } else {
            str = null;
            str2 = null;
        }
        new ContextInitializer((LoggerContext) AbstractC0782c.c()).autoConfig();
        new JMSQueueSink(str3, str4, str, str2);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Type \"exit\" to quit JMSQueueSink.");
        while (!bufferedReader.readLine().equalsIgnoreCase("exit")) {
        }
        System.out.println("Exiting. Kill the application if it does not exit due to daemon threads.");
    }

    public static void usage(String str) {
        PrintStream printStream = System.err;
        printStream.println(str);
        printStream.println("Usage: java " + JMSQueueSink.class.getName() + " QueueConnectionFactoryBindingName QueueBindingName Username Password");
        System.exit(1);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NameNotFoundException */
    public Object lookup(Context context, String str) throws NamingException, NameNotFoundException {
        try {
            return context.lookup(str);
        } catch (NameNotFoundException e4) {
            this.logger.error("Could not find name [" + str + "].");
            throw e4;
        }
    }

    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ILoggingEvent iLoggingEvent = (ILoggingEvent) ((ObjectMessage) message).getObject();
                ((Logger) AbstractC0782c.e(iLoggingEvent.getLoggerName())).callAppenders(iLoggingEvent);
            } else {
                this.logger.warn("Received message is of type " + message.getJMSType() + ", was expecting ObjectMessage.");
            }
        } catch (JMSException e4) {
            this.logger.error("Exception thrown while processing incoming message.", e4);
        }
    }
}
