package com.volcengine.tos.comm.common;

import androidx.core.os.EnvironmentCompat;
import com.volcengine.tos.model.acl.ACLConst;

/* loaded from: classes3.dex */
public enum ACLType {
    ACL_PRIVATE(ACLConst.ACL_PRIVATE),
    ACL_PUBLIC_READ(ACLConst.ACL_PUBLIC_READ),
    ACL_PUBLIC_READ_WRITE(ACLConst.ACL_PUBLIC_READ_WRITE),
    ACL_AUTHENTICATED_READ(ACLConst.ACL_AUTH_READ),
    ACL_BUCKET_OWNER_READ(ACLConst.ACL_BUCKET_OWNER_READ),
    ACL_BUCKET_OWNER_FULL_CONTROL(ACLConst.ACL_BUCKET_OWNER_FULL_CONTROL),
    ACL_LOG_DELIVERY_WRITE(ACLConst.ACL_LOG_DELIVERY_WRITE),
    ACL_BUCKET_OWNER_ENTRUSTED("bucket-owner-entrusted"),
    ACL_UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN);


    /* renamed from: a, reason: collision with root package name */
    public final String f4219a;

    ACLType(String str) {
        this.f4219a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4219a;
    }
}
