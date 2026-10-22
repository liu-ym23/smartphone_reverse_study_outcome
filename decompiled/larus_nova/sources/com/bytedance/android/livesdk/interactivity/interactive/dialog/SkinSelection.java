package com.bytedance.android.livesdk.interactivity.interactive.dialog;

import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.chatroom.msgboard.b;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import n82.c;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
public final class SkinSelection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f137175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f137176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f137177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DressType f137178d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/SkinSelection$DressType;", "", "UNKNOWN", "SKIN", "BADGE", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum DressType extends Enum<DressType> {
        public static final DressType BADGE = null;
        public static final DressType SKIN = null;
        public static final DressType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DressType[] f137179a = null;

        static {
            DressType r100 = new DressType("UNKNOWN", 0);
            UNKNOWN = r100;
            DressType r101 = new DressType("SKIN", 1);
            SKIN = r101;
            DressType r102 = new DressType("BADGE", 2);
            BADGE = r102;
            f137179a = new DressType[]{r100, r101, r102};
        }

        public static DressType valueOf(String r100) {
            return (DressType) a.a(DressType.class, r100);
        }

        public static DressType[] values() {
            return (DressType[]) f137179a.clone();
        }

        public DressType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public SkinSelection() {
        this.f137175a = "";
        this.f137176b = "";
        this.f137177c = new LinkedHashSet();
        this.f137178d = DressType.UNKNOWN;
    }

    public final boolean a(DataCenter r100) {
        if (CollectionUtils.isEmpty(this.f137177c) == true) goto L29;
        Set<String> r101 = this.f137177c;
        if (r101 == null) goto L30;
        Set<String> r102 = r101;
        if ((r102 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r103 = r102.iterator();
    L13:
        if (r103.hasNext() == false) goto L20;
        if (c.c((String) r103.next(), r100) == true) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == false) goto L13;
        boolean r105 = true;
    L21:
        if (r105 != true) goto L31;
        return true;
    L31:
        return false;
    L17:
        r104 = false;
    L20:
        r105 = false;
        goto L21
    L9:
        if (r102.isEmpty() == false) goto L11;
    L30:
        return false;
    L29:
        return false;
    }

    public final void b(DataCenter r100) {
        b r101 = c.i(r100);
        Set<String> r102 = this.f137177c;
        if (r102 != null) goto L5;
        r102 = new LinkedHashSet();
    L5:
        this.f137177c = r102;
        r102.clear();
        if (r101 == null) goto L19;
        List<VSMsgBoardDress> r103 = r101.a();
        if (r103 == null) goto L19;
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L19;
        VSMsgBoardDress r105 = (VSMsgBoardDress) r104.next();
        if (String.valueOf(r105.getDressId()).equals(this.f137176b) == true) goto L16;
        if (String.valueOf(r105.getDressId()).equals(this.f137175a) == false) goto L11;
    L16:
        String r106 = String.valueOf(r105.getEntityId());
        Set<String> r107 = this.f137177c;
        if (r107 == null) goto L11;
        r107.add(r106);
    L19:
        if (r101 == null) goto L32;
        List<VSMsgBoardDress> r108 = r101.c();
        if (r108 == null) goto L49;
        Iterator<T> r109 = r108.iterator();
    L24:
        if (r109.hasNext() == false) goto L50;
        VSMsgBoardDress r110 = (VSMsgBoardDress) r109.next();
        if (String.valueOf(r110.getDressId()).equals(this.f137176b) == true) goto L29;
        if (String.valueOf(r110.getDressId()).equals(this.f137175a) == false) goto L24;
    L29:
        String r111 = String.valueOf(r110.getEntityId());
        Set<String> r112 = this.f137177c;
        if (r112 == null) goto L24;
        r112.add(r111);
        goto L24
    L50:
        return;
    L49:
        return;
    }
}
