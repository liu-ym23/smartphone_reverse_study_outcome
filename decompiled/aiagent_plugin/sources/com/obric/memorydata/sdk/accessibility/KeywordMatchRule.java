package com.obric.memorydata.sdk.accessibility;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.memorydata.sdk.screencapture.rule.f;
import com.obric.memorydata.sdk.screencapture.rule.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: KeywordMatchRule.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class KeywordMatchRule implements Parcelable {
    public static final Parcelable.Creator<KeywordMatchRule> CREATOR = null;
    private final String keyword;
    private final g matchRule;
    private final f searchNode;
    private final boolean traverseAllChildren;
    private final String viewIdResourceName;
    private final long viewTreeCacheValidDuration;
    private final boolean viewVisibleOnly;

    /* JADX INFO: compiled from: KeywordMatchRule.kt */
    public static final class Creator implements Parcelable.Creator<KeywordMatchRule> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final KeywordMatchRule createFromParcel(Parcel r11) {
            o.e(r11, "parcel");
            String r1 = r11.readString();
            f r2 = f.valueOf(r11.readString());
            g r3 = g.valueOf(r11.readString());
            if (r11.readInt() == 0) goto L5;
            boolean r6 = true;
        L6:
            String r7 = r11.readString();
            long r8 = r11.readLong();
            if (r11.readInt() == 0) goto L9;
            boolean r12 = true;
        L11:
            return new KeywordMatchRule(r1, r2, r3, r6, r7, r8, r12);
        L9:
            r12 = false;
            goto L11
        L5:
            r6 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ KeywordMatchRule createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final KeywordMatchRule[] newArray(int r1) {
            return new KeywordMatchRule[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ KeywordMatchRule[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ KeywordMatchRule copy$default(KeywordMatchRule r9, String r10, f r11, g r12, boolean r13, String r14, long r15, boolean r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.keyword;
    L7:
        if ((r18 & 2) == 0) goto L9;
        f r2 = r9.searchNode;
    L11:
        if ((r18 & 4) == 0) goto L13;
        g r3 = r9.matchRule;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r4 = r9.traverseAllChildren;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r5 = r9.viewIdResourceName;
    L23:
        if ((r18 & 32) == 0) goto L25;
        long r6 = r9.viewTreeCacheValidDuration;
    L27:
        if ((r18 & 64) == 0) goto L29;
        boolean r8 = r9.viewVisibleOnly;
    L31:
        return r9.copy(r1, r2, r3, r4, r5, r6, r8);
    L29:
        r8 = r17;
        goto L31
    L25:
        r6 = r15;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String component1() {
        return this.keyword;
    }

    public final f component2() {
        return this.searchNode;
    }

    public final g component3() {
        return this.matchRule;
    }

    public final boolean component4() {
        return this.traverseAllChildren;
    }

    public final String component5() {
        return this.viewIdResourceName;
    }

    public final long component6() {
        return this.viewTreeCacheValidDuration;
    }

    public final boolean component7() {
        return this.viewVisibleOnly;
    }

    public final KeywordMatchRule copy(String r11, f r12, g r13, boolean r14, String r15, long r16, boolean r18) {
        o.e(r11, "keyword");
        o.e(r12, "searchNode");
        o.e(r13, "matchRule");
        return new KeywordMatchRule(r11, r12, r13, r14, r15, r16, r18);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, KeywordMatchRule.class) == true) goto L8;
        return false;
    L8:
        KeywordMatchRule r10 = (KeywordMatchRule) ZeusTransformUtils.preCheckCast(r9, KeywordMatchRule.class, "com.obric.aiagent.plugin");
        if (o.a(this.keyword, r10.keyword) == true) goto L12;
        return false;
    L12:
        if (this.searchNode == r10.searchNode) goto L15;
        return false;
    L15:
        if (this.matchRule == r10.matchRule) goto L18;
        return false;
    L18:
        if (this.traverseAllChildren == r10.traverseAllChildren) goto L21;
        return false;
    L21:
        if (o.a(this.viewIdResourceName, r10.viewIdResourceName) == true) goto L24;
        return false;
    L24:
        if (this.viewTreeCacheValidDuration == r10.viewTreeCacheValidDuration) goto L27;
        return false;
    L27:
        if (this.viewVisibleOnly == r10.viewVisibleOnly) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.keyword.hashCode() * 31) + this.searchNode.hashCode()) * 31) + this.matchRule.hashCode()) * 31) + Boolean.hashCode(this.traverseAllChildren)) * 31;
        String r1 = this.viewIdResourceName;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Long.hashCode(this.viewTreeCacheValidDuration)) * 31) + Boolean.hashCode(this.viewVisibleOnly);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "KeywordMatchRule(keyword=" + this.keyword + ", searchNode=" + this.searchNode + ", matchRule=" + this.matchRule + ", traverseAllChildren=" + this.traverseAllChildren + ", viewIdResourceName=" + this.viewIdResourceName + ", viewTreeCacheValidDuration=" + this.viewTreeCacheValidDuration + ", viewVisibleOnly=" + this.viewVisibleOnly + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        r3.writeString(this.keyword);
        r3.writeString(this.searchNode.name());
        r3.writeString(this.matchRule.name());
        r3.writeInt(this.traverseAllChildren ? 1 : 0);
        r3.writeString(this.viewIdResourceName);
        r3.writeLong(this.viewTreeCacheValidDuration);
        r3.writeInt(this.viewVisibleOnly ? 1 : 0);
    }

    public KeywordMatchRule(String r2, f r3, g r4, boolean r5, String r6, long r7, boolean r9) {
        o.e(r2, "keyword");
        o.e(r3, "searchNode");
        o.e(r4, "matchRule");
        this.keyword = r2;
        this.searchNode = r3;
        this.matchRule = r4;
        this.traverseAllChildren = r5;
        this.viewIdResourceName = r6;
        this.viewTreeCacheValidDuration = r7;
        this.viewVisibleOnly = r9;
    }

    public /* synthetic */ KeywordMatchRule(String r11, f r12, g r13, boolean r14, String r15, long r16, boolean r18, int r19, h r20) {
        if ((r19 & 8) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r19 & 16) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r19 & 32) == 0) goto L13;
        long r7 = 1000;
    L15:
        if ((r19 & 64) == 0) goto L17;
        boolean r9 = true;
    L18:
        this(r11, r12, r13, r5, r6, r7, r9);
        return;
    L17:
        r9 = r18;
        goto L18
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final f getSearchNode() {
        return this.searchNode;
    }

    public final g getMatchRule() {
        return this.matchRule;
    }

    public final boolean getTraverseAllChildren() {
        return this.traverseAllChildren;
    }

    public final String getViewIdResourceName() {
        return this.viewIdResourceName;
    }

    public final long getViewTreeCacheValidDuration() {
        return this.viewTreeCacheValidDuration;
    }

    public final boolean getViewVisibleOnly() {
        return this.viewVisibleOnly;
    }
}
