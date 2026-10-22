package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.common.oui.R$array;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.color.i0;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaskMaterialOwner;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import com.tmall.wireless.tangram.structure.card.FixCard;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import td.h;
import td.i;
import zd.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0088\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ3\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\fH\u0002¢\u0006\u0004\b,\u0010\u000eJ\u000f\u0010-\u001a\u00020\bH\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\fH\u0002¢\u0006\u0004\b/\u0010\u000eJ\u000f\u00101\u001a\u000200H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u000200H\u0002¢\u0006\u0004\b3\u00102J\u000f\u00104\u001a\u000200H\u0002¢\u0006\u0004\b4\u00102J\u000f\u00105\u001a\u000200H\u0002¢\u0006\u0004\b5\u00102J\u0015\u00107\u001a\u00020\f2\u0006\u00106\u001a\u00020\b¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\fH\u0014¢\u0006\u0004\b9\u0010\u000eJ\u0015\u0010;\u001a\u00020\f2\u0006\u0010:\u001a\u00020\b¢\u0006\u0004\b;\u00108J\u001f\u0010=\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020\b¢\u0006\u0004\b=\u0010\u001bJ+\u0010@\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\b2\b\b\u0002\u0010<\u001a\u00020\b2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b@\u0010AJ\r\u0010B\u001a\u00020\f¢\u0006\u0004\bB\u0010\u000eJ\r\u0010C\u001a\u00020\f¢\u0006\u0004\bC\u0010\u000eJ\u001f\u0010D\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020\b¢\u0006\u0004\bD\u0010\u001bJ+\u0010E\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\b2\b\b\u0002\u0010<\u001a\u00020\b2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\bE\u0010AJ\r\u0010F\u001a\u00020\f¢\u0006\u0004\bF\u0010\u000eJ\u0015\u0010G\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\bG\u0010HJ\u001f\u0010I\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020\b¢\u0006\u0004\bI\u0010\u001bJ+\u0010J\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\b2\b\b\u0002\u0010<\u001a\u00020\b2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\bJ\u0010AJ+\u0010K\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010<\u001a\u00020\b2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\bK\u0010LJ\u0015\u0010M\u001a\u00020\f2\u0006\u0010<\u001a\u00020\b¢\u0006\u0004\bM\u00108J\u0015\u0010N\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\b¢\u0006\u0004\bN\u00108J\u0015\u0010O\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\b¢\u0006\u0004\bO\u00108J\u0015\u0010P\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\b¢\u0006\u0004\bP\u00108J\u0015\u0010Q\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\b¢\u0006\u0004\bQ\u00108J\r\u0010S\u001a\u00020R¢\u0006\u0004\bS\u0010TJ\r\u0010U\u001a\u00020R¢\u0006\u0004\bU\u0010TJ\r\u0010V\u001a\u00020R¢\u0006\u0004\bV\u0010TJ\r\u0010W\u001a\u00020R¢\u0006\u0004\bW\u0010TJ\u0017\u0010X\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\bX\u0010YJ\u0015\u0010X\u001a\u00020\f2\u0006\u0010Z\u001a\u00020\b¢\u0006\u0004\bX\u00108J\u0015\u0010\\\u001a\u00020\f2\u0006\u0010[\u001a\u00020\b¢\u0006\u0004\b\\\u00108J\u0017\u0010]\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b]\u0010YJ\u0015\u0010]\u001a\u00020\f2\u0006\u0010Z\u001a\u00020\b¢\u0006\u0004\b]\u00108J\u0015\u0010^\u001a\u00020\f2\u0006\u0010[\u001a\u00020\b¢\u0006\u0004\b^\u00108J\u0017\u0010_\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b_\u0010YJ\u0015\u0010_\u001a\u00020\f2\u0006\u0010Z\u001a\u00020\b¢\u0006\u0004\b_\u00108J\u0015\u0010`\u001a\u00020\f2\u0006\u0010[\u001a\u00020\b¢\u0006\u0004\b`\u00108J\u0017\u0010a\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\ba\u0010YJ\u0015\u0010b\u001a\u00020\f2\u0006\u0010Z\u001a\u00020\b¢\u0006\u0004\bb\u00108J\u0015\u0010c\u001a\u00020\f2\u0006\u0010[\u001a\u00020\b¢\u0006\u0004\bc\u00108J\u0017\u0010f\u001a\u00020\f2\u0006\u0010e\u001a\u00020dH\u0007¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020\fH\u0007¢\u0006\u0004\bh\u0010\u000eJ\u000f\u0010i\u001a\u00020\fH\u0014¢\u0006\u0004\bi\u0010\u000eJ\u0015\u0010l\u001a\u00020\f2\u0006\u0010k\u001a\u00020j¢\u0006\u0004\bl\u0010mJ\u0015\u0010o\u001a\u00020\f2\u0006\u0010n\u001a\u000200¢\u0006\u0004\bo\u0010pJ\u0017\u0010r\u001a\u00020\f2\u0006\u0010q\u001a\u000200H\u0016¢\u0006\u0004\br\u0010pJ\u0017\u0010s\u001a\u00020\f2\u0006\u0010q\u001a\u000200H\u0016¢\u0006\u0004\bs\u0010pJ\u0019\u0010t\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\bt\u0010HJ\u0017\u0010v\u001a\u00020\f2\u0006\u0010u\u001a\u000200H\u0016¢\u0006\u0004\bv\u0010pJ\u0017\u0010x\u001a\u00020\f2\u0006\u0010w\u001a\u00020\bH\u0016¢\u0006\u0004\bx\u00108J\u001f\u0010{\u001a\u00020\f2\u0006\u0010y\u001a\u00020\b2\u0006\u0010z\u001a\u00020\bH\u0014¢\u0006\u0004\b{\u0010|J<\u0010\u0082\u0001\u001a\u00020\f2\u0006\u0010}\u001a\u0002002\u0006\u0010~\u001a\u00020\b2\u0006\u0010\u007f\u001a\u00020\b2\u0007\u0010\u0080\u0001\u001a\u00020\b2\u0007\u0010\u0081\u0001\u001a\u00020\bH\u0014¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u001e\u0010\u0086\u0001\u001a\u00020\f2\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0014¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R)\u0010\u0091\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001a\u0010\u0095\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0019\u0010\u0098\u0001\u001a\u00020R8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0019\u0010\u009a\u0001\u001a\u00020R8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0097\u0001R\u0018\u0010\u009b\u0001\u001a\u00020\u00018\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\bE\u0010\u0089\u0001R(\u0010\u009e\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086.¢\u0006\u0017\n\u0005\bD\u0010\u008c\u0001\u001a\u0006\b\u009c\u0001\u0010\u008e\u0001\"\u0006\b\u009d\u0001\u0010\u0090\u0001R\u0018\u0010\u009f\u0001\u001a\u00020\u00018\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\bJ\u0010\u0089\u0001R\u0019\u0010 \u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\bK\u0010\u0094\u0001R\u0018\u0010¡\u0001\u001a\u00020R8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\bI\u0010\u0097\u0001R\u0018\u0010¢\u0001\u001a\u00020R8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b@\u0010\u0097\u0001R\u0019\u0010£\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b=\u0010\u0094\u0001R)\u0010§\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b¤\u0001\u0010\u008c\u0001\u001a\u0006\b¥\u0001\u0010\u008e\u0001\"\u0006\b¦\u0001\u0010\u0090\u0001R(\u0010ª\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086.¢\u0006\u0017\n\u0005\b\u001f\u0010\u008c\u0001\u001a\u0006\b¨\u0001\u0010\u008e\u0001\"\u0006\b©\u0001\u0010\u0090\u0001R\u0018\u0010¬\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\"\u0010«\u0001R\u0018\u0010\u00ad\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b&\u0010«\u0001R\u0018\u0010¯\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0012\u0010®\u0001R\u0018\u0010°\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\r\u0010®\u0001R\u0018\u0010±\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b3\u0010®\u0001R\u0018\u0010²\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b5\u0010®\u0001R\u001a\u0010³\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b4\u0010«\u0001R\u0017\u0010u\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b1\u0010´\u0001R\u0018\u0010µ\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b/\u0010®\u0001R%\u0010¸\u0001\u001a\u000f\u0012\u0004\u0012\u000200\u0012\u0005\u0012\u00030¶\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bF\u0010·\u0001R\u0019\u0010º\u0001\u001a\u00030¶\u00018\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\bC\u0010¹\u0001R\u0018\u0010»\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bM\u0010®\u0001R\u0017\u0010¾\u0001\u001a\u00030¼\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bB\u0010½\u0001R\u0018\u0010¿\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b*\u0010´\u0001R\u0018\u0010À\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b,\u0010´\u0001R\u0018\u0010Á\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bh\u0010®\u0001R\u0018\u0010Â\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bo\u0010®\u0001R\u0018\u0010Ã\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0017\u0010®\u0001¨\u0006Ä\u0001"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/material/MaskMaterialOwner;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "r", "()V", "Landroid/view/View;", "getDefaultTargetView", "()Landroid/view/View;", "q", "(Landroid/util/AttributeSet;)V", "Lcom/obric/oui/button/OButtonGroup;", ServerElements.GROUP, "tintColor", "F", "(Lcom/obric/oui/button/OButtonGroup;I)V", "view", "H", "(Landroid/view/View;I)V", "styleRes", "Lkotlin/Function1;", "onTintColorChanged", "n", "(Lcom/obric/oui/button/OButtonGroup;ILkotlin/jvm/functions/Function1;)V", "iconRes", "o", "(II)Landroid/view/View;", "", "text", "p", "(Ljava/lang/String;I)Landroid/view/View;", "Landroid/widget/TextView;", "txt", "B", "(Landroid/widget/TextView;)V", "C", "getCenterTitleGap", "()I", "w", "", "v", "()Z", "s", "u", "t", "insetTop", "G", "(I)V", "onAttachedToWindow", "type", "setTitleType", SlideCard.KEY_INDEX, "l", "Landroid/view/View$OnClickListener;", BusSupport.EVENT_ON_CLICK, "k", "(IILandroid/view/View$OnClickListener;)Landroid/view/View;", "A", FixCard.FixStyle.KEY_Y, "g", "f", FixCard.FixStyle.KEY_X, "setCenterCustomView", "(Landroid/view/View;)V", "j", "h", "i", "(Ljava/lang/String;ILandroid/view/View$OnClickListener;)Landroid/view/View;", "z", "setStartButtonGroupStyle", "setCenterButtonGroupStyle", "setSubEndButtonGroupStyle", "setEndButtonGroupStyle", "Lcom/obric/oui/text/OTextView;", "getStartTitleView", "()Lcom/obric/oui/text/OTextView;", "getStartSubtitleView", "getCenterTitleView", "getCenterSubtitleView", "setStartTitle", "(Ljava/lang/String;)V", "resId", "color", "setStartTitleColor", "setStartSubtitle", "setStartSubTitleColor", "setCenterTitle", "setCenterTitleColor", "setCenterSubtitle", "setCenterSubTitle", "setCenterSubTitleColor", "Landroid/graphics/drawable/Drawable;", "drawable", "setMaskBackground", "(Landroid/graphics/drawable/Drawable;)V", "D", "onFinishInflate", "", "radius", "setMaskBlurRadius", "(F)V", "show", "E", "(Z)V", "apply", "applyMaskMaterial", "applyContentMaterial", "setBackdropTarget", "isBackdropView", "updateBackdropTargetType", "srcType", "updateBackdropSrcType", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "a", "Landroid/widget/FrameLayout;", "startContainer", "b", "Lcom/obric/oui/button/OButtonGroup;", "getStartButtonGroup", "()Lcom/obric/oui/button/OButtonGroup;", "setStartButtonGroup", "(Lcom/obric/oui/button/OButtonGroup;)V", "startButtonGroup", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "startTitleContainer", "d", "Lcom/obric/oui/text/OTextView;", "startTitleView", "e", "startSubtitleView", "centerContainer", "getCenterButtonGroup", "setCenterButtonGroup", "centerButtonGroup", "centerCustomContainer", "centerTitleContainer", "centerTitleView", "centerSubtitleView", "endContainer", "m", "getEndSubButtonGroup", "setEndSubButtonGroup", "endSubButtonGroup", "getEndButtonGroup", "setEndButtonGroup", "endButtonGroup", "Landroid/view/View;", "materialMask", "titleBarContainer", "I", "startTintColor", "centerTintColor", "endTintColor", "endSubTintColor", "backdropTarget", "Z", "materialSrcType", "Lcom/obric/oui/material/b;", "Lkotlin/jvm/functions/Function1;", "maskMaterial", "Lcom/obric/oui/material/b;", "currentMaskMaterialConfig", "mType", "Lzd/d;", "Lzd/d;", "floatingWindowHelper", "mIsLargeFont", "isCenterOverflow", "centerTitleHorizontalPaddingPx", "centerTitleGapPx", "centerTitleGapLargeFontPx", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFloatingTitleBar extends FrameLayout implements MaterialOwner, MaskMaterialOwner {
    public static final a G = null;
    public final d A;
    public boolean B;
    public boolean C;
    public int D;
    public int E;
    public int F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f17413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OButtonGroup f17414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f17415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OTextView f17416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OTextView f17417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f17418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OButtonGroup f17419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f17420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f17421i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OTextView f17422j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OTextView f17423k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f17424l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OButtonGroup f17425m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OButtonGroup f17426n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f17427o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f17428p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f17429q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f17430r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f17431s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f17432t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f17433u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f17434v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f17435w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Function1 f17436x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.obric.oui.material.b f17437y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f17438z;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        G = new a(null);
    }

    @JvmOverloads
    public OFloatingTitleBar(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private final void C() {
        View r10 = getDefaultTargetView();
        getStartButtonGroup().setBackdropTarget(r10);
        getCenterButtonGroup().setBackdropTarget(r10);
        getEndButtonGroup().setBackdropTarget(r10);
        getEndSubButtonGroup().setBackdropTarget(r10);
    }

    public static final /* synthetic */ void a(OFloatingTitleBar r10, int r11) {
        r10.f17430r = r11;
    }

    public static final /* synthetic */ void b(OFloatingTitleBar r10, int r11) {
        r10.f17432t = r11;
    }

    public static final /* synthetic */ void c(OFloatingTitleBar r10, int r11) {
        r10.f17431s = r11;
    }

    public static final /* synthetic */ void d(OFloatingTitleBar r10, int r11) {
        r10.f17429q = r11;
    }

    public static final /* synthetic */ void e(OFloatingTitleBar r10, OButtonGroup r11, int r12) {
        r10.F(r11, r12);
    }

    private final int getCenterTitleGap() {
        if (this.B == false) goto L6;
        return this.F;
    L6:
        return this.E;
    }

    private final View getDefaultTargetView() {
        if (OMaterialHelper.j() <= 1) goto L8;
        View r10 = this.f17428p;
        if (r10 != null) goto L9;
        q.y("titleBarContainer");
        return null;
    L9:
        return r10;
    L8:
        return this;
    }

    public static /* synthetic */ View m(OFloatingTitleBar r10, int r11, int r12, View.OnClickListener r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = -1;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = null;
    L9:
        return r10.k(r11, r12, r13);
    }

    private final void q(AttributeSet r10) {
        Context r11 = getContext();
        q.f(r11, "context");
        int[] r12 = R$styleable.OFloatingTitleBar;
        q.f(r12, "OFloatingTitleBar");
        boolean r13 = false;
        TypedArray r14 = r11.obtainStyledAttributes(r10, r12, 0, 0);
        q.f(r14, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        int r15 = R$styleable.OFloatingTitleBar_oFloatingTitleBar_type;
        if (r14.hasValue(r15) == false) goto L5;
        setTitleType(r14.getInt(r15, 0));
    L5:
        int r16 = R$styleable.OFloatingTitleBar_oFloatingTitleBar_startTitle;
        if (r14.hasValue(r16) == false) goto L8;
        setStartTitle(r14.getString(r16));
    L8:
        int r17 = R$styleable.OFloatingTitleBar_oFloatingTitleBar_startTitleColor;
        if (r14.hasValue(r17) == false) goto L11;
        setStartTitleColor(r14.getColor(r17, R$color.oui_basic_text_1));
    L11:
        int r18 = R$styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitle;
        if (r14.hasValue(r18) == false) goto L14;
        setStartSubtitle(r14.getString(r18));
    L14:
        int r19 = R$styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitleColor;
        if (r14.hasValue(r19) == false) goto L17;
        setStartSubTitleColor(r14.getColor(r19, R$color.oui_basic_text_3));
    L17:
        int r20 = R$styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitle;
        if (r14.hasValue(r20) == false) goto L20;
        setCenterTitle(r14.getString(r20));
    L20:
        int r21 = R$styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitleColor;
        if (r14.hasValue(r21) == false) goto L23;
        setCenterTitleColor(r14.getColor(r21, R$color.oui_basic_text_1));
    L23:
        int r22 = R$styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitle;
        if (r14.hasValue(r22) == false) goto L26;
        setCenterSubtitle(r14.getString(r22));
    L26:
        int r23 = R$styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitleColor;
        if (r14.hasValue(r23) == false) goto L29;
        setCenterSubTitleColor(r14.getColor(r23, R$color.oui_basic_text_3));
    L29:
        int r24 = R$styleable.OFloatingTitleBar_oFloatingTitleBar_startButtonGroupStyle;
        int r25 = R$style.OFloatingTitleBar_Action_Standard;
        setStartButtonGroupStyle(r14.getResourceId(r24, r25));
        setCenterButtonGroupStyle(r14.getResourceId(R$styleable.OFloatingTitleBar_oFloatingTitleBar_centerButtonGroupStyle, r25));
        setSubEndButtonGroupStyle(r14.getResourceId(R$styleable.OFloatingTitleBar_oFloatingTitleBar_endSubButtonGroupStyle, r25));
        setEndButtonGroupStyle(r14.getResourceId(R$styleable.OFloatingTitleBar_oFloatingTitleBar_endButtonGroupStyle, r25));
        int r26 = R$styleable.OFloatingTitleBar_oFloatingTitleBar_maskBackground;
        if (r14.hasValue(r26) == false) goto L35;
        Drawable r27 = r14.getDrawable(r26);
        if (r27 == null) goto L34;
        setMaskBackground(r27);
        goto L35
    L34:
        setMaskBackground(new ColorDrawable(r14.getColor(r26, 0)));
    L35:
        int r28 = R$styleable.OFloatingTitleBar_oFloatingTitleBar_defaultMaskBackground;
        if (r14.hasValue(r28) == true) goto L38;
    L40:
        int r29 = R$styleable.OFloatingTitleBar_oui_widgetBlurColors;
        if (r14.hasValue(r29) == false) goto L54;
        int r30 = R$styleable.OFloatingTitleBar_oui_widgetBlurBlendModes;
        if (r14.hasValue(r30) == false) goto L54;
        int r31 = r14.getResourceId(r29, R$array.oui_titlebar_blur_colors);
        int r32 = r14.getResourceId(r30, R$array.oui_titlebar_blur_blend_modes);
        com.obric.oui.material.b r33 = this.f17437y;
        com.obric.oui.material.b r34 = null;
        if (r33 != null) goto L47;
        q.y("currentMaskMaterialConfig");
        r33 = null;
    L47:
        r33.l(OMaterialHelper.i(r14.getResources(), r31, r32));
        com.obric.oui.material.b r35 = this.f17437y;
        if (r35 != null) goto L50;
        q.y("currentMaskMaterialConfig");
    L52:
        if (r34.b() != null) goto L54;
        L.b("OFloatingTitleBar", "init get widget blur colors or modes error");
        goto L54
    L50:
        r34 = r35;
    L54:
        int r36 = R$styleable.OFloatingTitleBar_oui_widgetMaterialSrcType;
        if (r14.hasValue(r36) == false) goto L60;
        int r37 = 2;
        if (this.f17438z != 2) goto L59;
        r37 = 4;
    L59:
        this.f17435w = r14.getInt(r36, r37);
    L60:
        int r38 = R$styleable.OFloatingTitleBar_oFloatingTitleBar_maskBlurRadius;
        if (r14.hasValue(r38) == false) goto L64;
        setMaskBlurRadius(r14.getFloat(r38, BlurToken.Blur_Progress_Thin));
    L64:
        if (r14.getBoolean(R$styleable.OFloatingTitleBar_oui_widgetFitInsetTop, r14.getBoolean(R$styleable.OFloatingTitleBar_oFloatingTitleBar_statusBarImmersion, false)) == true) goto L66;
    L68:
        this.A.l(r13, new OFloatingTitleBar$initAttrs$1$1(this));
        r14.recycle();
        return;
    L66:
        if (this.f17438z == 1) goto L68;
        r13 = true;
        goto L68
    L38:
        if (r14.getBoolean(r28, false) == false) goto L40;
        D();
        goto L40
    }

    private final void r() {
        View r10 = findViewById(R$id.start_container);
        q.f(r10, "findViewById(R.id.start_container)");
        this.f17413a = (FrameLayout) r10;
        View r11 = findViewById(R$id.start_button_group);
        q.f(r11, "findViewById(R.id.start_button_group)");
        setStartButtonGroup((OButtonGroup) r11);
        View r12 = findViewById(R$id.start_title_container);
        q.f(r12, "findViewById(R.id.start_title_container)");
        this.f17415c = (LinearLayout) r12;
        View r13 = findViewById(R$id.start_title);
        q.f(r13, "findViewById(R.id.start_title)");
        this.f17416d = (OTextView) r13;
        View r14 = findViewById(R$id.start_sub_title);
        q.f(r14, "findViewById(R.id.start_sub_title)");
        this.f17417e = (OTextView) r14;
        View r15 = findViewById(R$id.center_container);
        q.f(r15, "findViewById(R.id.center_container)");
        this.f17418f = (FrameLayout) r15;
        View r16 = findViewById(R$id.center_button_group);
        q.f(r16, "findViewById(R.id.center_button_group)");
        setCenterButtonGroup((OButtonGroup) r16);
        View r17 = findViewById(R$id.center_custom_container);
        q.f(r17, "findViewById(R.id.center_custom_container)");
        this.f17420h = (FrameLayout) r17;
        View r18 = findViewById(R$id.center_title_container);
        q.f(r18, "findViewById(R.id.center_title_container)");
        this.f17421i = (LinearLayout) r18;
        View r19 = findViewById(R$id.center_title);
        q.f(r19, "findViewById(R.id.center_title)");
        this.f17422j = (OTextView) r19;
        View r20 = findViewById(R$id.center_sub_title);
        q.f(r20, "findViewById(R.id.center_sub_title)");
        this.f17423k = (OTextView) r20;
        OTextView r21 = this.f17416d;
        View r22 = null;
        if (r21 != null) goto L5;
        q.y("startTitleView");
        r21 = null;
    L5:
        r21.setFallbackLineSpacing(false);
        OTextView r23 = this.f17417e;
        if (r23 != null) goto L8;
        q.y("startSubtitleView");
        r23 = null;
    L8:
        r23.setFallbackLineSpacing(false);
        OTextView r24 = this.f17422j;
        if (r24 != null) goto L11;
        q.y("centerTitleView");
        r24 = null;
    L11:
        r24.setFallbackLineSpacing(false);
        OTextView r25 = this.f17423k;
        if (r25 != null) goto L14;
        q.y("centerSubtitleView");
        r25 = null;
    L14:
        r25.setFallbackLineSpacing(false);
        View r26 = findViewById(R$id.end_container);
        q.f(r26, "findViewById(R.id.end_container)");
        this.f17424l = (LinearLayout) r26;
        View r27 = findViewById(R$id.end_sub_button_group);
        q.f(r27, "findViewById(R.id.end_sub_button_group)");
        setEndSubButtonGroup((OButtonGroup) r27);
        View r28 = findViewById(R$id.end_button_group);
        q.f(r28, "findViewById(R.id.end_button_group)");
        setEndButtonGroup((OButtonGroup) r28);
        View r29 = findViewById(R$id.material_mask);
        q.f(r29, "findViewById(R.id.material_mask)");
        this.f17427o = r29;
        View r30 = findViewById(R$id.title_bar_container);
        q.f(r30, "findViewById(R.id.title_bar_container)");
        this.f17428p = r30;
        if (r30 != null) goto L17;
        q.y("titleBarContainer");
    L18:
        r22.setClickable(true);
        this.f17437y = (com.obric.oui.material.b) this.f17436x.invoke(Boolean.valueOf(true ^ t()));
        C();
        return;
    L17:
        r22 = r30;
        goto L18
    }

    private final boolean t() {
        OTextView r10 = this.f17416d;
        OTextView r11 = null;
        if (r10 != null) goto L6;
        q.y("startTitleView");
        r10 = null;
    L6:
        if (r10.getVisibility() != 0) goto L12;
        OTextView r12 = this.f17416d;
        if (r12 != null) goto L10;
        q.y("startTitleView");
    L11:
        int r13 = r11.getTextColors().getDefaultColor();
    L23:
        return !i0.c(r13);
    L10:
        r11 = r12;
        goto L11
    L12:
        OTextView r14 = this.f17422j;
        if (r14 != null) goto L16;
        q.y("centerTitleView");
        r14 = null;
    L16:
        if (r14.getVisibility() != 0) goto L25;
        OTextView r15 = this.f17422j;
        if (r15 != null) goto L20;
        q.y("centerTitleView");
    L21:
        r13 = r11.getTextColors().getDefaultColor();
        goto L23
    L20:
        r11 = r15;
        goto L21
    L25:
        return i.a(this);
    }

    private final void w() {
        this.D = f.r(this, 8);
        this.E = f.r(this, 12);
        this.F = f.r(this, 4);
    }

    public final void A() {
        getStartButtonGroup().q();
    }

    public final void B(TextView r10) {
        CharSequence r11 = r10.getText();
        int r12 = 0;
        if (r11 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == false) goto L12;
        r12 = 8;
    L12:
        r10.setVisibility(r12);
        requestLayout();
        return;
    L5:
        if (r11.length() == 0) goto L8;
        r13 = false;
        goto L9
    }

    public final void D() {
    }

    public final void E(boolean r10) {
        View r11 = this.f17427o;
        if (r11 != null) goto L5;
        q.y("materialMask");
        r11 = null;
    L5:
        if (r10 == false) goto L7;
        int r12 = 0;
    L8:
        r11.setVisibility(r12);
        return;
    L7:
        r12 = 8;
        goto L8
    }

    public final void F(OButtonGroup r10, int r11) {
        int r12 = r10.getItemCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        int r14 = r13 + 1;
        H(r10.o(r13), r11);
        r13 = r14;
        goto L3
    }

    public final void G(int r10) {
        View r11 = this.f17427o;
        View r12 = null;
        if (r11 != null) goto L5;
        q.y("materialMask");
        r11 = null;
    L5:
        ViewGroup.LayoutParams r13 = r11.getLayoutParams();
        r13.height = getContext().getResources().getDimensionPixelSize(R$dimen.oui_title_bar_mask_height) + r10;
        View r14 = this.f17427o;
        if (r14 != null) goto L8;
        q.y("materialMask");
        r14 = null;
    L8:
        r14.setLayoutParams(r13);
        View r15 = this.f17428p;
        if (r15 != null) goto L11;
        q.y("titleBarContainer");
        r15 = null;
    L11:
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L20;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
        r17.topMargin = r10;
        View r18 = this.f17428p;
        if (r18 != null) goto L16;
        q.y("titleBarContainer");
    L17:
        r12.setLayoutParams(r17);
        return;
    L16:
        r12 = r18;
        goto L17
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void H(View r10, int r11) {
        if ((r10 instanceof ViewGroup) == false) goto L8;
        ViewGroup r12 = (ViewGroup) r10;
        int r13 = r12.getChildCount();
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L17;
        int r15 = r14 + 1;
        H(r12.getChildAt(r14), r11);
        r14 = r15;
        goto L5
    L17:
        return;
    L8:
        if ((r10 instanceof ImageView) == false) goto L11;
        ((ImageView) r10).setColorFilter(r11);
        return;
    L11:
        if ((r10 instanceof TextView) == false) goto L16;
        ((TextView) r10).setTextColor(r11);
        return;
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r10) {
        com.obric.oui.material.f.c(t.l(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), r10);
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void applyMaskMaterial(boolean r10) {
        int r11 = this.f17435w;
        if (r11 == (-1)) goto L6;
        com.obric.oui.material.f.a(this, r10, r11);
        return;
    L6:
        com.obric.oui.material.f.b(this, r10, this.f17434v);
    }

    public final View f(int r10, int r11, View.OnClickListener r12) {
        View r13 = o(r10, this.f17430r);
        if (r12 == null) goto L5;
        r13.setOnClickListener(r12);
    L5:
        g(r13, r11);
        return r13;
    }

    public final void g(View r10, int r11) {
        q.g(r10, "view");
        getCenterButtonGroup().l(r10, new ViewGroup.MarginLayoutParams(-2, -2), r11);
        getCenterButtonGroup().setVisibility(0);
    }

    @NotNull
    public final OButtonGroup getCenterButtonGroup() {
        OButtonGroup r10 = this.f17419g;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("centerButtonGroup");
        return null;
    }

    @NotNull
    public final OTextView getCenterSubtitleView() {
        OTextView r10 = this.f17423k;
        if (r10 != null) goto L6;
        q.y("centerSubtitleView");
        return null;
    L6:
        return r10;
    }

    @NotNull
    public final OTextView getCenterTitleView() {
        OTextView r10 = this.f17422j;
        if (r10 != null) goto L6;
        q.y("centerTitleView");
        return null;
    L6:
        return r10;
    }

    @NotNull
    public final OButtonGroup getEndButtonGroup() {
        OButtonGroup r10 = this.f17426n;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("endButtonGroup");
        return null;
    }

    @NotNull
    public final OButtonGroup getEndSubButtonGroup() {
        OButtonGroup r10 = this.f17425m;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("endSubButtonGroup");
        return null;
    }

    @NotNull
    public final OButtonGroup getStartButtonGroup() {
        OButtonGroup r10 = this.f17414b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("startButtonGroup");
        return null;
    }

    @NotNull
    public final OTextView getStartSubtitleView() {
        OTextView r10 = this.f17417e;
        if (r10 != null) goto L6;
        q.y("startSubtitleView");
        return null;
    L6:
        return r10;
    }

    @NotNull
    public final OTextView getStartTitleView() {
        OTextView r10 = this.f17416d;
        if (r10 != null) goto L6;
        q.y("startTitleView");
        return null;
    L6:
        return r10;
    }

    public final View h(int r10, int r11, View.OnClickListener r12) {
        View r13 = o(r10, this.f17431s);
        if (r12 == null) goto L5;
        r13.setOnClickListener(r12);
    L5:
        j(r13, r11);
        return r13;
    }

    public final View i(String r10, int r11, View.OnClickListener r12) {
        q.g(r10, "text");
        View r13 = p(r10, this.f17431s);
        if (r12 == null) goto L5;
        r13.setOnClickListener(r12);
    L5:
        j(r13, r11);
        return r13;
    }

    public final void j(View r10, int r11) {
        q.g(r10, "view");
        getEndButtonGroup().l(r10, new ViewGroup.MarginLayoutParams(-2, -2), r11);
        getEndButtonGroup().setVisibility(0);
    }

    public final View k(int r10, int r11, View.OnClickListener r12) {
        View r13 = o(r10, this.f17429q);
        if (r12 == null) goto L5;
        r13.setOnClickListener(r12);
    L5:
        l(r13, r11);
        return r13;
    }

    public final void l(View r10, int r11) {
        q.g(r10, "view");
        getStartButtonGroup().l(r10, new ViewGroup.MarginLayoutParams(-2, -2), r11);
        getStartButtonGroup().setVisibility(0);
    }

    public final void n(OButtonGroup r10, int r11, Function1 r12) {
        if (r11 != 0) goto L4;
        return;
    L4:
        TypedArray r13 = getContext().obtainStyledAttributes(r11, R$styleable.OShadowFrame);
        q.f(r13, "context.obtainStyledAttr…R.styleable.OShadowFrame)");
        int r14 = r13.getColor(R$styleable.OShadowFrame_oui_widgetBgColor, 0);
        int r15 = r13.getColor(R$styleable.OShadowFrame_oui_widgetPressColor, 0);
        int r16 = r13.getColor(R$styleable.OShadowFrame_oui_widgetBgColorDisabled, 0);
        int r17 = r13.getColor(R$styleable.OShadowFrame_oui_widgetTintColor, 0);
        String r18 = r13.getString(R$styleable.OShadowFrame_oui_widgetMaterial);
        String r19 = r13.getString(R$styleable.OShadowFrame_oui_widgetMaterialDisabled);
        r13.recycle();
        String r20 = getContext().getString(R$string.oui_material_bg_floating);
        q.f(r20, "context.getString(R.stri…oui_material_bg_floating)");
        if (o.m(r20, r18) == true) goto L7;
    L9:
        if (r14 == 0) goto L25;
        if (r18 == null) goto L16;
        if (r16 != 0) goto L14;
        r16 = r14;
    L14:
        r10.g(r14, r16, r18, r19);
        goto L25
    L16:
        if (i0.b(r14) == false) goto L21;
        if (r16 == 0) goto L19;
        int r21 = r16;
    L20:
        com.obric.oui.material.c r22 = com.obric.oui.material.c.f15225a;
        com.obric.oui.material.b[] r23 = MaterialToken.OUI_Bg_Floating_Tinted_Light;
        r10.h(r14, r21, r22.b(r23, r14), r22.b(r23, r16));
        goto L25
    L19:
        r21 = r14;
        goto L20
    L21:
        if (r16 != 0) goto L24;
        r16 = r14;
    L24:
        r10.g(r14, r16, null, null);
    L25:
        if (r15 == 0) goto L27;
        r10.setPressColor(r15);
    L27:
        if (r17 == 0) goto L30;
        r12.invoke(Integer.valueOf(r17));
        return;
    L30:
        return;
    L7:
        if (i0.b(r14) == false) goto L9;
        r18 = null;
        goto L9
    }

    public final View o(int r10, int r11) {
        Context r12 = getContext();
        q.f(r12, "context");
        OUIFrameLayout r13 = new OUIFrameLayout(r12, null, 0, null, 14, null);
        r13.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r13.setPadding(f.r(r13, 7), f.r(r13, 7), f.r(r13, 7), f.r(r13, 7));
        r13.setClickable(true);
        r13.setRadius(f.r(r13, 99));
        ImageView r14 = new ImageView(r13.getContext());
        r14.setImageResource(r10);
        if (r11 == 0) goto L5;
        r14.setColorFilter(r11);
    L5:
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(f.r(r13, 22), f.r(r13, 22));
        r15.gravity = 17;
        Unit r16 = Unit.f21064a;
        r13.addView(r14, r15);
        return r13;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((getParent() instanceof ViewGroup) == true) goto L5;
    L10:
        this.A.h();
        return;
    L5:
        if ((getParent() instanceof MaskMaterialOwner) == false) goto L8;
    L9:
        E(false);
        goto L10
    L8:
        if ((getParent().getParent() instanceof MaskMaterialOwner) == false) goto L10;
        goto L9
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        if (r10 == null) goto L6;
        q.d(r10);
        this.B = h.g(r10.fontScale);
    L6:
        w();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (this.f17435w == (-1)) goto L6;
        com.obric.oui.material.f.e(t.l(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), this.f17435w);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (s() == true) goto L5;
        return;
    L5:
        int r15 = getMeasuredWidth();
        View r16 = this.f17428p;
        FrameLayout r17 = null;
        if (r16 != null) goto L8;
        q.y("titleBarContainer");
        r16 = null;
    L8:
        int r18 = r16.getPaddingLeft();
        View r19 = this.f17428p;
        if (r19 != null) goto L11;
        q.y("titleBarContainer");
        r19 = null;
    L11:
        int r110 = r19.getPaddingRight();
        int r20 = getCenterTitleGap();
        if (v() == false) goto L17;
        FrameLayout r21 = this.f17413a;
        if (r21 != null) goto L16;
        q.y("startContainer");
        r21 = null;
    L16:
        r18 = (r18 + r21.getMeasuredWidth()) + r20;
    L17:
        int r111 = r15 - r110;
        if (u() == false) goto L23;
        LinearLayout r22 = this.f17424l;
        if (r22 != null) goto L22;
        q.y("endContainer");
        r22 = null;
    L22:
        r111 = (r111 - r22.getMeasuredWidth()) - r20;
    L23:
        FrameLayout r23 = this.f17418f;
        if (r23 != null) goto L26;
        q.y("centerContainer");
        r23 = null;
    L26:
        int r24 = r23.getMeasuredWidth();
        FrameLayout r25 = this.f17418f;
        if (r25 != null) goto L29;
        q.y("centerContainer");
        r25 = null;
    L29:
        int r26 = r25.getMeasuredHeight();
        int r27 = (r15 - r24) / 2;
        int r28 = r27 + r24;
        int r29 = r111 - r18;
        if (r24 <= r29) goto L33;
        r27 = r18;
    L32:
        r28 = r111;
    L38:
        if (this.C == false) goto L40;
        int r30 = (r29 - r24) / 2;
        r27 = r18 + r30;
        r28 = r111 - r30;
    L40:
        View r31 = this.f17428p;
        if (r31 != null) goto L43;
        q.y("titleBarContainer");
        r31 = null;
    L43:
        int r32 = r31.getPaddingTop();
        View r112 = this.f17428p;
        if (r112 != null) goto L46;
        q.y("titleBarContainer");
        r112 = null;
    L46:
        int r113 = r112.getMeasuredHeight();
        View r33 = this.f17428p;
        if (r33 != null) goto L49;
        q.y("titleBarContainer");
        r33 = null;
    L49:
        int r34 = r32 + ((((r113 - r33.getPaddingBottom()) - r32) - r26) / 2);
        int r35 = r26 + r34;
        FrameLayout r36 = this.f17418f;
        if (r36 != null) goto L52;
        q.y("centerContainer");
    L53:
        r17.layout(r27, r34, r28, r35);
        return;
    L52:
        r17 = r36;
        goto L53
    L33:
        if (r27 >= r18) goto L35;
        r28 = r18 + r24;
        r27 = r18;
        goto L38
    L35:
        if (r28 <= r111) goto L38;
        r27 = r111 - r24;
        goto L32
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r21, int r22) {
        this.C = false;
        OTextView r10 = this.f17422j;
        if (r10 != null) goto L5;
        q.y("centerTitleView");
        r10 = null;
    L5:
        r10.setMaxWidth(Channel.UNLIMITED);
        OTextView r11 = this.f17423k;
        if (r11 != null) goto L8;
        q.y("centerSubtitleView");
        r11 = null;
    L8:
        r11.setMaxWidth(Channel.UNLIMITED);
        OTextView r12 = this.f17416d;
        if (r12 != null) goto L11;
        q.y("startTitleView");
        r12 = null;
    L11:
        r12.setMaxWidth(Channel.UNLIMITED);
        OTextView r13 = this.f17417e;
        if (r13 != null) goto L14;
        q.y("startSubtitleView");
        r13 = null;
    L14:
        r13.setMaxWidth(Channel.UNLIMITED);
        super.onMeasure(r21, r22);
        boolean r14 = v();
        boolean r15 = s();
        boolean r16 = u();
        int r17 = getMeasuredWidth();
        View r18 = this.f17428p;
        if (r18 != null) goto L17;
        q.y("titleBarContainer");
        r18 = null;
    L17:
        int r19 = r18.getPaddingLeft();
        View r110 = this.f17428p;
        if (r110 != null) goto L20;
        q.y("titleBarContainer");
        r110 = null;
    L20:
        int r111 = r110.getPaddingRight();
        int r112 = getCenterTitleGap();
        if (r15 == false) goto L26;
        int r113 = r17 / 2;
        FrameLayout r20 = this.f17418f;
        if (r20 != null) goto L25;
        q.y("centerContainer");
        r20 = null;
    L25:
        int r23 = (r113 - (r20.getMeasuredWidth() / 2)) - r112;
    L33:
        if (r14 == false) goto L38;
        int r114 = (r17 / 2) - r19;
        FrameLayout r24 = this.f17413a;
        if (r24 != null) goto L37;
        q.y("startContainer");
        r24 = null;
    L37:
        int r25 = (r114 - r24.getMeasuredWidth()) - r112;
    L39:
        if (r16 == false) goto L44;
        int r115 = (r17 / 2) - r111;
        LinearLayout r26 = this.f17424l;
        if (r26 != null) goto L43;
        q.y("endContainer");
        r26 = null;
    L43:
        int r116 = (r115 - r26.getMeasuredWidth()) - r112;
    L45:
        boolean r27 = true;
        if (r14 == false) goto L59;
        int r28 = Math.max(0, r23 - r19);
        FrameLayout r29 = this.f17413a;
        if (r29 != null) goto L51;
        q.y("startContainer");
        r29 = null;
    L51:
        if (r29.getMeasuredWidth() <= r28) goto L59;
        OTextView r30 = this.f17416d;
        if (r30 != null) goto L55;
        q.y("startTitleView");
        r30 = null;
    L55:
        r30.setMaxWidth(r28);
        OTextView r31 = this.f17417e;
        if (r31 != null) goto L58;
        q.y("startSubtitleView");
        r31 = null;
    L58:
        r31.setMaxWidth(r28);
        boolean r32 = true;
    L60:
        if (r15 == false) goto L100;
        int r33 = Math.max(0, Math.min(r25 * 2, r116 * 2));
        FrameLayout r34 = this.f17418f;
        if (r34 != null) goto L65;
        q.y("centerContainer");
        r34 = null;
    L65:
        if (r34.getMeasuredWidth() <= r33) goto L100;
        this.C = true;
        int r35 = r25 + r116;
        OTextView r36 = this.f17422j;
        if (r36 != null) goto L69;
        q.y("centerTitleView");
        r36 = null;
    L69:
        r36.setMaxWidth(r35);
        OTextView r37 = this.f17422j;
        if (r37 != null) goto L73;
        q.y(r3);
        r37 = null;
    L73:
        if (r37.getMeasuredWidth() <= r33) goto L78;
        OTextView r38 = this.f17423k;
        if (r38 != null) goto L77;
        q.y("centerSubtitleView");
        r38 = null;
    L77:
        r38.setMaxWidth(r35);
    L82:
        FrameLayout r39 = this.f17420h;
        if (r39 != null) goto L86;
        q.y("centerCustomContainer");
        r39 = null;
    L86:
        if (r39.getVisibility() != 0) goto L101;
        FrameLayout r40 = this.f17420h;
        if (r40 != null) goto L90;
        q.y("centerCustomContainer");
        r40 = null;
    L90:
        ViewGroup.LayoutParams r41 = r40.getLayoutParams();
        FrameLayout r42 = this.f17420h;
        if (r42 != null) goto L94;
        q.y("centerCustomContainer");
        r42 = null;
    L94:
        if (r42.getMeasuredWidth() <= r35) goto L101;
        r41.width = r35;
        FrameLayout r43 = this.f17420h;
        if (r43 != null) goto L98;
        q.y("centerCustomContainer");
        FrameLayout r44 = null;
    L99:
        r44.setLayoutParams(r41);
        goto L101
    L98:
        r44 = r43;
    L101:
        if (r27 == false) goto L104;
        super.onMeasure(r21, r22);
        return;
    L104:
        return;
    L78:
        OTextView r45 = this.f17423k;
        if (r45 != null) goto L81;
        q.y(r6);
        r45 = null;
    L81:
        r45.setMaxWidth(r33);
    L100:
        r27 = r32;
    L59:
        r32 = false;
        goto L60
    L44:
        r116 = ((r17 / 2) - r111) - this.D;
        goto L45
    L38:
        r25 = ((r17 / 2) - r19) - this.D;
        goto L39
    L26:
        if (r16 == false) goto L31;
        int r46 = r17 - r111;
        LinearLayout r47 = this.f17424l;
        if (r47 != null) goto L30;
        q.y("endContainer");
        r47 = null;
    L30:
        r23 = (r46 - r47.getMeasuredWidth()) - r112;
        goto L33
    L31:
        r23 = r17 - r111;
        goto L33
    }

    public final View p(String r18, int r19) {
        Context r10 = getContext();
        q.f(r10, "context");
        OUIFrameLayout r11 = new OUIFrameLayout(r10, null, 0, null, 14, null);
        r11.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r11.setMinimumHeight(f.r(r11, 36));
        r11.setPadding(f.r(r11, 7), 0, f.r(r11, 7), 0);
        r11.setClickable(true);
        r11.setRadius(f.r(r11, 99));
        Context r12 = r11.getContext();
        q.f(r12, "context");
        OTextView r13 = new OTextView(r12, null, 0, null, 14, null);
        r13.setText(r18);
        r13.setGravity(17);
        r13.setPadding(f.r(r13, 4), 0, f.r(r13, 4), 0);
        r13.setSingleLine(true);
        r13.setMinHeight(f.r(r13, 22));
        r13.setTextAppearance(R$style.Button_2_Medium);
        if (r19 == 0) goto L5;
        r13.setTextColor(r19);
    L5:
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-2, -2);
        r14.gravity = 17;
        Unit r15 = Unit.f21064a;
        r11.addView(r13, r14);
        return r11;
    }

    public final boolean s() {
        if (getCenterButtonGroup().getVisibility() == 0) goto L23;
        OTextView r10 = this.f17422j;
        FrameLayout r11 = null;
        if (r10 != null) goto L9;
        q.y("centerTitleView");
        r10 = null;
    L9:
        if (r10.getVisibility() == 0) goto L23;
        OTextView r12 = this.f17423k;
        if (r12 != null) goto L15;
        q.y("centerSubtitleView");
        r12 = null;
    L15:
        if (r12.getVisibility() == 0) goto L23;
        FrameLayout r13 = this.f17420h;
        if (r13 != null) goto L20;
        q.y("centerCustomContainer");
    L22:
        if (r11.getVisibility() == 0) goto L23;
        return false;
    L20:
        r11 = r13;
    L23:
        return true;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(@Nullable View r10) {
        this.f17433u = r10;
        if (r10 != null) goto L6;
        com.obric.oui.material.o.n(this, this);
        C();
        return;
    L6:
        com.obric.oui.material.o.n(this, r10);
        com.obric.oui.material.f.g(t.l(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), r10);
    }

    public final void setCenterButtonGroup(@NotNull OButtonGroup r10) {
        q.g(r10, "<set-?>");
        this.f17419g = r10;
    }

    public final void setCenterButtonGroupStyle(int r10) {
        n(getCenterButtonGroup(), r10, new AnonymousClass1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCenterCustomView(@NotNull View r10) {
        q.g(r10, "view");
        FrameLayout r11 = this.f17420h;
        FrameLayout r12 = null;
        if (r11 != null) goto L5;
        q.y("centerCustomContainer");
        r11 = null;
    L5:
        r11.removeAllViews();
        FrameLayout r13 = this.f17420h;
        if (r13 != null) goto L8;
        q.y("centerCustomContainer");
        r13 = null;
    L8:
        r13.addView(r10);
        FrameLayout r14 = this.f17420h;
        if (r14 != null) goto L11;
        q.y("centerCustomContainer");
    L12:
        r12.setVisibility(0);
        if ((r10 instanceof MaterialOwner) == false) goto L16;
        ((MaterialOwner) r10).setBackdropTarget(getDefaultTargetView());
        return;
    L16:
        return;
    L11:
        r12 = r14;
        goto L12
    }

    public final void setCenterSubTitle(int r10) {
        setCenterSubtitle(getResources().getString(r10));
    }

    public final void setCenterSubTitleColor(int r10) {
        OTextView r11 = this.f17423k;
        if (r11 != null) goto L5;
        q.y("centerSubtitleView");
        r11 = null;
    L5:
        r11.setTextColor(r10);
    }

    public final void setCenterSubtitle(@Nullable String r10) {
        OTextView r11 = this.f17423k;
        OTextView r12 = null;
        if (r11 != null) goto L5;
        q.y("centerSubtitleView");
        r11 = null;
    L5:
        r11.setText(r10);
        OTextView r13 = this.f17423k;
        if (r13 != null) goto L8;
        q.y("centerSubtitleView");
    L9:
        B(r12);
        return;
    L8:
        r12 = r13;
        goto L9
    }

    public final void setCenterTitle(@Nullable String r10) {
        OTextView r11 = this.f17422j;
        OTextView r12 = null;
        if (r11 != null) goto L5;
        q.y("centerTitleView");
        r11 = null;
    L5:
        r11.setText(r10);
        OTextView r13 = this.f17422j;
        if (r13 != null) goto L8;
        q.y("centerTitleView");
    L9:
        B(r12);
        return;
    L8:
        r12 = r13;
        goto L9
    }

    public final void setCenterTitleColor(int r10) {
        OTextView r11 = this.f17422j;
        if (r11 != null) goto L5;
        q.y("centerTitleView");
        r11 = null;
    L5:
        r11.setTextColor(r10);
        this.f17437y = (com.obric.oui.material.b) this.f17436x.invoke(Boolean.valueOf(t()));
    }

    public final void setEndButtonGroup(@NotNull OButtonGroup r10) {
        q.g(r10, "<set-?>");
        this.f17426n = r10;
    }

    public final void setEndButtonGroupStyle(int r10) {
        n(getEndButtonGroup(), r10, new C04491(this));
    }

    public final void setEndSubButtonGroup(@NotNull OButtonGroup r10) {
        q.g(r10, "<set-?>");
        this.f17425m = r10;
    }

    @Deprecated(message = "not support set mask background")
    public final void setMaskBackground(@NotNull Drawable r10) {
        q.g(r10, "drawable");
        E(true);
    }

    public final void setMaskBlurRadius(float r10) {
        com.obric.oui.material.b r11 = this.f17437y;
        com.obric.oui.material.b r12 = null;
        if (r11 != null) goto L5;
        q.y("currentMaskMaterialConfig");
        r11 = null;
    L5:
        pc.a r13 = r11.d();
        if (r13 == null) goto L9;
        r13.f(r10);
    L9:
        d r14 = this.A;
        com.obric.oui.material.b r15 = this.f17437y;
        if (r15 != null) goto L12;
        q.y("currentMaskMaterialConfig");
    L13:
        r14.d(this, r12, this.f17435w);
        if (r10 != 0.0f) goto L16;
        boolean r16 = true;
    L17:
        E(!r16);
        return;
    L16:
        r16 = false;
        goto L17
    L12:
        r12 = r15;
        goto L13
    }

    public final void setStartButtonGroup(@NotNull OButtonGroup r10) {
        q.g(r10, "<set-?>");
        this.f17414b = r10;
    }

    public final void setStartButtonGroupStyle(int r10) {
        n(getStartButtonGroup(), r10, new C04501(this));
    }

    public final void setStartSubTitleColor(int r10) {
        OTextView r11 = this.f17417e;
        if (r11 != null) goto L5;
        q.y("startSubtitleView");
        r11 = null;
    L5:
        r11.setTextColor(r10);
    }

    public final void setStartSubtitle(@Nullable String r10) {
        OTextView r11 = this.f17417e;
        OTextView r12 = null;
        if (r11 != null) goto L5;
        q.y("startSubtitleView");
        r11 = null;
    L5:
        r11.setText(r10);
        OTextView r13 = this.f17417e;
        if (r13 != null) goto L8;
        q.y("startSubtitleView");
    L9:
        B(r12);
        return;
    L8:
        r12 = r13;
        goto L9
    }

    public final void setStartTitle(@Nullable String r10) {
        OTextView r11 = this.f17416d;
        OTextView r12 = null;
        if (r11 != null) goto L5;
        q.y("startTitleView");
        r11 = null;
    L5:
        r11.setText(r10);
        OTextView r13 = this.f17416d;
        if (r13 != null) goto L8;
        q.y("startTitleView");
    L9:
        B(r12);
        return;
    L8:
        r12 = r13;
        goto L9
    }

    public final void setStartTitleColor(int r10) {
        OTextView r11 = this.f17416d;
        if (r11 != null) goto L5;
        q.y("startTitleView");
        r11 = null;
    L5:
        r11.setTextColor(r10);
        this.f17437y = (com.obric.oui.material.b) this.f17436x.invoke(Boolean.valueOf(t()));
    }

    public final void setSubEndButtonGroupStyle(int r10) {
        n(getEndSubButtonGroup(), r10, new C04511(this));
    }

    public final void setTitleType(int r10) {
        this.f17438z = r10;
        d r11 = this.A;
        if (r10 != 2) goto L5;
        boolean r12 = true;
    L6:
        r11.j(r12);
        View r13 = null;
        com.obric.oui.material.b r14 = null;
        View r15 = null;
        if (r10 == 0) goto L33;
        if (r10 == 1) goto L25;
        if (r10 != 2) goto L44;
        View r16 = this.f17428p;
        if (r16 != null) goto L14;
        q.y("titleBarContainer");
        r16 = null;
    L14:
        r16.setMinimumHeight(f.r(this, 56));
        View r17 = this.f17428p;
        if (r17 != null) goto L17;
        q.y("titleBarContainer");
        r17 = null;
    L17:
        r17.setPadding(f.r(this, 12), f.r(this, 8), f.r(this, 12), f.r(this, 8));
        com.obric.oui.material.b r18 = this.f17437y;
        if (r18 != null) goto L20;
        q.y("currentMaskMaterialConfig");
    L21:
        pc.a r19 = r14.d();
        if (r19 == null) goto L45;
        setMaskBlurRadius(r19.b());
        return;
    L45:
        return;
    L20:
        r14 = r18;
        goto L21
    L44:
        return;
    L25:
        View r20 = this.f17428p;
        if (r20 != null) goto L28;
        q.y("titleBarContainer");
        r20 = null;
    L28:
        r20.setMinimumHeight(f.r(this, 64));
        View r21 = this.f17428p;
        if (r21 != null) goto L31;
        q.y("titleBarContainer");
    L32:
        r15.setPadding(f.r(this, 16), f.r(this, 16), f.r(this, 16), f.r(this, 8));
        return;
    L31:
        r15 = r21;
        goto L32
    L33:
        View r22 = this.f17428p;
        if (r22 != null) goto L36;
        q.y("titleBarContainer");
        r22 = null;
    L36:
        r22.setMinimumHeight(f.r(this, 56));
        View r23 = this.f17428p;
        if (r23 != null) goto L39;
        q.y("titleBarContainer");
    L40:
        r13.setPadding(f.r(this, 12), f.r(this, 8), f.r(this, 12), f.r(this, 8));
        return;
    L39:
        r13 = r23;
        goto L40
    L5:
        r12 = false;
        goto L6
    }

    public final boolean u() {
        if (getEndButtonGroup().getVisibility() != 0) goto L6;
    L7:
        return true;
    L6:
        if (getEndSubButtonGroup().getVisibility() == 0) goto L7;
        return false;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r10) {
        this.f17435w = r10;
        com.obric.oui.material.f.e(t.l(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), r10);
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r10) {
        if (this.f17434v == r10) goto L12;
        this.f17434v = r10;
        if (this.f17435w == (-1)) goto L8;
        return;
    L8:
        if (this.A.g() == true) goto L10;
        com.obric.oui.material.o.q(this, r10);
    L10:
        com.obric.oui.material.f.i(t.l(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), r10);
        return;
    }

    public final boolean v() {
        if (getStartButtonGroup().getVisibility() == 0) goto L17;
        OTextView r10 = this.f17416d;
        OTextView r11 = null;
        if (r10 != null) goto L9;
        q.y("startTitleView");
        r10 = null;
    L9:
        if (r10.getVisibility() == 0) goto L17;
        OTextView r12 = this.f17417e;
        if (r12 != null) goto L14;
        q.y("startSubtitleView");
    L16:
        if (r11.getVisibility() == 0) goto L17;
        return false;
    L14:
        r11 = r12;
    L17:
        return true;
    }

    public final void x() {
        getCenterButtonGroup().p();
    }

    public final void y() {
        getStartButtonGroup().p();
    }

    public final void z(int r10) {
        getEndButtonGroup().r(r10);
    }

    @JvmOverloads
    public OFloatingTitleBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OFloatingTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public final void setCenterTitle(int r10) {
        setCenterTitle(getResources().getString(r10));
    }

    public final void setStartSubtitle(int r10) {
        setStartSubtitle(getResources().getString(r10));
    }

    public final void setStartTitle(int r10) {
        setStartTitle(getResources().getString(r10));
    }

    @JvmOverloads
    public OFloatingTitleBar(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f17434v = true;
        this.f17435w = 2;
        this.f17436x = new OFloatingTitleBar$maskMaterial$1(this);
        d r13 = new d(this);
        this.A = r13;
        this.B = h.g(r10.getResources().getConfiguration().fontScale);
        w();
        LayoutInflater.from(r10).inflate(R$layout.o_floating_title_bar_layout, this, true);
        setClipChildren(false);
        setClipToPadding(false);
        r();
        if (r11 == null) goto L5;
        q(r11);
    L5:
        r13.k(49);
    }
}
