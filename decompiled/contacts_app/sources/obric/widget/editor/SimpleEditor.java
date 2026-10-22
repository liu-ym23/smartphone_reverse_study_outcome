package obric.widget.editor;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes5.dex */
public class SimpleEditor extends AbsEditor {
    @Override // obric.widget.editor.AbsEditor
    protected int getDefaultLeftLayout() {
        return 0;
    }

    @Override // obric.widget.editor.AbsEditor
    protected int getDefaultRightLayout() {
        return 0;
    }

    @Override // obric.widget.editor.AbsEditor
    protected void initLeftWidget() {
    }

    @Override // obric.widget.editor.AbsEditor
    protected void initRightWidget() {
    }

    public SimpleEditor(Context context) {
        this(context, null);
    }

    public SimpleEditor(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleEditor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
