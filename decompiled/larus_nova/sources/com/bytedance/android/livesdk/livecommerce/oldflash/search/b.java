package com.bytedance.android.livesdk.livecommerce.oldflash.search;

import android.view.KeyEvent;
import android.widget.TextView;
import com.bytedance.android.ui.ec.widget.searchbar.ECSearchBar;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECSearchBar f149690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveFlashSearchDialogFragment f149691b;

    public b(ECSearchBar r100, LiveFlashSearchDialogFragment r101) {
        this.f149690a = r100;
        this.f149691b = r101;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 3) goto L6;
        LiveFlashSearchDialogFragment.ja0(this.f149691b);
        ECSearchBar r103 = this.f149690a;
        r103.hideSoftInput(r103);
        return true;
    L6:
        return false;
    }
}
