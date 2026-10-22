package com.bytedance.android.live.core.utils;

import com.ss.android.download.api.constant.BaseConstants;
import java.util.Calendar;
import java.util.TimeZone;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes45.dex */
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f66190a = 0;

    static {
        f66190a = TimeZone.getDefault().getRawOffset();
    }

    public static final long a() {
        return ((long) Calendar.getInstance().get(3)) & BodyPartID.bodyIdMax;
    }

    public static final long b() {
        return ((System.currentTimeMillis() + ((long) f66190a)) / ((long) BaseConstants.Time.DAY)) & BodyPartID.bodyIdMax;
    }
}
