package org.bouncycastle.crypto.constraints;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.crypto.CryptoServiceProperties;

/* loaded from: classes.dex */
public class LoggingConstraint extends ServicesConstraint {
    public LoggingConstraint(Set<String> set) {
        super(set);
    }

    @Override // org.bouncycastle.crypto.CryptoServicesConstraints
    public void check(CryptoServiceProperties cryptoServiceProperties) {
        if (isException(cryptoServiceProperties.getServiceName())) {
            return;
        }
        Logger logger = ServicesConstraint.LOG;
        if (logger.isLoggable(Level.INFO)) {
            logger.info("service " + cryptoServiceProperties.getServiceName() + " referenced [" + cryptoServiceProperties.getServiceName() + ", " + cryptoServiceProperties.bitsOfSecurity() + ", " + cryptoServiceProperties.getPurpose());
        }
    }
}
