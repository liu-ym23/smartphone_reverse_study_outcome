package com.stepos.widget.list;

import Y8.h;
import Y8.t;
import android.R;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.databinding.SteposListItemBinding;
import com.stepos.widget.divider.StepOSDividerPainter;
import com.stepos.widget.toggle.StepOSSwitch;
import f.C4027a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import n9.C4946a;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\bU\b\u0016\u0018\u0000 Ò\u00022\u00020\u00012\u00020\u0002:\u0012Ó\u0002Ô\u0002Õ\u0002Ò\u0002Ö\u0002×\u0002Ø\u0002Ù\u0002Ú\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\rJ\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\"\u0010\u0016J\u000f\u0010#\u001a\u00020\u000bH\u0002¢\u0006\u0004\b#\u0010\rJ\u000f\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0004\b$\u0010\rJ\u000f\u0010%\u001a\u00020\u000bH\u0002¢\u0006\u0004\b%\u0010\rJ\u000f\u0010&\u001a\u00020\u000bH\u0002¢\u0006\u0004\b&\u0010\rJ\u000f\u0010'\u001a\u00020\u000bH\u0002¢\u0006\u0004\b'\u0010\rJ\u000f\u0010(\u001a\u00020\u000bH\u0002¢\u0006\u0004\b(\u0010\rJ1\u0010,\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0007H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0019H\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u000bH\u0002¢\u0006\u0004\b9\u0010\rJ\u0017\u0010:\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u0007H\u0002¢\u0006\u0004\b:\u00100J\u000f\u0010;\u001a\u00020\u0013H\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0013H\u0002¢\u0006\u0004\b=\u0010<J\u000f\u0010>\u001a\u00020\u000bH\u0002¢\u0006\u0004\b>\u0010\rJ\u001f\u0010@\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020\u0007H\u0002¢\u0006\u0004\b@\u0010 J'\u0010C\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007H\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010G\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u0013H\u0001¢\u0006\u0004\bF\u0010\u0016J)\u0010O\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020\u00132\b\b\u0002\u0010L\u001a\u00020KH\u0000¢\u0006\u0004\bM\u0010NJ\u0017\u0010T\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020PH\u0000¢\u0006\u0004\bR\u0010SJ\u0015\u0010V\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u0007¢\u0006\u0004\bV\u00100J\u0015\u0010W\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u0007¢\u0006\u0004\bW\u00100J\u0015\u0010X\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u0007¢\u0006\u0004\bX\u00100J\u0015\u0010Y\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u0007¢\u0006\u0004\bY\u00100J\u0015\u0010Z\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u0007¢\u0006\u0004\bZ\u00100J\u0017\u0010]\u001a\u00020\u000b2\b\u0010\\\u001a\u0004\u0018\u00010[¢\u0006\u0004\b]\u0010^J\u0015\u0010]\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u0007¢\u0006\u0004\b]\u00100J%\u0010b\u001a\u00020\u000b2\b\u0010`\u001a\u0004\u0018\u00010_2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010[H\u0007¢\u0006\u0004\bb\u0010cJ\u0015\u0010e\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020\u0013¢\u0006\u0004\be\u0010\u0016J\u0017\u0010g\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010f¢\u0006\u0004\bg\u0010hJ\u0017\u0010i\u001a\u00020\u000b2\b\b\u0001\u0010?\u001a\u00020\u0007¢\u0006\u0004\bi\u00100J\u0017\u0010k\u001a\u00020\u000b2\b\b\u0001\u0010?\u001a\u00020j¢\u0006\u0004\bk\u0010lJ\u0019\u0010n\u001a\u00020\u000b2\n\b\u0001\u0010m\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\bn\u0010oJ\u0017\u0010p\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\bp\u0010qJ!\u0010v\u001a\u00020\u000b2\b\u0010s\u001a\u0004\u0018\u00010r2\b\u0010u\u001a\u0004\u0018\u00010t¢\u0006\u0004\bv\u0010wJ\u0017\u0010y\u001a\u00020\u000b2\b\u0010u\u001a\u0004\u0018\u00010x¢\u0006\u0004\by\u0010zJ\u0017\u0010{\u001a\u00020\u000b2\b\u0010\\\u001a\u0004\u0018\u00010[¢\u0006\u0004\b{\u0010^J\u0017\u0010{\u001a\u00020\u000b2\b\b\u0001\u0010U\u001a\u00020\u0007¢\u0006\u0004\b{\u00100J%\u0010|\u001a\u00020\u000b2\b\u0010`\u001a\u0004\u0018\u00010_2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010[H\u0007¢\u0006\u0004\b|\u0010cJ\u0015\u0010}\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0013¢\u0006\u0004\b}\u0010\u0016J\u0017\u0010~\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010f¢\u0006\u0004\b~\u0010hJ\u0017\u0010\u007f\u001a\u00020\u000b2\b\b\u0001\u0010?\u001a\u00020\u0007¢\u0006\u0004\b\u007f\u00100JH\u0010\u0086\u0001\u001a\u00020\u000b2\b\u0010\u0081\u0001\u001a\u00030\u0080\u00012\t\b\u0003\u0010\u0082\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u00132\t\b\u0003\u0010\u0084\u0001\u001a\u00020\u00072\t\b\u0003\u0010\u0085\u0001\u001a\u00020\u0007H\u0007¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001a\u0010\u0088\u0001\u001a\u00020\u000b2\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u0013¢\u0006\u0005\b\u0088\u0001\u0010\u0016J\u0011\u0010\u008a\u0001\u001a\u00020\u000bH\u0000¢\u0006\u0005\b\u0089\u0001\u0010\rJ\u0011\u0010\u008c\u0001\u001a\u00020\u000bH\u0000¢\u0006\u0005\b\u008b\u0001\u0010\rJ\u0018\u0010\u008e\u0001\u001a\u00020\u000b2\u0007\u0010\u008d\u0001\u001a\u00020\u0013¢\u0006\u0005\b\u008e\u0001\u0010\u0016J\u000f\u0010\u008f\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u008f\u0001\u0010\rJ\u001b\u0010\u0091\u0001\u001a\u00020\u000b2\t\u0010u\u001a\u0005\u0018\u00010\u0090\u0001¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\u000b2\t\u0010u\u001a\u0005\u0018\u00010\u0093\u0001¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u001a\u0010\u0097\u0001\u001a\u00020\u000b2\u0007\u0010\u0096\u0001\u001a\u00020\u0013H\u0016¢\u0006\u0005\b\u0097\u0001\u0010\u0016J\u0011\u0010\u0098\u0001\u001a\u00020\u0013H\u0016¢\u0006\u0005\b\u0098\u0001\u0010<J\u0011\u0010\u0099\u0001\u001a\u00020\u000bH\u0016¢\u0006\u0005\b\u0099\u0001\u0010\rJ\u001c\u0010\u009c\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u0007H\u0014¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u001a\u0010\u009e\u0001\u001a\u00020\u000b2\u0007\u0010\u008d\u0001\u001a\u00020\u0013H\u0016¢\u0006\u0005\b\u009e\u0001\u0010\u0016J\u0011\u0010\u009f\u0001\u001a\u00020\u0007H\u0007¢\u0006\u0005\b\u009f\u0001\u0010\u0010J0\u0010¢\u0001\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u00132\t\b\u0002\u0010 \u0001\u001a\u00020\u00072\t\b\u0002\u0010¡\u0001\u001a\u00020\u0007H\u0007¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u001a\u0010¤\u0001\u001a\u00020\u000b2\t\b\u0001\u0010 \u0001\u001a\u00020\u0007¢\u0006\u0005\b¤\u0001\u00100J\u0017\u0010¥\u0001\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u0007¢\u0006\u0005\b¥\u0001\u00100J\u001c\u0010¨\u0001\u001a\u00020\u000b2\b\u0010§\u0001\u001a\u00030¦\u0001H\u0014¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u0011\u0010ª\u0001\u001a\u00020\u000bH\u0014¢\u0006\u0005\bª\u0001\u0010\rJ\u0011\u0010«\u0001\u001a\u00020\u000bH\u0014¢\u0006\u0005\b«\u0001\u0010\rJ$\u0010®\u0001\u001a\u00020\u000b2\u0007\u0010¬\u0001\u001a\u00020\u00072\u0007\u0010\u00ad\u0001\u001a\u00020\u0007H\u0014¢\u0006\u0006\b®\u0001\u0010¯\u0001R\u0018\u0010±\u0001\u001a\u00030°\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u0019\u0010³\u0001\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u0019\u0010µ\u0001\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010´\u0001R\u0019\u0010¶\u0001\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010´\u0001R\u0019\u0010·\u0001\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b·\u0001\u0010´\u0001R\u001c\u0010¸\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u001c\u0010º\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u001b\u0010¼\u0001\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u0019\u0010¾\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0019\u0010À\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010¿\u0001R\u001c\u0010Á\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R\u0019\u0010Ã\u0001\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010´\u0001R\u0019\u0010Ä\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010¿\u0001R\u0019\u0010Å\u0001\u001a\u00020j8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u001b\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u0019\u0010É\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010¿\u0001R\u0019\u0010Ê\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010¿\u0001R\u001b\u0010Ë\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bË\u0001\u0010È\u0001R\u0019\u0010Ì\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010¿\u0001R\u0019\u0010Í\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010¿\u0001R\u0019\u0010Î\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010¿\u0001R\u001b\u0010Ï\u0001\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R+\u0010Ñ\u0001\u001a\u0004\u0018\u00010_8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÑ\u0001\u0010Ò\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001R\u001b\u0010×\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R\u001b\u0010Ù\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001R\u001b\u0010Û\u0001\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R\u0019\u0010Ý\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010¿\u0001R\u0019\u0010Þ\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010´\u0001R\u001b\u0010ß\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010È\u0001R\u0019\u0010à\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0001\u0010¿\u0001R\u0019\u0010á\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0001\u0010´\u0001R\u001b\u0010â\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010È\u0001R\u0019\u0010ã\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0001\u0010´\u0001R\u0019\u0010ä\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010¿\u0001R\u0019\u0010å\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010´\u0001R\u0019\u0010æ\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0001\u0010´\u0001R\u001b\u0010ç\u0001\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010è\u0001R\u0019\u0010é\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010´\u0001R\u001b\u0010ê\u0001\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010ë\u0001R\u0019\u0010\u0083\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010¿\u0001R\u0018\u0010í\u0001\u001a\u00030ì\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bí\u0001\u0010î\u0001R\u0019\u0010ï\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0001\u0010¿\u0001R\u0019\u0010ð\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bð\u0001\u0010¿\u0001R\u0019\u0010ñ\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bñ\u0001\u0010¿\u0001R!\u0010÷\u0001\u001a\u00030ò\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bó\u0001\u0010ô\u0001\u001a\u0006\bõ\u0001\u0010ö\u0001R0\u0010ù\u0001\u001a\u00020\u00132\u0007\u0010ø\u0001\u001a\u00020\u00138G@GX\u0086\u000e¢\u0006\u0016\n\u0006\bù\u0001\u0010¿\u0001\u001a\u0005\bù\u0001\u0010<\"\u0005\bú\u0001\u0010\u0016R7\u0010û\u0001\u001a\u00020\u00072\u0007\u0010ø\u0001\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u001d\n\u0006\bû\u0001\u0010´\u0001\u0012\u0005\bþ\u0001\u0010\r\u001a\u0005\bü\u0001\u0010\u0010\"\u0005\bý\u0001\u00100R0\u0010ÿ\u0001\u001a\u00020\u00132\u0007\u0010ø\u0001\u001a\u00020\u00138G@GX\u0086\u000e¢\u0006\u0016\n\u0006\bÿ\u0001\u0010¿\u0001\u001a\u0005\bÿ\u0001\u0010<\"\u0005\b\u0080\u0002\u0010\u0016R\u0017\u0010\u0083\u0002\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0081\u0002\u0010\u0082\u0002R\u0017\u0010\u0085\u0002\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0084\u0002\u0010\u0082\u0002R\u0018\u0010\u0089\u0002\u001a\u00030\u0086\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0087\u0002\u0010\u0088\u0002R/\u0010\u008e\u0002\u001a\u00020\u00072\u0007\u0010\u008a\u0002\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u0015\u0012\u0005\b\u008d\u0002\u0010\r\u001a\u0005\b\u008b\u0002\u0010\u0010\"\u0005\b\u008c\u0002\u00100R/\u0010\u0092\u0002\u001a\u00020\u00072\u0007\u0010\u008a\u0002\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u0015\u0012\u0005\b\u0091\u0002\u0010\r\u001a\u0005\b\u008f\u0002\u0010\u0010\"\u0005\b\u0090\u0002\u00100R/\u0010\u0096\u0002\u001a\u00020\u00072\u0007\u0010ø\u0001\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u0015\u0012\u0005\b\u0095\u0002\u0010\r\u001a\u0005\b\u0093\u0002\u0010\u0010\"\u0005\b\u0094\u0002\u00100R\u0013\u0010\u0098\u0002\u001a\u0002018F¢\u0006\u0007\u001a\u0005\b\u0097\u0002\u00103R\u0013\u0010\u009a\u0002\u001a\u00020\u00198F¢\u0006\u0007\u001a\u0005\b\u0099\u0002\u00108R\u0013\u0010\u009c\u0002\u001a\u00020\u00198F¢\u0006\u0007\u001a\u0005\b\u009b\u0002\u00108R\u0013\u0010\u009e\u0002\u001a\u00020\u00198F¢\u0006\u0007\u001a\u0005\b\u009d\u0002\u00108R\u0013\u0010 \u0002\u001a\u00020\u00198F¢\u0006\u0007\u001a\u0005\b\u009f\u0002\u00108R\u0013\u0010¢\u0002\u001a\u0002018F¢\u0006\u0007\u001a\u0005\b¡\u0002\u00103R\u0016\u0010¤\u0002\u001a\u00020\u00138@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b£\u0002\u0010<R\u0016\u0010¦\u0002\u001a\u00020\u00138AX\u0080\u0004¢\u0006\u0007\u001a\u0005\b¥\u0002\u0010<R-\u0010ª\u0002\u001a\u0004\u0018\u00010r2\t\u0010\u008a\u0002\u001a\u0004\u0018\u00010r8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b§\u0002\u0010¨\u0002\"\u0005\bV\u0010©\u0002R-\u0010¬\u0002\u001a\u0004\u0018\u00010r2\t\u0010\u008a\u0002\u001a\u0004\u0018\u00010r8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b«\u0002\u0010¨\u0002\"\u0005\bW\u0010©\u0002R-\u0010®\u0002\u001a\u0004\u0018\u00010r2\t\u0010\u008a\u0002\u001a\u0004\u0018\u00010r8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b\u00ad\u0002\u0010¨\u0002\"\u0005\bX\u0010©\u0002R-\u0010°\u0002\u001a\u0004\u0018\u00010r2\t\u0010\u008a\u0002\u001a\u0004\u0018\u00010r8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b¯\u0002\u0010¨\u0002\"\u0005\bY\u0010©\u0002R-\u0010²\u0002\u001a\u0004\u0018\u00010r2\t\u0010\u008a\u0002\u001a\u0004\u0018\u00010r8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b±\u0002\u0010¨\u0002\"\u0005\bZ\u0010©\u0002R(\u0010µ\u0002\u001a\u00020\u00072\u0007\u0010ø\u0001\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b³\u0002\u0010\u0010\"\u0005\b´\u0002\u00100R(\u0010¸\u0002\u001a\u00020\u00072\u0007\u0010ø\u0001\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¶\u0002\u0010\u0010\"\u0005\b·\u0002\u00100R(\u0010»\u0002\u001a\u00020\u00132\u0007\u0010\u008a\u0002\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¹\u0002\u0010<\"\u0005\bº\u0002\u0010\u0016R(\u0010¾\u0002\u001a\u00020\u00132\u0007\u0010\u008a\u0002\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¼\u0002\u0010<\"\u0005\b½\u0002\u0010\u0016R/\u0010Â\u0002\u001a\u0004\u0018\u00010\u00072\u000b\b\u0001\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b¿\u0002\u0010À\u0002\"\u0005\bÁ\u0002\u0010oR(\u0010Å\u0002\u001a\u00020\u00132\u0007\u0010\u008a\u0002\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÃ\u0002\u0010<\"\u0005\bÄ\u0002\u0010\u0016R/\u0010È\u0002\u001a\u0004\u0018\u00010\u00072\u000b\b\u0001\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\bÆ\u0002\u0010À\u0002\"\u0005\bÇ\u0002\u0010oR(\u0010Ë\u0002\u001a\u00020\u00132\u0007\u0010ø\u0001\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÉ\u0002\u0010<\"\u0005\bÊ\u0002\u0010\u0016R(\u0010Î\u0002\u001a\u00020\u00132\u0007\u0010\u008a\u0002\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÌ\u0002\u0010<\"\u0005\bÍ\u0002\u0010\u0016R(\u0010Ñ\u0002\u001a\u00020\u00132\u0007\u0010ø\u0001\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÏ\u0002\u0010<\"\u0005\bÐ\u0002\u0010\u0016¨\u0006Û\u0002"}, d2 = {"Lcom/stepos/widget/list/StepOSListItem;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/Checkable;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "applyAccessorySize", "()V", "applyDisabledOpacity", "leadingContentWidth", "()I", "refreshDividerInset", "notifyDividerStateChanged", "", "hidden", "setNeighborBelowHidesDivider", "(Z)V", "rowAbove", "()Lcom/stepos/widget/list/StepOSListItem;", "Landroid/widget/TextView;", "view", "desiredTextWidth", "(Landroid/widget/TextView;)I", "Landroid/view/View;", "margin", "updateEndMargin", "(Landroid/view/View;I)V", "stacked", "applyValueStacking", "applyLineMode", "applyTitleStyle", "applyBadges", "updateIconVisibility", "applyLeadingSpacing", "applyTrailingSpacing", "show", "style", "tint", "applyBadge", "(Landroid/view/View;ZILjava/lang/Integer;)V", "type", "applyTrailingType", "(I)V", "Landroid/widget/ImageView;", "ensureCheck", "()Landroid/widget/ImageView;", "Lcom/stepos/widget/toggle/StepOSSwitch;", "ensureSwitch", "()Lcom/stepos/widget/toggle/StepOSSwitch;", "ensureButton", "()Landroid/widget/TextView;", "applyPressAnimation", "applyIconStyle", "isCircularIconClip", "()Z", "isPreviewIconClip", "applyIconShape", "px", "setSize", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "setSizeWH", "(Landroid/view/View;II)V", "active", "setSwipeAppearanceActive$StepOSWidget_release", "setSwipeAppearanceActive", "Landroid/content/res/TypedArray;", Const.INTENT_KEY_APIKEY, "applyDefaultChrome", "Lcom/stepos/widget/list/ListItemAttrIndices;", "indices", "applyListItemStyledAttributes$StepOSWidget_release", "(Landroid/content/res/TypedArray;ZLcom/stepos/widget/list/ListItemAttrIndices;)V", "applyListItemStyledAttributes", "Lcom/stepos/widget/list/PreferenceListItemBridgeState;", VoiceWakeupReceiver.EXTRA_STATE, "applyPreferenceBridgeState$StepOSWidget_release", "(Lcom/stepos/widget/list/PreferenceListItemBridgeState;)V", "applyPreferenceBridgeState", "resId", "setTitle", "setTitleEndText", "setSubtitle", "setValueText", "setRightText", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "", "source", "placeholder", "setIconSource", "(Ljava/lang/Object;Landroid/graphics/drawable/Drawable;)V", "visible", "setIconVisible", "Landroid/content/res/ColorStateList;", "setIconTint", "(Landroid/content/res/ColorStateList;)V", "setIconSize", "", "setIconCornerRadius", "(F)V", "color", "setIconBackgroundColor", "(Ljava/lang/Integer;)V", "setTrailingView", "(Landroid/view/View;)V", "", "text", "Landroid/view/View$OnClickListener;", "listener", "setTrailingButton", "(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)V", "Lcom/stepos/widget/list/StepOSListItem$OnSwitchCheckedChangeListener;", "setOnSwitchCheckedChangeListener", "(Lcom/stepos/widget/list/StepOSListItem$OnSwitchCheckedChangeListener;)V", "setAccessoryIcon", "setAccessorySource", "setShowAccessory", "setAccessoryTint", "setAccessorySize", "", "radii", "normalColor", "showDivider", "outsetTop", "outsetBottom", "applyCardChrome", "([FIZII)V", "applyFlatChrome", "syncIconAfterExternalDrawable$StepOSWidget_release", "syncIconAfterExternalDrawable", "syncContentAfterBridge$StepOSWidget_release", "syncContentAfterBridge", x5.d.EXTRA_ENABLED, "setPressScaleEnabled", "reset", "Lcom/stepos/widget/list/StepOSListItem$OnItemClickListener;", "setOnItemClickListener", "(Lcom/stepos/widget/list/StepOSListItem$OnItemClickListener;)V", "Lcom/stepos/widget/list/StepOSListItem$OnCheckedChangeListener;", "setOnCheckedChangeListener", "(Lcom/stepos/widget/list/StepOSListItem$OnCheckedChangeListener;)V", "checked", "setChecked", "isChecked", "toggle", "extraSpace", "", "onCreateDrawableState", "(I)[I", "setEnabled", "getDividerInsetStart", "insetStart", "insetEnd", "setShowDivider", "(ZII)V", "setDividerInsetStart", "setDividerColor", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "drawableStateChanged", "onDetachedFromWindow", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Lcom/stepos/widget/databinding/SteposListItemBinding;", "binding", "Lcom/stepos/widget/databinding/SteposListItemBinding;", "iconTextGapPx", "I", "valueGapPx", "contentGapPx", "basePaddingVerticalPx", "onItemClickListener", "Lcom/stepos/widget/list/StepOSListItem$OnItemClickListener;", "onCheckedChangeListener", "Lcom/stepos/widget/list/StepOSListItem$OnCheckedChangeListener;", "onSwitchCheckedChangeListener", "Lcom/stepos/widget/list/StepOSListItem$OnSwitchCheckedChangeListener;", "pressScaleEnabled", "Z", "pressFeedbackEnabledField", "cardChromeRadii", "[F", "cardChromeColor", "reservesCheckSlotField", "iconCornerRadius", "F", "iconBackgroundColor", "Ljava/lang/Integer;", "showAccessory", "isDefaultAccessoryArrow", "accessorySizeOverride", "iconVisibleFlag", "checkedState", "contentOpacityReady", "switchView", "Lcom/stepos/widget/toggle/StepOSSwitch;", "switchHapticFeedbackOwner", "Ljava/lang/Object;", "getSwitchHapticFeedbackOwner$StepOSWidget_release", "()Ljava/lang/Object;", "setSwitchHapticFeedbackOwner$StepOSWidget_release", "(Ljava/lang/Object;)V", "buttonView", "Landroid/widget/TextView;", "customTrailingView", "Landroid/view/View;", "checkView", "Landroid/widget/ImageView;", "showBadgeState", "badgeStyleState", "badgeTintState", "showRightBadgeState", "rightBadgeStyleState", "rightBadgeTintState", "lineModeState", "isValueStacked", "horizontalValueMaxLines", "trailingTypeState", "pendingButtonText", "Ljava/lang/CharSequence;", "titleStyleState", "defaultTitleColors", "Landroid/content/res/ColorStateList;", "Lcom/stepos/widget/divider/StepOSDividerPainter;", "dividerPainter", "Lcom/stepos/widget/divider/StepOSDividerPainter;", "nextRowHidesDivider", "pressedForDivider", "swipeAppearanceActive", "Landroid/graphics/Paint;", "swipeOverlayPaint$delegate", "LY8/h;", "getSwipeOverlayPaint", "()Landroid/graphics/Paint;", "swipeOverlayPaint", UxipConstants.f30680s, "isAdaptiveTextLayoutEnabled", "setAdaptiveTextLayoutEnabled", "iconStyle", "getIconStyle", "setIconStyle", "getIconStyle$annotations", "isSwitchHapticFeedbackEnabled", "setSwitchHapticFeedbackEnabled", "getBadgeView", "()Landroid/view/View;", "badgeView", "getRightBadgeView", "rightBadgeView", "Landroid/widget/FrameLayout;", "getTrailingContainer", "()Landroid/widget/FrameLayout;", "trailingContainer", "v", "getBadgeStyle", "setBadgeStyle", "getBadgeStyle$annotations", "badgeStyle", "getRightBadgeStyle", "setRightBadgeStyle", "getRightBadgeStyle$annotations", "rightBadgeStyle", "getTrailingType", "setTrailingType", "getTrailingType$annotations", "trailingType", "getIconView", "iconView", "getTitleView", "titleView", "getTitleEndView", "titleEndView", "getSubtitleView", "subtitleView", "getValueView", "valueView", "getAccessoryView", "accessoryView", "isSwitchChangeFromUser$StepOSWidget_release", "isSwitchChangeFromUser", "getHidesAdjacentDividers$StepOSWidget_release", "hidesAdjacentDividers", "getTitle", "()Ljava/lang/CharSequence;", "(Ljava/lang/CharSequence;)V", "title", "getTitleEndText", "titleEndText", "getSubtitle", "subtitle", "getValueText", "valueText", "getRightText", "rightText", "getLineMode", "setLineMode", "lineMode", "getTitleStyle", "setTitleStyle", "titleStyle", "getShowIcon", "setShowIcon", "showIcon", "getShowBadge", "setShowBadge", "showBadge", "getBadgeTint", "()Ljava/lang/Integer;", "setBadgeTint", "badgeTint", "getShowRightBadge", "setShowRightBadge", "showRightBadge", "getRightBadgeTint", "setRightBadgeTint", "rightBadgeTint", "getReservesCheckSlot", "setReservesCheckSlot", "reservesCheckSlot", "getSwitchChecked", "setSwitchChecked", "switchChecked", "getPressFeedbackEnabled", "setPressFeedbackEnabled", "pressFeedbackEnabled", "Companion", "OnItemClickListener", "OnCheckedChangeListener", "OnSwitchCheckedChangeListener", "IconStyle", "BadgeStyle", "LineMode", "TrailingType", "TitleStyle", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSListItem extends ConstraintLayout implements Checkable {
    public static final int BADGE_BLUE = 0;
    public static final int BADGE_RED = 1;
    private static final float DISABLED_ALPHA = 0.3f;
    public static final int ICON_STYLE_AVATAR = 3;
    public static final int ICON_STYLE_LARGE = 1;
    public static final int ICON_STYLE_PREVIEW = 4;
    public static final int ICON_STYLE_PREVIEW_WIDE = 5;
    public static final int ICON_STYLE_SMALL = 0;
    public static final int ICON_STYLE_SQUARE = 2;
    public static final int LINE_MODE_AUTO = 0;
    public static final int LINE_MODE_DOUBLE = 2;
    public static final int LINE_MODE_SINGLE = 1;
    public static final int TITLE_STYLE_LINK = 1;
    public static final int TITLE_STYLE_NORMAL = 0;
    public static final int TRAILING_ARROW = 1;
    public static final int TRAILING_BUTTON = 3;
    public static final int TRAILING_CUSTOM = 4;
    public static final int TRAILING_NONE = 0;
    public static final int TRAILING_SWITCH = 2;
    private static StepOSListImageLoader imageLoader;
    private Integer accessorySizeOverride;
    private int badgeStyleState;
    private Integer badgeTintState;
    private int basePaddingVerticalPx;
    private final SteposListItemBinding binding;
    private TextView buttonView;
    private int cardChromeColor;
    private float[] cardChromeRadii;
    private ImageView checkView;
    private boolean checkedState;
    private int contentGapPx;
    private boolean contentOpacityReady;
    private View customTrailingView;
    private ColorStateList defaultTitleColors;
    private final StepOSDividerPainter dividerPainter;
    private int horizontalValueMaxLines;
    private Integer iconBackgroundColor;
    private float iconCornerRadius;
    private int iconStyle;
    private int iconTextGapPx;
    private boolean iconVisibleFlag;
    private boolean isAdaptiveTextLayoutEnabled;
    private boolean isDefaultAccessoryArrow;
    private boolean isSwitchHapticFeedbackEnabled;
    private boolean isValueStacked;
    private int lineModeState;
    private boolean nextRowHidesDivider;
    private OnCheckedChangeListener onCheckedChangeListener;
    private OnItemClickListener onItemClickListener;
    private OnSwitchCheckedChangeListener onSwitchCheckedChangeListener;
    private CharSequence pendingButtonText;
    private boolean pressFeedbackEnabledField;
    private boolean pressScaleEnabled;
    private boolean pressedForDivider;
    private boolean reservesCheckSlotField;
    private int rightBadgeStyleState;
    private Integer rightBadgeTintState;
    private boolean showAccessory;
    private boolean showBadgeState;
    private boolean showDivider;
    private boolean showRightBadgeState;
    private boolean swipeAppearanceActive;

    /* renamed from: swipeOverlayPaint$delegate, reason: from kotlin metadata */
    private final h swipeOverlayPaint;
    private Object switchHapticFeedbackOwner;
    private StepOSSwitch switchView;
    private int titleStyleState;
    private int trailingTypeState;
    private int valueGapPx;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/list/StepOSListItem$BadgeStyle;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface BadgeStyle {
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/stepos/widget/list/StepOSListItem$Companion;", "", "<init>", "()V", "imageLoader", "Lcom/stepos/widget/list/StepOSListImageLoader;", "getImageLoader$annotations", "getImageLoader", "()Lcom/stepos/widget/list/StepOSListImageLoader;", "setImageLoader", "(Lcom/stepos/widget/list/StepOSListImageLoader;)V", "ICON_STYLE_SMALL", "", "ICON_STYLE_LARGE", "ICON_STYLE_SQUARE", "ICON_STYLE_AVATAR", "ICON_STYLE_PREVIEW", "ICON_STYLE_PREVIEW_WIDE", "BADGE_BLUE", "BADGE_RED", "LINE_MODE_AUTO", "LINE_MODE_SINGLE", "LINE_MODE_DOUBLE", "TRAILING_NONE", "TRAILING_ARROW", "TRAILING_SWITCH", "TRAILING_BUTTON", "TRAILING_CUSTOM", "TITLE_STYLE_NORMAL", "TITLE_STYLE_LINK", "DISABLED_ALPHA", "", "CHECKED_STATE_SET", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ void getImageLoader$annotations() {
        }

        public final StepOSListImageLoader getImageLoader() {
            return StepOSListItem.imageLoader;
        }

        public final void setImageLoader(StepOSListImageLoader stepOSListImageLoader) {
            StepOSListItem.imageLoader = stepOSListImageLoader;
        }

        private Companion() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/list/StepOSListItem$IconStyle;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface IconStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/list/StepOSListItem$LineMode;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface LineMode {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/widget/list/StepOSListItem$OnCheckedChangeListener;", "", "Lcom/stepos/widget/list/StepOSListItem;", "item", "", "checked", "LY8/t;", "onCheckedChanged", "(Lcom/stepos/widget/list/StepOSListItem;Z)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnCheckedChangeListener {
        void onCheckedChanged(StepOSListItem item, boolean checked);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/widget/list/StepOSListItem$OnItemClickListener;", "", "Lcom/stepos/widget/list/StepOSListItem;", "item", "LY8/t;", "onItemClick", "(Lcom/stepos/widget/list/StepOSListItem;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnItemClickListener {
        void onItemClick(StepOSListItem item);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/widget/list/StepOSListItem$OnSwitchCheckedChangeListener;", "", "Lcom/stepos/widget/list/StepOSListItem;", "item", "", "checked", "LY8/t;", "onSwitchCheckedChanged", "(Lcom/stepos/widget/list/StepOSListItem;Z)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnSwitchCheckedChangeListener {
        void onSwitchCheckedChanged(StepOSListItem item, boolean checked);
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/list/StepOSListItem$TitleStyle;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface TitleStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/list/StepOSListItem$TrailingType;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface TrailingType {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSListItem(Context context) {
        this(context, null, 0, 6, null);
        p.i(context, "context");
    }

    private final void applyAccessorySize() {
        Integer num = this.accessorySizeOverride;
        int iIntValue = num != null ? num.intValue() : getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_accessory_size);
        int dimensionPixelSize = (this.isDefaultAccessoryArrow && this.accessorySizeOverride == null) ? getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_arrow_width) : iIntValue;
        getAccessoryView().setScaleType(ImageView.ScaleType.FIT_CENTER);
        ViewGroup.LayoutParams layoutParams = getAccessoryView().getLayoutParams();
        if (layoutParams.width == dimensionPixelSize && layoutParams.height == iIntValue) {
            return;
        }
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = iIntValue;
        getAccessoryView().setLayoutParams(layoutParams);
    }

    private final void applyBadge(View view, boolean show, int style, Integer tint) {
        int color;
        if (!show) {
            view.setVisibility(8);
            return;
        }
        if (tint != null) {
            color = tint.intValue();
        } else {
            color = getContext().getColor(style == 1 ? com.stepos.widget.R.color.stepos_list_item_badge_red : com.stepos.widget.R.color.stepos_list_item_badge_blue);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(color);
        view.setBackground(gradientDrawable);
        view.setImportantForAccessibility(2);
        view.setVisibility(0);
    }

    private final void applyBadges() {
        applyBadge(getBadgeView(), this.showBadgeState, this.badgeStyleState, this.badgeTintState);
        applyBadge(getRightBadgeView(), this.showRightBadgeState, this.rightBadgeStyleState, this.rightBadgeTintState);
        applyLeadingSpacing();
        applyTrailingSpacing();
        refreshDividerInset();
    }

    public static /* synthetic */ void applyCardChrome$default(StepOSListItem stepOSListItem, float[] fArr, int i10, boolean z10, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyCardChrome");
        }
        if ((i13 & 2) != 0) {
            i10 = stepOSListItem.getContext().getColor(com.stepos.widget.R.color.stepos_list_group_background);
        }
        stepOSListItem.applyCardChrome(fArr, i10, (i13 & 4) != 0 ? false : z10, (i13 & 8) != 0 ? 0 : i11, (i13 & 16) != 0 ? 0 : i12);
    }

    private final void applyDisabledOpacity() {
        if (this.contentOpacityReady) {
            setAlpha(1.0f);
            float f10 = isEnabled() ? 1.0f : 0.3f;
            getTitleView().setAlpha(f10);
            getTitleEndView().setAlpha(f10);
            getSubtitleView().setAlpha(f10);
            getValueView().setAlpha(f10);
            getIconView().setAlpha(f10);
            getAccessoryView().setAlpha(f10);
            getBadgeView().setAlpha(f10);
            getRightBadgeView().setAlpha(f10);
            ImageView imageView = this.checkView;
            if (imageView != null) {
                imageView.setAlpha(f10);
            }
            TextView textView = this.buttonView;
            if (textView != null) {
                textView.setAlpha(f10);
                textView.setEnabled(isEnabled());
            }
            View view = this.customTrailingView;
            if (view != null) {
                view.setAlpha(f10);
                view.setEnabled(isEnabled());
            }
            StepOSSwitch stepOSSwitch = this.switchView;
            if (stepOSSwitch != null) {
                stepOSSwitch.setEnabled(isEnabled());
            }
        }
    }

    public static /* synthetic */ void applyFlatChrome$default(StepOSListItem stepOSListItem, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyFlatChrome");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        stepOSListItem.applyFlatChrome(z10);
    }

    private final void applyIconShape() {
        Integer num = this.iconBackgroundColor;
        if (num != null) {
            ImageView iconView = getIconView();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(this.iconCornerRadius);
            gradientDrawable.setColor(num.intValue());
            iconView.setBackground(gradientDrawable);
            getIconView().setClipToOutline(true);
            getIconView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            return;
        }
        if (isCircularIconClip()) {
            ImageView iconView2 = getIconView();
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius(this.iconCornerRadius);
            gradientDrawable2.setColor(0);
            iconView2.setBackground(gradientDrawable2);
            getIconView().setClipToOutline(true);
            getIconView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            return;
        }
        if (!isPreviewIconClip()) {
            getIconView().setBackground(null);
            getIconView().setClipToOutline(false);
            getIconView().setScaleType(ImageView.ScaleType.FIT_CENTER);
            return;
        }
        ImageView iconView3 = getIconView();
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius(this.iconCornerRadius);
        gradientDrawable3.setColor(0);
        iconView3.setBackground(gradientDrawable3);
        getIconView().setClipToOutline(true);
        getIconView().setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private final void applyIconStyle(int style) {
        Resources resources = getResources();
        if (style == 1) {
            setSize(getIconView(), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_icon_large));
            this.iconCornerRadius = 0.0f;
        } else if (style == 2) {
            setSize(getIconView(), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_icon_square));
            this.iconCornerRadius = resources.getDimension(com.stepos.widget.R.dimen.stepos_list_item_icon_radius_square);
        } else if (style == 3) {
            setSize(getIconView(), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_icon_avatar));
            this.iconCornerRadius = resources.getDimension(com.stepos.widget.R.dimen.stepos_radius_full);
        } else if (style == 4) {
            setSizeWH(getIconView(), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_icon_preview_width), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_icon_preview_height));
            this.iconCornerRadius = resources.getDimension(com.stepos.widget.R.dimen.stepos_list_item_icon_radius_preview);
        } else if (style != 5) {
            setSize(getIconView(), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_icon_small));
            this.iconCornerRadius = 0.0f;
        } else {
            setSizeWH(getIconView(), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_icon_preview_wide_width), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_icon_preview_wide_height));
            this.iconCornerRadius = resources.getDimension(com.stepos.widget.R.dimen.stepos_list_item_icon_radius_preview);
        }
        applyIconShape();
        refreshDividerInset();
    }

    private final void applyLeadingSpacing() {
        boolean z10 = getBadgeView().getVisibility() == 0;
        boolean z11 = getIconView().getVisibility() == 0;
        ViewGroup.LayoutParams layoutParams = getBadgeView().getLayoutParams();
        p.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        bVar.setMarginEnd((z10 && z11) ? this.iconTextGapPx : 0);
        getBadgeView().setLayoutParams(bVar);
        ViewGroup.LayoutParams layoutParams2 = getTitleView().getLayoutParams();
        p.g(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
        if (z11) {
            bVar2.f12662s = getIconView().getId();
            bVar2.f12664t = -1;
            bVar2.setMarginStart(this.iconTextGapPx);
        } else if (z10) {
            bVar2.f12662s = getBadgeView().getId();
            bVar2.f12664t = -1;
            bVar2.setMarginStart(this.iconTextGapPx);
        } else {
            bVar2.f12662s = -1;
            bVar2.f12664t = 0;
            bVar2.setMarginStart(0);
        }
        getTitleView().setLayoutParams(bVar2);
    }

    private final void applyLineMode() {
        CharSequence text = getSubtitleView().getText();
        TextView subtitleView = getSubtitleView();
        int i10 = this.lineModeState;
        int i11 = 8;
        if (i10 != 1 && (i10 == 2 || (text != null && text.length() != 0))) {
            i11 = 0;
        }
        subtitleView.setVisibility(i11);
    }

    public static /* synthetic */ void applyListItemStyledAttributes$StepOSWidget_release$default(StepOSListItem stepOSListItem, TypedArray typedArray, boolean z10, ListItemAttrIndices listItemAttrIndices, int i10, Object obj) throws Resources.NotFoundException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyListItemStyledAttributes");
        }
        if ((i10 & 4) != 0) {
            listItemAttrIndices = ListItemAttrIndices.INSTANCE.getLIST_ITEM$StepOSWidget_release();
        }
        stepOSListItem.applyListItemStyledAttributes$StepOSWidget_release(typedArray, z10, listItemAttrIndices);
    }

    private final void applyPressAnimation() {
        setStateListAnimator(this.pressScaleEnabled ? AnimatorInflater.loadStateListAnimator(getContext(), com.stepos.widget.R.animator.stepos_list_item_press) : null);
    }

    private final void applyTitleStyle() {
        if (this.titleStyleState == 1) {
            getTitleView().setTextColor(getContext().getColor(com.stepos.widget.R.color.stepos_list_item_title_link));
            return;
        }
        ColorStateList colorStateList = this.defaultTitleColors;
        if (colorStateList != null) {
            getTitleView().setTextColor(colorStateList);
        }
    }

    private final void applyTrailingSpacing() {
        boolean z10 = getRightBadgeView().getVisibility() == 0;
        boolean z11 = getTrailingContainer().getVisibility() == 0;
        ViewGroup.LayoutParams layoutParams = getValueView().getLayoutParams();
        p.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        if (z10) {
            bVar.f12666u = getRightBadgeView().getId();
            bVar.f12668v = -1;
            bVar.setMarginEnd(this.valueGapPx);
        } else if (z11) {
            bVar.f12666u = getTrailingContainer().getId();
            bVar.f12668v = -1;
            bVar.setMarginEnd(this.contentGapPx);
        } else {
            bVar.f12666u = -1;
            bVar.f12668v = 0;
            bVar.setMarginEnd(0);
        }
        getValueView().setLayoutParams(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void applyTrailingType(int r11) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.list.StepOSListItem.applyTrailingType(int):void");
    }

    private final void applyValueStacking(boolean stacked) {
        if (this.isValueStacked == stacked) {
            return;
        }
        this.isValueStacked = stacked;
        Barrier steposListItemTrailingBarrier = this.binding.steposListItemTrailingBarrier;
        p.h(steposListItemTrailingBarrier, "steposListItemTrailingBarrier");
        steposListItemTrailingBarrier.setReferencedIds(stacked ? new int[]{getRightBadgeView().getId(), getTrailingContainer().getId()} : new int[]{getValueView().getId(), getRightBadgeView().getId(), getTrailingContainer().getId()});
        ViewGroup.LayoutParams layoutParams = getSubtitleView().getLayoutParams();
        p.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        bVar.f12648l = stacked ? -1 : 0;
        bVar.f12646k = stacked ? getValueView().getId() : -1;
        getSubtitleView().setLayoutParams(bVar);
        ViewGroup.LayoutParams layoutParams2 = getValueView().getLayoutParams();
        p.g(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
        ((ViewGroup.MarginLayoutParams) bVar2).width = stacked ? 0 : -2;
        bVar2.f12664t = stacked ? getTitleView().getId() : -1;
        bVar2.f12642i = stacked ? -1 : 0;
        bVar2.f12644j = stacked ? getSubtitleView().getId() : -1;
        ((ViewGroup.MarginLayoutParams) bVar2).topMargin = stacked ? getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_title_subtitle_gap) : 0;
        getValueView().setLayoutParams(bVar2);
        if (!stacked) {
            getValueView().setMaxLines(this.horizontalValueMaxLines);
        } else {
            this.horizontalValueMaxLines = getValueView().getMaxLines();
            getValueView().setMaxLines(2);
        }
    }

    private final int desiredTextWidth(TextView view) {
        CharSequence text;
        if (view.getVisibility() == 8) {
            return 0;
        }
        TransformationMethod transformationMethod = view.getTransformationMethod();
        if (transformationMethod == null || (text = transformationMethod.getTransformation(view.getText(), view)) == null) {
            text = view.getText();
        }
        return ((int) Math.ceil(Layout.getDesiredWidth(text, view.getPaint()))) + view.getCompoundPaddingStart() + view.getCompoundPaddingEnd();
    }

    private final TextView ensureButton() throws Resources.NotFoundException {
        TextView textView = this.buttonView;
        if (textView != null) {
            return textView;
        }
        TextView textView2 = new TextView(getContext());
        textView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 16));
        textView2.setBackground(C4027a.b(textView2.getContext(), com.stepos.widget.R.drawable.stepos_bg_list_button));
        textView2.setTextAppearance(com.stepos.widget.R.style.StepOSTextAppearance_ListItem_Button);
        textView2.setGravity(17);
        textView2.setMaxLines(2);
        textView2.setMinHeight(textView2.getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_button_min_height));
        int dimensionPixelSize = textView2.getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_button_padding_horizontal);
        int dimensionPixelSize2 = textView2.getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_button_padding_vertical);
        textView2.setPaddingRelative(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        textView2.setContentDescription(textView2.getContext().getText(com.stepos.widget.R.string.stepos_list_item_button_desc));
        CharSequence charSequence = this.pendingButtonText;
        if (charSequence != null) {
            textView2.setText(charSequence);
        }
        getTrailingContainer().addView(textView2);
        this.buttonView = textView2;
        textView2.setAlpha(isEnabled() ? 1.0f : 0.3f);
        textView2.setEnabled(isEnabled());
        return textView2;
    }

    private final ImageView ensureCheck() throws Resources.NotFoundException {
        ImageView imageView = this.checkView;
        if (imageView != null) {
            return imageView;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_accessory_size);
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize, 16));
        imageView2.setImageDrawable(C4027a.b(imageView2.getContext(), com.stepos.widget.R.drawable.stepos_icon_check));
        imageView2.setImageTintList(ColorStateList.valueOf(imageView2.getContext().getColor(com.stepos.widget.R.color.stepos_list_item_check)));
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView2.setContentDescription(imageView2.getContext().getText(com.stepos.widget.R.string.stepos_list_item_selected_desc));
        getTrailingContainer().addView(imageView2);
        this.checkView = imageView2;
        imageView2.setAlpha(isEnabled() ? 1.0f : 0.3f);
        return imageView2;
    }

    private final StepOSSwitch ensureSwitch() {
        StepOSSwitch stepOSSwitch = this.switchView;
        if (stepOSSwitch != null) {
            return stepOSSwitch;
        }
        Context context = getContext();
        p.h(context, "getContext(...)");
        StepOSSwitch stepOSSwitch2 = new StepOSSwitch(context, null, 0, 6, null);
        stepOSSwitch2.setSwitchHapticFeedbackEnabled(this.isSwitchHapticFeedbackEnabled);
        stepOSSwitch2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 16));
        stepOSSwitch2.setContentDescription(stepOSSwitch2.getContext().getText(com.stepos.widget.R.string.stepos_list_item_switch_desc));
        stepOSSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.stepos.widget.list.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                StepOSListItem.ensureSwitch$lambda$30$lambda$29(this.f31264a, compoundButton, z10);
            }
        });
        getTrailingContainer().addView(stepOSSwitch2);
        this.switchView = stepOSSwitch2;
        stepOSSwitch2.setEnabled(isEnabled());
        return stepOSSwitch2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ensureSwitch$lambda$30$lambda$29(StepOSListItem stepOSListItem, CompoundButton compoundButton, boolean z10) {
        p.i(compoundButton, "<unused var>");
        OnSwitchCheckedChangeListener onSwitchCheckedChangeListener = stepOSListItem.onSwitchCheckedChangeListener;
        if (onSwitchCheckedChangeListener != null) {
            onSwitchCheckedChangeListener.onSwitchCheckedChanged(stepOSListItem, z10);
        }
    }

    public static /* synthetic */ void getBadgeStyle$annotations() {
    }

    private final View getBadgeView() {
        View steposListItemBadge = this.binding.steposListItemBadge;
        p.h(steposListItemBadge, "steposListItemBadge");
        return steposListItemBadge;
    }

    public static /* synthetic */ void getIconStyle$annotations() {
    }

    public static final StepOSListImageLoader getImageLoader() {
        return INSTANCE.getImageLoader();
    }

    public static /* synthetic */ void getRightBadgeStyle$annotations() {
    }

    private final View getRightBadgeView() {
        View steposListItemRightBadge = this.binding.steposListItemRightBadge;
        p.h(steposListItemRightBadge, "steposListItemRightBadge");
        return steposListItemRightBadge;
    }

    private final Paint getSwipeOverlayPaint() {
        return (Paint) this.swipeOverlayPaint.getValue();
    }

    private final FrameLayout getTrailingContainer() {
        FrameLayout steposListItemTrailing = this.binding.steposListItemTrailing;
        p.h(steposListItemTrailing, "steposListItemTrailing");
        return steposListItemTrailing;
    }

    public static /* synthetic */ void getTrailingType$annotations() {
    }

    private final boolean isCircularIconClip() {
        if (this.iconStyle == 3) {
            return true;
        }
        ViewGroup.LayoutParams layoutParams = getIconView().getLayoutParams();
        if (layoutParams == null) {
            return false;
        }
        int i10 = layoutParams.width;
        int i11 = layoutParams.height;
        return i10 > 0 && i11 > 0 && this.iconCornerRadius >= (((float) Math.min(i10, i11)) / 2.0f) - 0.5f;
    }

    private final boolean isPreviewIconClip() {
        int i10 = this.iconStyle;
        return i10 == 4 || i10 == 5;
    }

    private final int leadingContentWidth() {
        int dimensionPixelSize = getBadgeView().getVisibility() == 0 ? getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_badge_size) + this.iconTextGapPx : 0;
        return getIconView().getVisibility() == 0 ? dimensionPixelSize + C5685n.f(getIconView().getLayoutParams().width, 0) + this.iconTextGapPx : dimensionPixelSize;
    }

    private final void notifyDividerStateChanged() {
        invalidate();
        StepOSListItem stepOSListItemRowAbove = rowAbove();
        if (stepOSListItemRowAbove != null) {
            stepOSListItemRowAbove.setNeighborBelowHidesDivider(getHidesAdjacentDividers$StepOSWidget_release());
        }
        ViewParent parent = getParent();
        StepOSListGroup stepOSListGroup = parent instanceof StepOSListGroup ? (StepOSListGroup) parent : null;
        if (stepOSListGroup != null) {
            stepOSListGroup.invalidate();
        }
        ViewParent parent2 = getParent();
        RecyclerView recyclerView = parent2 instanceof RecyclerView ? (RecyclerView) parent2 : null;
        if (recyclerView != null) {
            recyclerView.invalidate();
        }
        ViewParent parent3 = getParent();
        StepOSSwipeActionLayout stepOSSwipeActionLayout = parent3 instanceof StepOSSwipeActionLayout ? (StepOSSwipeActionLayout) parent3 : null;
        if (stepOSSwipeActionLayout != null) {
            stepOSSwipeActionLayout.notifyContentPressedChanged$StepOSWidget_release();
        }
    }

    private static final int onMeasure$occupiedWidth(StepOSListItem stepOSListItem, int i10, int i11, View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        boolean zIsLayoutRequested = view.isLayoutRequested();
        stepOSListItem.measureChildWithMargins(view, i10, 0, i11, 0);
        if (zIsLayoutRequested) {
            view.forceLayout();
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        p.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        return view.getMeasuredWidth() + bVar.getMarginStart() + bVar.getMarginEnd();
    }

    private final void refreshDividerInset() {
        if (this.showDivider) {
            this.dividerPainter.setInsetStart$StepOSWidget_release(getDividerInsetStart());
            invalidate();
        }
    }

    private final StepOSListItem rowAbove() {
        View childAt;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        View view;
        ViewParent parent = getParent();
        if (parent instanceof StepOSSwipeActionLayout) {
            return ((StepOSSwipeActionLayout) parent).rowAbove$StepOSWidget_release();
        }
        if (parent instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) parent;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(this);
            if (childAdapterPosition <= 0 || (viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(childAdapterPosition - 1)) == null || (view = viewHolderFindViewHolderForAdapterPosition.itemView) == null) {
                return null;
            }
            StepOSListItem stepOSListItem = view instanceof StepOSListItem ? (StepOSListItem) view : null;
            if (stepOSListItem != null) {
                return stepOSListItem;
            }
            StepOSSwipeActionLayout stepOSSwipeActionLayout = view instanceof StepOSSwipeActionLayout ? (StepOSSwipeActionLayout) view : null;
            contentListItem$StepOSWidget_release = stepOSSwipeActionLayout != null ? stepOSSwipeActionLayout.getContentListItem$StepOSWidget_release() : null;
            return contentListItem$StepOSWidget_release == null ? (StepOSListItem) view.findViewById(com.stepos.widget.R.id.stepos_preference_bridge_row) : contentListItem$StepOSWidget_release;
        }
        if (parent instanceof StepOSListGroup) {
            return null;
        }
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int iIndexOfChild = viewGroup.indexOfChild(this);
            if (iIndexOfChild <= 0 || (childAt = viewGroup.getChildAt(iIndexOfChild - 1)) == null) {
                return null;
            }
            contentListItem$StepOSWidget_release = childAt instanceof StepOSListItem ? (StepOSListItem) childAt : null;
            if (contentListItem$StepOSWidget_release == null) {
                return (StepOSListItem) childAt.findViewById(com.stepos.widget.R.id.stepos_preference_bridge_row);
            }
        }
        return contentListItem$StepOSWidget_release;
    }

    public static /* synthetic */ void setAccessorySource$default(StepOSListItem stepOSListItem, Object obj, Drawable drawable, int i10, Object obj2) throws Resources.NotFoundException {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAccessorySource");
        }
        if ((i10 & 2) != 0) {
            drawable = null;
        }
        stepOSListItem.setAccessorySource(obj, drawable);
    }

    public static /* synthetic */ void setIconSource$default(StepOSListItem stepOSListItem, Object obj, Drawable drawable, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIconSource");
        }
        if ((i10 & 2) != 0) {
            drawable = null;
        }
        stepOSListItem.setIconSource(obj, drawable);
    }

    public static final void setImageLoader(StepOSListImageLoader stepOSListImageLoader) {
        INSTANCE.setImageLoader(stepOSListImageLoader);
    }

    private final void setNeighborBelowHidesDivider(boolean hidden) {
        if (this.nextRowHidesDivider == hidden) {
            return;
        }
        this.nextRowHidesDivider = hidden;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnItemClickListener$lambda$20(StepOSListItem stepOSListItem, View view) {
        OnItemClickListener onItemClickListener = stepOSListItem.onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(stepOSListItem);
        }
    }

    public static /* synthetic */ void setShowDivider$default(StepOSListItem stepOSListItem, boolean z10, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setShowDivider");
        }
        if ((i12 & 2) != 0) {
            i10 = stepOSListItem.dividerPainter.getInsetStart();
        }
        if ((i12 & 4) != 0) {
            i11 = stepOSListItem.dividerPainter.getInsetEnd();
        }
        stepOSListItem.setShowDivider(z10, i10, i11);
    }

    private final void setSize(View view, int px) {
        setSizeWH(view, px, px);
    }

    private final void setSizeWH(View view, int w10, int h10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = w10;
        layoutParams.height = h10;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint swipeOverlayPaint_delegate$lambda$1(Context context) {
        Paint paint = new Paint();
        paint.setColor(context.getColor(com.stepos.widget.R.color.stepos_list_item_swipe_overlay));
        return paint;
    }

    private final void updateEndMargin(View view, int margin) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        p.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        if (bVar.getMarginEnd() == margin && bVar.f12601B == margin) {
            return;
        }
        bVar.setMarginEnd(margin);
        bVar.f12601B = margin;
        view.setLayoutParams(bVar);
    }

    private final void updateIconVisibility() {
        getIconView().setVisibility((!this.iconVisibleFlag || getIconView().getDrawable() == null) ? 8 : 0);
        applyLeadingSpacing();
        refreshDividerInset();
    }

    public final void applyCardChrome(float[] radii) {
        p.i(radii, "radii");
        applyCardChrome$default(this, radii, 0, false, 0, 0, 30, null);
    }

    public final void applyFlatChrome(boolean showDivider) {
        setPressScaleEnabled(false);
        this.cardChromeRadii = null;
        setBackground(this.pressFeedbackEnabledField ? C4027a.b(getContext(), com.stepos.widget.R.drawable.stepos_bg_list_item_selector) : new ColorDrawable(0));
        setForeground(null);
        setShowDivider$default(this, showDivider, 0, 0, 6, null);
        setPaddingRelative(getPaddingStart(), this.basePaddingVerticalPx, getPaddingEnd(), this.basePaddingVerticalPx);
    }

    public final void applyListItemStyledAttributes$StepOSWidget_release(TypedArray a10, boolean applyDefaultChrome, ListItemAttrIndices indices) throws Resources.NotFoundException {
        CharSequence charSequence;
        p.i(a10, "a");
        p.i(indices, "indices");
        Resources resources = getResources();
        int dimensionPixelSize = a10.getDimensionPixelSize(indices.getMinHeight(), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_height));
        int dimensionPixelSize2 = a10.getDimensionPixelSize(indices.getPaddingHorizontal(), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_padding_start));
        int dimensionPixelSize3 = a10.getDimensionPixelSize(indices.getPaddingVertical(), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_padding_vertical));
        int dimensionPixelSize4 = a10.getDimensionPixelSize(indices.getIconTextGap(), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_icon_text_gap));
        this.valueGapPx = a10.getDimensionPixelSize(indices.getValueGap(), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_value_gap));
        this.contentGapPx = resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_content_gap);
        this.iconTextGapPx = dimensionPixelSize4;
        int resourceId = a10.getResourceId(indices.getTitleTextAppearance(), 0);
        if (resourceId != 0) {
            getTitleView().setTextAppearance(resourceId);
        }
        this.defaultTitleColors = getTitleView().getTextColors();
        int resourceId2 = a10.getResourceId(indices.getSubtitleTextAppearance(), 0);
        if (resourceId2 != 0) {
            getSubtitleView().setTextAppearance(resourceId2);
        }
        int resourceId3 = a10.getResourceId(indices.getValueTextAppearance(), 0);
        if (resourceId3 != 0) {
            getValueView().setTextAppearance(resourceId3);
        }
        getSubtitleView().setMaxLines(C5685n.f(a10.getInt(indices.getSubtitleMaxLines(), 1), 1));
        setAdaptiveTextLayoutEnabled(a10.getBoolean(indices.getAdaptiveTextLayoutEnabled(), false));
        setTitle(a10.getText(indices.getTitle()));
        setTitleEndText(a10.getText(indices.getTitleEndText()));
        setSubtitle(a10.getText(indices.getSubtitle()));
        CharSequence text = a10.getText(indices.getRightText());
        if (text == null) {
            text = a10.getText(indices.getValue());
        }
        setValueText(text);
        this.iconBackgroundColor = a10.hasValue(indices.getIconBackground()) ? Integer.valueOf(a10.getColor(indices.getIconBackground(), 0)) : null;
        Drawable drawable = a10.getDrawable(indices.getIcon());
        if (drawable != null) {
            getIconView().setImageDrawable(drawable);
        }
        if (a10.hasValue(indices.getIconTint())) {
            getIconView().setImageTintList(a10.getColorStateList(indices.getIconTint()));
        }
        this.iconVisibleFlag = a10.getBoolean(indices.getIconVisible(), true);
        setIconStyle(a10.getInt(indices.getIconStyle(), 0));
        if (a10.hasValue(indices.getIconSize())) {
            setIconSize(a10.getDimensionPixelSize(indices.getIconSize(), 0));
        }
        if (a10.hasValue(indices.getIconCornerRadius())) {
            setIconCornerRadius(a10.getDimension(indices.getIconCornerRadius(), 0.0f));
        }
        this.badgeStyleState = a10.getInt(indices.getBadgeStyle(), 0);
        if (a10.hasValue(indices.getBadgeTint())) {
            this.badgeTintState = Integer.valueOf(a10.getColor(indices.getBadgeTint(), 0));
        }
        this.showBadgeState = a10.getBoolean(indices.getShowBadge(), false);
        this.rightBadgeStyleState = a10.getInt(indices.getRightBadgeStyle(), 1);
        if (a10.hasValue(indices.getRightBadgeTint())) {
            this.rightBadgeTintState = Integer.valueOf(a10.getColor(indices.getRightBadgeTint(), 0));
        }
        this.showRightBadgeState = a10.getBoolean(indices.getShowRightBadge(), false);
        this.showAccessory = a10.getBoolean(indices.getShowAccessory(), true);
        Drawable drawable2 = a10.getDrawable(indices.getRightIcon());
        if (drawable2 == null) {
            drawable2 = a10.getDrawable(indices.getAccessoryIcon());
        }
        Integer numValueOf = Integer.valueOf(a10.getResourceId(indices.getRightIcon(), 0));
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        this.isDefaultAccessoryArrow = drawable2 == null || (numValueOf != null ? numValueOf.intValue() : a10.getResourceId(indices.getAccessoryIcon(), com.stepos.widget.R.drawable.stepos_icon_arrow_right)) == com.stepos.widget.R.drawable.stepos_icon_arrow_right;
        ImageView accessoryView = getAccessoryView();
        if (drawable2 == null) {
            drawable2 = C4027a.b(getContext(), com.stepos.widget.R.drawable.stepos_icon_arrow_right);
        }
        accessoryView.setImageDrawable(drawable2);
        if (a10.hasValue(indices.getAccessoryTint())) {
            getAccessoryView().setImageTintList(a10.getColorStateList(indices.getAccessoryTint()));
        }
        this.accessorySizeOverride = a10.hasValue(indices.getAccessorySize()) ? Integer.valueOf(a10.getDimensionPixelSize(indices.getAccessorySize(), 0)) : null;
        applyAccessorySize();
        this.trailingTypeState = a10.getInt(indices.getTrailingType(), 1);
        CharSequence text2 = a10.getText(indices.getButtonText());
        if (text2 != null) {
            this.pendingButtonText = text2;
        }
        this.lineModeState = a10.getInt(indices.getLineMode(), 0);
        this.titleStyleState = a10.getInt(indices.getTitleStyle(), 0);
        boolean z10 = a10.getBoolean(indices.getChecked(), false);
        setSwitchChecked(a10.getBoolean(indices.getSwitchChecked(), false));
        this.pressScaleEnabled = a10.getBoolean(indices.getPressScaleEnabled(), false);
        Drawable drawable3 = a10.hasValue(indices.getForeground()) ? a10.getDrawable(indices.getForeground()) : null;
        this.showDivider = a10.getBoolean(indices.getShowDivider(), false);
        this.dividerPainter.setThickness$StepOSWidget_release(a10.getDimensionPixelSize(indices.getDividerHeight(), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_divider_height)));
        this.dividerPainter.setInsetStart$StepOSWidget_release(a10.getDimensionPixelSize(indices.getDividerInsetStart(), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_divider_inset_start)));
        this.dividerPainter.setInsetEnd$StepOSWidget_release(a10.getDimensionPixelSize(indices.getDividerInsetEnd(), resources.getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_divider_inset_end)));
        this.dividerPainter.setColor$StepOSWidget_release(a10.getColor(indices.getDividerColor(), getContext().getColor(com.stepos.widget.R.color.stepos_divider)));
        setPaddingRelative(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3);
        this.basePaddingVerticalPx = dimensionPixelSize3;
        setMinimumHeight(dimensionPixelSize);
        setClipChildren(false);
        applyIconShape();
        updateIconVisibility();
        if (applyDefaultChrome) {
            setBackground(C4027a.b(getContext(), com.stepos.widget.R.drawable.stepos_bg_list_item_selector));
            setForeground(drawable3);
            applyPressAnimation();
        }
        applyBadges();
        applyLeadingSpacing();
        setLineMode(this.lineModeState);
        applyTitleStyle();
        setTrailingType(this.trailingTypeState);
        if (this.trailingTypeState == 3 && (charSequence = this.pendingButtonText) != null) {
            setTrailingButton(charSequence, null);
        }
        setChecked(z10);
    }

    public final void applyPreferenceBridgeState$StepOSWidget_release(PreferenceListItemBridgeState state) throws Resources.NotFoundException {
        p.i(state, "state");
        this.iconTextGapPx = state.getIconTextGap();
        this.valueGapPx = getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_value_gap);
        this.contentGapPx = getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_list_item_content_gap);
        if (state.getTitleTextAppearance() != 0) {
            getTitleView().setTextAppearance(state.getTitleTextAppearance());
        }
        this.defaultTitleColors = getTitleView().getTextColors();
        if (state.getSubtitleTextAppearance() != 0) {
            getSubtitleView().setTextAppearance(state.getSubtitleTextAppearance());
        }
        if (state.getValueTextAppearance() != 0) {
            getValueView().setTextAppearance(state.getValueTextAppearance());
        }
        getSubtitleView().setMaxLines(C5685n.f(state.getSubtitleMaxLines(), 1));
        setAdaptiveTextLayoutEnabled(state.getAdaptiveTextLayoutEnabled());
        CharSequence title = state.getTitle();
        if (title != null) {
            setTitle(title);
        }
        CharSequence titleEndText = state.getTitleEndText();
        if (titleEndText != null) {
            setTitleEndText(titleEndText);
        }
        CharSequence subtitle = state.getSubtitle();
        if (subtitle != null) {
            setSubtitle(subtitle);
        }
        CharSequence rightText = state.getRightText();
        if (rightText != null) {
            setValueText(rightText);
        }
        if (state.getIconBackgroundExplicit()) {
            setIconBackgroundColor(state.getIconBackgroundColor());
        }
        if (state.getIconDrawableRes() != 0) {
            setIcon(state.getIconDrawableRes());
        }
        if (state.getIconTintExplicit()) {
            setIconTint(state.getIconTint() != null ? ColorStateList.valueOf(state.getIconTint().intValue()) : null);
        }
        setShowIcon(state.getIconVisible());
        setIconStyle(state.getIconStyle());
        if (state.getIconSizeSet()) {
            setIconSize(state.getIconSize());
        }
        if (state.getIconCornerRadiusSet()) {
            setIconCornerRadius(state.getIconCornerRadius());
        }
        setBadgeStyle(state.getBadgeStyle());
        if (state.getBadgeTintSet()) {
            setBadgeTint(Integer.valueOf(state.getBadgeTint()));
        }
        setShowBadge(state.getShowBadge());
        setRightBadgeStyle(state.getRightBadgeStyle());
        if (state.getRightBadgeTintSet()) {
            setRightBadgeTint(Integer.valueOf(state.getRightBadgeTint()));
        }
        setShowRightBadge(state.getShowRightBadge());
        this.showAccessory = state.getShowAccessory();
        this.accessorySizeOverride = state.getAccessorySize();
        setAccessoryIcon(state.getAccessoryIconRes());
        this.trailingTypeState = state.getTrailingType();
        CharSequence buttonText = state.getButtonText();
        if (buttonText != null) {
            this.pendingButtonText = buttonText;
        }
        setTrailingType(state.getTrailingType());
        if (state.getTrailingType() == 3 && state.getButtonText() != null) {
            setTrailingButton(state.getButtonText(), null);
        }
        setLineMode(state.getLineMode());
        setTitleStyle(state.getTitleStyle());
        setSwitchChecked(state.getSwitchChecked());
        setPressScaleEnabled(state.getPressScaleEnabled());
        this.showDivider = state.getShowDivider();
        this.dividerPainter.setThickness$StepOSWidget_release(state.getDividerHeight());
        this.dividerPainter.setInsetStart$StepOSWidget_release(state.getDividerInsetStart());
        this.dividerPainter.setInsetEnd$StepOSWidget_release(state.getDividerInsetEnd());
        this.dividerPainter.setColor$StepOSWidget_release(state.getDividerColor());
        setMinimumHeight(state.getMinHeight());
        setPaddingRelative(state.getPaddingHorizontal(), state.getPaddingVertical(), state.getPaddingHorizontal(), state.getPaddingVertical());
        this.basePaddingVerticalPx = state.getPaddingVertical();
        setClipChildren(false);
        applyIconShape();
        updateIconVisibility();
        applyBadges();
        applyLeadingSpacing();
        applyLineMode();
        setChecked(state.getChecked());
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        p.i(canvas, "canvas");
        if (this.swipeAppearanceActive && isEnabled()) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), getSwipeOverlayPaint());
        }
        super.dispatchDraw(canvas);
        if (!this.showDivider || getHidesAdjacentDividers$StepOSWidget_release() || this.nextRowHidesDivider) {
            return;
        }
        StepOSDividerPainter.drawInView$StepOSWidget_release$default(this.dividerPainter, canvas, getHeight() - this.dividerPainter.getThickness(), getWidth(), getLayoutDirection(), 0.0f, 16, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        boolean zIsPressed = isPressed();
        if (zIsPressed == this.pressedForDivider) {
            return;
        }
        this.pressedForDivider = zIsPressed;
        notifyDividerStateChanged();
    }

    public final ImageView getAccessoryView() {
        ImageView steposListItemAccessory = this.binding.steposListItemAccessory;
        p.h(steposListItemAccessory, "steposListItemAccessory");
        return steposListItemAccessory;
    }

    /* renamed from: getBadgeStyle, reason: from getter */
    public final int getBadgeStyleState() {
        return this.badgeStyleState;
    }

    /* renamed from: getBadgeTint, reason: from getter */
    public final Integer getBadgeTintState() {
        return this.badgeTintState;
    }

    public final int getDividerInsetStart() {
        return getPaddingStart() + leadingContentWidth();
    }

    public final boolean getHidesAdjacentDividers$StepOSWidget_release() {
        if (this.swipeAppearanceActive) {
            return true;
        }
        return this.pressFeedbackEnabledField && isPressed();
    }

    public final int getIconStyle() {
        return this.iconStyle;
    }

    public final ImageView getIconView() {
        ImageView steposListItemLeadingIcon = this.binding.steposListItemLeadingIcon;
        p.h(steposListItemLeadingIcon, "steposListItemLeadingIcon");
        return steposListItemLeadingIcon;
    }

    /* renamed from: getLineMode, reason: from getter */
    public final int getLineModeState() {
        return this.lineModeState;
    }

    /* renamed from: getPressFeedbackEnabled, reason: from getter */
    public final boolean getPressFeedbackEnabledField() {
        return this.pressFeedbackEnabledField;
    }

    /* renamed from: getReservesCheckSlot, reason: from getter */
    public final boolean getReservesCheckSlotField() {
        return this.reservesCheckSlotField;
    }

    /* renamed from: getRightBadgeStyle, reason: from getter */
    public final int getRightBadgeStyleState() {
        return this.rightBadgeStyleState;
    }

    /* renamed from: getRightBadgeTint, reason: from getter */
    public final Integer getRightBadgeTintState() {
        return this.rightBadgeTintState;
    }

    public final CharSequence getRightText() {
        return getValueText();
    }

    /* renamed from: getShowBadge, reason: from getter */
    public final boolean getShowBadgeState() {
        return this.showBadgeState;
    }

    /* renamed from: getShowIcon, reason: from getter */
    public final boolean getIconVisibleFlag() {
        return this.iconVisibleFlag;
    }

    /* renamed from: getShowRightBadge, reason: from getter */
    public final boolean getShowRightBadgeState() {
        return this.showRightBadgeState;
    }

    public final CharSequence getSubtitle() {
        return getSubtitleView().getText();
    }

    public final TextView getSubtitleView() {
        TextView steposListItemSubtitle = this.binding.steposListItemSubtitle;
        p.h(steposListItemSubtitle, "steposListItemSubtitle");
        return steposListItemSubtitle;
    }

    public final boolean getSwitchChecked() {
        StepOSSwitch stepOSSwitch = this.switchView;
        if (stepOSSwitch != null) {
            return stepOSSwitch.isChecked();
        }
        return false;
    }

    /* renamed from: getSwitchHapticFeedbackOwner$StepOSWidget_release, reason: from getter */
    public final Object getSwitchHapticFeedbackOwner() {
        return this.switchHapticFeedbackOwner;
    }

    public final CharSequence getTitle() {
        return getTitleView().getText();
    }

    public final CharSequence getTitleEndText() {
        return getTitleEndView().getText();
    }

    public final TextView getTitleEndView() {
        TextView steposListItemTitleEnd = this.binding.steposListItemTitleEnd;
        p.h(steposListItemTitleEnd, "steposListItemTitleEnd");
        return steposListItemTitleEnd;
    }

    /* renamed from: getTitleStyle, reason: from getter */
    public final int getTitleStyleState() {
        return this.titleStyleState;
    }

    public final TextView getTitleView() {
        TextView steposListItemTitle = this.binding.steposListItemTitle;
        p.h(steposListItemTitle, "steposListItemTitle");
        return steposListItemTitle;
    }

    /* renamed from: getTrailingType, reason: from getter */
    public final int getTrailingTypeState() {
        return this.trailingTypeState;
    }

    public final CharSequence getValueText() {
        return getValueView().getText();
    }

    public final TextView getValueView() {
        TextView steposListItemValue = this.binding.steposListItemValue;
        p.h(steposListItemValue, "steposListItemValue");
        return steposListItemValue;
    }

    /* renamed from: isAdaptiveTextLayoutEnabled, reason: from getter */
    public final boolean getIsAdaptiveTextLayoutEnabled() {
        return this.isAdaptiveTextLayoutEnabled;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checkedState;
    }

    public final boolean isSwitchChangeFromUser$StepOSWidget_release() {
        StepOSSwitch stepOSSwitch = this.switchView;
        return stepOSSwitch != null && stepOSSwitch.isUserCheckedChange$StepOSWidget_release();
    }

    /* renamed from: isSwitchHapticFeedbackEnabled, reason: from getter */
    public final boolean getIsSwitchHapticFeedbackEnabled() {
        return this.isSwitchHapticFeedbackEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int extraSpace) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(extraSpace + 1);
        if (this.checkedState) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        p.f(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        StepOSListItem stepOSListItemRowAbove = rowAbove();
        if (stepOSListItemRowAbove != null) {
            stepOSListItemRowAbove.setNeighborBelowHidesDivider(false);
        }
        super.onDetachedFromWindow();
        this.nextRowHidesDivider = false;
        this.pressedForDivider = false;
        this.swipeAppearanceActive = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (View.MeasureSpec.getMode(widthMeasureSpec) == 0) {
            applyValueStacking(false);
            getValueView().setMaxWidth(Integer.MAX_VALUE);
            getTitleEndView().setMaxWidth(Integer.MAX_VALUE);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int iOnMeasure$occupiedWidth = onMeasure$occupiedWidth(this, widthMeasureSpec, heightMeasureSpec, getBadgeView()) + onMeasure$occupiedWidth(this, widthMeasureSpec, heightMeasureSpec, getIconView());
        int iOnMeasure$occupiedWidth2 = onMeasure$occupiedWidth(this, widthMeasureSpec, heightMeasureSpec, getRightBadgeView()) + onMeasure$occupiedWidth(this, widthMeasureSpec, heightMeasureSpec, getTrailingContainer());
        ViewGroup.LayoutParams layoutParams = getTitleView().getLayoutParams();
        p.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        boolean z10 = true;
        boolean z11 = getValueView().getVisibility() != 8;
        if (getRightBadgeView().getVisibility() == 8 && getTrailingContainer().getVisibility() == 8) {
            z10 = false;
        }
        int i10 = getRightBadgeView().getVisibility() != 8 ? this.valueGapPx : getTrailingContainer().getVisibility() != 8 ? this.contentGapPx : 0;
        int i11 = (z11 || z10) ? this.valueGapPx : 0;
        int iF = C5685n.f(((((View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingStart()) - getPaddingEnd()) - iOnMeasure$occupiedWidth) - bVar.getMarginStart()) - iOnMeasure$occupiedWidth2, 0);
        int iF2 = C5685n.f((iF - i11) - (z11 ? i10 : 0), 0);
        int iDesiredTextWidth = desiredTextWidth(getTitleView());
        int iDesiredTextWidth2 = desiredTextWidth(getTitleEndView());
        int i12 = getTitleEndView().getVisibility() != 8 ? this.contentGapPx : 0;
        int iMax = Math.max(iDesiredTextWidth + i12 + iDesiredTextWidth2, desiredTextWidth(getSubtitleView()));
        int iDesiredTextWidth3 = desiredTextWidth(getValueView());
        ListItemTextWidthPolicy listItemTextWidthPolicy = ListItemTextWidthPolicy.INSTANCE;
        int iEndWidth$StepOSWidget_release = listItemTextWidthPolicy.endWidth$StepOSWidget_release(iF2, iMax, iDesiredTextWidth3);
        int iF3 = iF2 - iEndWidth$StepOSWidget_release;
        int i13 = iF3 - i12;
        boolean zShouldStack$StepOSWidget_release = listItemTextWidthPolicy.shouldStack$StepOSWidget_release(this.isAdaptiveTextLayoutEnabled, z11, iDesiredTextWidth, C5685n.f(i13 - listItemTextWidthPolicy.auxiliaryWidth$StepOSWidget_release(C5685n.f(i13, 0), iDesiredTextWidth, iDesiredTextWidth2), 0), iMax, iF3, iDesiredTextWidth3, iEndWidth$StepOSWidget_release);
        applyValueStacking(zShouldStack$StepOSWidget_release);
        if (zShouldStack$StepOSWidget_release) {
            iF3 = C5685n.f(iF - (z10 ? this.valueGapPx : 0), 0);
        }
        int iAuxiliaryWidth$StepOSWidget_release = listItemTextWidthPolicy.auxiliaryWidth$StepOSWidget_release(C5685n.f(iF3 - i12, 0), iDesiredTextWidth, iDesiredTextWidth2);
        if (getTitleEndView().getMaxWidth() != iAuxiliaryWidth$StepOSWidget_release) {
            getTitleEndView().setMaxWidth(iAuxiliaryWidth$StepOSWidget_release);
        }
        if (zShouldStack$StepOSWidget_release) {
            iEndWidth$StepOSWidget_release = C5685n.f(iF - i10, 0);
        }
        int i14 = iEndWidth$StepOSWidget_release;
        if (getValueView().getMaxWidth() != i14) {
            getValueView().setMaxWidth(i14);
        }
        int i15 = (!zShouldStack$StepOSWidget_release || z10) ? i11 : 0;
        updateEndMargin(getTitleView(), getTitleEndView().getVisibility() == 8 ? i15 : 0);
        updateEndMargin(getTitleEndView(), i15);
        updateEndMargin(getSubtitleView(), i15);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void reset() throws Resources.NotFoundException {
        this.switchHapticFeedbackOwner = null;
        setSwitchHapticFeedbackEnabled(false);
        setOnSwitchCheckedChangeListener(null);
        setOnCheckedChangeListener(null);
        this.onItemClickListener = null;
        setTitle((CharSequence) null);
        setTitleEndText((CharSequence) null);
        setSubtitle((CharSequence) null);
        setValueText((CharSequence) null);
        setTitleStyle(0);
        setLineMode(0);
        setAdaptiveTextLayoutEnabled(false);
        setIcon((Drawable) null);
        setShowBadge(false);
        setShowRightBadge(false);
        setTrailingView(null);
        setAccessoryIcon(com.stepos.widget.R.drawable.stepos_icon_arrow_right);
        setShowAccessory(true);
        setTrailingType(1);
        setSwitchChecked(false);
        setChecked(false);
        setEnabled(true);
        this.nextRowHidesDivider = false;
        this.pressFeedbackEnabledField = true;
        this.reservesCheckSlotField = false;
    }

    public final void setAccessoryIcon(Drawable drawable) throws Resources.NotFoundException {
        this.isDefaultAccessoryArrow = false;
        getAccessoryView().setImageDrawable(drawable);
        applyAccessorySize();
        applyTrailingType(this.trailingTypeState);
    }

    public final void setAccessorySize(int px) {
        if (px >= 0) {
            this.accessorySizeOverride = Integer.valueOf(px);
            applyAccessorySize();
        } else {
            throw new IllegalArgumentException(("accessorySize must be >= 0 but was " + px).toString());
        }
    }

    public final void setAccessorySource(Object obj) throws Resources.NotFoundException {
        setAccessorySource$default(this, obj, null, 2, null);
    }

    public final void setAccessoryTint(ColorStateList tint) {
        getAccessoryView().setImageTintList(tint);
    }

    public final void setAdaptiveTextLayoutEnabled(boolean z10) {
        if (this.isAdaptiveTextLayoutEnabled == z10) {
            return;
        }
        this.isAdaptiveTextLayoutEnabled = z10;
        requestLayout();
    }

    public final void setBadgeStyle(int i10) {
        this.badgeStyleState = i10;
        applyBadges();
    }

    public final void setBadgeTint(Integer num) {
        this.badgeTintState = num;
        applyBadges();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) throws Resources.NotFoundException {
        if (this.checkedState == checked) {
            return;
        }
        this.checkedState = checked;
        applyTrailingType(this.trailingTypeState);
        OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(this, checked);
        }
    }

    public final void setDividerColor(int color) {
        this.dividerPainter.setColor$StepOSWidget_release(color);
        invalidate();
    }

    public final void setDividerInsetStart(int insetStart) {
        StepOSDividerPainter stepOSDividerPainter = this.dividerPainter;
        if (insetStart < 0) {
            insetStart = getDividerInsetStart();
        }
        stepOSDividerPainter.setInsetStart$StepOSWidget_release(insetStart);
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        applyDisabledOpacity();
    }

    public final void setIcon(Drawable drawable) {
        getIconView().setImageDrawable(drawable);
        updateIconVisibility();
    }

    public final void setIconBackgroundColor(Integer color) {
        this.iconBackgroundColor = color;
        applyIconShape();
    }

    public final void setIconCornerRadius(float px) {
        this.iconCornerRadius = px;
        applyIconShape();
    }

    public final void setIconSize(int px) {
        setSize(getIconView(), px);
    }

    public final void setIconSource(Object obj) {
        setIconSource$default(this, obj, null, 2, null);
    }

    public final void setIconStyle(int i10) {
        this.iconStyle = i10;
        applyIconStyle(i10);
    }

    public final void setIconTint(ColorStateList tint) {
        getIconView().setImageTintList(tint);
    }

    public final void setIconVisible(boolean visible) {
        setShowIcon(visible);
    }

    public final void setLineMode(int i10) {
        this.lineModeState = i10;
        applyLineMode();
    }

    public final void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        this.onCheckedChangeListener = listener;
    }

    public final void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
        if (listener != null) {
            setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.list.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StepOSListItem.setOnItemClickListener$lambda$20(this.f31263a, view);
                }
            });
        } else {
            setOnClickListener(null);
            setClickable(false);
        }
    }

    public final void setOnSwitchCheckedChangeListener(OnSwitchCheckedChangeListener listener) {
        this.onSwitchCheckedChangeListener = listener;
    }

    public final void setPressFeedbackEnabled(boolean z10) {
        Drawable drawableB;
        if (this.pressFeedbackEnabledField == z10) {
            return;
        }
        this.pressFeedbackEnabledField = z10;
        float[] fArr = this.cardChromeRadii;
        if (fArr != null) {
            Context context = getContext();
            p.h(context, "getContext(...)");
            drawableB = StepOSListItemKt.buildCardStateBackground(context, fArr, this.cardChromeColor, z10);
        } else {
            drawableB = z10 ? C4027a.b(getContext(), com.stepos.widget.R.drawable.stepos_bg_list_item_selector) : new ColorDrawable(0);
        }
        setBackground(drawableB);
        notifyDividerStateChanged();
    }

    public final void setPressScaleEnabled(boolean enabled) {
        this.pressScaleEnabled = enabled;
        applyPressAnimation();
    }

    public final void setReservesCheckSlot(boolean z10) throws Resources.NotFoundException {
        if (this.reservesCheckSlotField == z10) {
            return;
        }
        this.reservesCheckSlotField = z10;
        applyTrailingType(this.trailingTypeState);
    }

    public final void setRightBadgeStyle(int i10) {
        this.rightBadgeStyleState = i10;
        applyBadges();
    }

    public final void setRightBadgeTint(Integer num) {
        this.rightBadgeTintState = num;
        applyBadges();
    }

    public final void setRightText(CharSequence charSequence) {
        setValueText(charSequence);
    }

    public final void setShowAccessory(boolean show) throws Resources.NotFoundException {
        this.showAccessory = show;
        applyTrailingType(this.trailingTypeState);
    }

    public final void setShowBadge(boolean z10) {
        this.showBadgeState = z10;
        applyBadges();
    }

    public final void setShowDivider(boolean z10) {
        setShowDivider$default(this, z10, 0, 0, 6, null);
    }

    public final void setShowIcon(boolean z10) {
        this.iconVisibleFlag = z10;
        updateIconVisibility();
    }

    public final void setShowRightBadge(boolean z10) {
        this.showRightBadgeState = z10;
        applyBadges();
    }

    public final void setSubtitle(CharSequence charSequence) {
        getSubtitleView().setText(charSequence);
        applyLineMode();
    }

    public final void setSwipeAppearanceActive$StepOSWidget_release(boolean active) {
        if (this.swipeAppearanceActive == active) {
            return;
        }
        this.swipeAppearanceActive = active;
        notifyDividerStateChanged();
    }

    public final void setSwitchChecked(boolean z10) {
        ensureSwitch().setChecked(z10);
    }

    public final void setSwitchHapticFeedbackEnabled(boolean z10) {
        this.isSwitchHapticFeedbackEnabled = z10;
        StepOSSwitch stepOSSwitch = this.switchView;
        if (stepOSSwitch != null) {
            stepOSSwitch.setSwitchHapticFeedbackEnabled(z10);
        }
    }

    public final void setSwitchHapticFeedbackOwner$StepOSWidget_release(Object obj) {
        this.switchHapticFeedbackOwner = obj;
    }

    public final void setTitle(CharSequence charSequence) {
        getTitleView().setText(charSequence);
    }

    public final void setTitleEndText(CharSequence charSequence) {
        getTitleEndView().setText(charSequence);
        getTitleEndView().setVisibility((charSequence == null || charSequence.length() == 0) ? 8 : 0);
    }

    public final void setTitleStyle(int i10) {
        this.titleStyleState = i10;
        applyTitleStyle();
    }

    public final void setTrailingButton(CharSequence text, View.OnClickListener listener) throws Resources.NotFoundException {
        this.pendingButtonText = text;
        TextView textViewEnsureButton = ensureButton();
        textViewEnsureButton.setText(text);
        textViewEnsureButton.setOnClickListener(listener);
        setTrailingType(3);
    }

    public final void setTrailingType(int i10) {
        this.trailingTypeState = i10;
        applyTrailingType(i10);
    }

    public final void setTrailingView(View view) {
        View view2 = this.customTrailingView;
        if (view2 != null) {
            getTrailingContainer().removeView(view2);
        }
        this.customTrailingView = view;
        if (view == null) {
            if (this.trailingTypeState == 4) {
                setTrailingType(0);
                return;
            }
            return;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            ViewGroup viewGroup2 = viewGroup != getTrailingContainer() ? viewGroup : null;
            if (viewGroup2 != null) {
                viewGroup2.removeView(view);
            }
        }
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 16));
        }
        getTrailingContainer().addView(view);
        view.setAlpha(isEnabled() ? 1.0f : 0.3f);
        view.setEnabled(isEnabled());
        setTrailingType(4);
    }

    public final void setValueText(CharSequence charSequence) {
        getValueView().setText(charSequence);
        getValueView().setVisibility((charSequence == null || charSequence.length() == 0) ? 8 : 0);
    }

    public final void syncContentAfterBridge$StepOSWidget_release() {
        applyBadges();
        applyLineMode();
        TextView valueView = getValueView();
        CharSequence valueText = getValueText();
        valueView.setVisibility((valueText == null || valueText.length() == 0) ? 8 : 0);
    }

    public final void syncIconAfterExternalDrawable$StepOSWidget_release() {
        setIconStyle(this.iconStyle);
        applyIconShape();
        updateIconVisibility();
        applyLeadingSpacing();
    }

    @Override // android.widget.Checkable
    public void toggle() throws Resources.NotFoundException {
        setChecked(!this.checkedState);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSListItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    public final void applyCardChrome(float[] radii, int i10) {
        p.i(radii, "radii");
        applyCardChrome$default(this, radii, i10, false, 0, 0, 28, null);
    }

    public final void setAccessorySource(Object source, Drawable placeholder) throws Resources.NotFoundException {
        this.isDefaultAccessoryArrow = false;
        applyAccessorySize();
        StepOSListImageLoader stepOSListImageLoader = imageLoader;
        if (stepOSListImageLoader != null) {
            stepOSListImageLoader.load(getAccessoryView(), source, placeholder);
        } else {
            getAccessoryView().setImageDrawable(placeholder);
        }
        applyTrailingType(this.trailingTypeState);
    }

    public final void setIconSource(Object source, Drawable placeholder) {
        StepOSListImageLoader stepOSListImageLoader = imageLoader;
        if (stepOSListImageLoader != null) {
            stepOSListImageLoader.load(getIconView(), source, placeholder);
        } else {
            getIconView().setImageDrawable(placeholder);
        }
        getIconView().setVisibility(this.iconVisibleFlag ? 0 : 8);
        refreshDividerInset();
    }

    public final void setRightText(int resId) {
        setValueText(getContext().getText(resId));
    }

    public final void setShowDivider(boolean z10, int i10) {
        setShowDivider$default(this, z10, i10, 0, 4, null);
    }

    public final void setTitle(int resId) {
        getTitleView().setText(resId);
    }

    public /* synthetic */ StepOSListItem(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? com.stepos.widget.R.attr.steposListItemStyle : i10);
    }

    public final void applyCardChrome(float[] radii, int i10, boolean z10) {
        p.i(radii, "radii");
        applyCardChrome$default(this, radii, i10, z10, 0, 0, 24, null);
    }

    public final void setIcon(int resId) {
        getIconView().setImageResource(resId);
        updateIconVisibility();
    }

    public final void setShowDivider(boolean show, int insetStart, int insetEnd) {
        this.showDivider = show;
        this.dividerPainter.setInsetEnd$StepOSWidget_release(insetEnd);
        StepOSDividerPainter stepOSDividerPainter = this.dividerPainter;
        if (show) {
            insetStart = getDividerInsetStart();
        }
        stepOSDividerPainter.setInsetStart$StepOSWidget_release(insetStart);
        invalidate();
    }

    public final void setSubtitle(int resId) {
        setSubtitle(getContext().getText(resId));
    }

    public final void setTitleEndText(int resId) {
        setTitleEndText(getContext().getText(resId));
    }

    public final void setValueText(int resId) {
        setValueText(getContext().getText(resId));
    }

    public final void applyCardChrome(float[] radii, int i10, boolean z10, int i11) {
        p.i(radii, "radii");
        applyCardChrome$default(this, radii, i10, z10, i11, 0, 16, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSListItem(final Context context, AttributeSet attributeSet, int i10) throws Exception {
        super(context, attributeSet, i10);
        p.i(context, "context");
        SteposListItemBinding steposListItemBindingInflate = SteposListItemBinding.inflate(LayoutInflater.from(context), this);
        p.h(steposListItemBindingInflate, "inflate(...)");
        this.binding = steposListItemBindingInflate;
        this.pressScaleEnabled = true;
        this.pressFeedbackEnabledField = true;
        this.showAccessory = true;
        this.isDefaultAccessoryArrow = true;
        this.iconVisibleFlag = true;
        this.rightBadgeStyleState = 1;
        this.horizontalValueMaxLines = 1;
        this.trailingTypeState = 1;
        this.dividerPainter = new StepOSDividerPainter();
        this.swipeOverlayPaint = C4848b.a(LazyThreadSafetyMode.NONE, new InterfaceC5063a() { // from class: com.stepos.widget.list.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StepOSListItem.swipeOverlayPaint_delegate$lambda$1(context);
            }
        });
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.stepos.widget.R.styleable.StepOSListItem, i10, com.stepos.widget.R.style.StepOSWidget_ListItem);
        try {
            p.f(typedArrayObtainStyledAttributes);
            applyListItemStyledAttributes$StepOSWidget_release$default(this, typedArrayObtainStyledAttributes, true, null, 4, null);
            t tVar = t.f7040a;
            C4946a.a(typedArrayObtainStyledAttributes, null);
            this.contentOpacityReady = true;
            applyDisabledOpacity();
        } finally {
        }
    }

    public final void applyCardChrome(float[] radii, int normalColor, boolean showDivider, int outsetTop, int outsetBottom) {
        p.i(radii, "radii");
        setPressScaleEnabled(false);
        this.cardChromeRadii = (float[]) radii.clone();
        this.cardChromeColor = normalColor;
        Context context = getContext();
        p.h(context, "getContext(...)");
        setBackground(StepOSListItemKt.buildCardStateBackground(context, radii, normalColor, this.pressFeedbackEnabledField));
        setForeground(null);
        setShowDivider$default(this, showDivider, 0, 0, 6, null);
        setPaddingRelative(getPaddingStart(), this.basePaddingVerticalPx + outsetTop, getPaddingEnd(), this.basePaddingVerticalPx + outsetBottom);
    }

    public final void setAccessoryIcon(int resId) throws Resources.NotFoundException {
        this.isDefaultAccessoryArrow = resId == com.stepos.widget.R.drawable.stepos_icon_arrow_right;
        getAccessoryView().setImageResource(resId);
        applyAccessorySize();
        applyTrailingType(this.trailingTypeState);
    }
}
