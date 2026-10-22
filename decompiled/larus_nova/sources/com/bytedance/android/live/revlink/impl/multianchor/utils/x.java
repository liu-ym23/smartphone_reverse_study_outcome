package com.bytedance.android.live.revlink.impl.multianchor.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes47.dex */
public final class x {
    public static final boolean a(int r100) {
        if (r100 != 7) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean b(int r100) {
        if (r100 != 9) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 10) goto L10;
        if (r100 == 11) goto L10;
        return false;
    }

    public static final boolean c(int r100) {
        if (r100 != 21) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 20) goto L8;
        return false;
    }

    public static final boolean d(int r100) {
        if (r100 != 6) goto L5;
        return true;
    L5:
        return false;
    }

    public static final String f(int r100) {
        switch(r100) {
            case 1: goto L9;
            case 2: goto L3;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L3;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L3;
            case 9: goto L5;
            case 10: goto L4;
            case 11: goto L4;
            default: goto L3;
        };
    L3:
        return "";
    L4:
        return "triple_link";
    L5:
        return "single_link";
    L6:
        return "triple";
    L7:
        return "team_double";
    L8:
        return "link_double";
    L9:
        return "single";
    }

    public static final String g(List<? extends com.bytedance.android.livesdk.link.model.p> r100) {
        if (r100 == null) goto L14;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L5:
        if (r102.hasNext() == false) goto L12;
        IBaseUser r103 = ((com.bytedance.android.livesdk.link.model.p) r102.next()).getUser();
        if (r103 == null) goto L9;
        String r104 = r103.getIdString();
    L10:
        if (r104 == null) goto L5;
        r101.add(r104);
        goto L5
    L9:
        r104 = null;
        goto L10
    L12:
        String r105 = CollectionsKt.joinToString$default(r101, null, null, null, 0, null, null, 63, null);
        if (r105 == null) goto L14;
        return r105;
    L14:
        return "";
    }

    public static final String h(pc0.a r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$toLogString");
        StringBuilder r100 = new StringBuilder("SeiAppData{ver=");
        r100.append(r110.getVersion());
        r100.append(",channelId=");
        r100.append(r110.getChannelId());
        r100.append(",timestamp=");
        r100.append(r110.getTimestamp());
        r100.append(",grids=");
        List<RevSeiRegion> r101 = r110.e();
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.size());
    L6:
        r100.append(r102.intValue());
        r100.append(",[");
        List<RevSeiRegion> r111 = r110.e();
        if (r111 == null) goto L12;
        Iterator<T> r112 = r111.iterator();
    L10:
        if (r112.hasNext() == false) goto L12;
        RevSeiRegion r103 = (RevSeiRegion) r112.next();
        Intrinsics.checkNotNullParameter(r103, "$this$toLogString");
        StringBuilder r104 = new StringBuilder("Region{type=");
        r104.append(r103.getType());
        r104.append(",w=");
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        r104.append(String.format("%.3f", Arrays.copyOf(new Object[]{Double.valueOf(r103.getWidth())}, 1)));
        r104.append(",h=");
        r104.append(String.format("%.3f", Arrays.copyOf(new Object[]{Double.valueOf(r103.getHeight())}, 1)));
        r104.append(",x=");
        r104.append(String.format("%.3f", Arrays.copyOf(new Object[]{Double.valueOf(r103.getX())}, 1)));
        r104.append(",y=");
        r104.append(String.format("%.3f", Arrays.copyOf(new Object[]{Double.valueOf(r103.getY())}, 1)));
        r104.append(",stat=");
        r104.append(r103.getStatus());
        r104.append(",uid=");
        r104.append(r103.getUidStr());
        r104.append(",mute_audio=");
        r104.append(r103.getMuteAudio());
        r104.append("talk_volume=");
        r104.append(r103.getTalkVolume());
        r104.append(com.alipay.sdk.m.u.i.f25855d);
        r100.append(r104.toString());
        r100.append(",");
    L12:
        r100.append("]}");
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public static final <T> void e(LiveData<T> r100, Observer<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$observerForeverWithNotify");
        Intrinsics.checkNotNullParameter(r101, "observer");
        r100.observeForever(r101);
        T r102 = r100.getValue();
        if (r102 == null) goto L6;
        r101.onChanged(r102);
        return;
    }
}
