package com.bytedance.android.gamecp.common.whiteboxtest;

import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, b> f57336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f57337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<Function0<Pair<Boolean, String>>> f57338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f57339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f57340e;

    @Override // com.bytedance.android.gamecp.common.whiteboxtest.d
    public final void a() {
        Set r100 = ((LinkedHashMap) this.f57336a).keySet();
        Map<String, String> r101 = b();
        LinkedHashSet r102 = new LinkedHashSet();
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator r104 = r100.iterator();
        boolean r105 = true;
    L4:
        if (r104.hasNext() == false) goto L20;
        String r106 = (String) r104.next();
        b r107 = (b) ((LinkedHashMap) this.f57336a).get(r106);
        if (r107 != null) goto L8;
    L14:
        if (r107 == null) goto L4;
        if (r107.f57344d != true) goto L4;
        String r108 = r101.get(r106);
        if ((!Intrinsics.areEqual(r107.f57342b, r108)) == false) goto L4;
        r103.put(r106, new Pair(r107.f57342b, r108));
        goto L4
    L8:
        if (r107.f57343c != true) goto L14;
        String r109 = r101.get(r106);
        if (r109 != null) goto L12;
    L13:
        r102.add(r106);
        r105 = false;
        goto L14
    L12:
        if (Intrinsics.areEqual(r109, "") == false) goto L14;
    L20:
        StringBuilder r110 = new StringBuilder();
        ArrayList<Function0<Pair<Boolean, String>>> r111 = this.f57338c;
        if (r111 != null) goto L23;
    L33:
        boolean r112 = true;
    L34:
        Pair r113 = new Pair(Boolean.valueOf(r112), r110.toString());
        boolean r114 = ((Boolean) r113.getFirst()).booleanValue();
        String r115 = (String) r113.getSecond();
        if (r105 == false) goto L39;
        if (r105 == false) goto L39;
        if (r114 == false) goto L39;
        yr.c.e("游戏联运白盒测试", "case执行成功，case描述：" + this.f57339d);
        return;
    L39:
        StringBuilder r116 = new StringBuilder();
        if (r102.isEmpty() == true) goto L47;
        r116.append("参数非空检查出错，出错参数：\n");
        Iterator r117 = r102.iterator();
    L43:
        if (r117.hasNext() == false) goto L45;
        r116.append(((String) r117.next()) + '\n');
        goto L43
    L45:
        r116.append("\n");
    L47:
        if (r103.isEmpty() == true) goto L53;
        r116.append("参数准确性检查出错，出错参数：\n");
        Iterator r118 = r103.entrySet().iterator();
    L50:
        if (r118.hasNext() == false) goto L52;
        Map.Entry r119 = (Map.Entry) r118.next();
        r116.append(((String) r119.getKey()) + "\n预期：" + ((String) ((Pair) r119.getValue()).getFirst()) + "\n实际：" + ((String) ((Pair) r119.getValue()).getSecond()) + '\n');
        goto L50
    L52:
        r116.append("\n");
    L53:
        if (r114 == true) goto L55;
        r116.append("自定义规则检查失败，场景描述：\n" + r115);
    L55:
        String r120 = r116.toString();
        String r121 = this.f57339d;
        Intrinsics.checkNotNullParameter(r121, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r120, "content");
        int r122 = c.f57345a;
        String r123 = this.f57337b;
        Intrinsics.checkNotNullParameter(r123, "priority");
        Intrinsics.checkNotNullParameter(r121, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r120, "content");
        Lazy r124 = GamecpWhiteBoxTester.f57332d;
        if (GamecpWhiteBoxTester.a.a().f57333a == false) goto L90;
        int r125 = r123.hashCode();
        if (r125 == 2530) goto L67;
        if (r125 == 2531) goto L64;
        return;
    L64:
        if (r123.equals("P3") == false) goto L87;
        ToastUtil.b(r121 + '\n' + r120, 1);
        return;
    L87:
        return;
    L67:
        if (r123.equals(DiagnoseResult.DIAGNOSE_LEVEL_P2) == false) goto L89;
        ToastUtil.b(r121 + '\n' + r120, 1);
        return;
    L89:
        return;
    L90:
        return;
    L23:
        if ((!r111.isEmpty()) == true) goto L26;
        r111 = null;
    L26:
        if (r111 == null) goto L33;
        Iterator<Function0<Pair<Boolean, String>>> r126 = r111.iterator();
        r112 = true;
    L29:
        if (r126.hasNext() == false) goto L34;
        Pair<Boolean, String> r127 = r126.next().invoke();
        if (r127.getFirst().booleanValue() == true) goto L29;
        r110.append(r127.getSecond());
        r110.append("\n");
        r112 = false;
        goto L29
    }

    public Map<String, String> b() {
        return new LinkedHashMap();
    }

    public a() {
        this.f57336a = new LinkedHashMap();
        this.f57337b = DiagnoseResult.DIAGNOSE_LEVEL_P2;
        this.f57339d = "";
        this.f57340e = "";
    }

    @Override // com.bytedance.android.gamecp.common.whiteboxtest.d
    public final String getPriority() {
        return this.f57337b;
    }

    @Override // com.bytedance.android.gamecp.common.whiteboxtest.d
    public final String getScene() {
        return this.f57340e;
    }

    public final void c(Map<String, b> r100, String r101, String r102, ArrayList<Function0<Pair<Boolean, String>>> r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r102, "priority");
        Lazy r105 = GamecpWhiteBoxTester.f57332d;
        if (GamecpWhiteBoxTester.a.a().f57333a == true) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r100, "map");
        Iterator<Map.Entry<String, b>> r106 = r100.entrySet().iterator();
    L7:
        if (r106.hasNext() == false) goto L9;
        Map.Entry<String, b> r107 = r106.next();
        String r108 = r107.getKey();
        b r109 = r107.getValue();
        this.f57336a.put(r108, r109);
        goto L7
    L9:
        Intrinsics.checkNotNullParameter(r102, "p");
        this.f57337b = r102;
        this.f57339d = r101;
        this.f57338c = r103;
        if (r104 != null) goto L12;
    L17:
        Lazy r110 = GamecpWhiteBoxTester.f57332d;
        r104 = GamecpWhiteBoxTester.a.a().b();
    L18:
        Intrinsics.checkNotNullParameter(r104, "scene");
        this.f57340e = r104;
        return;
    L12:
        if (r104.length() <= 0) goto L14;
        boolean r111 = true;
    L15:
        if (r111 == false) goto L17;
    L14:
        r111 = false;
        goto L15
    }
}
