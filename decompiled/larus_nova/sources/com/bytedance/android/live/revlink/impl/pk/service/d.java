package com.bytedance.android.live.revlink.impl.pk.service;

import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.d7;

/* JADX INFO: loaded from: classes47.dex */
public interface d {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f96858a;

        public a() {
            this(false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (this.f96858a == ((a) r100).f96858a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            boolean r100 = this.f96858a;
            if (r100 == false) goto L6;
            return 1;
        L6:
            return r100 ? 1 : 0;
        }

        public final String toString() {
            return "LinkOptParams(isBizOptLink=" + this.f96858a + ")";
        }

        public a(boolean r100) {
            this.f96858a = r100;
        }
    }

    long channelId();

    m41.b getUnLoadSource();

    String guestLinkMicId();

    String linkmicId();

    d7 multiLiveCoreInfo();

    v1 multiRtcInfo();

    void setUnLoadSource(m41.b r100);
}
