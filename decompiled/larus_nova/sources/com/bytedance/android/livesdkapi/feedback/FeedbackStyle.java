package com.bytedance.android.livesdkapi.feedback;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes12.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/feedback/FeedbackStyle;", "", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface FeedbackStyle {
    public static final int BOTTOM_BAR = 2;
    public static final int BOTTOM_COMPONENT = 3;
    public static final Companion Companion = null;
    public static final int PREVIEW_COMPLEX_COMPONENT = 5;
    public static final int PREVIEW_PAGE = 1;
    public static final int ROOM_COMMON_LYNX = 4;
    public static final int UNKNOWN = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/feedback/FeedbackStyle$Companion;", "", "()V", "BOTTOM_BAR", "", "BOTTOM_COMPONENT", "PREVIEW_COMPLEX_COMPONENT", "PREVIEW_PAGE", "ROOM_COMMON_LYNX", "UNKNOWN", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int BOTTOM_BAR = 2;
        public static final int BOTTOM_COMPONENT = 3;
        public static final int PREVIEW_COMPLEX_COMPONENT = 5;
        public static final int PREVIEW_PAGE = 1;
        public static final int ROOM_COMMON_LYNX = 4;
        public static final int UNKNOWN = 0;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
