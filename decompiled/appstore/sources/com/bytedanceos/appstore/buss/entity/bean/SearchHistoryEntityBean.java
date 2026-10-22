package com.bytedanceos.appstore.buss.entity.bean;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Entity(tableName = "tv_search_history_table")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/bean/SearchHistoryEntityBean;", "", "word", "", "createTime", "", "(Ljava/lang/String;J)V", "getCreateTime", "()J", "getWord", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SearchHistoryEntityBean {
    private final long createTime;

    @PrimaryKey
    @ColumnInfo(name = "id")
    @NotNull
    private final String word;

    public SearchHistoryEntityBean(@NotNull String r10, long r11) {
        q.g(r10, "word");
        this.word = r10;
        this.createTime = r11;
    }

    public static /* synthetic */ SearchHistoryEntityBean copy$default(SearchHistoryEntityBean r10, String r11, long r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.word;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.createTime;
    L9:
        return r10.copy(r11, r12);
    }

    @NotNull
    public final String component1() {
        return this.word;
    }

    public final long component2() {
        return this.createTime;
    }

    @NotNull
    public final SearchHistoryEntityBean copy(@NotNull String r10, long r11) {
        q.g(r10, "word");
        return new SearchHistoryEntityBean(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SearchHistoryEntityBean) == true) goto L8;
        return false;
    L8:
        SearchHistoryEntityBean r11 = (SearchHistoryEntityBean) r10;
        if (q.b(this.word, r11.word) == true) goto L12;
        return false;
    L12:
        if (this.createTime == r11.createTime) goto L14;
        return false;
    L14:
        return true;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final String getWord() {
        return this.word;
    }

    public int hashCode() {
        return (this.word.hashCode() * 31) + Long.hashCode(this.createTime);
    }

    @NotNull
    public String toString() {
        return "SearchHistoryEntityBean(word=" + this.word + ", createTime=" + this.createTime + ')';
    }
}
