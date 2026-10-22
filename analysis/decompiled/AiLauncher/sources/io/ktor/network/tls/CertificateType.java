package io.ktor.network.tls;

import com.autonavi.aps.amapapi.security.Encrypt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lio/ktor/network/tls/CertificateType;", "", "<init>", "()V", "", Encrypt.KEY_ALGORITHM, "B", "DSS", "RSA_FIXED_DH", "DSS_FIXED_DH", "RSA_EPHEMERAL_DH_RESERVED", "DSS_EPHEMERAL_DH_RESERVED", "FORTEZZA_DMS_RESERVED", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CertificateType {
    public static final byte DSS = 2;
    public static final byte DSS_EPHEMERAL_DH_RESERVED = 6;
    public static final byte DSS_FIXED_DH = 4;
    public static final byte FORTEZZA_DMS_RESERVED = 20;
    public static final CertificateType INSTANCE = new CertificateType();
    public static final byte RSA = 1;
    public static final byte RSA_EPHEMERAL_DH_RESERVED = 5;
    public static final byte RSA_FIXED_DH = 3;

    private CertificateType() {
    }
}
