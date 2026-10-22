package com.fasterxml.jackson.databind.h.a;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SubTypeValidator.java */
/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Set<String> f12732a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final p f12733c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Set<String> f12734b;

    static {
        HashSet r0 = new HashSet();
        r0.add("org.apache.commons.collections.functors.InvokerTransformer");
        r0.add("org.apache.commons.collections.functors.InstantiateTransformer");
        r0.add("org.apache.commons.collections4.functors.InvokerTransformer");
        r0.add("org.apache.commons.collections4.functors.InstantiateTransformer");
        r0.add("org.codehaus.groovy.runtime.ConvertedClosure");
        r0.add("org.codehaus.groovy.runtime.MethodClosure");
        r0.add("org.springframework.beans.factory.ObjectFactory");
        r0.add("com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl");
        r0.add("org.apache.xalan.xsltc.trax.TemplatesImpl");
        r0.add("com.sun.rowset.JdbcRowSetImpl");
        r0.add("java.util.logging.FileHandler");
        r0.add("java.rmi.server.UnicastRemoteObject");
        r0.add("org.springframework.beans.factory.config.PropertyPathFactoryBean");
        r0.add("org.springframework.aop.config.MethodLocatingFactoryBean");
        r0.add("org.springframework.beans.factory.config.BeanReferenceFactoryBean");
        r0.add("org.apache.tomcat.dbcp.dbcp2.BasicDataSource");
        r0.add("com.sun.org.apache.bcel.internal.util.ClassLoader");
        r0.add("org.hibernate.jmx.StatisticsService");
        r0.add("org.apache.ibatis.datasource.jndi.JndiDataSourceFactory");
        r0.add("org.apache.ibatis.parsing.XPathParser");
        r0.add("jodd.db.connection.DataSourceConnectionProvider");
        r0.add("oracle.jdbc.connector.OracleManagedConnectionFactory");
        r0.add("oracle.jdbc.rowset.OracleJDBCRowSet");
        r0.add("org.slf4j.ext.EventData");
        r0.add("flex.messaging.util.concurrent.AsynchBeansWorkManagerExecutor");
        r0.add("com.sun.deploy.security.ruleset.DRSHelper");
        r0.add("org.apache.axis2.jaxws.spi.handler.HandlerResolverImpl");
        r0.add("org.jboss.util.propertyeditor.DocumentEditor");
        r0.add("org.apache.openjpa.ee.RegistryManagedRuntime");
        r0.add("org.apache.openjpa.ee.JNDIManagedRuntime");
        r0.add("org.apache.openjpa.ee.WASRegistryManagedRuntime");
        r0.add("org.apache.axis2.transport.jms.JMSOutTransportInfo");
        r0.add("com.mysql.cj.jdbc.admin.MiniAdmin");
        r0.add("ch.qos.logback.core.db.DriverManagerConnectionSource");
        r0.add("org.jdom.transform.XSLTransformer");
        r0.add("org.jdom2.transform.XSLTransformer");
        r0.add("net.sf.ehcache.transaction.manager.DefaultTransactionManagerLookup");
        r0.add("net.sf.ehcache.hibernate.EhcacheJtaTransactionManagerLookup");
        r0.add("ch.qos.logback.core.db.JNDIConnectionSource");
        r0.add("com.zaxxer.hikari.HikariConfig");
        r0.add("com.zaxxer.hikari.HikariDataSource");
        r0.add("org.apache.cxf.jaxrs.provider.XSLTJaxbProvider");
        r0.add("org.apache.commons.configuration.JNDIConfiguration");
        r0.add("org.apache.commons.configuration2.JNDIConfiguration");
        r0.add("org.apache.xalan.lib.sql.JNDIConnectionPool");
        r0.add("com.sun.org.apache.xalan.internal.lib.sql.JNDIConnectionPool");
        r0.add("org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS");
        r0.add("org.apache.commons.dbcp.datasources.PerUserPoolDataSource");
        r0.add("org.apache.commons.dbcp.datasources.SharedPoolDataSource");
        r0.add("com.p6spy.engine.spy.P6DataSource");
        r0.add("org.apache.log4j.receivers.db.DriverManagerConnectionSource");
        r0.add("org.apache.log4j.receivers.db.JNDIConnectionSource");
        r0.add("net.sf.ehcache.transaction.manager.selector.GenericJndiSelector");
        r0.add("net.sf.ehcache.transaction.manager.selector.GlassfishSelector");
        r0.add("org.apache.xbean.propertyeditor.JndiConverter");
        r0.add("org.apache.hadoop.shaded.com.zaxxer.hikari.HikariConfig");
        r0.add("com.ibatis.sqlmap.engine.transaction.jta.JtaTransactionConfig");
        r0.add("br.com.anteros.dbcp.AnterosDBCPConfig");
        r0.add("br.com.anteros.dbcp.AnterosDBCPDataSource");
        r0.add("javax.swing.JEditorPane");
        r0.add("javax.swing.JTextPane");
        r0.add("org.apache.shiro.realm.jndi.JndiRealmFactory");
        r0.add("org.apache.shiro.jndi.JndiObjectFactory");
        r0.add("org.apache.ignite.cache.jta.jndi.CacheJndiTmLookup");
        r0.add("org.apache.ignite.cache.jta.jndi.CacheJndiTmFactory");
        r0.add("org.quartz.utils.JNDIConnectionProvider");
        r0.add("org.apache.aries.transaction.jms.internal.XaPooledConnectionFactory");
        r0.add("org.apache.aries.transaction.jms.RecoverablePooledConnectionFactory");
        r0.add("com.caucho.config.types.ResourceRef");
        r0.add("org.aoju.bus.proxy.provider.RmiProvider");
        r0.add("org.aoju.bus.proxy.provider.remoting.RmiProvider");
        r0.add("org.apache.activemq.ActiveMQConnectionFactory");
        r0.add("org.apache.activemq.ActiveMQXAConnectionFactory");
        r0.add("org.apache.activemq.spring.ActiveMQConnectionFactory");
        r0.add("org.apache.activemq.spring.ActiveMQXAConnectionFactory");
        r0.add("org.apache.activemq.pool.JcaPooledConnectionFactory");
        r0.add("org.apache.activemq.pool.PooledConnectionFactory");
        r0.add("org.apache.activemq.pool.XaPooledConnectionFactory");
        r0.add("org.apache.activemq.jms.pool.XaPooledConnectionFactory");
        r0.add("org.apache.activemq.jms.pool.JcaPooledConnectionFactory");
        r0.add("org.apache.commons.proxy.provider.remoting.RmiProvider");
        r0.add("org.apache.commons.jelly.impl.Embedded");
        r0.add("oadd.org.apache.xalan.lib.sql.JNDIConnectionPool");
        r0.add("oadd.org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS");
        r0.add("oadd.org.apache.commons.dbcp.datasources.PerUserPoolDataSource");
        r0.add("oadd.org.apache.commons.dbcp.datasources.SharedPoolDataSource");
        r0.add("oracle.jms.AQjmsQueueConnectionFactory");
        r0.add("oracle.jms.AQjmsXATopicConnectionFactory");
        r0.add("oracle.jms.AQjmsTopicConnectionFactory");
        r0.add("oracle.jms.AQjmsXAQueueConnectionFactory");
        r0.add("oracle.jms.AQjmsXAConnectionFactory");
        r0.add("org.jsecurity.realm.jndi.JndiRealmFactory");
        r0.add("com.pastdev.httpcomponents.configuration.JndiConfiguration");
        r0.add("com.nqadmin.rowset.JdbcRowSetImpl");
        r0.add("org.arrah.framework.rdbms.UpdatableJdbcRowsetImpl");
        r0.add("org.apache.commons.dbcp2.datasources.PerUserPoolDataSource");
        r0.add("org.apache.commons.dbcp2.datasources.SharedPoolDataSource");
        r0.add("org.apache.commons.dbcp2.cpdsadapter.DriverAdapterCPDS");
        r0.add("com.newrelic.agent.deps.ch.qos.logback.core.db.JNDIConnectionSource");
        r0.add("com.newrelic.agent.deps.ch.qos.logback.core.db.DriverManagerConnectionSource");
        r0.add("org.apache.tomcat.dbcp.dbcp.cpdsadapter.DriverAdapterCPDS");
        r0.add("org.apache.tomcat.dbcp.dbcp.datasources.PerUserPoolDataSource");
        r0.add("org.apache.tomcat.dbcp.dbcp.datasources.SharedPoolDataSource");
        r0.add("org.apache.tomcat.dbcp.dbcp2.cpdsadapter.DriverAdapterCPDS");
        r0.add("org.apache.tomcat.dbcp.dbcp2.datasources.PerUserPoolDataSource");
        r0.add("org.apache.tomcat.dbcp.dbcp2.datasources.SharedPoolDataSource");
        r0.add("com.oracle.wls.shaded.org.apache.xalan.lib.sql.JNDIConnectionPool");
        r0.add("org.docx4j.org.apache.xalan.lib.sql.JNDIConnectionPool");
        f12732a = Collections.unmodifiableSet(r0);
        f12733c = new p();
    }

    public p() {
        this.f12734b = f12732a;
    }

    public static p a() {
        return f12733c;
    }

    public void a(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.c r5) {
        Class<?> r6 = r4.e();
        String r0 = r6.getName();
        if (this.f12734b.contains(r0) == false) goto L6;
    L23:
        r3.a(r5, "Illegal type (%s) to deserialize: prevented for security reasons", new Object[]{r0});
        return;
    L6:
        if (r6.isInterface() == false) goto L9;
        return;
    L9:
        if (r0.startsWith("org.springframework.") == false) goto L20;
    L10:
        if (r6 == null) goto L32;
        if (r6 == Object.class) goto L33;
        String r2 = r6.getSimpleName();
        if ("AbstractPointcutAdvisor".equals(r2) == true) goto L23;
        if ("AbstractApplicationContext".equals(r2) == true) goto L23;
        r6 = r6.getSuperclass();
        goto L10
    L33:
        return;
    L32:
        return;
    L20:
        if (r0.startsWith("com.mchange.v2.c3p0.") == true) goto L22;
        return;
    L22:
        if (r0.endsWith("DataSource") == true) goto L23;
    }
}
