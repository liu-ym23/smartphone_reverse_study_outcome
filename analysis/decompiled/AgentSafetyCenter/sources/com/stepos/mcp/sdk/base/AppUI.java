package com.stepos.mcp.sdk.base;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import jb.a;
import tc.b;
import vc.e;
import xc.i0;
import xc.l0;
import yb.f;
import yb.k;
import yc.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class AppUI {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE_CUSTOM = "customView";
    public static final String TYPE_WEB = "web";
    public static final String TYPE_WIDGET = "widget";
    private final String appUIName;
    private final boolean isFix;
    private final String packageName;
    private final String type;
    private final String widgetAction;
    private final String widgetName;

    @a
    public AppUI(int i, String str, String str2, String str3, String str4, String str5, boolean z10, i0 i0Var) {
        if (3 == (i & 3)) {
            this.type = str;
            this.packageName = str2;
            if ((i & 4) == 0) {
                this.appUIName = null;
            } else {
                this.appUIName = str3;
            }
            if ((i & 8) == 0) {
                this.widgetName = null;
            } else {
                this.widgetName = str4;
            }
            if ((i & 16) == 0) {
                this.widgetAction = null;
            } else {
                this.widgetAction = str5;
            }
            if ((i & 32) == 0) {
                this.isFix = false;
                return;
            } else {
                this.isFix = z10;
                return;
            }
        }
        e descriptor = AppUI$$serializer.INSTANCE.getDescriptor();
        descriptor.getClass();
        ArrayList arrayList = new ArrayList();
        int i3 = (~i) & 3;
        for (int i10 = 0; i10 < 32; i10++) {
            if ((i3 & 1) != 0) {
                arrayList.add(descriptor.e(i10));
            }
            i3 >>>= 1;
        }
        String strA = descriptor.a();
        strA.getClass();
        b bVar = new b(arrayList.size() == 1 ? "Field '" + ((String) arrayList.get(0)) + "' is required for type with serial name '" + strA + "', but it was missing" : "Fields " + arrayList + " are required for type with serial name '" + strA + "', but they were missing", null);
        VarHandle.storeStoreFence();
        throw bVar;
    }

    public static /* synthetic */ AppUI copy$default(AppUI appUI, String str, String str2, String str3, String str4, String str5, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appUI.type;
        }
        if ((i & 2) != 0) {
            str2 = appUI.packageName;
        }
        if ((i & 4) != 0) {
            str3 = appUI.appUIName;
        }
        if ((i & 8) != 0) {
            str4 = appUI.widgetName;
        }
        if ((i & 16) != 0) {
            str5 = appUI.widgetAction;
        }
        if ((i & 32) != 0) {
            z10 = appUI.isFix;
        }
        String str6 = str5;
        boolean z11 = z10;
        return appUI.copy(str, str2, str3, str4, str6, z11);
    }

    public static final /* synthetic */ void write$Self(AppUI appUI, wc.b bVar, e eVar) {
        bVar.c(eVar, 0, appUI.type);
        bVar.c(eVar, 1, appUI.packageName);
        if (bVar.e(eVar) || appUI.appUIName != null) {
            l0 l0Var = l0.f15644a;
            bVar.a(eVar, 2, appUI.appUIName);
        }
        if (bVar.e(eVar) || appUI.widgetName != null) {
            l0 l0Var2 = l0.f15644a;
            bVar.a(eVar, 3, appUI.widgetName);
        }
        if (bVar.e(eVar) || appUI.widgetAction != null) {
            l0 l0Var3 = l0.f15644a;
            bVar.a(eVar, 4, appUI.widgetAction);
        }
        if (bVar.e(eVar) || appUI.isFix) {
            bVar.b(eVar, 5, appUI.isFix);
        }
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.appUIName;
    }

    public final String component4() {
        return this.widgetName;
    }

    public final String component5() {
        return this.widgetAction;
    }

    public final boolean component6() {
        return this.isFix;
    }

    public final AppUI copy(String str, String str2, String str3, String str4, String str5, boolean z10) {
        str.getClass();
        str2.getClass();
        return new AppUI(str, str2, str3, str4, str5, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppUI)) {
            return false;
        }
        AppUI appUI = (AppUI) obj;
        return k.a(this.type, appUI.type) && k.a(this.packageName, appUI.packageName) && k.a(this.appUIName, appUI.appUIName) && k.a(this.widgetName, appUI.widgetName) && k.a(this.widgetAction, appUI.widgetAction) && this.isFix == appUI.isFix;
    }

    public final String getAppUIName() {
        return this.appUIName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getType() {
        return this.type;
    }

    public final String getWidgetAction() {
        return this.widgetAction;
    }

    public final String getWidgetName() {
        return this.widgetName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iD = androidx.activity.b.d(this.type.hashCode() * 31, 31, this.packageName);
        String str = this.appUIName;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.widgetName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.widgetAction;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z10 = this.isFix;
        int i = z10;
        if (z10 != 0) {
            i = 1;
        }
        return iHashCode3 + i;
    }

    public final boolean isFix() {
        return this.isFix;
    }

    public String toString() {
        String str = this.type;
        String str2 = this.packageName;
        String str3 = this.appUIName;
        String str4 = this.widgetName;
        String str5 = this.widgetAction;
        boolean z10 = this.isFix;
        StringBuilder sbP = androidx.activity.b.p("AppUI(type=", str, ", packageName=", str2, ", appUIName=");
        androidx.activity.b.u(sbP, str3, ", widgetName=", str4, ", widgetAction=");
        sbP.append(str5);
        sbP.append(", isFix=");
        sbP.append(z10);
        sbP.append(")");
        return sbP.toString();
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ AppUI buildCustomView$default(Companion companion, String str, String str2, boolean z10, int i, Object obj) {
            if ((i & 4) != 0) {
                z10 = false;
            }
            return companion.buildCustomView(str, str2, z10);
        }

        public final AppUI buildCustomView(String str, String str2, boolean z10) {
            str.getClass();
            str2.getClass();
            return new AppUI(AppUI.TYPE_CUSTOM, str, str2, (String) null, (String) null, z10, 24, (f) null);
        }

        public final AppUI buildWidget(String str, String str2, String str3) {
            str.getClass();
            str2.getClass();
            str3.getClass();
            return new AppUI(AppUI.TYPE_WIDGET, str, (String) null, str2, str3, false, 36, (f) null);
        }

        public final AppUI getAppUIFromMeta(m mVar) {
            if (mVar != null) {
                return (AppUI) j6.b.a(String.valueOf((yc.f) mVar.get("appUI")), AppUI.class);
            }
            return null;
        }

        public final tc.a serializer() {
            return AppUI$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public AppUI(String str, String str2, String str3, String str4, String str5, boolean z10) {
        str.getClass();
        str2.getClass();
        this.type = str;
        this.packageName = str2;
        this.appUIName = str3;
        this.widgetName = str4;
        this.widgetAction = str5;
        this.isFix = z10;
    }

    public /* synthetic */ AppUI(String str, String str2, String str3, String str4, String str5, boolean z10, int i, f fVar) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? false : z10);
    }
}
