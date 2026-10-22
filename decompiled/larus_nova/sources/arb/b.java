package arb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.model.ChatAtModel;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public interface b {
    void V(Object r100, String r101);

    void W();

    boolean X();

    void Y(Context r100, String r101);

    void Z(SparseArray<drb.a<? extends BaseAtBean, ?>> r100, IItemContainer r101);

    String a0(String r100);

    void b0();

    void c0(Object r100, String r101, ChatAtModel.a r102);

    void d0(boolean r100);

    Drawable e0(Context r100, List r101);
}
