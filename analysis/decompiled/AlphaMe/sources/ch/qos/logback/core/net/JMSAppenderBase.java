package ch.qos.logback.core.net;

import ch.qos.logback.core.AppenderBase;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

/* loaded from: classes.dex */
public abstract class JMSAppenderBase<E> extends AppenderBase<E> {
    protected String initialContextFactoryName;
    protected String password;
    protected String providerURL;
    protected String securityCredentials;
    protected String securityPrincipalName;
    protected String urlPkgPrefixes;
    protected String userName;

    public Properties buildEnvProperties() {
        Properties properties = new Properties();
        properties.put("java.naming.factory.initial", this.initialContextFactoryName);
        String str = this.providerURL;
        if (str != null) {
            properties.put("java.naming.provider.url", str);
        } else {
            addWarn("You have set InitialContextFactoryName option but not the ProviderURL. This is likely to cause problems.");
        }
        String str2 = this.urlPkgPrefixes;
        if (str2 != null) {
            properties.put("java.naming.factory.url.pkgs", str2);
        }
        String str3 = this.securityPrincipalName;
        if (str3 != null) {
            properties.put("java.naming.security.principal", str3);
            String str4 = this.securityCredentials;
            if (str4 != null) {
                properties.put("java.naming.security.credentials", str4);
            } else {
                addWarn("You have set SecurityPrincipalName option but not the SecurityCredentials. This is likely to cause problems.");
            }
        }
        return properties;
    }

    public Context buildJNDIContext() throws NamingException {
        return this.initialContextFactoryName != null ? new InitialContext(buildEnvProperties()) : new InitialContext();
    }

    public String getInitialContextFactoryName() {
        return this.initialContextFactoryName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getProviderURL() {
        return this.providerURL;
    }

    public String getSecurityCredentials() {
        return this.securityCredentials;
    }

    public String getSecurityPrincipalName() {
        return this.securityPrincipalName;
    }

    public String getURLPkgPrefixes() {
        return this.urlPkgPrefixes;
    }

    public String getUserName() {
        return this.userName;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NameNotFoundException */
    public Object lookup(Context context, String str) throws NamingException, NameNotFoundException {
        try {
            return context.lookup(str);
        } catch (NameNotFoundException e4) {
            this.addError("Could not find name [" + str + "].");
            throw e4;
        }
    }

    public void setInitialContextFactoryName(String str) {
        this.initialContextFactoryName = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setProviderURL(String str) {
        this.providerURL = str;
    }

    public void setSecurityCredentials(String str) {
        this.securityCredentials = str;
    }

    public void setSecurityPrincipalName(String str) {
        this.securityPrincipalName = str;
    }

    public void setURLPkgPrefixes(String str) {
        this.urlPkgPrefixes = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
