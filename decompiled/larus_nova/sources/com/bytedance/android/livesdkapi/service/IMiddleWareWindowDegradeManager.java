package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u0000 \n2\u00020\u0001:\u0003\n\u000b\fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005H&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IMiddleWareWindowDegradeManager;", "Lcom/bytedance/android/live/base/IService;", "checkDegradeForHybrid", "", "page", "", "checkDegradeForNative", "checkRecoverForHybrid", "source", "checkRecoverForNative", "Companion", "DegradeFlag", "DegradeLevel", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddleWareWindowDegradeManager extends IService {
    public static final Companion Companion = null;
    public static final int FLAG_DEGRADE_GIFT = 1;
    public static final int FLAG_DEGRADE_LEVEL_1 = 1;
    public static final int FLAG_DEGRADE_LEVEL_2 = 2;
    public static final int FLAG_DEGRADE_LEVEL_3 = 4;
    public static final int FLAG_DEGRADE_NONE = 0;
    public static final int FLAG_DEGRADE_REV_LINK = 2;
    public static final String NATIVE_KEY_PROFILE = "profile_parallax";
    public static final int WINDOW_DEGRADE_LEVEL_1 = 1;
    public static final int WINDOW_DEGRADE_LEVEL_2 = 2;
    public static final int WINDOW_DEGRADE_LEVEL_3 = 3;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IMiddleWareWindowDegradeManager$Companion;", "", "()V", "FLAG_DEGRADE_GIFT", "", "FLAG_DEGRADE_LEVEL_1", "FLAG_DEGRADE_LEVEL_2", "FLAG_DEGRADE_LEVEL_3", "FLAG_DEGRADE_NONE", "FLAG_DEGRADE_REV_LINK", "NATIVE_KEY_PROFILE", "", "WINDOW_DEGRADE_LEVEL_1", "WINDOW_DEGRADE_LEVEL_2", "WINDOW_DEGRADE_LEVEL_3", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int FLAG_DEGRADE_GIFT = 1;
        public static final int FLAG_DEGRADE_LEVEL_1 = 1;
        public static final int FLAG_DEGRADE_LEVEL_2 = 2;
        public static final int FLAG_DEGRADE_LEVEL_3 = 4;
        public static final int FLAG_DEGRADE_NONE = 0;
        public static final int FLAG_DEGRADE_REV_LINK = 2;
        public static final String NATIVE_KEY_PROFILE = "profile_parallax";
        public static final int WINDOW_DEGRADE_LEVEL_1 = 1;
        public static final int WINDOW_DEGRADE_LEVEL_2 = 2;
        public static final int WINDOW_DEGRADE_LEVEL_3 = 3;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void checkRecoverForHybrid$default(IMiddleWareWindowDegradeManager r100, String r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = "";
        L6:
            r100.checkRecoverForHybrid(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkRecoverForHybrid");
        }

        public static /* synthetic */ void checkRecoverForNative$default(IMiddleWareWindowDegradeManager r100, String r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = "";
        L6:
            r100.checkRecoverForNative(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkRecoverForNative");
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IMiddleWareWindowDegradeManager$DegradeFlag;", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public @interface DegradeFlag {
    }

    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IMiddleWareWindowDegradeManager$DegradeLevel;", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DegradeLevel {
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void checkDegradeForHybrid(String r100);

    void checkDegradeForNative(String r100);

    void checkRecoverForHybrid(String r100, String r101);

    void checkRecoverForNative(String r100, String r101);
}
