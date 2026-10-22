package com.bytedance.android.annie.debug.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.CompoundButton;
import com.bytedance.common.utility.android.ClipboardCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public class DialogItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f39428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f39429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View.OnClickListener f39430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompoundButton.OnCheckedChangeListener f39431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ItemType f39432f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/DialogItem$ItemType;", "", "DUMMY_TITLE", "JUMP_TITLE", "KV_TEXT", "VALUE_TEXT", "SWITCH", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
    public static final enum ItemType extends Enum<ItemType> {
        public static final ItemType DUMMY_TITLE = null;
        public static final ItemType JUMP_TITLE = null;
        public static final ItemType KV_TEXT = null;
        public static final ItemType SWITCH = null;
        public static final ItemType VALUE_TEXT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ItemType[] f39433a = null;

        public static ItemType valueOf(String r100) {
            return (ItemType) r27.a.a(ItemType.class, r100);
        }

        public static ItemType[] values() {
            return (ItemType[]) f39433a.clone();
        }

        static {
            ItemType r100 = new ItemType("DUMMY_TITLE", 0);
            DUMMY_TITLE = r100;
            ItemType r101 = new ItemType("JUMP_TITLE", 1);
            JUMP_TITLE = r101;
            ItemType r102 = new ItemType("KV_TEXT", 2);
            KV_TEXT = r102;
            ItemType r103 = new ItemType("VALUE_TEXT", 3);
            VALUE_TEXT = r103;
            ItemType r104 = new ItemType("SWITCH", 4);
            SWITCH = r104;
            f39433a = new ItemType[]{r100, r101, r102, r103, r104};
        }

        public ItemType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f39434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DialogItem f39435b;

        public a(Context r100, DialogItem r101) {
            this.f39434a = r100;
            this.f39435b = r101;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            ClipboardCompat.setText(this.f39434a, "", this.f39435b.f39428b);
        }
    }

    public final ItemType getType() {
        ItemType r100 = this.f39432f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public void a(Context r100) {
        String r101 = this.f39428b;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        AlertDialog.Builder r103 = new AlertDialog.Builder(r100);
        r103.setMessage(this.f39428b).setPositiveButton("确定", new a(r100, this));
        r103.show();
        return;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    public DialogItem(String r100, String r101, View.OnClickListener r102) {
        this.f39427a = r100;
        this.f39428b = r101;
        this.f39430d = r102;
        if (r100 == null) goto L12;
        if (r101 != null) goto L10;
        if (r102 != null) goto L8;
        ItemType r103 = ItemType.DUMMY_TITLE;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f39432f = r103;
        return;
    L8:
        ItemType r104 = ItemType.JUMP_TITLE;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f39432f = r104;
        return;
    L10:
        ItemType r105 = ItemType.KV_TEXT;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f39432f = r105;
        return;
    L12:
        ItemType r106 = ItemType.VALUE_TEXT;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f39432f = r106;
    }

    public DialogItem(String r100, boolean r101, CompoundButton.OnCheckedChangeListener r102) {
        this.f39427a = r100;
        this.f39431e = r102;
        ItemType r103 = ItemType.SWITCH;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f39432f = r103;
        this.f39429c = r101;
    }

    public /* synthetic */ DialogItem(String r100, String r101, View.OnClickListener r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
