package brb;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.GroupMemAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.WantAtMemBean;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final List<BaseAtBean> a(List<? extends BaseAtBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ArrayList r101 = new ArrayList();
        Iterator<? extends BaseAtBean> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L19;
        BaseAtBean r103 = r102.next();
        if ((r103 instanceof GroupMemAtBean) == false) goto L9;
        com.ss.android.lark.mention.base.impl.atselector.bean.a r104 = ((GroupMemAtBean) r103).getChatterInfo();
    L15:
        if (r104 == null) goto L18;
        if (r104.f431701g == Chatter.ChatterType.AI) goto L4;
    L18:
        r101.add(r103);
        goto L4
    L9:
        if ((r103 instanceof SearchBean) == false) goto L12;
        r104 = ((SearchBean) r103).getChatterInfo();
        goto L15
    L12:
        if ((r103 instanceof WantAtMemBean) == false) goto L14;
        r104 = ((WantAtMemBean) r103).getChatterInfo();
        goto L15
    L14:
        r104 = null;
        goto L15
    L19:
        HashSet r105 = new HashSet();
        ArrayList r106 = new ArrayList();
        Iterator r107 = r101.iterator();
    L21:
        if (r107.hasNext() == false) goto L30;
        Object r108 = r107.next();
        BaseAtBean r109 = (BaseAtBean) r108;
        if ((r109 instanceof SearchBean) == false) goto L25;
        String r110 = ((SearchBean) r109).getChatterInfo().f431695a;
    L27:
        if (r105.add(r110) == false) goto L21;
        r106.add(r108);
        goto L21
    L25:
        r110 = UUID.randomUUID().toString();
        goto L27
    L30:
        if (r106.size() == r101.size()) goto L32;
        Log.w("MentionList", "duplicate search items");
    L32:
        return r106;
    }
}
