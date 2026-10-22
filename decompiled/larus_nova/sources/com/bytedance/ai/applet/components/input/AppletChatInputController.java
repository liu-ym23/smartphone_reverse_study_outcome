package com.bytedance.ai.applet.components.input;

import androidx.fragment.app.Fragment;
import com.bytedance.ai.applet.app.AppletFullScreenActivity;
import com.bytedance.ai.applet.app.foundation.AppletModelContextProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public interface AppletChatInputController {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/applet/components/input/AppletChatInputController$ActionBarItemLocation;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY_BAR", "DETAIL_PANEL", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActionBarItemLocation extends Enum<ActionBarItemLocation> {
        public static final ActionBarItemLocation DETAIL_PANEL = null;
        public static final ActionBarItemLocation PRIMARY_BAR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionBarItemLocation[] f34532a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f34533b = null;

        public static EnumEntries<ActionBarItemLocation> getEntries() {
            return f34533b;
        }

        static {
            ActionBarItemLocation r100 = new ActionBarItemLocation("PRIMARY_BAR", 0);
            PRIMARY_BAR = r100;
            ActionBarItemLocation r101 = new ActionBarItemLocation("DETAIL_PANEL", 1);
            DETAIL_PANEL = r101;
            ActionBarItemLocation[] r102 = {r100, r101};
            f34532a = r102;
            f34533b = EnumEntriesKt.enumEntries(r102);
        }

        public static ActionBarItemLocation[] values() {
            return (ActionBarItemLocation[]) f34532a.clone();
        }

        public static ActionBarItemLocation valueOf(String r100) {
            return (ActionBarItemLocation) r27.a.a(ActionBarItemLocation.class, r100);
        }

        public ActionBarItemLocation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a(ActionBarItemLocation r100, String r101, int r102);

        void b(ActionBarItemLocation r100, String r101, int r102);
    }

    public interface b {
        String b();

        e c();

        Map<String, String> getExtra();

        Integer getSource();
    }

    public interface c {
        void P0(r2.f r100);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f34534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f34535b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f34536c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f34537d;

        public d() {
            this(true, true, null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f34534a == r101.f34534a) goto L12;
            return false;
        L12:
            if (this.f34535b == r101.f34535b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f34536c, r101.f34536c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f34537d, r101.f34537d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f34534a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f34535b == true) goto L10;
            r100 = 1237;
        L10:
            int r103 = (r102 + r100) * 31;
            String r104 = this.f34536c;
            int r105 = 0;
            if (r104 != null) goto L13;
            int r106 = 0;
        L14:
            int r107 = (r103 + r106) * 31;
            String r108 = this.f34537d;
            if (r108 == null) goto L19;
            r105 = r108.hashCode();
        L19:
            return r107 + r105;
        L13:
            r106 = r104.hashCode();
            goto L14
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Config(cameraEnabled=" + this.f34534a + ", extraActionsEnabled=" + this.f34535b + ", inputHint=" + this.f34536c + ", speakHint=" + this.f34537d + ')';
        }

        public d(boolean r100, boolean r101, String r102, String r103) {
            this.f34534a = r100;
            this.f34535b = r101;
            this.f34536c = r102;
            this.f34537d = r103;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f34538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f34539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f f34540c;

        public e() {
            this(null, null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f34538a, r101.f34538a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f34539b, r101.f34539b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f34540c, r101.f34540c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f34538a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f34539b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            f r107 = this.f34540c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "GuiContext(artifactType=" + this.f34538a + ", uri=" + this.f34539b + ", view=" + this.f34540c + ')';
        }

        public e(String r100, String r101, f r102) {
            this.f34538a = r100;
            this.f34539b = r101;
            this.f34540c = r102;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f34541a;

        public f() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f34541a, ((f) r100).f34541a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f34541a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "GuiView(bizPayload=" + this.f34541a + ')';
        }

        public f(String r100) {
            this.f34541a = r100;
        }
    }

    public interface g {
        void A0(String r100, String r101);

        void L(String r100);

        void M0(String r100);

        void t();

        void y();
    }

    void A7(AppletFullScreenActivity.b r100);

    void I1(boolean r100, boolean r101);

    Fragment getFragment();

    boolean getVisibility();

    void q7(String r100);

    void r7(AppletModelContextProvider r100);

    void s7(c r100);

    void setVisibility(boolean r100);

    void t7();

    r2.f u6();

    void u7(g r100);

    void v7(r2.c r100);

    void w7(c r100);

    void x7(String r100, String r101);

    void y7(d r100);

    void z7(g r100);
}
