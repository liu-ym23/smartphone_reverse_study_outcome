package com.bytedance.android.livehostapi.business.depend.miniapp;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/miniapp/ReviewStatus;", "", "TYPE", "", "(Ljava/lang/String;II)V", "getTYPE", "()I", "NO_REVIEW", "REVIEW_PASS", "REVIEW_REJECT", "REVIEW_UNKNOWN", "Companion", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReviewStatus extends Enum<ReviewStatus> {
    private static final /* synthetic */ ReviewStatus[] $VALUES = null;
    public static final Companion Companion = null;
    public static final ReviewStatus NO_REVIEW = null;
    public static final ReviewStatus REVIEW_PASS = null;
    public static final ReviewStatus REVIEW_REJECT = null;
    public static final ReviewStatus REVIEW_UNKNOWN = null;
    private final int TYPE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/miniapp/ReviewStatus$Companion;", "", "()V", "from", "Lcom/bytedance/android/livehostapi/business/depend/miniapp/ReviewStatus;", "findValue", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ReviewStatus from(int r100) {
            ReviewStatus[] r101 = ReviewStatus.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L12;
            ReviewStatus r104 = r101[r103];
            if (r100 != r104.getTYPE()) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L9;
            r103 = r103 + 1;
            goto L3
        L9:
            return r104;
        L7:
            r105 = false;
            goto L8
        L12:
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
    }

    static {
        ReviewStatus r100 = new ReviewStatus("NO_REVIEW", 0, -1);
        NO_REVIEW = r100;
        ReviewStatus r101 = new ReviewStatus("REVIEW_PASS", 1, 1);
        REVIEW_PASS = r101;
        ReviewStatus r102 = new ReviewStatus("REVIEW_REJECT", 2, 2);
        REVIEW_REJECT = r102;
        ReviewStatus r103 = new ReviewStatus("REVIEW_UNKNOWN", 3, 0);
        REVIEW_UNKNOWN = r103;
        $VALUES = new ReviewStatus[]{r100, r101, r102, r103};
        Companion = new Companion(null);
    }

    public static ReviewStatus valueOf(String r100) {
        return (ReviewStatus) a.a(ReviewStatus.class, r100);
    }

    public static ReviewStatus[] values() {
        return (ReviewStatus[]) $VALUES.clone();
    }

    public final int getTYPE() {
        return this.TYPE;
    }

    private ReviewStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.TYPE = r102;
    }
}
