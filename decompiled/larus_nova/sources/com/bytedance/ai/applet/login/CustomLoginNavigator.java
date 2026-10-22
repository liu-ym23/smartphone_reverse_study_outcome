package com.bytedance.ai.applet.login;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes43.dex */
public final class CustomLoginNavigator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CustomLoginNavigator f34707a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f34708b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, r4.f.a> f34709c = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/applet/login/CustomLoginNavigator$LaunchReason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NO_PHONE_MASK", "OTHER_LOGIN_METHOD", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LaunchReason extends Enum<LaunchReason> {
        public static final LaunchReason NO_PHONE_MASK = null;
        public static final LaunchReason OTHER_LOGIN_METHOD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LaunchReason[] f34710a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f34711b = null;
        private final String value;

        public static EnumEntries<LaunchReason> getEntries() {
            return f34711b;
        }

        static {
            LaunchReason r100 = new LaunchReason("NO_PHONE_MASK", 0, "no_phone_mask");
            NO_PHONE_MASK = r100;
            LaunchReason r101 = new LaunchReason("OTHER_LOGIN_METHOD", 1, "other_login_method");
            OTHER_LOGIN_METHOD = r101;
            LaunchReason[] r102 = {r100, r101};
            f34710a = r102;
            f34711b = EnumEntriesKt.enumEntries(r102);
        }

        public static LaunchReason[] values() {
            return (LaunchReason[]) f34710a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static LaunchReason valueOf(String r100) {
            return (LaunchReason) r27.a.a(LaunchReason.class, r100);
        }

        public LaunchReason(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/applet/login/CustomLoginNavigator$LaunchSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CHAT", "FULL_PAGE", "UNKNOWN", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LaunchSource extends Enum<LaunchSource> {
        public static final LaunchSource CHAT = null;
        public static final a Companion = null;
        public static final LaunchSource FULL_PAGE = null;
        public static final LaunchSource UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LaunchSource[] f34712a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f34713b = null;
        private final String value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<LaunchSource> getEntries() {
            return f34713b;
        }

        static {
            LaunchSource r100 = new LaunchSource("CHAT", 0, "chat");
            CHAT = r100;
            LaunchSource r101 = new LaunchSource("FULL_PAGE", 1, "detail");
            FULL_PAGE = r101;
            LaunchSource r102 = new LaunchSource("UNKNOWN", 2, "unknown");
            UNKNOWN = r102;
            LaunchSource[] r103 = {r100, r101, r102};
            f34712a = r103;
            f34713b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static LaunchSource[] values() {
            return (LaunchSource[]) f34712a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static LaunchSource valueOf(String r100) {
            return (LaunchSource) r27.a.a(LaunchSource.class, r100);
        }

        public LaunchSource(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f34714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f34715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f34716c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LaunchSource f34717d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LaunchReason f34718e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f34714a, r101.f34714a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f34715b, r101.f34715b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f34716c, r101.f34716c) == true) goto L18;
            return false;
        L18:
            if (this.f34717d == r101.f34717d) goto L21;
            return false;
        L21:
            if (this.f34718e == r101.f34718e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f34714a.hashCode() * 31;
            String r101 = this.f34715b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((((((r100 + r102) * 31) + this.f34716c.hashCode()) * 31) + this.f34717d.hashCode()) * 31) + this.f34718e.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "LaunchContext(appletId=" + this.f34714a + ", messageId=" + this.f34715b + ", url=" + this.f34716c + ", source=" + this.f34717d + ", reason=" + this.f34718e + ')';
        }

        public a(String r100, String r101, String r102, LaunchSource r103, LaunchReason r104) {
            Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
            Intrinsics.checkNotNullParameter(r102, "url");
            Intrinsics.checkNotNullParameter(r103, "source");
            Intrinsics.checkNotNullParameter(r104, "reason");
            this.f34714a = r100;
            this.f34715b = r101;
            this.f34716c = r102;
            this.f34717d = r103;
            this.f34718e = r104;
        }
    }

    public CustomLoginNavigator() {
    }

    static {
        f34707a = new CustomLoginNavigator();
        f34708b = new ConcurrentHashMap();
        f34709c = new ConcurrentHashMap();
    }

    public static void c(String r100) {
        r4.f.a r101 = f34709c.remove(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        r4.f r102 = r4.a.f535987n;
        if (r102 != null) goto L9;
        com.bytedance.ai.utils.g.f37637a.w("CustomLoginNavigator", "unregisterHostMainActivityLifecycleCallback: lifecycleDepend is null, appletId=" + r100);
        return;
    L9:
        r102.a(r101);
    }

    public final Object a(String r110, String r111, String r112, String r113, String r114, Continuation<? super Result<Unit>> r115) {
        if ((r115 instanceof CustomLoginNavigator$navigateToCustomLogin$1) == false) goto L7;
        CustomLoginNavigator$navigateToCustomLogin$1 r100 = (CustomLoginNavigator$navigateToCustomLogin$1) r115;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        CustomLoginNavigator$navigateToCustomLogin$1 r116 = r100;
        Object r102 = r116.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r116.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
        return ((Result) r102).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        LaunchSource.Companion.getClass();
        if (Intrinsics.areEqual(r111, "chat") == false) goto L19;
        LaunchSource r105 = LaunchSource.CHAT;
    L17:
        LaunchSource r106 = r105;
        LaunchReason r117 = LaunchReason.NO_PHONE_MASK;
        r116.label = 1;
        Object r107 = b(r110, r112, r113, r114, "mcp-login-page", r106, r117, r116);
        if (r107 != r103) goto L26;
        return r103;
    L26:
        return r107;
    L19:
        if (Intrinsics.areEqual(r111, "detail") == false) goto L21;
        r105 = LaunchSource.FULL_PAGE;
        goto L17
    L21:
        r105 = LaunchSource.UNKNOWN;
    L7:
        r100 = new CustomLoginNavigator$navigateToCustomLogin$1(this, r115);
        goto L8
    }

    public final Object b(String r110, String r111, String r112, String r113, String r210, LaunchSource r211, LaunchReason r212, Continuation<? super Result<Unit>> r213) {
        if ((r213 instanceof CustomLoginNavigator$openLoginPage$1) == false) goto L7;
        CustomLoginNavigator$openLoginPage$1 r100 = (CustomLoginNavigator$openLoginPage$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L18:
        return ((Result) r102).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        MainCoroutineDispatcher r105 = Dispatchers.getMain().getImmediate();
        CustomLoginNavigator$openLoginPage$2 r106 = new CustomLoginNavigator$openLoginPage$2(r110, r211, r212, r111, r112, r113, r210, null);
        r100.label = 1;
        r102 = BuildersKt.withContext(r105, r106, r100);
        if (r102 != r103) goto L18;
        return r103;
    L7:
        r100 = new CustomLoginNavigator$openLoginPage$1(this, r213);
        goto L8
    }
}
