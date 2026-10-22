package com.bytedance.android.bcm.impl.monitor;

import com.bytedance.android.bcm.impl.paramcheck.checker.BcmCheckErrorType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f41839a = 0;

    static {
    }

    public static void a(com.bytedance.android.bcm.impl.paramcheck.checker.b r100, String r101, String r110) {
        StringBuilder r102 = new StringBuilder();
        if (r110 == null) goto L5;
        r101 = r110;
    L5:
        r102.append(r101);
        r102.append('\n');
        BcmCheckErrorType[] r103 = BcmCheckErrorType.values();
        int r111 = r103.length;
        int r104 = 0;
    L6:
        if (r104 >= r111) goto L34;
        BcmCheckErrorType r105 = r103[r104];
        List<com.bytedance.android.bcm.impl.paramcheck.checker.a> r106 = r100.f41875a;
        ArrayList r107 = new ArrayList();
        Iterator r108 = ((ArrayList) r106).iterator();
    L9:
        if (r108.hasNext() == false) goto L13;
        Object r109 = r108.next();
        if ((r109 instanceof com.bytedance.android.bcm.impl.paramcheck.checker.a.b) == false) goto L9;
        r107.add(r109);
        goto L9
    L13:
        ArrayList r112 = new ArrayList();
        Iterator r113 = r107.iterator();
    L14:
        boolean r114 = true;
        if (r113.hasNext() == false) goto L23;
        Object r115 = r113.next();
        if (((com.bytedance.android.bcm.impl.paramcheck.checker.a.b) r115).f41873b == r105) goto L20;
        r114 = false;
    L20:
        if (r114 == false) goto L14;
        r112.add(r115);
        goto L14
    L23:
        if ((!r112.isEmpty()) == false) goto L33;
        StringBuilder r116 = new StringBuilder("【参数");
        r116.append(r105.getErrorTip());
        r116.append("】\n");
        Iterator r117 = r112.iterator();
    L26:
        if (r117.hasNext() == false) goto L33;
        com.bytedance.android.bcm.impl.paramcheck.checker.a.b r118 = (com.bytedance.android.bcm.impl.paramcheck.checker.a.b) r117.next();
        StringBuilder r119 = new StringBuilder(" - ");
        r119.append(r118.f41872a);
        r119.append(": ");
        if (r118.f41874c.containsKey("expect_value") == false) goto L31;
        StringBuilder r120 = new StringBuilder("[预期：");
        r120.append(r118.f41874c.get("expect_value"));
        r120.append(']');
    L31:
        if (r118.f41874c.containsKey("actual_value") == false) goto L26;
        StringBuilder r121 = new StringBuilder("[实际：");
        r121.append(r118.f41874c.get("actual_value"));
        r121.append(']');
    L33:
        r104 = r104 + 1;
        goto L6
    L34:
        com.bytedance.android.bcm.impl.paramcheck.checker.a.C0771a r122 = r100.b();
        if (r122 == null) goto L55;
        new StringBuilder("规则校验不通过,规则表达式: ").append(r122.f41871a);
        return;
    }
}
