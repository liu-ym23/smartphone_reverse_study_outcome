package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import h9.InterfaceC4149a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJM\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/chat/view/PagingFeedbackPolicy;", "", "<init>", "()V", "", ChatTracker.PREVIEW_LOADING, "hasError", "completed", "empty", "showEmpty", "showRetryWhenEmpty", "Lcom/stepos/ailauncher/chat/view/PagingFeedbackPolicy$Feedback;", Const.INTENT_KEY_APIKEY, "(ZZZZZZ)Lcom/stepos/ailauncher/chat/view/PagingFeedbackPolicy$Feedback;", "active", "contentVisible", "layoutPending", "hasNext", "loadAll", "canScrollDown", Const.INTENT_KEY_PKGNAME, "(ZZZZZZZZ)Z", "Feedback", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PagingFeedbackPolicy {
    public static final PagingFeedbackPolicy INSTANCE = new PagingFeedbackPolicy();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/view/PagingFeedbackPolicy$Feedback;", "", "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "RETRY", "EMPTY", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Feedback {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Feedback[] $VALUES;
        public static final Feedback HIDDEN = new Feedback("HIDDEN", 0);
        public static final Feedback RETRY = new Feedback("RETRY", 1);
        public static final Feedback EMPTY = new Feedback("EMPTY", 2);

        private static final /* synthetic */ Feedback[] $values() {
            return new Feedback[]{HIDDEN, RETRY, EMPTY};
        }

        static {
            Feedback[] feedbackArr$values = $values();
            $VALUES = feedbackArr$values;
            $ENTRIES = kotlin.enums.a.a(feedbackArr$values);
        }

        private Feedback(String str, int i10) {
        }

        public static InterfaceC4149a<Feedback> getEntries() {
            return $ENTRIES;
        }

        public static Feedback valueOf(String str) {
            return (Feedback) Enum.valueOf(Feedback.class, str);
        }

        public static Feedback[] values() {
            return (Feedback[]) $VALUES.clone();
        }
    }

    public final Feedback a(boolean loading, boolean hasError, boolean completed, boolean empty, boolean showEmpty, boolean showRetryWhenEmpty) {
        return loading ? Feedback.HIDDEN : (!hasError || (empty && !showRetryWhenEmpty)) ? (completed && empty && showEmpty) ? Feedback.EMPTY : Feedback.HIDDEN : Feedback.RETRY;
    }

    public final boolean b(boolean active, boolean contentVisible, boolean layoutPending, boolean loading, boolean hasError, boolean hasNext, boolean loadAll, boolean canScrollDown) {
        if (!active || !contentVisible || layoutPending || loading || hasError || !hasNext) {
            return false;
        }
        return loadAll || !canScrollDown;
    }
}
