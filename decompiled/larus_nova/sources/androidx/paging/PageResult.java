package androidx.paging;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
class PageResult<T> {
    static final int APPEND = 1;
    private static final PageResult EMPTY_RESULT = null;
    static final int INIT = 0;
    private static final PageResult INVALID_RESULT = null;
    static final int PREPEND = 2;
    static final int TILE = 3;
    public final int leadingNulls;
    public final List<T> page;
    public final int positionOffset;
    public final int trailingNulls;

    public static abstract class Receiver<T> {
        public Receiver() {
        }

        public abstract void onPageResult(int r100, PageResult<T> r101);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResultType {
    }

    static {
        EMPTY_RESULT = new PageResult(Collections.emptyList(), 0);
        INVALID_RESULT = new PageResult(Collections.emptyList(), 0);
    }

    public boolean isInvalid() {
        if (this != INVALID_RESULT) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "Result " + this.leadingNulls + ", " + this.page + ", " + this.trailingNulls + ", offset " + this.positionOffset;
    }

    public static <T> PageResult<T> getEmptyResult() {
        return EMPTY_RESULT;
    }

    public static <T> PageResult<T> getInvalidResult() {
        return INVALID_RESULT;
    }

    public PageResult(List<T> r100, int r101) {
        this.page = r100;
        this.leadingNulls = 0;
        this.trailingNulls = 0;
        this.positionOffset = r101;
    }

    public PageResult(List<T> r100, int r101, int r102, int r103) {
        this.page = r100;
        this.leadingNulls = r101;
        this.trailingNulls = r102;
        this.positionOffset = r103;
    }
}
