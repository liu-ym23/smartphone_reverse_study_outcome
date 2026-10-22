package com.bytedance.ai.applet.app.base;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
public interface ApplicationRouter {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/applet/app/base/ApplicationRouter$Mode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NAVIGATE", "REDIRECT", "RELAUNCH", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Mode extends Enum<Mode> {
        public static final Mode NAVIGATE = null;
        public static final Mode REDIRECT = null;
        public static final Mode RELAUNCH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f34151a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f34152b = null;
        private final String value;

        public static EnumEntries<Mode> getEntries() {
            return f34152b;
        }

        static {
            Mode r100 = new Mode("NAVIGATE", 0, MusicAppletPage.ROUTE_MODE_NAVIGATION);
            NAVIGATE = r100;
            Mode r101 = new Mode("REDIRECT", 1, "redirect");
            REDIRECT = r101;
            Mode r102 = new Mode("RELAUNCH", 2, MusicAppletPage.ROUTE_MODE_RELAUNCH);
            RELAUNCH = r102;
            Mode[] r103 = {r100, r101, r102};
            f34151a = r103;
            f34152b = EnumEntriesKt.enumEntries(r103);
        }

        public static Mode[] values() {
            return (Mode[]) f34151a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static Mode valueOf(String r100) {
            return (Mode) r27.a.a(Mode.class, r100);
        }

        public Mode(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/applet/app/base/ApplicationRouter$OpenPageMode;", "", "<init>", "(Ljava/lang/String;I)V", FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, "REPLACE", "NAVIGATE", "POP_TO", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum OpenPageMode extends Enum<OpenPageMode> {
        public static final OpenPageMode NAVIGATE = null;
        public static final OpenPageMode POP_TO = null;
        public static final OpenPageMode PUSH = null;
        public static final OpenPageMode REPLACE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OpenPageMode[] f34153a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f34154b = null;

        public static EnumEntries<OpenPageMode> getEntries() {
            return f34154b;
        }

        static {
            OpenPageMode r100 = new OpenPageMode(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 0);
            PUSH = r100;
            OpenPageMode r101 = new OpenPageMode("REPLACE", 1);
            REPLACE = r101;
            OpenPageMode r102 = new OpenPageMode("NAVIGATE", 2);
            NAVIGATE = r102;
            OpenPageMode r103 = new OpenPageMode("POP_TO", 3);
            POP_TO = r103;
            OpenPageMode[] r104 = {r100, r101, r102, r103};
            f34153a = r104;
            f34154b = EnumEntriesKt.enumEntries(r104);
        }

        public static OpenPageMode[] values() {
            return (OpenPageMode[]) f34153a.clone();
        }

        public static OpenPageMode valueOf(String r100) {
            return (OpenPageMode) r27.a.a(OpenPageMode.class, r100);
        }

        public OpenPageMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    Object b(String r100, OpenPageMode r101, RouteOptions r102, Continuation<? super Result<Unit>> r103);

    Object c(String r100, RouteOptions r101, Continuation<? super Result<Unit>> r102);

    Object e(String r100, RouteOptions r101, Continuation<? super Result<Unit>> r102);

    Object f();

    Object i(String r100, RouteOptions r101, Continuation<? super Result<Unit>> r102);

    Object j(RouteOptions r100, Continuation<? super Result<Unit>> r101);

    void k(long r100);

    Object l(Continuation<? super Result<Unit>> r100);

    Object m(int r100);

    void n(long r100, String r101);
}
