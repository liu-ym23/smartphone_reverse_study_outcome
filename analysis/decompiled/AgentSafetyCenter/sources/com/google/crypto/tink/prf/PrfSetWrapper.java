package com.google.crypto.tink.prf;

import b8.z;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.monitoring.MonitoringClient;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class PrfSetWrapper implements PrimitiveWrapper<Prf, PrfSet> {
    private static final PrfSetWrapper WRAPPER = new PrfSetWrapper();

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class WrappedPrfSet extends PrfSet {
        private final Map<Integer, Prf> keyIdToPrfMap;
        private final int primaryKeyId;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class PrfWithMonitoring implements Prf {
            private final int keyId;
            private final MonitoringClient.Logger logger;
            private final Prf prf;

            public PrfWithMonitoring(Prf prf, int i, MonitoringClient.Logger logger) {
                this.prf = prf;
                this.keyId = i;
                this.logger = logger;
            }

            @Override // com.google.crypto.tink.prf.Prf
            public byte[] compute(byte[] bArr, int i) throws GeneralSecurityException {
                try {
                    byte[] bArrCompute = this.prf.compute(bArr, i);
                    this.logger.log(this.keyId, bArr.length);
                    return bArrCompute;
                } catch (GeneralSecurityException e10) {
                    this.logger.logFailure();
                    throw e10;
                }
            }
        }

        private WrappedPrfSet(PrimitiveSet<Prf> primitiveSet) throws GeneralSecurityException {
            if (primitiveSet.getRawPrimitives().isEmpty()) {
                z.l("No primitives provided.");
                throw null;
            }
            if (primitiveSet.getPrimary() == null) {
                z.l("Primary key not set.");
                throw null;
            }
            MonitoringClient.Logger loggerCreateLogger = primitiveSet.hasAnnotations() ? MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(MonitoringUtil.getMonitoringKeysetInfo(primitiveSet), "prf", "compute") : MonitoringUtil.DO_NOTHING_LOGGER;
            this.primaryKeyId = primitiveSet.getPrimary().getKeyId();
            List<PrimitiveSet.Entry<Prf>> rawPrimitives = primitiveSet.getRawPrimitives();
            HashMap map = new HashMap();
            for (PrimitiveSet.Entry<Prf> entry : rawPrimitives) {
                if (!entry.getOutputPrefixType().equals(OutputPrefixType.RAW)) {
                    throw new GeneralSecurityException("Key " + entry.getKeyId() + " has non raw prefix type");
                }
                map.put(Integer.valueOf(entry.getKeyId()), new PrfWithMonitoring(entry.getPrimitive(), entry.getKeyId(), loggerCreateLogger));
            }
            this.keyIdToPrfMap = Collections.unmodifiableMap(map);
        }

        @Override // com.google.crypto.tink.prf.PrfSet
        public Map<Integer, Prf> getPrfs() {
            return this.keyIdToPrfMap;
        }

        @Override // com.google.crypto.tink.prf.PrfSet
        public int getPrimaryId() {
            return this.primaryKeyId;
        }
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(WRAPPER);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<Prf> getInputPrimitiveClass() {
        return Prf.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<PrfSet> getPrimitiveClass() {
        return PrfSet.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public PrfSet wrap(PrimitiveSet<Prf> primitiveSet) {
        return new WrappedPrfSet(primitiveSet);
    }
}
