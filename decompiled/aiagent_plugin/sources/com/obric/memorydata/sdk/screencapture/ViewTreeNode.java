package com.obric.memorydata.sdk.screencapture;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ViewTreeNode.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ViewTreeNode implements Parcelable {
    public static final Parcelable.Creator<ViewTreeNode> CREATOR = null;
    private final String className;
    private final String contentDescription;
    private final String id;
    private final Rect rect;
    private final String text;
    private final boolean visible;

    /* JADX INFO: compiled from: ViewTreeNode.kt */
    public static final class Creator implements Parcelable.Creator<ViewTreeNode> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ViewTreeNode createFromParcel(Parcel r8) {
            o.e(r8, "parcel");
            String r1 = r8.readString();
            String r2 = r8.readString();
            String r3 = r8.readString();
            String r4 = r8.readString();
            Rect r5 = (Rect) ZeusTransformUtils.preCheckCast(r8.readParcelable(ViewTreeNode.class.getClassLoader()), Rect.class, "com.obric.aiagent.plugin");
            if (r8.readInt() == 0) goto L5;
            boolean r9 = true;
        L7:
            return new ViewTreeNode(r1, r2, r3, r4, r5, r9);
        L5:
            r9 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ViewTreeNode createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ViewTreeNode[] newArray(int r1) {
            return new ViewTreeNode[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ViewTreeNode[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ ViewTreeNode copy$default(ViewTreeNode r4, String r5, String r6, String r7, String r8, Rect r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.text;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.contentDescription;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.id;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.className;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.rect;
    L17:
        Rect r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.visible;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.contentDescription;
    }

    public final String component3() {
        return this.id;
    }

    public final String component4() {
        return this.className;
    }

    public final Rect component5() {
        return this.rect;
    }

    public final boolean component6() {
        return this.visible;
    }

    public final ViewTreeNode copy(String r8, String r9, String r10, String r11, Rect r12, boolean r13) {
        o.e(r8, "text");
        o.e(r9, "contentDescription");
        o.e(r10, DbHelper.COL_ID);
        o.e(r11, "className");
        o.e(r12, "rect");
        return new ViewTreeNode(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ViewTreeNode.class) == true) goto L8;
        return false;
    L8:
        ViewTreeNode r6 = (ViewTreeNode) ZeusTransformUtils.preCheckCast(r5, ViewTreeNode.class, "com.obric.aiagent.plugin");
        if (o.a(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (o.a(this.contentDescription, r6.contentDescription) == true) goto L15;
        return false;
    L15:
        if (o.a(this.id, r6.id) == true) goto L18;
        return false;
    L18:
        if (o.a(this.className, r6.className) == true) goto L21;
        return false;
    L21:
        if (o.a(this.rect, r6.rect) == true) goto L24;
        return false;
    L24:
        if (this.visible == r6.visible) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.text.hashCode() * 31) + this.contentDescription.hashCode()) * 31) + this.id.hashCode()) * 31) + this.className.hashCode()) * 31) + this.rect.hashCode()) * 31) + Boolean.hashCode(this.visible);
    }

    public String toString() {
        return "ViewTreeNode(text=" + this.text + ", contentDescription=" + this.contentDescription + ", id=" + this.id + ", className=" + this.className + ", rect=" + this.rect + ", visible=" + this.visible + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "dest");
        r4.writeString(this.text);
        r4.writeString(this.contentDescription);
        r4.writeString(this.id);
        r4.writeString(this.className);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.rect, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeInt(this.visible ? 1 : 0);
    }

    public ViewTreeNode(String r2, String r3, String r4, String r5, Rect r6, boolean r7) {
        o.e(r2, "text");
        o.e(r3, "contentDescription");
        o.e(r4, DbHelper.COL_ID);
        o.e(r5, "className");
        o.e(r6, "rect");
        this.text = r2;
        this.contentDescription = r3;
        this.id = r4;
        this.className = r5;
        this.rect = r6;
        this.visible = r7;
    }

    public final String getText() {
        return this.text;
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final String getId() {
        return this.id;
    }

    public final String getClassName() {
        return this.className;
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final boolean getVisible() {
        return this.visible;
    }
}
