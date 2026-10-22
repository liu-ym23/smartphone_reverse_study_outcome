package com.stepos.widget.menu;

import A7.C0746n;
import Y8.t;
import Z8.C1173v;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.databinding.SteposMenuBinding;
import com.stepos.widget.databinding.SteposMenuItemBinding;
import com.stepos.widget.glass.GlassCustomizer;
import com.stepos.widget.glass.GlassDelegate;
import com.stepos.widget.glass.GlassEffectResolver;
import com.stepos.widget.glass.StepOSGlassPresets;
import f.C4027a;
import io.ktor.http.LinkHeader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import n9.C4946a;
import p9.InterfaceC5074l;
import v9.C5685n;
import y7.B;
import y7.o;

@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b)*\u0002\u0098\u0001\b\u0016\u0018\u0000 \u0085\u00022\u00020\u0001:\b\u0086\u0002\u0087\u0002\u0088\u0002\u0085\u0002B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ7\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u000eJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u000eJ\u000f\u0010\u001f\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\fH\u0002¢\u0006\u0004\b!\u0010\u000eJ\u000f\u0010\"\u001a\u00020\fH\u0002¢\u0006\u0004\b\"\u0010\u000eJ\u000f\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b#\u0010\u000eJ\u000f\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010\u000eJ?\u0010&\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0017H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\fH\u0002¢\u0006\u0004\b(\u0010\u000eJ\u001f\u0010,\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J)\u00101\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00172\b\b\u0001\u00100\u001a\u00020\u0006H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u00104J\u0019\u00106\u001a\u00020\u00062\b\b\u0001\u00105\u001a\u00020\u0006H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00109\u001a\u000208H\u0002¢\u0006\u0004\b9\u0010:J\u001f\u0010<\u001a\u00020\f2\u0006\u0010;\u001a\u0002082\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\fH\u0002¢\u0006\u0004\b>\u0010\u000eJ\u0015\u0010A\u001a\u00020\f2\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BJ\r\u0010C\u001a\u00020\f¢\u0006\u0004\bC\u0010\u000eJ\u0017\u0010E\u001a\u00020\f2\b\b\u0001\u0010D\u001a\u00020\u0006¢\u0006\u0004\bE\u0010FJ\u001d\u0010I\u001a\u00020\f2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020*0GH\u0007¢\u0006\u0004\bI\u0010JJ\u0017\u0010M\u001a\u00020\f2\b\u0010L\u001a\u0004\u0018\u00010K¢\u0006\u0004\bM\u0010NJ\u0017\u0010P\u001a\u00020\f2\b\u0010L\u001a\u0004\u0018\u00010O¢\u0006\u0004\bP\u0010QJ\u001f\u0010S\u001a\u00020\f2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u0017H\u0007¢\u0006\u0004\bS\u0010TJ\u0015\u0010U\u001a\u00020\u00172\u0006\u0010D\u001a\u00020\u0006¢\u0006\u0004\bU\u0010VJ\u0017\u0010X\u001a\u00020\f2\b\u0010L\u001a\u0004\u0018\u00010W¢\u0006\u0004\bX\u0010YJ\u0017\u0010%\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b%\u0010\u001cJ/\u0010Z\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0007¢\u0006\u0004\bZ\u0010[J\u0017\u0010\\\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\\\u0010\u001cJ/\u0010\\\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\\\u0010[J\u000f\u0010]\u001a\u00020\fH\u0007¢\u0006\u0004\b]\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010^R\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010f\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010m\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010lR\u0016\u0010n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010lR\u0016\u0010o\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010lR\u0016\u0010p\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010s\u001a\u00020r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010v\u001a\u00020u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010x\u001a\u00020r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010tR$\u0010H\u001a\u0012\u0012\u0004\u0012\u00020*0yj\b\u0012\u0004\u0012\u00020*`z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010{R$\u0010~\u001a\u0012\u0012\u0004\u0012\u00020\u00060|j\b\u0012\u0004\u0012\u00020\u0006`}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001b\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0085\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010lR\u0018\u0010\u0086\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010lR\u0018\u0010\u0087\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010lR\u0018\u0010\u0088\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010qR\u001b\u0010\u0089\u0001\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001b\u0010\u008d\u0001\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0018\u0010\u0090\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001c\u0010\u0093\u0001\u001a\u00070\u0092\u0001R\u00020\u00008\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0018\u0010\u0099\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0016\u0010\u009b\u0001\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010lR1\u0010\u009d\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u009d\u0001\u0010l\u001a\u0005\b\u009e\u0001\u00104\"\u0005\b\u009f\u0001\u0010FR1\u0010 \u0001\u001a\u00020\u00062\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0015\n\u0005\b \u0001\u0010l\u001a\u0005\b¡\u0001\u00104\"\u0005\b¢\u0001\u0010FR1\u0010£\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0015\n\u0005\b£\u0001\u0010l\u001a\u0005\b¤\u0001\u00104\"\u0005\b¥\u0001\u0010FR8\u0010§\u0001\u001a\u0005\u0018\u00010¦\u00012\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010¦\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R1\u0010\u00ad\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u00ad\u0001\u0010l\u001a\u0005\b®\u0001\u00104\"\u0005\b¯\u0001\u0010FR1\u0010°\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0015\n\u0005\b°\u0001\u0010l\u001a\u0005\b±\u0001\u00104\"\u0005\b²\u0001\u0010FR4\u0010´\u0001\u001a\u00030³\u00012\b\u0010\u009c\u0001\u001a\u00030³\u00018G@FX\u0086\u000e¢\u0006\u0018\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R'\u0010º\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bº\u0001\u0010q\u001a\u0005\bº\u0001\u0010 \"\u0006\b»\u0001\u0010¼\u0001R0\u0010½\u0001\u001a\u00020\u00172\u0007\u0010\u009c\u0001\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0005\b½\u0001\u0010q\u001a\u0005\b½\u0001\u0010 \"\u0006\b¾\u0001\u0010¼\u0001R\u001b\u0010¿\u0001\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R0\u0010Á\u0001\u001a\u00020\u00172\u0007\u0010\u009c\u0001\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0005\bÁ\u0001\u0010q\u001a\u0005\bÁ\u0001\u0010 \"\u0006\bÂ\u0001\u0010¼\u0001R0\u0010Ã\u0001\u001a\u00020\u00172\u0007\u0010\u009c\u0001\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0005\bÃ\u0001\u0010q\u001a\u0005\bÃ\u0001\u0010 \"\u0006\bÄ\u0001\u0010¼\u0001R/\u0010Å\u0001\u001a\u00020\u00062\u0007\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0015\n\u0005\bÅ\u0001\u0010l\u001a\u0005\bÆ\u0001\u00104\"\u0005\bÇ\u0001\u0010FR1\u0010È\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0015\n\u0005\bÈ\u0001\u0010l\u001a\u0005\bÉ\u0001\u00104\"\u0005\bÊ\u0001\u0010FR1\u0010Ë\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0015\n\u0005\bË\u0001\u0010l\u001a\u0005\bÌ\u0001\u00104\"\u0005\bÍ\u0001\u0010FR/\u0010Î\u0001\u001a\u00020\u00062\u0007\u0010\u009c\u0001\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\bÎ\u0001\u0010l\u001a\u0005\bÏ\u0001\u00104\"\u0005\bÐ\u0001\u0010FR0\u0010Ñ\u0001\u001a\u00020\u00172\u0007\u0010\u009c\u0001\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0005\bÑ\u0001\u0010q\u001a\u0005\bÑ\u0001\u0010 \"\u0006\bÒ\u0001\u0010¼\u0001R8\u0010Ô\u0001\u001a\u0005\u0018\u00010Ó\u00012\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010Ó\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\bÔ\u0001\u0010Õ\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001R*\u0010Ü\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÚ\u0001\u00104\"\u0005\bÛ\u0001\u0010FR*\u0010ß\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÝ\u0001\u00104\"\u0005\bÞ\u0001\u0010FR0\u0010å\u0001\u001a\u0005\u0018\u00010à\u00012\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010à\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bá\u0001\u0010â\u0001\"\u0006\bã\u0001\u0010ä\u0001R0\u0010è\u0001\u001a\u0005\u0018\u00010à\u00012\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010à\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bæ\u0001\u0010â\u0001\"\u0006\bç\u0001\u0010ä\u0001R*\u0010ë\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bé\u0001\u00104\"\u0005\bê\u0001\u0010FR0\u0010î\u0001\u001a\u0005\u0018\u00010à\u00012\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010à\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bì\u0001\u0010â\u0001\"\u0006\bí\u0001\u0010ä\u0001R0\u0010ñ\u0001\u001a\u0005\u0018\u00010à\u00012\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010à\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bï\u0001\u0010â\u0001\"\u0006\bð\u0001\u0010ä\u0001R*\u0010ô\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bò\u0001\u00104\"\u0005\bó\u0001\u0010FR*\u0010÷\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bõ\u0001\u00104\"\u0005\bö\u0001\u0010FR*\u0010ú\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bø\u0001\u00104\"\u0005\bù\u0001\u0010FR*\u0010ý\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bû\u0001\u00104\"\u0005\bü\u0001\u0010FR,\u0010\u0080\u0002\u001a\u00030³\u00012\b\u0010\u009c\u0001\u001a\u00030³\u00018G@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bþ\u0001\u0010·\u0001\"\u0006\bÿ\u0001\u0010¹\u0001R*\u0010\u0083\u0002\u001a\u00020\u00062\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0081\u0002\u00104\"\u0005\b\u0082\u0002\u0010FR\u0013\u0010\u0084\u0002\u001a\u00020\u00178F¢\u0006\u0007\u001a\u0005\b\u0084\u0002\u0010 ¨\u0006\u0089\u0002"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenu;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;I)V", "LY8/t;", "refreshAdapter", "()V", "refreshItemAppearance", "applyListPadding", "invalidateDivider", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "xoff", "yoff", "gravity", "", "overlap", "showInternal", "(Landroid/view/View;IIIZ)V", "bindAnchor", "(Landroid/view/View;)V", "unbindAnchor", "applyMenuGlass", "hasRealGlass", "()Z", "invalidateMenuGlass", "requestMenuGlass", "applySolidBackground", "showSolidBackground", "show", "layoutPopup", "(Landroid/view/View;IIIZZ)V", "relayoutShowingPopup", "position", "Lcom/stepos/widget/menu/StepOSMenuItem;", "item", "handleItemActivate", "(ILcom/stepos/widget/menu/StepOSMenuItem;)V", "width", "shrinkToFit", "windowHeight", "applyListSize", "(IZI)V", "measureContentWidth", "()I", "widthPx", "measureContentHeight", "(I)I", "Lcom/stepos/widget/databinding/SteposMenuItemBinding;", "inflateProbe", "()Lcom/stepos/widget/databinding/SteposMenuItemBinding;", "probe", "bindProbe", "(Lcom/stepos/widget/databinding/SteposMenuItemBinding;Lcom/stepos/widget/menu/StepOSMenuItem;)V", "updateScrollbar", "Lcom/stepos/widget/glass/GlassCustomizer;", "customizer", "applyCustomGlass", "(Lcom/stepos/widget/glass/GlassCustomizer;)V", "clearCustomGlass", "id", "setBackgroundResource", "(I)V", "", DidiCardProvider.KEY_ITEMS, "setItems", "(Ljava/util/List;)V", "Lcom/stepos/widget/menu/StepOSMenu$OnItemClickListener;", "listener", "setOnItemClickListener", "(Lcom/stepos/widget/menu/StepOSMenu$OnItemClickListener;)V", "Lcom/stepos/widget/menu/StepOSMenu$OnItemCheckedChangeListener;", "setOnItemCheckedChangeListener", "(Lcom/stepos/widget/menu/StepOSMenu$OnItemCheckedChangeListener;)V", "checked", "setItemChecked", "(IZ)V", "isItemChecked", "(I)Z", "Landroid/widget/PopupWindow$OnDismissListener;", "setOnDismissListener", "(Landroid/widget/PopupWindow$OnDismissListener;)V", "showAsDropDown", "(Landroid/view/View;III)V", "showOverlapping", DidiCardProvider.ACTION_DISMISS, "Landroid/content/Context;", "Lcom/stepos/widget/databinding/SteposMenuBinding;", "binding", "Lcom/stepos/widget/databinding/SteposMenuBinding;", "Lcom/stepos/widget/menu/StepOSMenuPanel;", "panel", "Lcom/stepos/widget/menu/StepOSMenuPanel;", "Lcom/stepos/widget/glass/GlassDelegate;", "glassDelegate", "Lcom/stepos/widget/glass/GlassDelegate;", "Lcom/stepos/widget/menu/StepOSMenuStyle;", "itemStyle", "Lcom/stepos/widget/menu/StepOSMenuStyle;", "appliedGlassWidth", "I", "appliedGlassHeight", "glassEpoch", "appliedGlassEpoch", "glassRefreshPosted", "Z", "", "lastMenuGlassCommitUptimeMs", "J", "Ljava/lang/Runnable;", "applyMenuGlassRunnable", "Ljava/lang/Runnable;", "lastDismissUptimeMs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "expandedIndexes", "Ljava/util/HashSet;", "lastAnchor", "Landroid/view/View;", "Landroid/view/View$OnAttachStateChangeListener;", "anchorDetachListener", "Landroid/view/View$OnAttachStateChangeListener;", "lastXoff", "lastYoff", "lastGravity", "lastOverlap", "onDismissListener", "Landroid/widget/PopupWindow$OnDismissListener;", "onItemClickListener", "Lcom/stepos/widget/menu/StepOSMenu$OnItemClickListener;", "onItemCheckedChangeListener", "Lcom/stepos/widget/menu/StepOSMenu$OnItemCheckedChangeListener;", "Lcom/stepos/widget/menu/StepOSMenuAdapter;", "adapter", "Lcom/stepos/widget/menu/StepOSMenuAdapter;", "Lcom/stepos/widget/menu/StepOSMenu$MenuDividerDecoration;", "dividerDecoration", "Lcom/stepos/widget/menu/StepOSMenu$MenuDividerDecoration;", "Landroid/widget/PopupWindow;", "popup", "Landroid/widget/PopupWindow;", "com/stepos/widget/menu/StepOSMenu$scrollbarScrollListener$1", "scrollbarScrollListener", "Lcom/stepos/widget/menu/StepOSMenu$scrollbarScrollListener$1;", "scrollbarInsetVertical", UxipConstants.f30680s, "menuMinWidth", "getMenuMinWidth", "setMenuMinWidth", "menuMaxWidth", "getMenuMaxWidth", "setMenuMaxWidth", "menuMaxHeight", "getMenuMaxHeight", "setMenuMaxHeight", "Landroid/graphics/drawable/Drawable;", "background", "Landroid/graphics/drawable/Drawable;", "getBackground", "()Landroid/graphics/drawable/Drawable;", "setBackground", "(Landroid/graphics/drawable/Drawable;)V", "elevation", "getElevation", "setElevation", "paddingVertical", "getPaddingVertical", "setPaddingVertical", "", "cornerRadius", "F", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "isDismissOnItemClick", "setDismissOnItemClick", "(Z)V", "isDismissOnOutsideTouch", "setDismissOnOutsideTouch", "glassCustomizer", "Lcom/stepos/widget/glass/GlassCustomizer;", "isCheckBoxVisible", "setCheckBoxVisible", "isDividerVisible", "setDividerVisible", "dividerColor", "getDividerColor", "setDividerColor", "dividerHeight", "getDividerHeight", "setDividerHeight", "dividerInsetHorizontal", "getDividerInsetHorizontal", "setDividerInsetHorizontal", "selectedItemId", "getSelectedItemId", "setSelectedItemId", "isGlassEnabled", "setGlassEnabled", "Ly7/o;", "glassEffect", "Ly7/o;", "getGlassEffect", "()Ly7/o;", "setGlassEffect", "(Ly7/o;)V", "getItemTextAppearance", "setItemTextAppearance", "itemTextAppearance", "getItemSubtitleTextAppearance", "setItemSubtitleTextAppearance", "itemSubtitleTextAppearance", "Landroid/content/res/ColorStateList;", "getItemTextColor", "()Landroid/content/res/ColorStateList;", "setItemTextColor", "(Landroid/content/res/ColorStateList;)V", "itemTextColor", "getItemSubtitleTextColor", "setItemSubtitleTextColor", "itemSubtitleTextColor", "getItemWarningTextColor", "setItemWarningTextColor", "itemWarningTextColor", "getItemIconTint", "setItemIconTint", "itemIconTint", "getItemOverlayColor", "setItemOverlayColor", "itemOverlayColor", "getItemMinHeight", "setItemMinHeight", "itemMinHeight", "getItemPaddingHorizontal", "setItemPaddingHorizontal", "itemPaddingHorizontal", "getItemPaddingVertical", "setItemPaddingVertical", "itemPaddingVertical", "getItemIconSize", "setItemIconSize", "itemIconSize", "getItemOverlayRadius", "setItemOverlayRadius", "itemOverlayRadius", "getItemOverlayInsetHorizontal", "setItemOverlayInsetHorizontal", "itemOverlayInsetHorizontal", "isShowing", "Companion", "OnItemClickListener", "OnItemCheckedChangeListener", "MenuDividerDecoration", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSMenu {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final long GLASS_REBUILD_MIN_INTERVAL_MS = 100;
    private static final long IGNORE_REOPEN_MS = 300;
    private static final float MENU_BLUR_FROST_MAX = 0.3f;
    public static final int NO_ID = -1;
    private static final Field materialPendingField;
    private final StepOSMenuAdapter adapter;
    private final View.OnAttachStateChangeListener anchorDetachListener;
    private int appliedGlassEpoch;
    private int appliedGlassHeight;
    private int appliedGlassWidth;
    private final Runnable applyMenuGlassRunnable;
    private Drawable background;
    private final SteposMenuBinding binding;
    private final Context context;
    private float cornerRadius;
    private int dividerColor;
    private final MenuDividerDecoration dividerDecoration;
    private int dividerHeight;
    private int dividerInsetHorizontal;
    private int elevation;
    private final HashSet<Integer> expandedIndexes;
    private GlassCustomizer glassCustomizer;
    private final GlassDelegate glassDelegate;
    private o glassEffect;
    private int glassEpoch;
    private boolean glassRefreshPosted;
    private boolean isCheckBoxVisible;
    private boolean isDismissOnItemClick;
    private boolean isDismissOnOutsideTouch;
    private boolean isDividerVisible;
    private boolean isGlassEnabled;
    private final StepOSMenuStyle itemStyle;
    private final ArrayList<StepOSMenuItem> items;
    private View lastAnchor;
    private long lastDismissUptimeMs;
    private int lastGravity;
    private long lastMenuGlassCommitUptimeMs;
    private boolean lastOverlap;
    private int lastXoff;
    private int lastYoff;
    private int menuMaxHeight;
    private int menuMaxWidth;
    private int menuMinWidth;
    private PopupWindow.OnDismissListener onDismissListener;
    private OnItemCheckedChangeListener onItemCheckedChangeListener;
    private OnItemClickListener onItemClickListener;
    private int paddingVertical;
    private final StepOSMenuPanel panel;
    private final PopupWindow popup;
    private final int scrollbarInsetVertical;
    private final StepOSMenu$scrollbarScrollListener$1 scrollbarScrollListener;
    private int selectedItemId;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenu$Companion;", "", "<init>", "()V", "Ly7/B;", "builder", "LY8/t;", "clampMenuBlurFrost", "(Ly7/B;)V", "", "NO_ID", "I", "", "IGNORE_REOPEN_MS", "J", "GLASS_REBUILD_MIN_INTERVAL_MS", "", "MENU_BLUR_FROST_MAX", "F", "Ljava/lang/reflect/Field;", "materialPendingField", "Ljava/lang/reflect/Field;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void clampMenuBlurFrost(B builder) {
            Object objB;
            Field field = StepOSMenu.materialPendingField;
            Object obj = field != null ? field.get(builder) : null;
            List list = obj instanceof List ? (List) obj : null;
            if (list == null) {
                return;
            }
            for (Object obj2 : list) {
                if (obj2 != null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objB = Result.b(obj2.getClass().getMethod("getParams", null).invoke(obj2, null));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objB = Result.b(C4849c.a(th));
                    }
                    if (Result.g(objB)) {
                        objB = null;
                    }
                    if (objB != null && (objB instanceof C0746n)) {
                        C0746n c0746n = (C0746n) objB;
                        float frost = c0746n.getFrost();
                        float fM = 0.0f;
                        if (!Float.isInfinite(frost) && !Float.isNaN(frost)) {
                            fM = C5685n.m(frost, 0.0f, 0.3f);
                        }
                        c0746n.l(fM);
                    }
                }
            }
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenu$MenuDividerDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "(Lcom/stepos/widget/menu/StepOSMenu;)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/graphics/Paint;", "dividerPaint", "Landroid/graphics/Paint;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class MenuDividerDecoration extends RecyclerView.ItemDecoration {
        private final Paint dividerPaint;

        public MenuDividerDecoration() {
            Paint paint = new Paint();
            paint.setAntiAlias(false);
            this.dividerPaint = paint;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            p.i(outRect, "outRect");
            p.i(view, "view");
            p.i(parent, "parent");
            p.i(state, "state");
            outRect.set(0, 0, 0, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
            int itemCount;
            Canvas canvas2;
            View viewFindViewByPosition;
            p.i(canvas, "canvas");
            p.i(parent, "parent");
            p.i(state, "state");
            if (!StepOSMenu.this.getIsDividerVisible() || StepOSMenu.this.getDividerHeight() <= 0) {
                return;
            }
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager == null || (itemCount = linearLayoutManager.getItemCount()) <= 1) {
                return;
            }
            Paint paint = this.dividerPaint;
            paint.setColor(StepOSMenu.this.getDividerColor());
            int dividerInsetHorizontal = StepOSMenu.this.getDividerInsetHorizontal();
            int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            if (iFindLastVisibleItemPosition == -1 || iFindFirstVisibleItemPosition == -1 || iFindFirstVisibleItemPosition > iFindLastVisibleItemPosition) {
                return;
            }
            int i10 = iFindFirstVisibleItemPosition;
            while (true) {
                if (i10 == itemCount - 1 || (viewFindViewByPosition = linearLayoutManager.findViewByPosition(i10)) == null) {
                    canvas2 = canvas;
                } else {
                    float bottom = viewFindViewByPosition.getBottom();
                    paint.setColor(StepOSMenu.this.getDividerColor());
                    canvas2 = canvas;
                    canvas2.drawRect(dividerInsetHorizontal, bottom, parent.getWidth() - dividerInsetHorizontal, bottom + StepOSMenu.this.getDividerHeight(), paint);
                }
                if (i10 == iFindLastVisibleItemPosition) {
                    return;
                }
                i10++;
                canvas = canvas2;
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenu$OnItemCheckedChangeListener;", "", "", "position", "Lcom/stepos/widget/menu/StepOSMenuItem;", "item", "", "isChecked", "LY8/t;", "onItemCheckedChanged", "(ILcom/stepos/widget/menu/StepOSMenuItem;Z)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnItemCheckedChangeListener {
        void onItemCheckedChanged(int position, StepOSMenuItem item, boolean isChecked);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenu$OnItemClickListener;", "", "", "position", "Lcom/stepos/widget/menu/StepOSMenuItem;", "item", "LY8/t;", "onItemClick", "(ILcom/stepos/widget/menu/StepOSMenuItem;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnItemClickListener {
        void onItemClick(int position, StepOSMenuItem item);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Field field = null;
        try {
            Field declaredField = B.class.getDeclaredField(Const.INTENT_KEY_PKGNAME);
            declaredField.setAccessible(true);
            field = declaredField;
        } catch (ReflectiveOperationException e10) {
            Log.w("StepOSMenu", "MaterialBuilder.pending missing; frost clamp disabled", e10);
        }
        materialPendingField = field;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenu(Context context) {
        this(context, null, 0, 0, 14, null);
        p.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$28(StepOSMenu stepOSMenu, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (stepOSMenu.panel.isAttachedToWindow()) {
            stepOSMenu.requestMenuGlass();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$29(StepOSMenu stepOSMenu) {
        stepOSMenu.unbindAnchor();
        PopupWindow.OnDismissListener onDismissListener = stepOSMenu.onDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public static void a(StepOSMenu stepOSMenu, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        stepOSMenu.updateScrollbar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t adapter$lambda$1(StepOSMenu stepOSMenu, int i10, StepOSMenuItem item) {
        p.i(item, "item");
        stepOSMenu.handleItemActivate(i10, item);
        return t.f7040a;
    }

    private final void applyListPadding() {
        RecyclerView recyclerView = this.binding.steposMenuRecycler;
        int i10 = this.paddingVertical;
        recyclerView.setPaddingRelative(0, i10, 0, i10);
    }

    private final void applyListSize(int width, boolean shrinkToFit, int windowHeight) {
        if (shrinkToFit) {
            windowHeight = -1;
        }
        FrameLayout frameLayout = this.binding.steposMenuListContainer;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.height = windowHeight;
        frameLayout.setLayoutParams(layoutParams);
        RecyclerView recyclerView = this.binding.steposMenuRecycler;
        ViewGroup.LayoutParams layoutParams2 = recyclerView.getLayoutParams();
        layoutParams2.height = windowHeight;
        recyclerView.setLayoutParams(layoutParams2);
        recyclerView.setNestedScrollingEnabled(shrinkToFit);
        ViewGroup.LayoutParams layoutParams3 = this.panel.getLayoutParams();
        layoutParams3.width = width;
        layoutParams3.height = windowHeight;
        this.panel.setLayoutParams(layoutParams3);
        if (shrinkToFit) {
            return;
        }
        this.binding.steposMenuScrollbar.setVisibility(8);
    }

    private final void applyMenuGlass() throws Resources.NotFoundException {
        int width = this.panel.getWidth();
        int height = this.panel.getHeight();
        if (!this.isGlassEnabled || width <= 0 || height <= 0) {
            applySolidBackground();
            return;
        }
        if (this.appliedGlassWidth == width && this.appliedGlassHeight == height && this.appliedGlassEpoch == this.glassEpoch) {
            return;
        }
        if (!hasRealGlass()) {
            this.panel.setBackground(null);
        }
        final GlassCustomizer glassCustomizer = this.glassCustomizer;
        if (glassCustomizer != null) {
            this.glassDelegate.applyCustom$StepOSWidget_release(1, this.cornerRadius, new InterfaceC5074l() { // from class: com.stepos.widget.menu.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return StepOSMenu.applyMenuGlass$lambda$31(glassCustomizer, (B) obj);
                }
            });
        } else {
            boolean z10 = this.context.getResources().getBoolean(R.bool.stepos_menu_glass_light);
            o oVar = this.glassEffect;
            if (oVar != null) {
                this.glassDelegate.apply$StepOSWidget_release(1, this.cornerRadius, oVar);
            } else {
                final GlassCustomizer glassCustomizerMENU_LIGHT_TUNED = z10 ? StepOSGlassPresets.INSTANCE.MENU_LIGHT_TUNED(this.context.getResources().getDisplayMetrics().density) : StepOSGlassPresets.INSTANCE.MENU_DARK_TUNED(this.context.getResources().getDisplayMetrics().density);
                this.glassDelegate.applyCustom$StepOSWidget_release(1, this.cornerRadius, new InterfaceC5074l() { // from class: com.stepos.widget.menu.g
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return StepOSMenu.applyMenuGlass$lambda$32(glassCustomizerMENU_LIGHT_TUNED, (B) obj);
                    }
                });
            }
        }
        this.lastMenuGlassCommitUptimeMs = SystemClock.uptimeMillis();
        this.appliedGlassWidth = width;
        this.appliedGlassHeight = height;
        this.appliedGlassEpoch = this.glassEpoch;
        if (hasRealGlass()) {
            return;
        }
        showSolidBackground();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final B applyMenuGlass$lambda$31(GlassCustomizer glassCustomizer, B builder) {
        p.i(builder, "builder");
        glassCustomizer.customize(builder);
        INSTANCE.clampMenuBlurFrost(builder);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final B applyMenuGlass$lambda$32(GlassCustomizer glassCustomizer, B builder) {
        p.i(builder, "builder");
        glassCustomizer.customize(builder);
        INSTANCE.clampMenuBlurFrost(builder);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyMenuGlassRunnable$lambda$0(StepOSMenu stepOSMenu) throws Resources.NotFoundException {
        stepOSMenu.glassRefreshPosted = false;
        if (stepOSMenu.panel.isAttachedToWindow()) {
            stepOSMenu.applyMenuGlass();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applySolidBackground() {
        this.panel.removeCallbacks(this.applyMenuGlassRunnable);
        this.glassRefreshPosted = false;
        this.lastMenuGlassCommitUptimeMs = 0L;
        this.appliedGlassWidth = 0;
        this.appliedGlassHeight = 0;
        this.appliedGlassEpoch = 0;
        showSolidBackground();
    }

    private final void bindAnchor(View anchor) {
        if (this.lastAnchor == anchor) {
            return;
        }
        unbindAnchor();
        this.lastAnchor = anchor;
        anchor.addOnAttachStateChangeListener(this.anchorDetachListener);
    }

    private final void bindProbe(SteposMenuItemBinding probe, StepOSMenuItem item) {
        int id = item.getId();
        int i10 = this.selectedItemId;
        boolean z10 = id == i10 && i10 != -1;
        boolean z11 = (z10 && !StepOSMenuAdapterKt.isMenuItemCheckable(item, this.isCheckBoxVisible)) || item.getTextStyle() == 1;
        boolean zIsMenuItemExpanded = StepOSMenuAdapterKt.isMenuItemExpanded(item, this.items, this.expandedIndexes);
        StepOSMenuAdapterKt.applyMenuItemStyle(probe, this.itemStyle);
        StepOSMenuAdapterKt.bindMenuItemText(probe, item, z11, zIsMenuItemExpanded, this.itemStyle);
        ImageView steposMenuItemIcon = probe.steposMenuItemIcon;
        p.h(steposMenuItemIcon, "steposMenuItemIcon");
        StepOSMenuAdapterKt.bindMenuItemIcon(steposMenuItemIcon, item);
        StepOSMenuAdapterKt.bindMenuItemAccessories(probe, item, z10, this.isCheckBoxVisible, zIsMenuItemExpanded);
        ViewGroup.LayoutParams layoutParams = probe.steposMenuItemTitle.getLayoutParams();
        p.g(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.width = -2;
        layoutParams2.weight = 0.0f;
        probe.steposMenuItemTitle.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = probe.steposMenuItemText.getLayoutParams();
        p.g(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
        layoutParams4.width = -2;
        layoutParams4.weight = 0.0f;
        probe.steposMenuItemText.setLayoutParams(layoutParams4);
    }

    private final void handleItemActivate(int position, StepOSMenuItem item) {
        int iIndexOf = this.items.indexOf(item);
        if (item.getIsExpandable() && iIndexOf >= 0) {
            if (!this.expandedIndexes.add(Integer.valueOf(iIndexOf))) {
                this.expandedIndexes.remove(Integer.valueOf(iIndexOf));
            }
            refreshAdapter();
            relayoutShowingPopup();
        }
        if (StepOSMenuAdapterKt.isMenuItemCheckable(item, this.isCheckBoxVisible)) {
            boolean z10 = this.selectedItemId != item.getId();
            setSelectedItemId(z10 ? item.getId() : -1);
            OnItemCheckedChangeListener onItemCheckedChangeListener = this.onItemCheckedChangeListener;
            if (onItemCheckedChangeListener != null) {
                onItemCheckedChangeListener.onItemCheckedChanged(position, item, z10);
            }
        }
        OnItemClickListener onItemClickListener = this.onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(position, item);
        }
        if (!this.isDismissOnItemClick || item.getIsExpandable()) {
            return;
        }
        dismiss();
    }

    private final boolean hasRealGlass() {
        return this.glassDelegate.getHasRealGlass$StepOSWidget_release();
    }

    private final SteposMenuItemBinding inflateProbe() {
        SteposMenuItemBinding steposMenuItemBindingInflate = SteposMenuItemBinding.inflate(LayoutInflater.from(this.context), new FrameLayout(this.context), false);
        p.h(steposMenuItemBindingInflate, "inflate(...)");
        return steposMenuItemBindingInflate;
    }

    private final void invalidateDivider() {
        this.binding.steposMenuRecycler.invalidate();
        if (isShowing()) {
            relayoutShowingPopup();
        }
    }

    private final void invalidateMenuGlass() {
        this.glassEpoch++;
        if (this.panel.isAttachedToWindow()) {
            requestMenuGlass();
        }
    }

    private final void layoutPopup(View anchor, int xoff, int yoff, int gravity, boolean overlap, boolean show) {
        int iMeasureContentWidth = measureContentWidth();
        Rect rect = new Rect();
        anchor.getWindowVisibleDisplayFrame(rect);
        StepOSMenuPopupLayout stepOSMenuPopupLayout = StepOSMenuPopupLayout.INSTANCE;
        StepOSMenuPopupSize stepOSMenuPopupSizeResolvePopupSize$StepOSWidget_release = stepOSMenuPopupLayout.resolvePopupSize$StepOSWidget_release(measureContentHeight(iMeasureContentWidth), this.menuMaxHeight, rect.height());
        applyListSize(iMeasureContentWidth, stepOSMenuPopupSizeResolvePopupSize$StepOSWidget_release.getShrinkToFit(), stepOSMenuPopupSizeResolvePopupSize$StepOSWidget_release.getWindowHeight());
        this.popup.setWidth(iMeasureContentWidth);
        this.popup.setHeight(stepOSMenuPopupSizeResolvePopupSize$StepOSWidget_release.getWindowHeight());
        this.popup.setClippingEnabled(stepOSMenuPopupSizeResolvePopupSize$StepOSWidget_release.getShrinkToFit());
        this.popup.setIsLaidOutInScreen(true);
        this.popup.setIsClippedToScreen(stepOSMenuPopupSizeResolvePopupSize$StepOSWidget_release.getShrinkToFit());
        int height = overlap ? yoff - anchor.getHeight() : yoff;
        if (!stepOSMenuPopupSizeResolvePopupSize$StepOSWidget_release.getShrinkToFit()) {
            int[] iArr = new int[2];
            anchor.getLocationOnScreen(iArr);
            height += overlap ? stepOSMenuPopupLayout.extraOverlapYOffToKeepFullHeight$StepOSWidget_release(rect.top, rect.bottom, iArr[1], anchor.getHeight(), stepOSMenuPopupSizeResolvePopupSize$StepOSWidget_release.getWindowHeight(), yoff) : stepOSMenuPopupLayout.extraDropDownYOffToKeepFullHeight$StepOSWidget_release(rect.top, rect.bottom, iArr[1], anchor.getHeight(), stepOSMenuPopupSizeResolvePopupSize$StepOSWidget_release.getWindowHeight(), yoff);
        }
        int i10 = height;
        if (show) {
            androidx.core.widget.g.c(this.popup, anchor, xoff, i10, gravity);
        } else {
            this.popup.update(anchor, xoff, i10, iMeasureContentWidth, stepOSMenuPopupSizeResolvePopupSize$StepOSWidget_release.getWindowHeight());
        }
        this.binding.steposMenuRecycler.post(new Runnable() { // from class: com.stepos.widget.menu.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f31277a.updateScrollbar();
            }
        });
    }

    private final int measureContentHeight(int widthPx) {
        int i10 = this.paddingVertical;
        if (this.items.isEmpty()) {
            return i10 * 2;
        }
        SteposMenuItemBinding steposMenuItemBindingInflateProbe = inflateProbe();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(widthPx, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int measuredHeight = i10 * 2;
        Iterator<StepOSMenuItem> it = StepOSMenuAdapterKt.flattenVisibleMenuItems(this.items, this.expandedIndexes).iterator();
        while (it.hasNext()) {
            bindProbe(steposMenuItemBindingInflateProbe, it.next());
            steposMenuItemBindingInflateProbe.getRoot().measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            measuredHeight += steposMenuItemBindingInflateProbe.getRoot().getMeasuredHeight();
        }
        return measuredHeight;
    }

    private final int measureContentWidth() {
        int iMin = Math.min(this.menuMinWidth, this.menuMaxWidth);
        int iMax = Math.max(this.menuMinWidth, this.menuMaxWidth);
        if (this.items.isEmpty()) {
            return iMin;
        }
        SteposMenuItemBinding steposMenuItemBindingInflateProbe = inflateProbe();
        int measuredWidth = 0;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        Iterator<StepOSMenuItem> it = StepOSMenuAdapterKt.flattenVisibleMenuItems(this.items, this.expandedIndexes).iterator();
        while (it.hasNext()) {
            bindProbe(steposMenuItemBindingInflateProbe, it.next());
            steposMenuItemBindingInflateProbe.getRoot().measure(iMakeMeasureSpec, iMakeMeasureSpec);
            if (steposMenuItemBindingInflateProbe.getRoot().getMeasuredWidth() > measuredWidth) {
                measuredWidth = steposMenuItemBindingInflateProbe.getRoot().getMeasuredWidth();
            }
        }
        return C5685n.n(measuredWidth, iMin, iMax);
    }

    private final void refreshAdapter() {
        this.adapter.submit(this.items, this.selectedItemId, this.isCheckBoxVisible, this.expandedIndexes);
    }

    private final void refreshItemAppearance() {
        refreshAdapter();
        if (isShowing()) {
            relayoutShowingPopup();
        }
    }

    private final void relayoutShowingPopup() {
        View view = this.lastAnchor;
        if (view != null && this.popup.isShowing()) {
            layoutPopup(view, this.lastXoff, this.lastYoff, this.lastGravity, this.lastOverlap, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestMenuGlass() {
        if (!this.panel.isAttachedToWindow() || this.glassRefreshPosted) {
            return;
        }
        this.glassRefreshPosted = true;
        this.panel.postDelayed(this.applyMenuGlassRunnable, C5685n.g(100 - (SystemClock.uptimeMillis() - this.lastMenuGlassCommitUptimeMs), 0L));
    }

    private final void showInternal(View anchor, int xoff, int yoff, int gravity, boolean overlap) {
        if (SystemClock.uptimeMillis() - this.lastDismissUptimeMs < 300) {
            return;
        }
        bindAnchor(anchor);
        this.lastXoff = xoff;
        this.lastYoff = yoff;
        this.lastGravity = gravity;
        this.lastOverlap = overlap;
        layoutPopup(anchor, xoff, yoff, gravity, overlap, true);
    }

    private final void showSolidBackground() {
        this.glassDelegate.release$StepOSWidget_release();
        this.panel.setBackground(this.background);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unbindAnchor() {
        View view = this.lastAnchor;
        if (view != null) {
            view.removeOnAttachStateChangeListener(this.anchorDetachListener);
        }
        this.lastAnchor = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateScrollbar() {
        RecyclerView steposMenuRecycler = this.binding.steposMenuRecycler;
        p.h(steposMenuRecycler, "steposMenuRecycler");
        View steposMenuScrollbar = this.binding.steposMenuScrollbar;
        p.h(steposMenuScrollbar, "steposMenuScrollbar");
        int iComputeVerticalScrollRange = steposMenuRecycler.computeVerticalScrollRange();
        int iComputeVerticalScrollExtent = steposMenuRecycler.computeVerticalScrollExtent();
        int iComputeVerticalScrollOffset = steposMenuRecycler.computeVerticalScrollOffset();
        int height = steposMenuRecycler.getHeight();
        if (iComputeVerticalScrollRange <= iComputeVerticalScrollExtent || iComputeVerticalScrollExtent <= 0 || steposMenuRecycler.getHeight() <= 0) {
            steposMenuScrollbar.setVisibility(8);
            return;
        }
        int iF = C5685n.f(height - (this.scrollbarInsetVertical * 2), 0);
        if (iF <= 0) {
            steposMenuScrollbar.setVisibility(8);
            return;
        }
        int iN = C5685n.n((int) ((iComputeVerticalScrollExtent / iComputeVerticalScrollRange) * iF), C5685n.f(steposMenuScrollbar.getWidth(), 1), iF);
        int iF2 = C5685n.f(iF - iN, 0);
        int i10 = iComputeVerticalScrollRange - iComputeVerticalScrollExtent;
        int i11 = this.scrollbarInsetVertical + ((i10 <= 0 || iF2 <= 0) ? 0 : (int) ((iComputeVerticalScrollOffset / i10) * iF2));
        ViewGroup.LayoutParams layoutParams = steposMenuScrollbar.getLayoutParams();
        if (layoutParams.height != iN) {
            layoutParams.height = iN;
            steposMenuScrollbar.setLayoutParams(layoutParams);
        }
        steposMenuScrollbar.setTranslationY(i11);
        steposMenuScrollbar.setVisibility(0);
    }

    public final void applyCustomGlass(GlassCustomizer customizer) {
        p.i(customizer, "customizer");
        this.glassCustomizer = customizer;
        invalidateMenuGlass();
    }

    public final void clearCustomGlass() {
        if (this.glassCustomizer == null) {
            return;
        }
        this.glassCustomizer = null;
        invalidateMenuGlass();
    }

    public final void dismiss() {
        this.popup.dismiss();
    }

    public final Drawable getBackground() {
        return this.background;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final int getDividerColor() {
        return this.dividerColor;
    }

    public final int getDividerHeight() {
        return this.dividerHeight;
    }

    public final int getDividerInsetHorizontal() {
        return this.dividerInsetHorizontal;
    }

    public final int getElevation() {
        return this.elevation;
    }

    public final o getGlassEffect() {
        return this.glassEffect;
    }

    public final int getItemIconSize() {
        return this.itemStyle.getItemIconSize();
    }

    public final ColorStateList getItemIconTint() {
        return this.itemStyle.getItemIconTint();
    }

    public final int getItemMinHeight() {
        return this.itemStyle.getItemMinHeight();
    }

    public final ColorStateList getItemOverlayColor() {
        return this.itemStyle.getItemOverlayColor();
    }

    public final int getItemOverlayInsetHorizontal() {
        return this.itemStyle.getOverlayInsetHorizontal();
    }

    public final float getItemOverlayRadius() {
        return this.itemStyle.getOverlayRadius();
    }

    public final int getItemPaddingHorizontal() {
        return this.itemStyle.getItemPaddingHorizontal();
    }

    public final int getItemPaddingVertical() {
        return this.itemStyle.getItemPaddingVertical();
    }

    public final int getItemSubtitleTextAppearance() {
        return this.itemStyle.getItemSubtitleTextAppearance();
    }

    public final ColorStateList getItemSubtitleTextColor() {
        return this.itemStyle.getItemSubtitleTextColor();
    }

    public final int getItemTextAppearance() {
        return this.itemStyle.getItemTextAppearance();
    }

    public final ColorStateList getItemTextColor() {
        return this.itemStyle.getItemTextColor();
    }

    public final int getItemWarningTextColor() {
        return this.itemStyle.getItemWarningTextColor();
    }

    public final int getMenuMaxHeight() {
        return this.menuMaxHeight;
    }

    public final int getMenuMaxWidth() {
        return this.menuMaxWidth;
    }

    public final int getMenuMinWidth() {
        return this.menuMinWidth;
    }

    public final int getPaddingVertical() {
        return this.paddingVertical;
    }

    public final int getSelectedItemId() {
        return this.selectedItemId;
    }

    /* renamed from: isCheckBoxVisible, reason: from getter */
    public final boolean getIsCheckBoxVisible() {
        return this.isCheckBoxVisible;
    }

    /* renamed from: isDismissOnItemClick, reason: from getter */
    public final boolean getIsDismissOnItemClick() {
        return this.isDismissOnItemClick;
    }

    /* renamed from: isDismissOnOutsideTouch, reason: from getter */
    public final boolean getIsDismissOnOutsideTouch() {
        return this.isDismissOnOutsideTouch;
    }

    /* renamed from: isDividerVisible, reason: from getter */
    public final boolean getIsDividerVisible() {
        return this.isDividerVisible;
    }

    /* renamed from: isGlassEnabled, reason: from getter */
    public final boolean getIsGlassEnabled() {
        return this.isGlassEnabled;
    }

    public final boolean isItemChecked(int id) {
        return id != -1 && this.selectedItemId == id;
    }

    public final boolean isShowing() {
        return this.popup.isShowing();
    }

    public final void setBackground(Drawable drawable) {
        Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
        if (this.background == drawableMutate) {
            return;
        }
        this.background = drawableMutate;
        if (this.panel.isAttachedToWindow()) {
            if (this.isGlassEnabled && hasRealGlass()) {
                return;
            }
            applySolidBackground();
        }
    }

    public final void setBackgroundResource(int id) {
        if (id == 0) {
            throw new IllegalArgumentException("setBackgroundResource id must be a valid @DrawableRes, was 0");
        }
        setBackground(C4027a.b(this.context, id));
    }

    public final void setCheckBoxVisible(boolean z10) {
        if (this.isCheckBoxVisible == z10) {
            return;
        }
        this.isCheckBoxVisible = z10;
        this.adapter.submit(this.items, this.selectedItemId, z10, this.expandedIndexes);
    }

    public final void setCornerRadius(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(("cornerRadius must be >= 0 but was " + f10).toString());
        }
        if (this.cornerRadius == f10) {
            return;
        }
        this.cornerRadius = f10;
        this.panel.setCornerRadius(f10);
        this.panel.invalidateOutline();
        if (hasRealGlass()) {
            this.glassDelegate.updateCornerRadius$StepOSWidget_release(f10);
        } else {
            invalidateMenuGlass();
        }
    }

    public final void setDismissOnItemClick(boolean z10) {
        this.isDismissOnItemClick = z10;
    }

    public final void setDismissOnOutsideTouch(boolean z10) {
        this.isDismissOnOutsideTouch = z10;
        this.popup.setOutsideTouchable(z10);
    }

    public final void setDividerColor(int i10) {
        if (this.dividerColor == i10) {
            return;
        }
        this.dividerColor = i10;
        invalidateDivider();
    }

    public final void setDividerHeight(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("dividerHeight must be >= 0 but was " + i10).toString());
        }
        if (this.dividerHeight == i10) {
            return;
        }
        this.dividerHeight = i10;
        invalidateDivider();
    }

    public final void setDividerInsetHorizontal(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("dividerInsetHorizontal must be >= 0 but was " + i10).toString());
        }
        if (this.dividerInsetHorizontal == i10) {
            return;
        }
        this.dividerInsetHorizontal = i10;
        invalidateDivider();
    }

    public final void setDividerVisible(boolean z10) {
        if (this.isDividerVisible == z10) {
            return;
        }
        this.isDividerVisible = z10;
        invalidateDivider();
    }

    public final void setElevation(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("elevation must be >= 0 but was " + i10).toString());
        }
        if (this.elevation == i10) {
            return;
        }
        this.elevation = i10;
        this.popup.setElevation(i10);
    }

    public final void setGlassEffect(o oVar) {
        boolean z10 = this.glassCustomizer != null;
        this.glassCustomizer = null;
        if (!p.d(this.glassEffect, oVar) || z10) {
            this.glassEffect = oVar;
            invalidateMenuGlass();
        }
    }

    public final void setGlassEnabled(boolean z10) {
        if (this.isGlassEnabled == z10) {
            return;
        }
        this.isGlassEnabled = z10;
        if (z10) {
            invalidateMenuGlass();
        } else {
            applySolidBackground();
        }
    }

    public final void setItemChecked(int id, boolean checked) {
        if (!checked) {
            int i10 = this.selectedItemId;
            id = i10 == id ? -1 : i10;
        }
        setSelectedItemId(id);
    }

    public final void setItemIconSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("itemIconSize must be >= 0 but was " + i10).toString());
        }
        if (this.itemStyle.getItemIconSize() == i10) {
            return;
        }
        this.itemStyle.setItemIconSize(i10);
        refreshItemAppearance();
    }

    public final void setItemIconTint(ColorStateList colorStateList) {
        if (this.itemStyle.getItemIconTint() == colorStateList) {
            return;
        }
        this.itemStyle.setItemIconTint(colorStateList);
        refreshItemAppearance();
    }

    public final void setItemMinHeight(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("itemMinHeight must be >= 0 but was " + i10).toString());
        }
        if (this.itemStyle.getItemMinHeight() == i10) {
            return;
        }
        this.itemStyle.setItemMinHeight(i10);
        refreshItemAppearance();
    }

    public final void setItemOverlayColor(ColorStateList colorStateList) {
        if (this.itemStyle.getItemOverlayColor() == colorStateList) {
            return;
        }
        this.itemStyle.setItemOverlayColor(colorStateList);
        refreshItemAppearance();
    }

    public final void setItemOverlayInsetHorizontal(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("itemOverlayInsetHorizontal must be >= 0 but was " + i10).toString());
        }
        if (this.itemStyle.getOverlayInsetHorizontal() == i10) {
            return;
        }
        this.itemStyle.setOverlayInsetHorizontal(i10);
        refreshItemAppearance();
    }

    public final void setItemOverlayRadius(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(("itemOverlayRadius must be >= 0 but was " + f10).toString());
        }
        if (this.itemStyle.getOverlayRadius() == f10) {
            return;
        }
        this.itemStyle.setOverlayRadius(f10);
        refreshItemAppearance();
    }

    public final void setItemPaddingHorizontal(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("itemPaddingHorizontal must be >= 0 but was " + i10).toString());
        }
        if (this.itemStyle.getItemPaddingHorizontal() == i10) {
            return;
        }
        this.itemStyle.setItemPaddingHorizontal(i10);
        refreshItemAppearance();
    }

    public final void setItemPaddingVertical(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("itemPaddingVertical must be >= 0 but was " + i10).toString());
        }
        if (this.itemStyle.getItemPaddingVertical() == i10) {
            return;
        }
        this.itemStyle.setItemPaddingVertical(i10);
        refreshItemAppearance();
    }

    public final void setItemSubtitleTextAppearance(int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("itemSubtitleTextAppearance 不能为 0，请传一个 @style 资源；恢复默认请传 R.style.StepOSTextAppearance_Menu_Item_Subtitle");
        }
        if (this.itemStyle.getItemSubtitleTextAppearance() == i10) {
            return;
        }
        this.itemStyle.setItemSubtitleTextAppearance(i10);
        refreshItemAppearance();
    }

    public final void setItemSubtitleTextColor(ColorStateList colorStateList) {
        if (this.itemStyle.getItemSubtitleTextColor() == colorStateList) {
            return;
        }
        this.itemStyle.setItemSubtitleTextColor(colorStateList);
        refreshItemAppearance();
    }

    public final void setItemTextAppearance(int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("itemTextAppearance 不能为 0，请传一个 @style 资源；恢复默认请传 R.style.StepOSTextAppearance_Menu_Item");
        }
        if (this.itemStyle.getItemTextAppearance() == i10) {
            return;
        }
        this.itemStyle.setItemTextAppearance(i10);
        refreshItemAppearance();
    }

    public final void setItemTextColor(ColorStateList colorStateList) {
        if (this.itemStyle.getItemTextColor() == colorStateList) {
            return;
        }
        this.itemStyle.setItemTextColor(colorStateList);
        refreshItemAppearance();
    }

    public final void setItemWarningTextColor(int i10) {
        if (this.itemStyle.getItemWarningTextColor() == i10) {
            return;
        }
        this.itemStyle.setItemWarningTextColor(i10);
        refreshItemAppearance();
    }

    public final void setItems(List<StepOSMenuItem> items) {
        p.i(items, "items");
        this.items.clear();
        this.items.addAll(items);
        this.expandedIndexes.clear();
        int i10 = 0;
        for (Object obj : this.items) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            StepOSMenuItem stepOSMenuItem = (StepOSMenuItem) obj;
            if (stepOSMenuItem.getIsExpandable() && stepOSMenuItem.getIsExpanded()) {
                this.expandedIndexes.add(Integer.valueOf(i10));
            }
            i10 = i11;
        }
        refreshAdapter();
    }

    public final void setMenuMaxHeight(int i10) {
        if (i10 >= 0) {
            this.menuMaxHeight = i10;
            return;
        }
        throw new IllegalArgumentException(("menuMaxHeight must be >= 0 but was " + i10).toString());
    }

    public final void setMenuMaxWidth(int i10) {
        if (i10 >= 0) {
            this.menuMaxWidth = i10;
            return;
        }
        throw new IllegalArgumentException(("menuMaxWidth must be >= 0 but was " + i10).toString());
    }

    public final void setMenuMinWidth(int i10) {
        if (i10 >= 0) {
            this.menuMinWidth = i10;
            return;
        }
        throw new IllegalArgumentException(("menuMinWidth must be >= 0 but was " + i10).toString());
    }

    public final void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        this.onDismissListener = listener;
    }

    public final void setOnItemCheckedChangeListener(OnItemCheckedChangeListener listener) {
        this.onItemCheckedChangeListener = listener;
    }

    public final void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public final void setPaddingVertical(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("paddingVertical must be >= 0 but was " + i10).toString());
        }
        if (this.paddingVertical == i10) {
            return;
        }
        this.paddingVertical = i10;
        applyListPadding();
        if (isShowing()) {
            relayoutShowingPopup();
        }
    }

    public final void setSelectedItemId(int i10) {
        if (this.selectedItemId == i10) {
            return;
        }
        this.selectedItemId = i10;
        this.adapter.submit(this.items, i10, this.isCheckBoxVisible, this.expandedIndexes);
    }

    public final void show(View anchor) {
        p.i(anchor, "anchor");
        showAsDropDown(anchor, 0, 0, 8388611);
    }

    public final void showAsDropDown(View anchor, int xoff, int yoff, int gravity) {
        p.i(anchor, "anchor");
        showInternal(anchor, xoff, yoff, gravity, false);
    }

    public final void showOverlapping(View anchor) {
        p.i(anchor, "anchor");
        showOverlapping(anchor, 0, 0, 8388613);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        p.i(context, "context");
    }

    public final void showOverlapping(View anchor, int xoff, int yoff, int gravity) {
        p.i(anchor, "anchor");
        showInternal(anchor, xoff, yoff, gravity, true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenu(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        p.i(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.stepos.widget.menu.StepOSMenu$scrollbarScrollListener$1] */
    public StepOSMenu(Context context, AttributeSet attributeSet, int i10, int i11) throws Exception {
        p.i(context, "context");
        this.context = context;
        SteposMenuBinding steposMenuBindingInflate = SteposMenuBinding.inflate(LayoutInflater.from(context));
        p.h(steposMenuBindingInflate, "inflate(...)");
        this.binding = steposMenuBindingInflate;
        StepOSMenuPanel steposMenuPanel = steposMenuBindingInflate.steposMenuPanel;
        p.h(steposMenuPanel, "steposMenuPanel");
        this.panel = steposMenuPanel;
        this.glassDelegate = new GlassDelegate(steposMenuPanel);
        StepOSMenuStyle stepOSMenuStyle = new StepOSMenuStyle(context);
        this.itemStyle = stepOSMenuStyle;
        this.applyMenuGlassRunnable = new Runnable() { // from class: com.stepos.widget.menu.a
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                StepOSMenu.applyMenuGlassRunnable$lambda$0(this.f31270a);
            }
        };
        this.items = new ArrayList<>();
        this.expandedIndexes = new HashSet<>();
        this.anchorDetachListener = new View.OnAttachStateChangeListener() { // from class: com.stepos.widget.menu.StepOSMenu$anchorDetachListener$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v10) {
                p.i(v10, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v10) {
                p.i(v10, "v");
                if (this.this$0.popup.isShowing()) {
                    this.this$0.dismiss();
                } else {
                    this.this$0.unbindAnchor();
                }
            }
        };
        this.lastGravity = 8388611;
        StepOSMenuAdapter stepOSMenuAdapter = new StepOSMenuAdapter(new p9.p() { // from class: com.stepos.widget.menu.b
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return StepOSMenu.adapter$lambda$1(this.f31271a, ((Integer) obj).intValue(), (StepOSMenuItem) obj2);
            }
        }, stepOSMenuStyle);
        this.adapter = stepOSMenuAdapter;
        MenuDividerDecoration menuDividerDecoration = new MenuDividerDecoration();
        this.dividerDecoration = menuDividerDecoration;
        final FrameLayout root = steposMenuBindingInflate.getRoot();
        PopupWindow popupWindow = new PopupWindow(root) { // from class: com.stepos.widget.menu.StepOSMenu$popup$1
            @Override // android.widget.PopupWindow
            public void dismiss() {
                if (isShowing()) {
                    this.this$0.lastDismissUptimeMs = SystemClock.uptimeMillis();
                    if (this.this$0.panel.isAttachedToWindow()) {
                        this.this$0.applySolidBackground();
                    }
                }
                super.dismiss();
            }
        };
        this.popup = popupWindow;
        ?? r02 = new RecyclerView.OnScrollListener() { // from class: com.stepos.widget.menu.StepOSMenu$scrollbarScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                p.i(recyclerView, "recyclerView");
                this.this$0.updateScrollbar();
            }
        };
        this.scrollbarScrollListener = r02;
        this.scrollbarInsetVertical = context.getResources().getDimensionPixelSize(R.dimen.stepos_menu_scrollbar_inset_vertical);
        this.menuMinWidth = context.getResources().getDimensionPixelSize(R.dimen.stepos_menu_min_width);
        this.menuMaxWidth = context.getResources().getDimensionPixelSize(R.dimen.stepos_menu_max_width);
        this.menuMaxHeight = context.getResources().getDimensionPixelSize(R.dimen.stepos_menu_max_height);
        Drawable drawableB = C4027a.b(context, R.drawable.stepos_bg_menu);
        this.background = drawableB != null ? drawableB.mutate() : null;
        this.elevation = context.getResources().getDimensionPixelSize(R.dimen.stepos_menu_elevation);
        this.paddingVertical = context.getResources().getDimensionPixelSize(R.dimen.stepos_menu_padding_vertical);
        this.cornerRadius = context.getResources().getDimension(R.dimen.stepos_menu_corner_radius);
        this.isDismissOnItemClick = true;
        this.isDismissOnOutsideTouch = true;
        this.dividerColor = context.getColor(R.color.stepos_menu_divider_color);
        this.dividerHeight = context.getResources().getDimensionPixelSize(R.dimen.stepos_menu_divider_height);
        this.dividerInsetHorizontal = context.getResources().getDimensionPixelSize(R.dimen.stepos_menu_divider_inset_horizontal);
        this.selectedItemId = -1;
        this.isGlassEnabled = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSMenu, i10, i11);
        try {
            stepOSMenuStyle.setItemTextAppearance(typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSMenu_steposMenuItemTextAppearance, stepOSMenuStyle.getItemTextAppearance()));
            stepOSMenuStyle.setItemSubtitleTextAppearance(typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSMenu_steposMenuItemSubtitleTextAppearance, stepOSMenuStyle.getItemSubtitleTextAppearance()));
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.StepOSMenu_steposMenuItemTextColor);
            if (colorStateList != null) {
                stepOSMenuStyle.setItemTextColor(colorStateList);
            }
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.StepOSMenu_steposMenuItemSubtitleTextColor);
            if (colorStateList2 != null) {
                stepOSMenuStyle.setItemSubtitleTextColor(colorStateList2);
            }
            stepOSMenuStyle.setItemWarningTextColor(typedArrayObtainStyledAttributes.getColor(R.styleable.StepOSMenu_steposMenuItemWarningTextColor, stepOSMenuStyle.getItemWarningTextColor()));
            ColorStateList colorStateList3 = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.StepOSMenu_steposMenuItemIconTint);
            if (colorStateList3 != null) {
                stepOSMenuStyle.setItemIconTint(colorStateList3);
            }
            ColorStateList colorStateList4 = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.StepOSMenu_steposMenuItemOverlayColor);
            if (colorStateList4 != null) {
                stepOSMenuStyle.setItemOverlayColor(colorStateList4);
            }
            int i12 = R.styleable.StepOSMenu_steposMenuBackground;
            if (typedArrayObtainStyledAttributes.hasValue(i12)) {
                setBackground(typedArrayObtainStyledAttributes.getDrawable(i12));
            }
            setMenuMinWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSMenu_steposMenuMinWidth, this.menuMinWidth));
            setMenuMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSMenu_steposMenuMaxWidth, this.menuMaxWidth));
            setMenuMaxHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSMenu_steposMenuMaxHeight, this.menuMaxHeight));
            setElevation(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSMenu_steposMenuElevation, this.elevation));
            setPaddingVertical(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSMenu_steposMenuPaddingVertical, this.paddingVertical));
            stepOSMenuStyle.setItemMinHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSMenu_steposMenuItemMinHeight, stepOSMenuStyle.getItemMinHeight()));
            stepOSMenuStyle.setItemPaddingHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSMenu_steposMenuItemPaddingHorizontal, stepOSMenuStyle.getItemPaddingHorizontal()));
            stepOSMenuStyle.setItemPaddingVertical(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSMenu_steposMenuItemPaddingVertical, stepOSMenuStyle.getItemPaddingVertical()));
            stepOSMenuStyle.setItemIconSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSMenu_steposMenuItemIconSize, stepOSMenuStyle.getItemIconSize()));
            stepOSMenuStyle.setOverlayRadius(typedArrayObtainStyledAttributes.getDimension(R.styleable.StepOSMenu_steposMenuItemOverlayRadius, stepOSMenuStyle.getOverlayRadius()));
            stepOSMenuStyle.setOverlayInsetHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSMenu_steposMenuItemOverlayInsetHorizontal, stepOSMenuStyle.getOverlayInsetHorizontal()));
            setDividerVisible(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSMenu_steposMenuDividerVisible, this.isDividerVisible));
            ColorStateList colorStateList5 = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.StepOSMenu_steposMenuDividerColor);
            if (colorStateList5 != null) {
                setDividerColor(colorStateList5.getDefaultColor());
            }
            setDividerHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSMenu_steposMenuDividerHeight, this.dividerHeight));
            setDividerInsetHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSMenu_steposMenuDividerInsetHorizontal, this.dividerInsetHorizontal));
            setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSMenu_steposGlassEnabled, this.isGlassEnabled));
            GlassEffectResolver glassEffectResolver = GlassEffectResolver.INSTANCE;
            p.f(typedArrayObtainStyledAttributes);
            o oVar = glassEffectResolver.read$StepOSWidget_release(typedArrayObtainStyledAttributes, R.styleable.StepOSMenu_steposGlassEffect);
            if (oVar != null) {
                setGlassEffect(oVar);
            }
            setCornerRadius(typedArrayObtainStyledAttributes.getDimension(R.styleable.StepOSMenu_steposGlassCornerRadius, this.cornerRadius));
            t tVar = t.f7040a;
            C4946a.a(typedArrayObtainStyledAttributes, null);
            RecyclerView recyclerView = this.binding.steposMenuRecycler;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(stepOSMenuAdapter);
            recyclerView.setVerticalScrollBarEnabled(false);
            recyclerView.addItemDecoration(menuDividerDecoration);
            recyclerView.addOnScrollListener(r02);
            recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.widget.menu.c
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20) {
                    StepOSMenu.a(this.f31272a, view, i13, i14, i15, i16, i17, i18, i19, i20);
                }
            });
            applyListPadding();
            this.panel.setCornerRadius(this.cornerRadius);
            this.panel.setClipToOutline(true);
            this.panel.setOutlineProvider(new ViewOutlineProvider() { // from class: com.stepos.widget.menu.StepOSMenu.3
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    p.i(view, "view");
                    p.i(outline, "outline");
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), StepOSMenu.this.getCornerRadius());
                }
            });
            this.panel.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.stepos.widget.menu.StepOSMenu.4
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v10) {
                    p.i(v10, "v");
                    StepOSMenu.this.requestMenuGlass();
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v10) {
                    p.i(v10, "v");
                }
            });
            this.panel.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.widget.menu.d
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20) {
                    StepOSMenu._init_$lambda$28(this.f31273a, view, i13, i14, i15, i16, i17, i18, i19, i20);
                }
            });
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            popupWindow.setOutsideTouchable(this.isDismissOnOutsideTouch);
            popupWindow.setInputMethodMode(2);
            popupWindow.setElevation(this.elevation);
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.stepos.widget.menu.e
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    StepOSMenu._init_$lambda$29(this.f31274a);
                }
            });
        } finally {
        }
    }

    public /* synthetic */ StepOSMenu(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposMenuStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_Menu : i11);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenu(Context context, int i10) {
        this(context, null, 0, i10);
        p.i(context, "context");
    }
}
