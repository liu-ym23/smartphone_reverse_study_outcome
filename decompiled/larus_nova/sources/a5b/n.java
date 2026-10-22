package a5b;

import com.ss.android.lark.chat.cot.CotViewBlock;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.cot.ToolCallCodeResultArea;
import com.ss.android.lark.chat.cot.ToolCallExtra;
import com.ss.android.lark.chat.cot.ToolCallListResultArea;
import com.ss.android.lark.chat.cot.ToolCallResultArea;
import com.ss.android.lark.chat.cot.ToolCallTextResultArea;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class n extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f1927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StringBuilder f1928j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f1929k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f1930l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f1931m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f1932n;

    @Override // a5b.h
    public final CotViewBlock a() {
        StringBuilder r100 = this.f1928j;
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L12;
        String r102 = r100.toString();
    L13:
        String r103 = this.f1919c;
        if (r103 != null) goto L26;
        r103 = this.f1926h;
        if (r103 == null) goto L25;
        if (r102 != null) goto L19;
    L22:
        boolean r104 = true;
    L23:
        if (r104 == true) goto L26;
        r103 = r103 + " (" + r102 + ')';
        goto L26
    L19:
        if (r102.length() == 0) goto L22;
        r104 = false;
        goto L23
    L25:
        r103 = null;
    L26:
        CotViewBlock r105 = super.a();
        String r106 = this.f1926h;
        String r107 = this.f1927i;
        String r110 = this.f1929k;
        String r111 = this.f1930l;
        String r112 = this.f1931m;
        String r113 = this.f1932n;
        int r108 = com.ss.android.lark.chat.cot.i.f415065a;
        if (r112 != null) goto L29;
    L33:
        if (r111 != null) goto L35;
    L37:
        String r109 = null;
    L38:
        if (r109 != null) goto L100;
        String r210 = r103;
        ArrayList r114 = new ArrayList();
    L92:
        return CotViewBlock.copy$default(r105, null, null, r210, null, null, false, new ToolCallExtra(r106, r107, r102, r110, r111, r112, r113, r114, this.f1925g, false, false), 59, null);
    L100:
        if (StringsKt.startsWith$default(StringsKt.trimStart(r109).toString(), "{", false, 2, null) == false) goto L45;
        Object r115 = new JSONObject(r109);     // Catch: Throwable -> L48
    L50:
        if (r115 != null) goto L52;
        r210 = r103;
        ArrayList r116 = CollectionsKt.arrayListOf(new ToolCallResultArea[]{new ToolCallTextResultArea(r109)});
    L90:
        r114 = r116;
        goto L92
    L52:
        if ((r115 instanceof JSONObject) == false) goto L62;
        JSONObject r117 = (JSONObject) r115;
        ToolCallResultArea r118 = com.ss.android.lark.chat.cot.i.b(r117);
        r210 = r103;
        if (r118 == null) goto L56;
        r116 = CollectionsKt.arrayListOf(new ToolCallResultArea[]{r118});
    L57:
        if (r116 != null) goto L90;
        ToolCallResultArea[] r119 = new ToolCallResultArea[1];
        String r120 = r117.toString(2);     // Catch: Throwable -> L93
        Intrinsics.checkNotNull(r120);     // Catch: Throwable -> L93
        r109 = r120;
    L61:
        r119[0] = new ToolCallCodeResultArea(r109, "json");
        r116 = CollectionsKt.arrayListOf(r119);
        goto L90
    L56:
        r116 = null;
        goto L57
    L62:
        r210 = r103;
        if ((r115 instanceof JSONArray) == false) goto L88;
        JSONArray r121 = (JSONArray) r115;
        if (r121.length() != 0) goto L70;
        ToolCallResultArea[] r122 = new ToolCallResultArea[1];
        String r123 = r121.toString(2);     // Catch: Throwable -> L94
        Intrinsics.checkNotNull(r123);     // Catch: Throwable -> L94
        r109 = r123;
    L69:
        r122[0] = new ToolCallCodeResultArea(r109, "json");
        r116 = CollectionsKt.arrayListOf(r122);
        goto L90
    L70:
        ArrayList r124 = new ArrayList(r121.length());
        int r125 = r121.length();
        int r126 = 0;
    L71:
        if (r126 >= r125) goto L79;
        JSONObject r211 = r121.optJSONObject(r126);
        if (r211 == null) goto L77;
        ToolCallResultArea r127 = com.ss.android.lark.chat.cot.i.b(r211);
        if (r127 == null) goto L77;
        r124.add(r127);
        r126 = r126 + 1;
    L77:
        r124 = null;
    L79:
        if (r124 == null) goto L81;
        r116 = r124;
        goto L90
    L81:
        ToolCallListResultArea r128 = com.ss.android.lark.chat.cot.i.a(r121);
        if (r128 == null) goto L84;
        r116 = CollectionsKt.arrayListOf(new ToolCallResultArea[]{r128});
        goto L90
    L84:
        ToolCallResultArea[] r129 = new ToolCallResultArea[1];
        String r130 = r121.toString(2);     // Catch: Throwable -> L95
        Intrinsics.checkNotNull(r130);     // Catch: Throwable -> L95
        r109 = r130;
    L87:
        r129[0] = new ToolCallCodeResultArea(r109, "json");
        r116 = CollectionsKt.arrayListOf(r129);
        goto L90
    L88:
        r116 = CollectionsKt.arrayListOf(new ToolCallResultArea[]{new ToolCallTextResultArea(r109)});
        goto L90
    L45:
        if (StringsKt.startsWith$default(StringsKt.trimStart(r109).toString(), "[", false, 2, null) == false) goto L49;
        r115 = new JSONArray(r109);     // Catch: Throwable -> L48
        goto L50
    L104:
        r115 = null;
    L49:
        r115 = null;
        goto L50
    L35:
        if ((!StringsKt.isBlank(r111)) == false) goto L37;
        r109 = r111;
        goto L38
    L29:
        if ((!StringsKt.isBlank(r112)) == false) goto L31;
        r109 = r112;
    L32:
        if (r109 != null) goto L100;
    L31:
        r109 = null;
        goto L32
    L12:
        r102 = null;
        goto L13
    L5:
        r101 = false;
        goto L7
    }

    public n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stableId");
        super(r100, CotViewBlockType.TOOL_CALL);
        this.f1925g = true;
        this.f1928j = new StringBuilder();
    }

    public final void setResult(String r100) {
        this.f1930l = r100;
    }
}
