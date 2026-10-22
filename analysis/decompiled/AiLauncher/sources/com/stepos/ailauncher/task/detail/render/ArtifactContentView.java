package com.stepos.ailauncher.task.detail.render;

import A1.g;
import Ua.C1060i;
import Ua.L0;
import Ua.Y;
import Z8.C1173v;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.format.Formatter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentframework.chatui.view.I0;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.task.R$dimen;
import com.stepos.ailauncher.task.R$string;
import com.stepos.ailauncher.task.detail.TaskWebView;
import com.stepos.ailauncher.task.detail.render.ArtifactRenderKind;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p7.AppUI;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import tb.z;
import u6.C5578a;
import u6.C5581d;
import v9.C5685n;

@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u00ad\u00022\u00020\u0001:\u0003®\u0002\u0013B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\"\u0010!J\u000f\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\nH\u0002¢\u0006\u0004\b%\u0010$J%\u0010(\u001a\u00020\f2\u0014\u0010'\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\f0&H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0014H\u0002¢\u0006\u0004\b+\u0010,J!\u0010-\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u0014H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\fH\u0002¢\u0006\u0004\b2\u0010\u001cJ\u0017\u00104\u001a\u00020\f2\u0006\u00103\u001a\u00020\u001eH\u0002¢\u0006\u0004\b4\u0010!J\u000f\u00105\u001a\u00020\fH\u0002¢\u0006\u0004\b5\u0010\u001cJ\u0019\u00107\u001a\u00020\f2\b\b\u0002\u00106\u001a\u00020\nH\u0002¢\u0006\u0004\b7\u0010\u000eJ\u000f\u00108\u001a\u00020\fH\u0002¢\u0006\u0004\b8\u0010\u001cJ\u000f\u00109\u001a\u00020\fH\u0002¢\u0006\u0004\b9\u0010\u001cJ\u0019\u0010;\u001a\u00020\f2\b\b\u0002\u0010:\u001a\u00020\nH\u0002¢\u0006\u0004\b;\u0010\u000eJ\u000f\u0010<\u001a\u00020\fH\u0002¢\u0006\u0004\b<\u0010\u001cJ\u000f\u0010=\u001a\u00020\fH\u0002¢\u0006\u0004\b=\u0010\u001cJ\u000f\u0010>\u001a\u00020\fH\u0002¢\u0006\u0004\b>\u0010\u001cJ\u000f\u0010?\u001a\u00020\fH\u0002¢\u0006\u0004\b?\u0010\u001cJ\u000f\u0010@\u001a\u00020\fH\u0002¢\u0006\u0004\b@\u0010\u001cJ\u000f\u0010A\u001a\u00020\fH\u0002¢\u0006\u0004\bA\u0010\u001cJ\u000f\u0010B\u001a\u00020\fH\u0002¢\u0006\u0004\bB\u0010\u001cJ\u000f\u0010C\u001a\u00020\fH\u0002¢\u0006\u0004\bC\u0010\u001cJ\u000f\u0010D\u001a\u00020\fH\u0002¢\u0006\u0004\bD\u0010\u001cJ\u000f\u0010E\u001a\u00020\fH\u0002¢\u0006\u0004\bE\u0010\u001cJ\u0017\u0010H\u001a\u00020\f2\u0006\u0010G\u001a\u00020FH\u0002¢\u0006\u0004\bH\u0010IJ-\u0010J\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\bJ\u0010\u0018J\u001f\u0010M\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010L\u001a\u00020KH\u0002¢\u0006\u0004\bM\u0010NJ9\u0010T\u001a\u00020\f2\u0006\u0010P\u001a\u00020O2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010L\u001a\u00020K2\u0010\b\u0002\u0010S\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010RH\u0002¢\u0006\u0004\bT\u0010UJ\u0019\u0010W\u001a\u00020O2\b\u0010V\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bW\u0010XJ\u0019\u0010[\u001a\u00020O2\b\u0010Z\u001a\u0004\u0018\u00010YH\u0002¢\u0006\u0004\b[\u0010\\J\u0019\u0010]\u001a\u00020\n2\b\u0010Z\u001a\u0004\u0018\u00010YH\u0002¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\n2\u0006\u0010Z\u001a\u00020_H\u0002¢\u0006\u0004\b`\u0010aJ\u001f\u0010d\u001a\u00020\f2\u0006\u0010b\u001a\u00020O2\u0006\u0010c\u001a\u00020OH\u0002¢\u0006\u0004\bd\u0010eJ'\u0010g\u001a\u00020\f2\u0006\u0010L\u001a\u00020K2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010f\u001a\u00020OH\u0002¢\u0006\u0004\bg\u0010hJ\u0017\u0010i\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\bi\u0010\u001aJ\u0017\u0010j\u001a\u00020\f2\u0006\u0010P\u001a\u00020OH\u0002¢\u0006\u0004\bj\u0010kJ\u000f\u0010l\u001a\u00020\fH\u0002¢\u0006\u0004\bl\u0010\u001cJ\u000f\u0010m\u001a\u00020\fH\u0002¢\u0006\u0004\bm\u0010\u001cJ\u0019\u0010o\u001a\u00020\f2\b\u0010n\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\bo\u0010!J\u000f\u0010p\u001a\u00020\fH\u0002¢\u0006\u0004\bp\u0010\u001cJ\u000f\u0010q\u001a\u00020\nH\u0002¢\u0006\u0004\bq\u0010$J\u0017\u0010s\u001a\u00020\f2\u0006\u0010r\u001a\u00020\nH\u0002¢\u0006\u0004\bs\u0010\u000eJ\u0017\u0010t\u001a\u00020\f2\u0006\u0010r\u001a\u00020\nH\u0002¢\u0006\u0004\bt\u0010\u000eJ\u000f\u0010u\u001a\u00020\fH\u0002¢\u0006\u0004\bu\u0010\u001cJ\u000f\u0010v\u001a\u00020\fH\u0002¢\u0006\u0004\bv\u0010\u001cJ\u000f\u0010w\u001a\u00020\fH\u0002¢\u0006\u0004\bw\u0010\u001cJ7\u0010|\u001a\u00020\f2\u0006\u0010x\u001a\u00020O2\u0006\u0010y\u001a\u00020\u00062\u0006\u0010z\u001a\u00020\u00062\u000e\u0010{\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010RH\u0002¢\u0006\u0004\b|\u0010}J7\u0010\u0083\u0001\u001a\u00020\f2\u0006\u0010\u007f\u001a\u00020~2\u0007\u0010\u0080\u0001\u001a\u00020O2\u0007\u0010\u0081\u0001\u001a\u00020O2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001JN\u0010\u0088\u0001\u001a\u00020\f2\u0006\u0010\u007f\u001a\u00020~2\b\u0010\u0086\u0001\u001a\u00030\u0085\u00012\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010O2\u0010\b\u0002\u0010S\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010R2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0019\u0010\u008a\u0001\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0005\b\u008a\u0001\u0010\u001aJ\u001a\u0010\u008b\u0001\u001a\u00020O2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J!\u0010\u008e\u0001\u001a\u00020\f2\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\f0RH\u0002¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u001c\u0010\u0092\u0001\u001a\u00020\n2\b\u0010\u0091\u0001\u001a\u00030\u0090\u0001H\u0016¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0019\u0010\u0094\u0001\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0094\u0001\u0010\u0011J\u000f\u0010\u0095\u0001\u001a\u00020\n¢\u0006\u0005\b\u0095\u0001\u0010$J\u0017\u0010\u0096\u0001\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0005\b\u0096\u0001\u0010\u001aJ)\u0010\u009a\u0001\u001a\u00020\f2\u0007\u0010\u0097\u0001\u001a\u00020\u00122\u000e\u0010\u0099\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120\u0098\u0001¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u001a\u0010\u009e\u0001\u001a\u00020\f2\b\u0010\u009d\u0001\u001a\u00030\u009c\u0001¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u000f\u0010 \u0001\u001a\u00020\f¢\u0006\u0005\b \u0001\u0010\u001cJ\u000f\u0010¡\u0001\u001a\u00020\f¢\u0006\u0005\b¡\u0001\u0010\u001cJ\u000f\u0010¢\u0001\u001a\u00020\n¢\u0006\u0005\b¢\u0001\u0010$J\u000f\u0010£\u0001\u001a\u00020\f¢\u0006\u0005\b£\u0001\u0010\u001cJ\u000f\u0010¤\u0001\u001a\u00020\f¢\u0006\u0005\b¤\u0001\u0010\u001cJ\u000f\u0010¥\u0001\u001a\u00020\f¢\u0006\u0005\b¥\u0001\u0010\u001cJ\u0011\u0010¦\u0001\u001a\u00020\fH\u0014¢\u0006\u0005\b¦\u0001\u0010\u001cJ6\u0010«\u0001\u001a\u00020\f2\u0007\u0010§\u0001\u001a\u00020\u00062\u0007\u0010¨\u0001\u001a\u00020\u00062\u0007\u0010©\u0001\u001a\u00020\u00062\u0007\u0010ª\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u001c\u0010¯\u0001\u001a\u00020\f2\b\u0010®\u0001\u001a\u00030\u00ad\u0001H\u0014¢\u0006\u0006\b¯\u0001\u0010°\u0001R\u0018\u0010²\u0001\u001a\u00030±\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u0018\u0010µ\u0001\u001a\u00030´\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u001c\u0010¸\u0001\u001a\u0005\u0018\u00010·\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u0019\u0010º\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u001b\u0010¼\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R,\u0010¿\u0001\u001a\u00030\u009c\u00012\b\u0010¾\u0001\u001a\u00030\u009c\u00018\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001R\u0019\u0010Ã\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010»\u0001R\u001b\u0010Ä\u0001\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u001b\u0010Æ\u0001\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Å\u0001R\u0019\u0010Ç\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010»\u0001R\u001c\u0010É\u0001\u001a\u0005\u0018\u00010È\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u001c\u0010Ë\u0001\u001a\u0005\u0018\u00010È\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010Ê\u0001R\u001c\u0010Ì\u0001\u001a\u0005\u0018\u00010È\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Ê\u0001R\u0019\u0010Í\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Î\u0001R\u0019\u0010Ï\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Î\u0001R\u0019\u0010Ð\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010»\u0001R\u0019\u0010Ñ\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010»\u0001R\u0019\u0010Ò\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010»\u0001R\u001b\u0010Ó\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010½\u0001R\u0018\u0010Õ\u0001\u001a\u00030Ô\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R!\u0010Ü\u0001\u001a\u00030×\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bØ\u0001\u0010Ù\u0001\u001a\u0006\bÚ\u0001\u0010Û\u0001R\u0019\u0010Ý\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010»\u0001R4\u0010ß\u0001\u001a\u00030Þ\u00012\b\u0010¾\u0001\u001a\u00030Þ\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\bß\u0001\u0010à\u0001\u001a\u0006\bá\u0001\u0010â\u0001\"\u0006\bã\u0001\u0010ä\u0001R\u0019\u0010å\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010»\u0001R\u0019\u0010æ\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0001\u0010»\u0001R\u0018\u0010è\u0001\u001a\u00030ç\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bè\u0001\u0010é\u0001R!\u0010ì\u0001\u001a\u00030Þ\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bê\u0001\u0010Ù\u0001\u001a\u0006\bë\u0001\u0010â\u0001R!\u0010ï\u0001\u001a\u00030Þ\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bí\u0001\u0010Ù\u0001\u001a\u0006\bî\u0001\u0010â\u0001R!\u0010ò\u0001\u001a\u00030Þ\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bð\u0001\u0010Ù\u0001\u001a\u0006\bñ\u0001\u0010â\u0001R!\u0010õ\u0001\u001a\u00030Þ\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bó\u0001\u0010Ù\u0001\u001a\u0006\bô\u0001\u0010â\u0001R\u0019\u0010ö\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bö\u0001\u0010»\u0001R\u001b\u0010÷\u0001\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b÷\u0001\u0010Å\u0001R\u0019\u0010ø\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0001\u0010Î\u0001R\u0019\u0010ù\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010Î\u0001R\u0019\u0010ú\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0001\u0010»\u0001R\u0019\u0010û\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0001\u0010»\u0001R\u0019\u0010ü\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0001\u0010»\u0001R\u0019\u0010ý\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bý\u0001\u0010»\u0001R\u0019\u0010þ\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0001\u0010Î\u0001R\u0019\u0010ÿ\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÿ\u0001\u0010»\u0001R\u001c\u0010\u0080\u0002\u001a\u0005\u0018\u00010È\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0002\u0010Ê\u0001R\u0019\u0010\u0081\u0002\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0002\u0010»\u0001R\u001c\u0010\u0082\u0002\u001a\u0005\u0018\u00010È\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0002\u0010Ê\u0001R2\u0010\u0083\u0002\u001a\u00020\u00062\u0007\u0010¾\u0001\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0083\u0002\u0010Î\u0001\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002\"\u0006\b\u0086\u0002\u0010\u0087\u0002R2\u0010\u0088\u0002\u001a\u00020\u00062\u0007\u0010¾\u0001\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0088\u0002\u0010Î\u0001\u001a\u0006\b\u0089\u0002\u0010\u0085\u0002\"\u0006\b\u008a\u0002\u0010\u0087\u0002R\u001a\u0010\u008b\u0002\u001a\u00030Þ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0002\u0010à\u0001R\u001a\u0010\u008c\u0002\u001a\u00030Þ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0002\u0010à\u0001R\u001a\u0010\u008d\u0002\u001a\u00030Þ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0002\u0010à\u0001R\u0019\u0010\u008e\u0002\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0002\u0010»\u0001R\u0019\u0010\u008f\u0002\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0002\u0010»\u0001R\u0019\u0010\u0090\u0002\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0002\u0010»\u0001R\u0017\u0010\u0091\u0002\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0002\u0010Î\u0001R1\u0010\u0092\u0002\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010R8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0092\u0002\u0010\u0093\u0002\u001a\u0006\b\u0094\u0002\u0010\u0095\u0002\"\u0006\b\u0096\u0002\u0010\u008f\u0001R1\u0010\u0097\u0002\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010R8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0097\u0002\u0010\u0093\u0002\u001a\u0006\b\u0098\u0002\u0010\u0095\u0002\"\u0006\b\u0099\u0002\u0010\u008f\u0001R6\u0010\u009a\u0002\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u009a\u0002\u0010\u009b\u0002\u001a\u0006\b\u009c\u0002\u0010\u009d\u0002\"\u0005\b\u009e\u0002\u0010)R\u001b\u0010\u009f\u0002\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0002\u0010 \u0002R>\u0010¢\u0002\u001a\u0017\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0018\u00010¡\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¢\u0002\u0010£\u0002\u001a\u0006\b¤\u0002\u0010¥\u0002\"\u0006\b¦\u0002\u0010§\u0002R1\u0010¨\u0002\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010R8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¨\u0002\u0010\u0093\u0002\u001a\u0006\b©\u0002\u0010\u0095\u0002\"\u0006\bª\u0002\u0010\u008f\u0001R\u0013\u0010¬\u0002\u001a\u00020\n8F¢\u0006\u0007\u001a\u0005\b«\u0002\u0010$¨\u0006¯\u0002"}, d2 = {"Lcom/stepos/ailauncher/task/detail/render/ArtifactContentView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "disallow", "LY8/t;", "x0", "(Z)V", "direction", "h1", "(I)Z", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", Const.INTENT_KEY_APIKEY, "Landroid/graphics/Bitmap;", "snapshot", "keepSnapshot", "A0", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Landroid/graphics/Bitmap;Z)V", "D1", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)V", "C1", "()V", "V1", "Landroid/view/View;", "child", "P0", "(Landroid/view/View;)V", "e1", "L1", "()Z", "W0", "Lkotlin/Function1;", "onDone", "t0", "(Lp9/l;)V", "src", "D0", "(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "R1", "(Landroid/graphics/Bitmap;Z)V", "bitmap", "i0", "(Landroid/graphics/Bitmap;)V", "j0", "view", "G0", "G1", "hideProgress", "r0", "v0", "R0", "fade", "S0", "g0", "K1", "X1", "l0", "F1", "g1", "q0", "I1", "s0", "y0", "Lcom/stepos/ailauncher/task/detail/render/ArtifactRenderKind$Kind;", "active", "n1", "(Lcom/stepos/ailauncher/task/detail/render/ArtifactRenderKind$Kind;)V", "A1", "Lcom/stepos/ailauncher/task/detail/TaskWebView;", AppUI.TYPE_WEB, "K0", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Lcom/stepos/ailauncher/task/detail/TaskWebView;)V", "", "url", "asHtml", "Lkotlin/Function0;", "onFailRetry", "N0", "(Ljava/lang/String;ZLcom/stepos/ailauncher/task/detail/TaskWebView;Lp9/a;)V", "code", "k1", "(Ljava/lang/Integer;)Ljava/lang/String;", "", "e", "l1", "(Ljava/lang/Throwable;)Ljava/lang/String;", "Y0", "(Ljava/lang/Throwable;)Z", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException$Other;", "V0", "(Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException$Other;)Z", "failedReason", HomeGestureEligibilityContract.EXTRA_SCENE, "O1", "(Ljava/lang/String;Ljava/lang/String;)V", "text", "q1", "(Lcom/stepos/ailauncher/task/detail/TaskWebView;ZLjava/lang/String;)V", "r1", "x1", "(Ljava/lang/String;)V", "J0", "p0", "target", "Q1", "U1", "o0", "enable", "k0", "h0", "d0", "W1", "E1", "branch", "top", "bottom", "onApplied", "i1", "(Ljava/lang/String;IILp9/a;)V", "Landroid/widget/ImageView;", "image", "fileId", "rawContent", "preferRgb565", "Z0", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/String;Z)V", "", "data", "cacheKey", "c1", "(Landroid/widget/ImageView;Ljava/lang/Object;Ljava/lang/String;Lp9/a;Z)V", "B1", "n0", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)Ljava/lang/String;", "block", SdCardDbCreator.FIELD_LASTLOC_INFO, "(Lp9/a;)V", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "canScrollVertically", "Z1", "o1", "folder", "", "children", "u1", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/util/List;)V", "Lcom/stepos/ailauncher/task/detail/render/ArtifactContentView$HtmlView;", "mode", "f0", "(Lcom/stepos/ailauncher/task/detail/render/ArtifactContentView$HtmlView;)V", "Q0", "Y1", "w0", "N1", "M1", "m1", "onDetachedFromWindow", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "Lr6/q;", Const.INTENT_KEY_PKGNAME, "Lr6/q;", "LUa/M;", "scope", "LUa/M;", "Lkotlinx/coroutines/g;", "renderJob", "Lkotlinx/coroutines/g;", "previewFetchInFlight", "Z", "current", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", UxipConstants.f30680s, "htmlView", "Lcom/stepos/ailauncher/task/detail/render/ArtifactContentView$HtmlView;", "getHtmlView", "()Lcom/stepos/ailauncher/task/detail/render/ArtifactContentView$HtmlView;", "codeLoaded", "currentHtmlSource", "Ljava/lang/String;", "currentHtmlUrl", "htmlFallbackDone", "Ljava/lang/Runnable;", "htmlFallbackRunnable", "Ljava/lang/Runnable;", "maskHideRunnable", "maskProgressRunnable", "renderGeneration", "I", "maskHideToken", "hasPresentedContent", "snapshotMaskActive", "snapshotCapturePending", "pendingRenderArtifact", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Landroid/graphics/RenderEffect;", "snapshotBlurEffect$delegate", "LY8/h;", "getSnapshotBlurEffect", "()Landroid/graphics/RenderEffect;", "snapshotBlurEffect", "webPreviewFailed", "", "immersiveFraction", "F", "getImmersiveFraction", "()F", "setImmersiveFraction", "(F)V", "webviewFullscreen", "markdownEdgeToEdge", "Lcom/stepos/agentframework/chatui/view/I0;", "viewportFade", "Lcom/stepos/agentframework/chatui/view/I0;", "fadeTopPx$delegate", "getFadeTopPx", "fadeTopPx", "fadeBottomPx$delegate", "getFadeBottomPx", "fadeBottomPx", "fadeTopHoldPx$delegate", "getFadeTopHoldPx", "fadeTopHoldPx", "fadeBottomHoldPx$delegate", "getFadeBottomHoldPx", "fadeBottomHoldPx", "imeHeightFrozen", "lastInsetKey", "docTopOnScreen", "docTopRequested", "webPainted", "webShapeSettled", "webRevealed", "webFullscreenHeightLocked", "lockedWebShiftPx", "awaitingWebPaint", "shapeFallbackRunnable", "loadUrlPaintSettled", "loadUrlSettleRunnable", "topInsetPx", "getTopInsetPx", "()I", "setTopInsetPx", "(I)V", "bottomInsetPx", "getBottomInsetPx", "setBottomInsetPx", "touchDownX", "touchDownY", "touchLastY", "touchAxisDecided", "touchGrabbing", "contentOwnsVerticalGesture", "touchAxisSlop", "onContentMetricsChanged", "Lp9/a;", "getOnContentMetricsChanged", "()Lp9/a;", "setOnContentMetricsChanged", "onContentScrollChanged", "getOnContentScrollChanged", "setOnContentScrollChanged", "onChromeBlockingChanged", "Lp9/l;", "getOnChromeBlockingChanged", "()Lp9/l;", "setOnChromeBlockingChanged", "lastChromeBlocking", "Ljava/lang/Boolean;", "Lkotlin/Function2;", "onFolderChildClick", "Lp9/p;", "getOnFolderChildClick", "()Lp9/p;", "setOnFolderChildClick", "(Lp9/p;)V", "onUserDragContent", "getOnUserDragContent", "setOnUserDragContent", "X0", "isRenderMaskVisible", "Companion", "HtmlView", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArtifactContentView extends FrameLayout {
    private static final int GATEWAY_CODE_FILE_BLOCKED = 70003;
    private static final long HTML_DOWNLOAD_WAIT_MS = 8000;
    private static final long HTML_FIRST_PAINT_TIMEOUT_MS = 4000;
    private static final long HTML_PAINT_WAIT_MS = 12000;
    private static final long LOAD_URL_PAINT_SETTLE_MS = 600;
    private static final long RENDER_MASK_FADE_MS = 100;
    private static final long RENDER_MASK_PROGRESS_DELAY_MS = 1000;
    private static final long RENDER_MASK_TIMEOUT_MS = 4000;
    private static final long SHAPE_SETTLE_FALLBACK_MS = 1200;
    private static final float SNAPSHOT_BLUR_RADIUS_DP = 25.0f;
    private static final String TAG = "ArtifactContentView";
    private boolean awaitingWebPaint;
    private final r6.q b;
    private int bottomInsetPx;
    private boolean codeLoaded;
    private boolean contentOwnsVerticalGesture;
    private SessionArtifact current;
    private String currentHtmlSource;
    private String currentHtmlUrl;
    private int docTopOnScreen;
    private int docTopRequested;

    /* renamed from: fadeBottomHoldPx$delegate, reason: from kotlin metadata */
    private final Y8.h fadeBottomHoldPx;

    /* renamed from: fadeBottomPx$delegate, reason: from kotlin metadata */
    private final Y8.h fadeBottomPx;

    /* renamed from: fadeTopHoldPx$delegate, reason: from kotlin metadata */
    private final Y8.h fadeTopHoldPx;

    /* renamed from: fadeTopPx$delegate, reason: from kotlin metadata */
    private final Y8.h fadeTopPx;
    private boolean hasPresentedContent;
    private boolean htmlFallbackDone;
    private Runnable htmlFallbackRunnable;
    private HtmlView htmlView;
    private boolean imeHeightFrozen;
    private float immersiveFraction;
    private Boolean lastChromeBlocking;
    private String lastInsetKey;
    private boolean loadUrlPaintSettled;
    private Runnable loadUrlSettleRunnable;
    private int lockedWebShiftPx;
    private final Handler mainHandler;
    private boolean markdownEdgeToEdge;
    private Runnable maskHideRunnable;
    private int maskHideToken;
    private Runnable maskProgressRunnable;
    private InterfaceC5074l<? super Boolean, Y8.t> onChromeBlockingChanged;
    private InterfaceC5063a<Y8.t> onContentMetricsChanged;
    private InterfaceC5063a<Y8.t> onContentScrollChanged;
    private p9.p<? super SessionArtifact, ? super Integer, Y8.t> onFolderChildClick;
    private InterfaceC5063a<Y8.t> onUserDragContent;
    private SessionArtifact pendingRenderArtifact;
    private boolean previewFetchInFlight;
    private int renderGeneration;
    private kotlinx.coroutines.g renderJob;
    private final Ua.M scope;
    private Runnable shapeFallbackRunnable;

    /* renamed from: snapshotBlurEffect$delegate, reason: from kotlin metadata */
    private final Y8.h snapshotBlurEffect;
    private boolean snapshotCapturePending;
    private boolean snapshotMaskActive;
    private int topInsetPx;
    private boolean touchAxisDecided;
    private final int touchAxisSlop;
    private float touchDownX;
    private float touchDownY;
    private boolean touchGrabbing;
    private float touchLastY;
    private final I0 viewportFade;
    private boolean webFullscreenHeightLocked;
    private boolean webPainted;
    private boolean webPreviewFailed;
    private boolean webRevealed;
    private boolean webShapeSettled;
    private boolean webviewFullscreen;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<tb.z> downloadClient$delegate = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.g
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ArtifactContentView.C0();
        }
    });

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/task/detail/render/ArtifactContentView$HtmlView;", "", "<init>", "(Ljava/lang/String;I)V", "PREVIEW", "CODE", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class HtmlView {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ HtmlView[] $VALUES;
        public static final HtmlView PREVIEW = new HtmlView("PREVIEW", 0);
        public static final HtmlView CODE = new HtmlView("CODE", 1);

        private static final /* synthetic */ HtmlView[] $values() {
            return new HtmlView[]{PREVIEW, CODE};
        }

        static {
            HtmlView[] htmlViewArr$values = $values();
            $VALUES = htmlViewArr$values;
            $ENTRIES = kotlin.enums.a.a(htmlViewArr$values);
        }

        private HtmlView(String str, int i10) {
        }

        public static InterfaceC4149a<HtmlView> getEntries() {
            return $ENTRIES;
        }

        public static HtmlView valueOf(String str) {
            return (HtmlView) Enum.valueOf(HtmlView.class, str);
        }

        public static HtmlView[] values() {
            return (HtmlView[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/task/detail/render/ArtifactContentView$a;", "", "<init>", "()V", "Ltb/z;", "downloadClient$delegate", "LY8/h;", Const.INTENT_KEY_PKGNAME, "()Ltb/z;", "downloadClient", "", "TAG", "Ljava/lang/String;", "", "RENDER_MASK_TIMEOUT_MS", "J", "HTML_PAINT_WAIT_MS", "HTML_DOWNLOAD_WAIT_MS", "RENDER_MASK_FADE_MS", "RENDER_MASK_PROGRESS_DELAY_MS", "", "SNAPSHOT_BLUR_RADIUS_DP", "F", "LOAD_URL_PAINT_SETTLE_MS", "HTML_FIRST_PAINT_TIMEOUT_MS", "SHAPE_SETTLE_FALLBACK_MS", "", "GATEWAY_CODE_FILE_BLOCKED", "I", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.detail.render.ArtifactContentView$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final tb.z b() {
            return (tb.z) ArtifactContentView.downloadClient$delegate.getValue();
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArtifactRenderKind.Kind.values().length];
            try {
                iArr[ArtifactRenderKind.Kind.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArtifactRenderKind.Kind.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArtifactRenderKind.Kind.CODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArtifactRenderKind.Kind.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ArtifactRenderKind.Kind.FILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ArtifactRenderKind.Kind.FALLBACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements View.OnLayoutChangeListener {
        public c() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            ArtifactContentView.this.d0();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements View.OnLayoutChangeListener {
        public d() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            ArtifactContentView.this.d0();
            ArtifactContentView.this.X1();
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/ailauncher/task/detail/render/ArtifactContentView$e", "LA1/g$b;", "LA1/g;", "request", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LA1/g;)V", Const.INTENT_KEY_APIKEY, "LA1/e;", "result", Const.INTENT_KEY_UMID, "(LA1/g;LA1/e;)V", "LA1/o;", "c", "(LA1/g;LA1/o;)V", "coil-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements g.b {
        final /* synthetic */ InterfaceC5063a $onFailRetry$inlined;
        final /* synthetic */ ArtifactContentView this$0;

        public e(InterfaceC5063a interfaceC5063a, ArtifactContentView artifactContentView, ArtifactContentView artifactContentView2) {
            this.$onFailRetry$inlined = interfaceC5063a;
            this.this$0 = artifactContentView;
        }

        @Override // A1.g.b
        public void a(A1.g request) {
        }

        @Override // A1.g.b
        public void b(A1.g request) {
        }

        @Override // A1.g.b
        public void c(A1.g request, A1.o result) {
            this.this$0.R0();
        }

        @Override // A1.g.b
        public void d(A1.g request, A1.e result) {
            C4148a.t(ArtifactContentView.TAG, "loadImageWithCoil coil load failed", result.getThrowable(), false, 8, null);
            InterfaceC5063a interfaceC5063a = this.$onFailRetry$inlined;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            } else {
                this.this$0.O1(M5.c.REASON_LOAD_FAILED, "preview");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f implements View.OnLayoutChangeListener {
        public f() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            ArtifactContentView.this.d0();
            ArtifactContentView.this.X1();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g implements View.OnLayoutChangeListener {
        final /* synthetic */ InterfaceC5063a $block$inlined;

        public g(InterfaceC5063a interfaceC5063a) {
            this.$block$inlined = interfaceC5063a;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            this.$block$inlined.invoke();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ArtifactContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final Y8.t B0(ArtifactContentView artifactContentView) {
        artifactContentView.setVisibility(0);
        return Y8.t.f7040a;
    }

    public static final tb.z C0() {
        z.a aVar = new z.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return aVar.g(30L, timeUnit).T(30L, timeUnit).W(30L, timeUnit).d();
    }

    public static final float E0(ArtifactContentView artifactContentView) {
        return artifactContentView.getResources().getDimension(R$dimen.artifact_detail_content_fade_bottom_hold);
    }

    public static final float F0(ArtifactContentView artifactContentView) {
        return artifactContentView.getResources().getDimension(R$dimen.artifact_detail_content_fade_bottom);
    }

    public static final float H0(ArtifactContentView artifactContentView) {
        return artifactContentView.getResources().getDimension(R$dimen.artifact_detail_content_fade_top_hold);
    }

    public static final void H1(ArtifactContentView artifactContentView, ProgressBar progressBar) {
        artifactContentView.maskProgressRunnable = null;
        FrameLayout resultRenderMask = artifactContentView.b.resultRenderMask;
        kotlin.jvm.internal.p.h(resultRenderMask, "resultRenderMask");
        if (resultRenderMask.getVisibility() == 0 && artifactContentView.snapshotMaskActive) {
            artifactContentView.G0(progressBar);
        }
    }

    public static final float I0(ArtifactContentView artifactContentView) {
        return artifactContentView.getResources().getDimension(R$dimen.artifact_detail_content_fade_top);
    }

    public static final void J1(ArtifactContentView artifactContentView) {
        if (artifactContentView.webShapeSettled) {
            return;
        }
        C4148a.u(TAG, "shape probe late, reveal with current shape", false, 4, null);
        artifactContentView.K1();
    }

    public static final Y8.t L0(ArtifactContentView artifactContentView, boolean z10, TaskWebView taskWebView, String url, InterfaceC5063a interfaceC5063a) {
        kotlin.jvm.internal.p.i(url, "url");
        artifactContentView.N0(url, z10, taskWebView, interfaceC5063a);
        return Y8.t.f7040a;
    }

    public static final Y8.t M0(String str, ArtifactContentView artifactContentView, SessionArtifact sessionArtifact, boolean z10, TaskWebView taskWebView, Throwable th) {
        C4148a.u(TAG, "fetchTextAndRender getDownloadUrl failed, fallback to cloudPath. fileId=" + str + " e=" + th, false, 4, null);
        if (artifactContentView.Y0(th)) {
            artifactContentView.O1(artifactContentView.l1(th), "preview");
        } else {
            String cloudPath = sessionArtifact.getCloudPath();
            if (cloudPath == null) {
                cloudPath = "";
            }
            O0(artifactContentView, cloudPath, z10, taskWebView, null, 8, null);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t N(ArtifactContentView artifactContentView, Integer num) {
        String str;
        if (!artifactContentView.webPreviewFailed) {
            artifactContentView.p0();
            if (!artifactContentView.b.resultWeb.getLoadedViaData() || (str = artifactContentView.currentHtmlSource) == null || str.length() == 0) {
                artifactContentView.O1(artifactContentView.k1(num), "preview");
            } else {
                artifactContentView.F1();
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t O(ArtifactContentView artifactContentView) {
        if (!artifactContentView.webPreviewFailed && artifactContentView.awaitingWebPaint && !artifactContentView.webPainted) {
            artifactContentView.webPainted = true;
            artifactContentView.p0();
            artifactContentView.I1();
            artifactContentView.C1();
            InterfaceC5063a<Y8.t> interfaceC5063a = artifactContentView.onContentMetricsChanged;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void O0(ArtifactContentView artifactContentView, String str, boolean z10, TaskWebView taskWebView, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            interfaceC5063a = null;
        }
        artifactContentView.N0(str, z10, taskWebView, interfaceC5063a);
    }

    public static final Y8.t P(ArtifactContentView artifactContentView) {
        if (artifactContentView.awaitingWebPaint) {
            artifactContentView.K1();
        }
        return Y8.t.f7040a;
    }

    public static final void P1(SessionArtifact sessionArtifact, String str, String str2, ArtifactContentView artifactContentView, View view) {
        String fileId;
        if (sessionArtifact != null) {
            M5.c.INSTANCE.w(sessionArtifact, str, "retry", str2);
        }
        if (sessionArtifact != null && (fileId = sessionArtifact.getFileId()) != null) {
            if (La.H.x0(fileId)) {
                fileId = null;
            }
            if (fileId != null) {
                C5581d c5581d = C5581d.INSTANCE;
                C5578a c5578a = C5578a.INSTANCE;
                c5581d.e(c5578a.a(fileId));
                c5581d.e(c5578a.b(fileId, "html", null));
            }
        }
        if (sessionArtifact != null) {
            artifactContentView.o1(sessionArtifact);
        }
    }

    public static final Y8.t Q(ArtifactContentView artifactContentView) {
        C4148a.k("PptTrace", "viewportHeightChanged view=" + System.identityHashCode(artifactContentView) + " generation=" + artifactContentView.renderGeneration + " fullscreen=" + artifactContentView.webviewFullscreen + " revealed=" + artifactContentView.webRevealed + " web=" + artifactContentView.b.resultWeb.getWidth() + "x" + artifactContentView.b.resultWeb.getHeight() + " viewport=" + artifactContentView.b.resultViewport.getWidth() + "x" + artifactContentView.b.resultViewport.getHeight(), false, 4, null);
        if (artifactContentView.webviewFullscreen && artifactContentView.webShapeSettled && !artifactContentView.webRevealed) {
            artifactContentView.lastInsetKey = null;
            artifactContentView.d0();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t R(ArtifactContentView artifactContentView, boolean z10) {
        if (!artifactContentView.webRevealed) {
            artifactContentView.k0(z10);
        }
        artifactContentView.X1();
        InterfaceC5063a<Y8.t> interfaceC5063a = artifactContentView.onContentMetricsChanged;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t S(ArtifactContentView artifactContentView) {
        InterfaceC5063a<Y8.t> interfaceC5063a = artifactContentView.onContentMetricsChanged;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static final void S1(ArtifactContentView artifactContentView, Ref$LongRef ref$LongRef, FrameLayout frameLayout, Ref$ObjectRef ref$ObjectRef) {
        String str;
        if (artifactContentView.webPreviewFailed || artifactContentView.webRevealed) {
            return;
        }
        Runnable runnable = null;
        if (!artifactContentView.b.resultWeb.getLoadedViaData() || (str = artifactContentView.currentHtmlSource) == null || str.length() == 0) {
            if (artifactContentView.previewFetchInFlight) {
                long j10 = ref$LongRef.f34819a;
                if (j10 < 8000) {
                    ref$LongRef.f34819a = j10 + 4000;
                    T t10 = ref$ObjectRef.f34820a;
                    if (t10 == 0) {
                        kotlin.jvm.internal.p.A("timeout");
                    } else {
                        runnable = (Runnable) t10;
                    }
                    frameLayout.postDelayed(runnable, 4000L);
                    return;
                }
            }
            C4148a.u(TAG, "preview load timeout", false, 4, null);
            artifactContentView.O1(M5.c.REASON_LOAD_FAILED, "preview");
            return;
        }
        if (!artifactContentView.webPainted) {
            long j11 = ref$LongRef.f34819a;
            if (j11 < HTML_PAINT_WAIT_MS) {
                long j12 = j11 + 4000;
                ref$LongRef.f34819a = j12;
                C4148a.k(TAG, "html loaded, hold mask until first paint waited=" + j12 + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
                T t11 = ref$ObjectRef.f34820a;
                if (t11 == 0) {
                    kotlin.jvm.internal.p.A("timeout");
                } else {
                    runnable = (Runnable) t11;
                }
                frameLayout.postDelayed(runnable, 4000L);
                return;
            }
        }
        artifactContentView.F1();
    }

    public static final Y8.t T(ArtifactContentView artifactContentView) {
        InterfaceC5063a<Y8.t> interfaceC5063a = artifactContentView.onContentScrollChanged;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t T0(int i10, ArtifactContentView artifactContentView, FrameLayout frameLayout, ProgressBar progressBar) {
        if (i10 != artifactContentView.maskHideToken) {
            return Y8.t.f7040a;
        }
        frameLayout.setVisibility(8);
        frameLayout.setAlpha(1.0f);
        progressBar.setVisibility(8);
        progressBar.setAlpha(0.0f);
        artifactContentView.v0();
        artifactContentView.snapshotMaskActive = false;
        if (!artifactContentView.webPreviewFailed) {
            FrameLayout resultInvalid = artifactContentView.b.resultInvalid;
            kotlin.jvm.internal.p.h(resultInvalid, "resultInvalid");
            resultInvalid.setVisibility(8);
        }
        artifactContentView.hasPresentedContent = true;
        artifactContentView.y0();
        return Y8.t.f7040a;
    }

    public static final RenderEffect T1(ArtifactContentView artifactContentView) {
        float f10 = artifactContentView.getResources().getDisplayMetrics().density * SNAPSHOT_BLUR_RADIUS_DP;
        return RenderEffect.createBlurEffect(f10, f10, Shader.TileMode.CLAMP);
    }

    public static final void U(ArtifactContentView artifactContentView, View view, int i10, int i11, int i12, int i13) {
        InterfaceC5063a<Y8.t> interfaceC5063a = artifactContentView.onContentScrollChanged;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void U0(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public static final void V(ArtifactContentView artifactContentView, View view, int i10, int i11, int i12, int i13) {
        InterfaceC5063a<Y8.t> interfaceC5063a = artifactContentView.onContentScrollChanged;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final Y8.t a1(ArtifactContentView artifactContentView, ImageView imageView, String str, boolean z10, String url, InterfaceC5063a interfaceC5063a) {
        kotlin.jvm.internal.p.i(url, "url");
        artifactContentView.c1(imageView, url, str, interfaceC5063a, z10);
        return Y8.t.f7040a;
    }

    public static final Y8.t b1(String str, ArtifactContentView artifactContentView, ImageView imageView, String str2, String str3, boolean z10, Throwable th) {
        C4148a.u(TAG, "loadImageFromDownloadUrl getDownloadUrl failed, fallback to content. fileId=" + str + " e=" + th, false, 4, null);
        if (artifactContentView.Y0(th)) {
            artifactContentView.O1(artifactContentView.l1(th), "preview");
        } else {
            d1(artifactContentView, imageView, str2, str3, null, z10, 8, null);
        }
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d1(ArtifactContentView artifactContentView, ImageView imageView, Object obj, String str, InterfaceC5063a interfaceC5063a, boolean z10, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            str = null;
        }
        if ((i10 & 8) != 0) {
            interfaceC5063a = null;
        }
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        artifactContentView.c1(imageView, obj, str, interfaceC5063a, z10);
    }

    public static final Y8.t e0(ArtifactContentView artifactContentView, int i10) {
        artifactContentView.docTopOnScreen = i10;
        artifactContentView.W1();
        artifactContentView.X1();
        return Y8.t.f7040a;
    }

    public static final void f1(ArtifactContentView artifactContentView) {
        artifactContentView.V1();
    }

    private final float getFadeBottomHoldPx() {
        return ((Number) this.fadeBottomHoldPx.getValue()).floatValue();
    }

    private final float getFadeBottomPx() {
        return ((Number) this.fadeBottomPx.getValue()).floatValue();
    }

    private final float getFadeTopHoldPx() {
        return ((Number) this.fadeTopHoldPx.getValue()).floatValue();
    }

    private final float getFadeTopPx() {
        return ((Number) this.fadeTopPx.getValue()).floatValue();
    }

    private final RenderEffect getSnapshotBlurEffect() {
        return (RenderEffect) this.snapshotBlurEffect.getValue();
    }

    public static final Y8.t j1(ArtifactContentView artifactContentView, String str, InterfaceC5063a interfaceC5063a) {
        FrameLayout resultViewport = artifactContentView.b.resultViewport;
        kotlin.jvm.internal.p.h(resultViewport, "resultViewport");
        resultViewport.setPadding(resultViewport.getPaddingLeft(), 0, resultViewport.getPaddingRight(), 0);
        artifactContentView.lastInsetKey = str;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static final void m0(ArtifactContentView artifactContentView) {
        artifactContentView.loadUrlSettleRunnable = null;
        if (artifactContentView.webRevealed || artifactContentView.webPreviewFailed) {
            return;
        }
        artifactContentView.loadUrlPaintSettled = true;
        artifactContentView.X1();
    }

    public static final Y8.t p1(ArtifactContentView artifactContentView, int i10, SessionArtifact sessionArtifact, Bitmap bitmap) {
        artifactContentView.snapshotCapturePending = false;
        if (i10 != artifactContentView.renderGeneration) {
            if (bitmap != null) {
                bitmap.recycle();
            }
            return Y8.t.f7040a;
        }
        SessionArtifact sessionArtifact2 = artifactContentView.pendingRenderArtifact;
        if (sessionArtifact2 != null) {
            sessionArtifact = sessionArtifact2;
        }
        artifactContentView.A0(sessionArtifact, bitmap, false);
        return Y8.t.f7040a;
    }

    public static final Y8.t s1(ArtifactContentView artifactContentView, String url) {
        kotlin.jvm.internal.p.i(url, "url");
        artifactContentView.x1(url);
        return Y8.t.f7040a;
    }

    public static final Y8.t t1(String str, ArtifactContentView artifactContentView, Throwable th) {
        C4148a.u(TAG, "renderFilePart getPreviewUrl(html) failed fileId=" + str + " e=" + th, false, 4, null);
        artifactContentView.O1(artifactContentView.l1(th), "preview");
        return Y8.t.f7040a;
    }

    public static final void u0(InterfaceC5074l interfaceC5074l, ArtifactContentView artifactContentView, Bitmap bitmap, int i10) {
        if (i10 == 0) {
            interfaceC5074l.invoke(artifactContentView.D0(bitmap));
        } else {
            bitmap.recycle();
            interfaceC5074l.invoke(null);
        }
    }

    public static final void v1(ArtifactContentView artifactContentView, SessionArtifact sessionArtifact, int i10, View view) {
        p9.p<? super SessionArtifact, ? super Integer, Y8.t> pVar = artifactContentView.onFolderChildClick;
        if (pVar != null) {
            pVar.invoke(sessionArtifact, Integer.valueOf(i10));
        }
    }

    public static final Y8.t w1(ArtifactContentView artifactContentView) {
        artifactContentView.setVisibility(0);
        return Y8.t.f7040a;
    }

    public static final Y8.t y1(ArtifactContentView artifactContentView, String it) {
        kotlin.jvm.internal.p.i(it, "it");
        C4148a.u(TAG, "html treated as download, fallback to fetch+loadHtmlData", false, 4, null);
        artifactContentView.J0();
        return Y8.t.f7040a;
    }

    public static final Y8.t z0(ArtifactContentView artifactContentView, Canvas it) {
        kotlin.jvm.internal.p.i(it, "it");
        super.dispatchDraw(it);
        return Y8.t.f7040a;
    }

    public static final void z1(ArtifactContentView artifactContentView, TaskWebView taskWebView) {
        C4148a.u("PptTrace", "html first-paint timeout generation=" + artifactContentView.renderGeneration + " web=" + System.identityHashCode(taskWebView) + " size=" + taskWebView.getWidth() + "x" + taskWebView.getHeight() + "; fallback to fetch+loadHtmlData", false, 4, null);
        artifactContentView.J0();
    }

    public final void A0(SessionArtifact a10, Bitmap snapshot, boolean keepSnapshot) {
        this.pendingRenderArtifact = null;
        D1(a10);
        A1(a10, snapshot, keepSnapshot);
        InterfaceC5063a<Y8.t> interfaceC5063a = this.onContentMetricsChanged;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        a2(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactContentView.B0(this.f28720a);
            }
        });
    }

    public final void A1(SessionArtifact a10, Bitmap snapshot, boolean keepSnapshot) {
        String fileId = a10.getFileId();
        String mimeType = a10.getMimeType();
        String fileName = a10.getFileName();
        String title = a10.getTitle();
        String cloudPath = a10.getCloudPath();
        String lowerCase = null;
        C4148a.k(TAG, "renderPart fileId=" + fileId + " mimeType=" + mimeType + " fileName=" + fileName + " title=" + title + " cloudPath=" + (cloudPath != null ? La.K.R1(cloudPath, 80) : null), false, 4, null);
        int i10 = this.renderGeneration;
        ArtifactRenderKind artifactRenderKind = ArtifactRenderKind.INSTANCE;
        C4148a.k("PptTrace", "renderPart generation=" + i10 + " kind=" + artifactRenderKind.g(a10) + " web=" + System.identityHashCode(this.b.resultWeb) + " host=" + getWidth() + "x" + getHeight(), false, 4, null);
        ArtifactRenderKind.Kind kindG = artifactRenderKind.g(a10);
        h0(kindG == ArtifactRenderKind.Kind.TEXT || kindG == ArtifactRenderKind.Kind.CODE);
        n1(kindG);
        if (kindG != ArtifactRenderKind.Kind.FALLBACK) {
            this.webPreviewFailed = false;
            this.previewFetchInFlight = true;
            R1(snapshot, keepSnapshot);
        }
        switch (b.$EnumSwitchMapping$0[kindG.ordinal()]) {
            case 1:
            case 2:
            case 3:
                Q1(this.b.resultWeb);
                TaskWebView resultWeb = this.b.resultWeb;
                kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
                K0(a10, resultWeb);
                return;
            case 4:
                String fileId2 = a10.getFileId();
                if (fileId2 == null || La.H.x0(fileId2)) {
                    B1(a10);
                    return;
                }
                kotlinx.coroutines.g gVar = this.renderJob;
                if (gVar != null) {
                    kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                }
                Q1(this.b.resultImage);
                String strC = artifactRenderKind.c(a10);
                if (strC != null) {
                    lowerCase = strC.toLowerCase(Locale.ROOT);
                    kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
                }
                boolean z10 = !kotlin.jvm.internal.p.d(lowerCase, "svg");
                ImageView resultImage = this.b.resultImage;
                kotlin.jvm.internal.p.h(resultImage, "resultImage");
                String cloudPath2 = a10.getCloudPath();
                if (cloudPath2 == null) {
                    cloudPath2 = "";
                }
                Z0(resultImage, fileId2, cloudPath2, z10);
                return;
            case 5:
                r1(a10);
                return;
            case 6:
                B1(a10);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void B1(SessionArtifact a10) {
        kotlinx.coroutines.g gVar = this.renderJob;
        String shortFileSize = null;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        R0();
        M5.c cVar = M5.c.INSTANCE;
        String sessionId = a10.getSessionId();
        if (sessionId == null || sessionId.length() <= 0) {
            sessionId = null;
        }
        cVar.x(a10, sessionId, M5.c.REASON_FORMAT_UNSUPPORTED, "preview");
        Q1(this.b.resultFallbackScroll);
        this.hasPresentedContent = true;
        String strN0 = n0(a10);
        Long size = a10.getSize();
        if (size != null) {
            if (size.longValue() <= 0) {
                size = null;
            }
            if (size != null) {
                shortFileSize = Formatter.formatShortFileSize(getContext(), size.longValue());
            }
        }
        TextView textView = this.b.resultFallback;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strN0);
        if (shortFileSize != null && shortFileSize.length() != 0) {
            sb2.append("\n");
            sb2.append(shortFileSize);
        }
        sb2.append("\n\n");
        sb2.append(getContext().getString(R$string.task_detail_preview_unsupported));
        textView.setText(sb2.toString());
    }

    public final void C1() {
        this.lastInsetKey = null;
        this.docTopOnScreen = 0;
        this.docTopRequested = Integer.MIN_VALUE;
    }

    public final Bitmap D0(Bitmap src) {
        int iF = C5685n.f(src.getWidth() / 4, 1);
        int iF2 = C5685n.f(src.getHeight() / 4, 1);
        if (iF == src.getWidth() && iF2 == src.getHeight()) {
            return src;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(src, iF, iF2, false);
        kotlin.jvm.internal.p.h(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        src.recycle();
        return bitmapCreateScaledBitmap;
    }

    public final void D1(SessionArtifact a10) {
        this.current = a10;
        this.htmlView = HtmlView.PREVIEW;
        this.codeLoaded = false;
        this.currentHtmlSource = null;
        C1();
        this.webPainted = false;
        this.webShapeSettled = false;
        this.webRevealed = false;
        this.webFullscreenHeightLocked = false;
        this.lockedWebShiftPx = 0;
        this.awaitingWebPaint = false;
        this.loadUrlPaintSettled = false;
        q0();
        s0();
        E1();
    }

    public final void E1() {
        TaskWebView resultWeb = this.b.resultWeb;
        kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
        resultWeb.setScaleY(1.0f);
        resultWeb.setTranslationY(0.0f);
        ViewGroup.LayoutParams layoutParams = resultWeb.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        if (layoutParams2.topMargin == 0 && layoutParams2.height == -1) {
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = resultWeb.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        layoutParams4.topMargin = 0;
        resultWeb.setLayoutParams(layoutParams4);
    }

    public final void F1() {
        if (this.webPreviewFailed || this.webRevealed) {
            return;
        }
        C4148a.u(TAG, "html data loaded, reveal without first paint", false, 4, null);
        if (!this.webPainted) {
            this.webPainted = true;
        }
        if (!this.webShapeSettled) {
            K1();
        }
        if (this.webRevealed) {
            return;
        }
        g1();
    }

    public final void G0(View view) {
        if (view.getVisibility() == 0 && view.getAlpha() >= 1.0f) {
            view.setAlpha(1.0f);
            return;
        }
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().alpha(1.0f).setDuration(100L).withEndAction(null).start();
    }

    public final void G1() {
        r0(true);
        final ProgressBar resultRenderMaskProgress = this.b.resultRenderMaskProgress;
        kotlin.jvm.internal.p.h(resultRenderMaskProgress, "resultRenderMaskProgress");
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.task.detail.render.D
            @Override // java.lang.Runnable
            public final void run() {
                ArtifactContentView.H1(this.f28681a, resultRenderMaskProgress);
            }
        };
        this.maskProgressRunnable = runnable;
        this.b.resultRenderMask.postDelayed(runnable, 1000L);
    }

    public final void I1() {
        s0();
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.task.detail.render.m
            @Override // java.lang.Runnable
            public final void run() {
                ArtifactContentView.J1(this.f28707a);
            }
        };
        this.shapeFallbackRunnable = runnable;
        this.b.resultWeb.postDelayed(runnable, 1200L);
    }

    public final void J0() {
        if (this.htmlFallbackDone) {
            return;
        }
        this.htmlFallbackDone = true;
        p0();
        String str = this.currentHtmlUrl;
        if (str == null) {
            return;
        }
        C4148a.u("PptTrace", "fallbackFetchHtml generation=" + this.renderGeneration + " url=" + La.K.S1(La.H.w1(str, '?', null, 2, null), com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME) + " web=" + System.identityHashCode(this.b.resultWeb), false, 4, null);
        TaskWebView resultWeb = this.b.resultWeb;
        kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
        O0(this, str, true, resultWeb, null, 8, null);
    }

    public final void K0(final SessionArtifact a10, final TaskWebView web) {
        final boolean z10 = ArtifactRenderKind.INSTANCE.g(a10) == ArtifactRenderKind.Kind.HTML;
        final String fileId = a10.getFileId();
        if (fileId == null || La.H.x0(fileId)) {
            String cloudPath = a10.getCloudPath();
            if (cloudPath == null) {
                cloudPath = "";
            }
            O0(this, cloudPath, z10, web, null, 8, null);
            return;
        }
        kotlinx.coroutines.g gVar = this.renderJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        final boolean z11 = z10;
        u6.i.h(u6.i.INSTANCE, fileId, false, new p9.p() { // from class: com.stepos.ailauncher.task.detail.render.A
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ArtifactContentView.L0(this.f28668a, z10, web, (String) obj, (InterfaceC5063a) obj2);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.render.B
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactContentView.M0(fileId, this, a10, z11, web, (Throwable) obj);
            }
        }, 2, null);
    }

    public final void K1() {
        if (this.webShapeSettled || this.webRevealed || this.webPreviewFailed) {
            return;
        }
        s0();
        this.webShapeSettled = true;
        if (!this.webviewFullscreen) {
            d0();
            X1();
            return;
        }
        TaskWebView resultWeb = this.b.resultWeb;
        kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
        if (!resultWeb.isLaidOut() || resultWeb.isLayoutRequested()) {
            resultWeb.addOnLayoutChangeListener(new f());
        } else {
            d0();
            X1();
        }
    }

    public final boolean L1() {
        return this.hasPresentedContent && !W0() && getWidth() > 0 && getHeight() > 0;
    }

    public final void M1() {
        O1("content_blocked", "preview");
    }

    public final void N0(String url, boolean asHtml, TaskWebView web, InterfaceC5063a<Y8.t> onFailRetry) {
        kotlinx.coroutines.g gVar = this.renderJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.renderJob = C1060i.d(this.scope, null, null, new ArtifactContentView$fetchTextWithUrl$1(onFailRetry, this, web, asHtml, url, null), 3, null);
    }

    public final void N1() {
        O1("file_not_found", "preview");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O1(final java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 1
            r8.webPreviewFailed = r0
            r1 = 0
            r8.awaitingWebPaint = r1
            r8.s0()
            com.stepos.ailauncher.contract.model.SessionArtifact r2 = r8.current
            r3 = 0
            if (r2 == 0) goto L1b
            java.lang.String r4 = r2.getSessionId()
            if (r4 == 0) goto L1b
            int r5 = r4.length()
            if (r5 <= 0) goto L1b
            r3 = r4
        L1b:
            if (r2 == 0) goto L22
            M5.c r4 = M5.c.INSTANCE
            r4.x(r2, r3, r9, r10)
        L22:
            r8.h0(r1)
            r8.S0(r0)
            r6.q r10 = r8.b
            android.widget.FrameLayout r10 = r10.resultInvalid
            r8.Q1(r10)
            r8.hasPresentedContent = r0
            r6.q r10 = r8.b
            android.widget.ImageView r10 = r10.resultInvalidIcon
            int r0 = r9.hashCode()
            r4 = -750936650(0xffffffffd33d9db6, float:-8.143948E11)
            java.lang.String r5 = "file_not_found"
            java.lang.String r6 = "link_expired"
            java.lang.String r7 = "load_failed"
            if (r0 == r4) goto L60
            r4 = -690733037(0xffffffffd6d44013, float:-1.1668583E14)
            if (r0 == r4) goto L56
            r4 = 2137940960(0x7f6e63e0, float:3.1687484E38)
            if (r0 == r4) goto L4f
            goto L66
        L4f:
            boolean r0 = r9.equals(r6)
            if (r0 != 0) goto L5d
            goto L66
        L56:
            boolean r0 = r9.equals(r5)
            if (r0 != 0) goto L5d
            goto L66
        L5d:
            int r0 = com.stepos.ailauncher.task.R$drawable.ic_artifact_invalid_expired
            goto L6b
        L60:
            boolean r0 = r9.equals(r7)
            if (r0 != 0) goto L69
        L66:
            int r0 = com.stepos.ailauncher.task.R$drawable.ic_artifact_invalid_warning
            goto L6b
        L69:
            int r0 = com.stepos.ailauncher.task.R$drawable.ic_artifact_invalid_network
        L6b:
            r10.setImageResource(r0)
            r6.q r10 = r8.b
            android.widget.TextView r10 = r10.resultInvalidReason
            int r0 = r9.hashCode()
            switch(r0) {
                case -750936650: goto L97;
                case -690733037: goto L8d;
                case 400831526: goto L81;
                case 2137940960: goto L7a;
                default: goto L79;
            }
        L79:
            goto L9d
        L7a:
            boolean r0 = r9.equals(r6)
            if (r0 == 0) goto L9d
            goto L94
        L81:
            java.lang.String r0 = "content_blocked"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L8a
            goto L9d
        L8a:
            int r0 = com.stepos.ailauncher.task.R$string.task_detail_invalid_content_blocked
            goto La2
        L8d:
            boolean r0 = r9.equals(r5)
            if (r0 != 0) goto L94
            goto L9d
        L94:
            int r0 = com.stepos.ailauncher.task.R$string.task_detail_invalid_not_found
            goto La2
        L97:
            boolean r0 = r9.equals(r7)
            if (r0 != 0) goto La0
        L9d:
            int r0 = com.stepos.ailauncher.task.R$string.task_detail_invalid_load_failed
            goto La2
        La0:
            int r0 = com.stepos.ailauncher.task.R$string.task_detail_invalid_network
        La2:
            r10.setText(r0)
            boolean r10 = kotlin.jvm.internal.p.d(r9, r7)
            r6.q r0 = r8.b
            android.widget.TextView r0 = r0.resultInvalidRetry
            java.lang.String r4 = "resultInvalidRetry"
            kotlin.jvm.internal.p.h(r0, r4)
            if (r10 == 0) goto Lb6
            goto Lb8
        Lb6:
            r1 = 8
        Lb8:
            r0.setVisibility(r1)
            r6.q r10 = r8.b
            android.widget.TextView r10 = r10.resultInvalidRetry
            com.stepos.ailauncher.task.detail.render.n r0 = new com.stepos.ailauncher.task.detail.render.n
            r0.<init>()
            r10.setOnClickListener(r0)
            r8.y0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.render.ArtifactContentView.O1(java.lang.String, java.lang.String):void");
    }

    public final void P0(View child) {
        int height;
        if (child.getVisibility() != 0 || (height = child.getHeight()) <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.height = height;
        child.setLayoutParams(layoutParams);
    }

    public final void Q0() {
        int height;
        if (!this.imeHeightFrozen && (height = getHeight()) > 0) {
            this.imeHeightFrozen = true;
            ViewParent parent = getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.setClipChildren(true);
            }
            setClipChildren(true);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.height = height;
            setLayoutParams(layoutParams);
            if (!this.webviewFullscreen) {
                TaskWebView resultWeb = this.b.resultWeb;
                kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
                P0(resultWeb);
            }
            ImageView resultImage = this.b.resultImage;
            kotlin.jvm.internal.p.h(resultImage, "resultImage");
            P0(resultImage);
            ScrollView resultFallbackScroll = this.b.resultFallbackScroll;
            kotlin.jvm.internal.p.h(resultFallbackScroll, "resultFallbackScroll");
            P0(resultFallbackScroll);
            ScrollView resultFolderScroll = this.b.resultFolderScroll;
            kotlin.jvm.internal.p.h(resultFolderScroll, "resultFolderScroll");
            P0(resultFolderScroll);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q1(android.view.View r7) {
        /*
            r6 = this;
            r6.q r0 = r6.b
            com.stepos.ailauncher.task.detail.TaskWebView r0 = r0.resultWeb
            java.lang.String r1 = "resultWeb"
            kotlin.jvm.internal.p.h(r0, r1)
            r6.q r1 = r6.b
            com.stepos.ailauncher.task.detail.TaskWebView r1 = r1.resultWeb
            r2 = 1
            r3 = 0
            if (r7 != r1) goto L14
            r1 = r2
            goto L15
        L14:
            r1 = r3
        L15:
            r4 = 8
            if (r1 == 0) goto L1b
            r1 = r3
            goto L1c
        L1b:
            r1 = r4
        L1c:
            r0.setVisibility(r1)
            r6.q r0 = r6.b
            android.widget.ImageView r0 = r0.resultImage
            java.lang.String r1 = "resultImage"
            kotlin.jvm.internal.p.h(r0, r1)
            r6.q r1 = r6.b
            android.widget.ImageView r1 = r1.resultImage
            if (r7 != r1) goto L31
            r1 = r2
            goto L32
        L31:
            r1 = r3
        L32:
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            r1 = r4
        L37:
            r0.setVisibility(r1)
            r6.q r0 = r6.b
            android.widget.ScrollView r0 = r0.resultFallbackScroll
            java.lang.String r1 = "resultFallbackScroll"
            kotlin.jvm.internal.p.h(r0, r1)
            r6.q r1 = r6.b
            android.widget.ScrollView r1 = r1.resultFallbackScroll
            if (r7 != r1) goto L4c
            r1 = r2
            goto L4d
        L4c:
            r1 = r3
        L4d:
            if (r1 == 0) goto L51
            r1 = r3
            goto L52
        L51:
            r1 = r4
        L52:
            r0.setVisibility(r1)
            r6.q r0 = r6.b
            android.widget.ScrollView r0 = r0.resultFolderScroll
            java.lang.String r1 = "resultFolderScroll"
            kotlin.jvm.internal.p.h(r0, r1)
            r6.q r1 = r6.b
            android.widget.ScrollView r1 = r1.resultFolderScroll
            if (r7 != r1) goto L67
            r1 = r2
            goto L68
        L67:
            r1 = r3
        L68:
            if (r1 == 0) goto L6c
            r1 = r3
            goto L6d
        L6c:
            r1 = r4
        L6d:
            r0.setVisibility(r1)
            r6.q r0 = r6.b
            android.widget.FrameLayout r0 = r0.resultInvalid
            java.lang.String r1 = "resultInvalid"
            kotlin.jvm.internal.p.h(r0, r1)
            r6.q r5 = r6.b
            android.widget.FrameLayout r5 = r5.resultInvalid
            if (r7 == r5) goto L9b
            kotlin.jvm.internal.p.h(r5, r1)
            int r7 = r5.getVisibility()
            if (r7 != 0) goto L9a
            r6.q r7 = r6.b
            android.widget.FrameLayout r7 = r7.resultRenderMask
            java.lang.String r1 = "resultRenderMask"
            kotlin.jvm.internal.p.h(r7, r1)
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L9a
            goto L9b
        L9a:
            r2 = r3
        L9b:
            if (r2 == 0) goto L9e
            r4 = r3
        L9e:
            r0.setVisibility(r4)
            r6.k0(r3)
            r6.U1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.render.ArtifactContentView.Q1(android.view.View):void");
    }

    public final void R0() {
        S0(true);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, com.stepos.ailauncher.task.detail.render.C] */
    public final void R1(Bitmap snapshot, boolean keepSnapshot) {
        Runnable runnable;
        final FrameLayout resultRenderMask = this.b.resultRenderMask;
        kotlin.jvm.internal.p.h(resultRenderMask, "resultRenderMask");
        this.maskHideToken++;
        resultRenderMask.animate().cancel();
        if (!keepSnapshot || !this.snapshotMaskActive) {
            if (snapshot != null) {
                i0(snapshot);
            } else {
                j0();
            }
        }
        Runnable runnable2 = this.maskHideRunnable;
        if (runnable2 != null) {
            resultRenderMask.removeCallbacks(runnable2);
        }
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? r12 = new Runnable() { // from class: com.stepos.ailauncher.task.detail.render.C
            @Override // java.lang.Runnable
            public final void run() {
                ArtifactContentView.S1(this.f28677a, ref$LongRef, resultRenderMask, ref$ObjectRef);
            }
        };
        ref$ObjectRef.f34820a = r12;
        this.maskHideRunnable = (Runnable) r12;
        T t10 = ref$ObjectRef.f34820a;
        if (t10 == 0) {
            kotlin.jvm.internal.p.A("timeout");
            runnable = null;
        } else {
            runnable = (Runnable) t10;
        }
        resultRenderMask.postDelayed(runnable, 4000L);
        G0(resultRenderMask);
        if (this.snapshotMaskActive) {
            G1();
        } else {
            r0(true);
        }
        y0();
    }

    public final void S0(boolean fade) {
        this.previewFetchInFlight = false;
        Runnable runnable = this.maskHideRunnable;
        if (runnable != null) {
            this.b.resultRenderMask.removeCallbacks(runnable);
        }
        this.maskHideRunnable = null;
        r0(false);
        final FrameLayout resultRenderMask = this.b.resultRenderMask;
        kotlin.jvm.internal.p.h(resultRenderMask, "resultRenderMask");
        final ProgressBar resultRenderMaskProgress = this.b.resultRenderMaskProgress;
        kotlin.jvm.internal.p.h(resultRenderMaskProgress, "resultRenderMaskProgress");
        final int i10 = this.maskHideToken + 1;
        this.maskHideToken = i10;
        resultRenderMask.animate().cancel();
        resultRenderMaskProgress.animate().cancel();
        final InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactContentView.T0(i10, this, resultRenderMask, resultRenderMaskProgress);
            }
        };
        if (!fade || resultRenderMask.getVisibility() != 0 || resultRenderMask.getAlpha() <= 0.0f) {
            interfaceC5063a.invoke();
            return;
        }
        if (resultRenderMaskProgress.getVisibility() == 0 && resultRenderMaskProgress.getAlpha() > 0.0f) {
            resultRenderMaskProgress.animate().alpha(0.0f).setDuration(100L).start();
        }
        resultRenderMask.animate().alpha(0.0f).setDuration(100L).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.task.detail.render.p
            @Override // java.lang.Runnable
            public final void run() {
                ArtifactContentView.U0(interfaceC5063a);
            }
        }).start();
    }

    public final void U1() {
        if ((this.immersiveFraction > 0.5f || !o0()) ? I0.d(this.viewportFade, 0.0f, 0.0f, 0.0f, 0.0f, 12, null) : this.viewportFade.c(getFadeTopPx(), getFadeBottomPx(), getFadeTopHoldPx(), getFadeBottomHoldPx())) {
            invalidate();
        }
    }

    public final boolean V0(FileStorageException.GatewayException.Other e10) {
        if (e10.getCode() == GATEWAY_CODE_FILE_BLOCKED) {
            return true;
        }
        String message = e10.getMessage();
        if (message == null) {
            message = "";
        }
        return La.H.e0(message, "safety audit", true);
    }

    public final void V1() {
        if (this.imeHeightFrozen) {
            return;
        }
        if (this.webviewFullscreen) {
            W1();
            return;
        }
        this.webFullscreenHeightLocked = false;
        this.lockedWebShiftPx = 0;
        TaskWebView resultWeb = this.b.resultWeb;
        kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
        ViewGroup.LayoutParams layoutParams = resultWeb.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null && (layoutParams2.height != -1 || layoutParams2.topMargin != 0)) {
            ViewGroup.LayoutParams layoutParams3 = resultWeb.getLayoutParams();
            if (layoutParams3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            layoutParams4.height = -1;
            layoutParams4.topMargin = 0;
            resultWeb.setLayoutParams(layoutParams4);
            return;
        }
        ViewGroup.LayoutParams layoutParams5 = resultWeb.getLayoutParams();
        if (layoutParams5 == null || layoutParams5.height != -1) {
            ViewGroup.LayoutParams layoutParams6 = resultWeb.getLayoutParams();
            if (layoutParams6 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams6.height = -1;
            resultWeb.setLayoutParams(layoutParams6);
        }
    }

    public final boolean W0() {
        FrameLayout resultRenderMask = this.b.resultRenderMask;
        kotlin.jvm.internal.p.h(resultRenderMask, "resultRenderMask");
        return resultRenderMask.getVisibility() == 0 && this.b.resultRenderMask.getAlpha() > 0.0f;
    }

    public final void W1() {
        TaskWebView resultWeb = this.b.resultWeb;
        kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
        resultWeb.setScaleY(1.0f);
        resultWeb.setTranslationY(0.0f);
        View rootView = getRootView();
        if (rootView != null) {
            Integer numValueOf = Integer.valueOf(rootView.getHeight());
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                int iF = this.webFullscreenHeightLocked ? this.lockedWebShiftPx : C5685n.f(this.topInsetPx, 0);
                int i10 = iIntValue + iF;
                int i11 = -C5685n.f((int) (iF * this.immersiveFraction), 0);
                ViewGroup.LayoutParams layoutParams = resultWeb.getLayoutParams();
                FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null && layoutParams2.height == i10 && layoutParams2.topMargin == i11) {
                    return;
                }
                if (!this.webFullscreenHeightLocked) {
                    Integer numValueOf2 = layoutParams2 != null ? Integer.valueOf(layoutParams2.height) : null;
                    Integer numValueOf3 = layoutParams2 != null ? Integer.valueOf(layoutParams2.topMargin) : null;
                    C4148a.k(TAG, "syncWebPlacement h=" + numValueOf2 + "->" + i10 + " margin=" + numValueOf3 + "->" + i11 + " fullShift=" + iF + " frac=" + this.immersiveFraction + " locked=" + this.webFullscreenHeightLocked, false, 4, null);
                }
                ViewGroup.LayoutParams layoutParams3 = resultWeb.getLayoutParams();
                if (layoutParams3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                layoutParams4.height = i10;
                layoutParams4.topMargin = i11;
                resultWeb.setLayoutParams(layoutParams4);
            }
        }
    }

    public final boolean X0() {
        FrameLayout resultRenderMask = this.b.resultRenderMask;
        kotlin.jvm.internal.p.h(resultRenderMask, "resultRenderMask");
        return resultRenderMask.getVisibility() == 0;
    }

    public final void X1() {
        if (this.webRevealed || this.webPreviewFailed || !this.webPainted || !this.webShapeSettled) {
            return;
        }
        if (this.webviewFullscreen) {
            int i10 = this.topInsetPx;
            if (i10 <= 0 || this.docTopOnScreen != i10) {
                return;
            }
            View rootView = getRootView();
            int height = rootView != null ? rootView.getHeight() : 0;
            int i11 = this.topInsetPx;
            int i12 = height + i11;
            int i13 = -((int) (i11 * this.immersiveFraction));
            ViewGroup.LayoutParams layoutParams = this.b.resultWeb.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (height <= 0 || this.b.resultWeb.getHeight() != i12 || layoutParams2 == null || layoutParams2.topMargin != i13) {
                return;
            }
        } else if (this.topInsetPx <= 0) {
            return;
        }
        if (this.b.resultWeb.getLoadedViaData() || this.loadUrlPaintSettled) {
            g1();
        } else {
            l0();
        }
    }

    public final boolean Y0(Throwable e10) {
        return kotlin.jvm.internal.p.d(l1(e10), "content_blocked");
    }

    public final void Y1() {
        if (this.imeHeightFrozen) {
            this.imeHeightFrozen = false;
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.height = -1;
            setLayoutParams(layoutParams);
            V1();
            ImageView resultImage = this.b.resultImage;
            kotlin.jvm.internal.p.h(resultImage, "resultImage");
            e1(resultImage);
            ScrollView resultFallbackScroll = this.b.resultFallbackScroll;
            kotlin.jvm.internal.p.h(resultFallbackScroll, "resultFallbackScroll");
            e1(resultFallbackScroll);
            ScrollView resultFolderScroll = this.b.resultFolderScroll;
            kotlin.jvm.internal.p.h(resultFolderScroll, "resultFolderScroll");
            e1(resultFolderScroll);
        }
    }

    public final void Z0(final ImageView image, final String fileId, final String rawContent, final boolean preferRgb565) {
        final String strA = C5578a.INSTANCE.a(fileId);
        u6.i.h(u6.i.INSTANCE, fileId, false, new p9.p() { // from class: com.stepos.ailauncher.task.detail.render.y
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ArtifactContentView.a1(this.f28732a, image, strA, preferRgb565, (String) obj, (InterfaceC5063a) obj2);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.render.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactContentView.b1(fileId, this, image, rawContent, strA, preferRgb565, (Throwable) obj);
            }
        }, 2, null);
    }

    public final boolean Z1() {
        TaskWebView resultWeb = this.b.resultWeb;
        kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
        if (resultWeb.getVisibility() == 0 && this.b.resultWeb.I()) {
            return !this.b.resultWeb.J();
        }
        return false;
    }

    public final void a2(InterfaceC5063a<Y8.t> block) {
        if (getHeight() > 0) {
            block.invoke();
        } else if (!isLaidOut() || isLayoutRequested()) {
            addOnLayoutChangeListener(new g(block));
        } else {
            block.invoke();
        }
    }

    public final void c1(ImageView image, Object data, String cacheKey, InterfaceC5063a<Y8.t> onFailRetry, boolean preferRgb565) {
        coil.c cVarC = com.stepos.ailauncher.task.common.h.INSTANCE.c();
        g.a aVarR = new g.a(image.getContext()).d(data).r(image);
        if (preferRgb565) {
            aVarR.b(Bitmap.Config.RGB_565);
        }
        if (cacheKey != null) {
            aVarR.j(cacheKey);
            aVarR.f(cacheKey);
        }
        aVarR.h(new e(onFailRetry, this, this));
        cVarC.c(aVarR.c());
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        return h1(direction);
    }

    public final void d0() {
        float f10 = this.immersiveFraction;
        float f11 = 1.0f - f10;
        boolean z10 = f10 <= 0.0f || f10 >= 1.0f;
        int iF = C5685n.f((int) (this.topInsetPx * f11), 0);
        int iF2 = C5685n.f((int) (this.bottomInsetPx * f11), 0);
        TaskWebView resultWeb = this.b.resultWeb;
        kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
        String str = this.markdownEdgeToEdge ? "mdEdgeToEdge" : this.webviewFullscreen ? "webFullscreen" : "padding";
        if (!this.webviewFullscreen) {
            E1();
            this.docTopOnScreen = 0;
            this.docTopRequested = Integer.MIN_VALUE;
            i1(str, iF, iF2, null);
            X1();
            return;
        }
        W1();
        View rootView = getRootView();
        int height = rootView != null ? rootView.getHeight() : 0;
        int iF3 = this.webFullscreenHeightLocked ? this.lockedWebShiftPx : C5685n.f(this.topInsetPx, 0);
        int i10 = height > 0 ? height + iF3 : 0;
        int i11 = -((int) (iF3 * this.immersiveFraction));
        ViewGroup.LayoutParams layoutParams = resultWeb.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (!this.webFullscreenHeightLocked && i10 > 0 && (resultWeb.getHeight() != i10 || layoutParams2 == null || layoutParams2.topMargin != i11)) {
            if (!resultWeb.isLaidOut() || resultWeb.isLayoutRequested()) {
                resultWeb.addOnLayoutChangeListener(new c());
                return;
            } else {
                d0();
                return;
            }
        }
        if (z10) {
            final int iF4 = C5685n.f(this.topInsetPx, 0);
            int iF5 = iF4 != 0 ? C5685n.f(this.bottomInsetPx, 0) : 0;
            String str2 = iF4 + Const.STR_MART_COMMA + iF5 + Const.STR_MART_COMMA + str;
            if (iF4 != this.docTopRequested || !kotlin.jvm.internal.p.d(this.lastInsetKey, str2)) {
                this.docTopRequested = iF4;
                i1(str, iF4, iF5, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.h
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return ArtifactContentView.e0(this.f28699a, iF4);
                    }
                });
            }
        }
        X1();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        this.viewportFade.a(this, canvas, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.render.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactContentView.z0(this.f28701a, (Canvas) obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.p.i(r8, r0)
            int r0 = r8.getActionMasked()
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L84
            r3 = 1
            if (r0 == r3) goto L7e
            r4 = 2
            if (r0 == r4) goto L18
            r1 = 3
            if (r0 == r1) goto L7e
            goto La0
        L18:
            float r0 = r8.getX()
            float r4 = r7.touchDownX
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            float r4 = r8.getY()
            float r5 = r7.touchDownY
            float r4 = r4 - r5
            float r4 = java.lang.Math.abs(r4)
            boolean r5 = r7.touchAxisDecided
            if (r5 != 0) goto L50
            int r5 = r7.touchAxisSlop
            float r6 = (float) r5
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 > 0) goto L3e
            float r5 = (float) r5
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 <= 0) goto L50
        L3e:
            r7.touchAxisDecided = r3
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 <= 0) goto L46
            r0 = r3
            goto L47
        L46:
            r0 = r2
        L47:
            r7.touchGrabbing = r0
            p9.a<Y8.t> r0 = r7.onUserDragContent
            if (r0 == 0) goto L50
            r0.invoke()
        L50:
            boolean r0 = r7.touchGrabbing
            if (r0 == 0) goto L74
            float r0 = r8.getY()
            float r4 = r7.touchLastY
            float r0 = r0 - r4
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L65
            boolean r0 = r7.h1(r1)
            goto L69
        L65:
            boolean r0 = r7.h1(r3)
        L69:
            boolean r1 = r7.contentOwnsVerticalGesture
            if (r1 != 0) goto L6f
            if (r0 == 0) goto L70
        L6f:
            r2 = r3
        L70:
            r7.x0(r2)
            goto L77
        L74:
            r7.x0(r2)
        L77:
            float r0 = r8.getY()
            r7.touchLastY = r0
            goto La0
        L7e:
            r7.x0(r2)
            r7.contentOwnsVerticalGesture = r2
            goto La0
        L84:
            float r0 = r8.getX()
            r7.touchDownX = r0
            float r0 = r8.getY()
            r7.touchDownY = r0
            float r0 = r8.getY()
            r7.touchLastY = r0
            r7.touchAxisDecided = r2
            r7.touchGrabbing = r2
            boolean r0 = r7.h1(r1)
            r7.contentOwnsVerticalGesture = r0
        La0:
            boolean r7 = super.dispatchTouchEvent(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.render.ArtifactContentView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void e1(View child) {
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.height = -1;
        child.setLayoutParams(layoutParams);
    }

    public final void f0(HtmlView mode) {
        kotlin.jvm.internal.p.i(mode, "mode");
        this.htmlView = mode;
        TaskWebView resultWeb = this.b.resultWeb;
        kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
        HtmlView htmlView = HtmlView.CODE;
        if (mode == htmlView) {
            String str = this.currentHtmlSource;
            if (str == null || str.length() == 0) {
                C4148a.u(TAG, "applyHtmlView CODE ignored: html source not ready", false, 4, null);
                this.htmlView = HtmlView.PREVIEW;
                return;
            } else if (this.codeLoaded) {
                resultWeb.m0();
            } else {
                resultWeb.K(str, "html");
                this.codeLoaded = true;
            }
        } else {
            resultWeb.n0();
        }
        h0(mode == htmlView);
        U1();
    }

    public final void g0() {
        if (this.webShapeSettled || !this.awaitingWebPaint) {
            d0();
        }
    }

    public final void g1() {
        if (this.webRevealed || this.webPreviewFailed) {
            return;
        }
        this.webRevealed = true;
        if (this.webviewFullscreen) {
            this.lockedWebShiftPx = C5685n.f(C5685n.f(this.docTopOnScreen, this.topInsetPx), 0);
            this.webFullscreenHeightLocked = true;
            W1();
        }
        s0();
        q0();
        C4148a.k(TAG, "revealWebPreview loadUrlSettled=" + this.loadUrlPaintSettled + " heightLocked=" + this.webFullscreenHeightLocked + " shift=" + this.lockedWebShiftPx, false, 4, null);
        R0();
    }

    public final int getBottomInsetPx() {
        return this.bottomInsetPx;
    }

    public final HtmlView getHtmlView() {
        return this.htmlView;
    }

    public final float getImmersiveFraction() {
        return this.immersiveFraction;
    }

    public final InterfaceC5074l<Boolean, Y8.t> getOnChromeBlockingChanged() {
        return this.onChromeBlockingChanged;
    }

    public final InterfaceC5063a<Y8.t> getOnContentMetricsChanged() {
        return this.onContentMetricsChanged;
    }

    public final InterfaceC5063a<Y8.t> getOnContentScrollChanged() {
        return this.onContentScrollChanged;
    }

    public final p9.p<SessionArtifact, Integer, Y8.t> getOnFolderChildClick() {
        return this.onFolderChildClick;
    }

    public final InterfaceC5063a<Y8.t> getOnUserDragContent() {
        return this.onUserDragContent;
    }

    public final int getTopInsetPx() {
        return this.topInsetPx;
    }

    public final void h0(boolean enable) {
        if (this.markdownEdgeToEdge == enable) {
            return;
        }
        this.markdownEdgeToEdge = enable;
        d0();
    }

    public final boolean h1(int direction) {
        FrameLayout resultInvalid = this.b.resultInvalid;
        kotlin.jvm.internal.p.h(resultInvalid, "resultInvalid");
        if (resultInvalid.getVisibility() == 0) {
            return false;
        }
        TaskWebView resultWeb = this.b.resultWeb;
        kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
        if (resultWeb.getVisibility() == 0) {
            return this.b.resultWeb.canScrollVertically(direction);
        }
        ScrollView resultFallbackScroll = this.b.resultFallbackScroll;
        kotlin.jvm.internal.p.h(resultFallbackScroll, "resultFallbackScroll");
        if (resultFallbackScroll.getVisibility() == 0) {
            return this.b.resultFallbackScroll.canScrollVertically(direction);
        }
        ScrollView resultFolderScroll = this.b.resultFolderScroll;
        kotlin.jvm.internal.p.h(resultFolderScroll, "resultFolderScroll");
        if (resultFolderScroll.getVisibility() == 0) {
            return this.b.resultFolderScroll.canScrollVertically(direction);
        }
        return false;
    }

    public final void i0(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            j0();
            return;
        }
        ImageView resultRenderMaskSnapshot = this.b.resultRenderMaskSnapshot;
        kotlin.jvm.internal.p.h(resultRenderMaskSnapshot, "resultRenderMaskSnapshot");
        v0();
        resultRenderMaskSnapshot.setImageBitmap(bitmap);
        resultRenderMaskSnapshot.setRenderEffect(getSnapshotBlurEffect());
        resultRenderMaskSnapshot.setVisibility(0);
        LinearLayout resultRenderMaskLoading = this.b.resultRenderMaskLoading;
        kotlin.jvm.internal.p.h(resultRenderMaskLoading, "resultRenderMaskLoading");
        resultRenderMaskLoading.setVisibility(8);
        this.snapshotMaskActive = true;
    }

    public final void i1(String branch, int top, int bottom, final InterfaceC5063a<Y8.t> onApplied) {
        final String str = top + Const.STR_MART_COMMA + bottom + Const.STR_MART_COMMA + branch;
        if (kotlin.jvm.internal.p.d(str, this.lastInsetKey)) {
            if (onApplied != null) {
                onApplied.invoke();
                return;
            }
            return;
        }
        TaskWebView resultWeb = this.b.resultWeb;
        kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
        if (this.markdownEdgeToEdge) {
            this.lastInsetKey = str;
            FrameLayout resultViewport = this.b.resultViewport;
            kotlin.jvm.internal.p.h(resultViewport, "resultViewport");
            resultViewport.setPadding(resultViewport.getPaddingLeft(), 0, resultViewport.getPaddingRight(), 0);
            resultWeb.C();
            resultWeb.g0(top, bottom);
            if (onApplied != null) {
                onApplied.invoke();
                return;
            }
            return;
        }
        if (this.webviewFullscreen) {
            if (!this.webRevealed) {
                resultWeb.g0(0, 0);
                resultWeb.b0(top, bottom, TaskWebView.EDGE_SPACER_TRANSPARENT, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.k
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return ArtifactContentView.j1(this.f28703a, str, onApplied);
                    }
                });
                return;
            } else {
                this.lastInsetKey = str;
                if (onApplied != null) {
                    onApplied.invoke();
                    return;
                }
                return;
            }
        }
        this.lastInsetKey = str;
        FrameLayout resultViewport2 = this.b.resultViewport;
        kotlin.jvm.internal.p.h(resultViewport2, "resultViewport");
        resultViewport2.setPadding(resultViewport2.getPaddingLeft(), top, resultViewport2.getPaddingRight(), bottom);
        resultWeb.C();
        resultWeb.g0(0, 0);
        if (onApplied != null) {
            onApplied.invoke();
        }
    }

    public final void j0() {
        v0();
        ImageView resultRenderMaskSnapshot = this.b.resultRenderMaskSnapshot;
        kotlin.jvm.internal.p.h(resultRenderMaskSnapshot, "resultRenderMaskSnapshot");
        resultRenderMaskSnapshot.setVisibility(8);
        LinearLayout resultRenderMaskLoading = this.b.resultRenderMaskLoading;
        kotlin.jvm.internal.p.h(resultRenderMaskLoading, "resultRenderMaskLoading");
        resultRenderMaskLoading.setVisibility(0);
        this.snapshotMaskActive = false;
    }

    public final void k0(boolean enable) {
        boolean z10 = this.webviewFullscreen;
        if (z10 == enable) {
            return;
        }
        C4148a.k("PptTrace", "applyWebViewFullscreen " + z10 + "->" + enable + " generation=" + this.renderGeneration + " web=" + System.identityHashCode(this.b.resultWeb) + " before=" + this.b.resultWeb.getWidth() + "x" + this.b.resultWeb.getHeight() + " host=" + getWidth() + "x" + getHeight(), false, 4, null);
        this.webviewFullscreen = enable;
        if (enable) {
            FrameLayout resultViewport = this.b.resultViewport;
            kotlin.jvm.internal.p.h(resultViewport, "resultViewport");
            resultViewport.setPadding(resultViewport.getPaddingLeft(), 0, resultViewport.getPaddingRight(), 0);
        }
        V1();
        if (this.webShapeSettled) {
            TaskWebView resultWeb = this.b.resultWeb;
            kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
            if (!resultWeb.isLaidOut() || resultWeb.isLayoutRequested()) {
                resultWeb.addOnLayoutChangeListener(new d());
            } else {
                d0();
                X1();
            }
        }
    }

    public final String k1(Integer code) {
        return (code != null && code.intValue() == 403) ? M5.c.REASON_LINK_EXPIRED : (code != null && code.intValue() == 404) ? "file_not_found" : M5.c.REASON_LOAD_FAILED;
    }

    public final void l0() {
        if (this.loadUrlSettleRunnable != null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.task.detail.render.f
            @Override // java.lang.Runnable
            public final void run() {
                ArtifactContentView.m0(this.f28698a);
            }
        };
        this.loadUrlSettleRunnable = runnable;
        C4148a.k(TAG, "loadUrl paint settle armed 600ms", false, 4, null);
        postDelayed(runnable, LOAD_URL_PAINT_SETTLE_MS);
    }

    public final String l1(Throwable e10) {
        return e10 instanceof FileStorageException.Network ? M5.c.REASON_LOAD_FAILED : e10 instanceof FileStorageException.AuditBlocked ? "content_blocked" : e10 instanceof FileStorageException.BizError ? k1(Integer.valueOf(((FileStorageException.BizError) e10).getHttpStatus())) : ((e10 instanceof FileStorageException.GatewayException.Other) && V0((FileStorageException.GatewayException.Other) e10)) ? "content_blocked" : M5.c.REASON_LOAD_FAILED;
    }

    public final void m1() {
        this.imeHeightFrozen = false;
        this.onContentMetricsChanged = null;
        this.onContentScrollChanged = null;
        this.onUserDragContent = null;
        this.onChromeBlockingChanged = null;
        this.lastChromeBlocking = null;
        this.b.resultWeb.setOnContentMetricsProbed(null);
        this.b.resultWeb.setOnMainFrameLoadFailed(null);
        this.b.resultWeb.setOnContentFirstPaint(null);
        this.b.resultWeb.setOnShapeSettled(null);
        this.b.resultWeb.setOnViewportHeightChanged(null);
        this.b.resultWeb.setOnScrollChanged(null);
        kotlinx.coroutines.g gVar = this.renderJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.previewFetchInFlight = false;
        this.renderGeneration++;
        this.snapshotCapturePending = false;
        this.pendingRenderArtifact = null;
        p0();
        s0();
        q0();
        r0(true);
        Runnable runnable = this.maskHideRunnable;
        if (runnable != null) {
            this.b.resultRenderMask.removeCallbacks(runnable);
        }
        this.maskHideRunnable = null;
        this.b.resultRenderMask.animate().cancel();
        this.b.resultRenderMaskProgress.animate().cancel();
        v0();
        this.hasPresentedContent = false;
        this.snapshotMaskActive = false;
        this.b.resultWeb.F();
        kotlinx.coroutines.d.e(this.scope, null, 1, null);
    }

    public final String n0(SessionArtifact a10) {
        String title = a10.getTitle();
        if (title != null) {
            if (La.H.x0(title)) {
                title = null;
            }
            if (title != null) {
                return title;
            }
        }
        String strD = ArtifactRenderKind.INSTANCE.d(a10.getMimeType());
        if (strD == null) {
            strD = "bin";
        }
        return "result." + strD;
    }

    public final void n1(ArtifactRenderKind.Kind active) {
        if (active != ArtifactRenderKind.Kind.TEXT && active != ArtifactRenderKind.Kind.HTML && active != ArtifactRenderKind.Kind.FILE) {
            this.b.resultWeb.O("about:blank");
        }
        if (active != ArtifactRenderKind.Kind.IMAGE) {
            this.b.resultImage.setImageDrawable(null);
        }
    }

    public final boolean o0() {
        ImageView resultImage = this.b.resultImage;
        kotlin.jvm.internal.p.h(resultImage, "resultImage");
        if (resultImage.getVisibility() == 0) {
            return true;
        }
        ScrollView resultFallbackScroll = this.b.resultFallbackScroll;
        kotlin.jvm.internal.p.h(resultFallbackScroll, "resultFallbackScroll");
        if (resultFallbackScroll.getVisibility() == 0) {
            return true;
        }
        ScrollView resultFolderScroll = this.b.resultFolderScroll;
        kotlin.jvm.internal.p.h(resultFolderScroll, "resultFolderScroll");
        if (resultFolderScroll.getVisibility() == 0) {
            return true;
        }
        TaskWebView resultWeb = this.b.resultWeb;
        kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
        return resultWeb.getVisibility() == 0 && !this.b.resultWeb.I();
    }

    public final void o1(final SessionArtifact a10) {
        kotlin.jvm.internal.p.i(a10, "a");
        this.pendingRenderArtifact = a10;
        if (this.snapshotCapturePending) {
            return;
        }
        if (L1()) {
            this.snapshotCapturePending = true;
            final int i10 = this.renderGeneration + 1;
            this.renderGeneration = i10;
            t0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.render.q
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ArtifactContentView.p1(this.f28717a, i10, a10, (Bitmap) obj);
                }
            });
            return;
        }
        if (this.snapshotMaskActive && W0()) {
            this.renderGeneration++;
            A0(a10, null, true);
        } else {
            this.renderGeneration++;
            A0(a10, null, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        kotlinx.coroutines.g gVar = this.renderJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.render.j
            @Override // java.lang.Runnable
            public final void run() {
                ArtifactContentView.f1(this.f28702a);
            }
        });
    }

    public final void p0() {
        Runnable runnable = this.htmlFallbackRunnable;
        if (runnable != null) {
            this.b.resultWeb.removeCallbacks(runnable);
        }
        this.htmlFallbackRunnable = null;
    }

    public final void q0() {
        Runnable runnable = this.loadUrlSettleRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.loadUrlSettleRunnable = null;
    }

    public final void q1(TaskWebView web, boolean asHtml, String text) throws Resources.NotFoundException {
        SessionArtifact sessionArtifact = this.current;
        if (asHtml) {
            this.currentHtmlSource = text;
            this.awaitingWebPaint = true;
            web.L(text);
            return;
        }
        if (sessionArtifact != null) {
            ArtifactRenderKind artifactRenderKind = ArtifactRenderKind.INSTANCE;
            if (artifactRenderKind.g(sessionArtifact) == ArtifactRenderKind.Kind.CODE) {
                web.K(text, artifactRenderKind.a(sessionArtifact.getFileName()));
                R0();
                return;
            }
        }
        web.M(null, text);
        R0();
    }

    public final void r0(boolean hideProgress) {
        Runnable runnable = this.maskProgressRunnable;
        if (runnable != null) {
            this.b.resultRenderMask.removeCallbacks(runnable);
        }
        this.maskProgressRunnable = null;
        if (hideProgress) {
            ProgressBar resultRenderMaskProgress = this.b.resultRenderMaskProgress;
            kotlin.jvm.internal.p.h(resultRenderMaskProgress, "resultRenderMaskProgress");
            resultRenderMaskProgress.animate().cancel();
            resultRenderMaskProgress.setAlpha(0.0f);
            resultRenderMaskProgress.setVisibility(8);
        }
    }

    public final void r1(SessionArtifact a10) {
        final String fileId = a10.getFileId();
        if (fileId == null || La.H.x0(fileId)) {
            B1(a10);
            return;
        }
        Q1(this.b.resultWeb);
        k0(true);
        u6.i.INSTANCE.k(fileId, "html", null, 600, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.render.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactContentView.s1(this.f28728a, (String) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.render.x
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactContentView.t1(fileId, this, (Throwable) obj);
            }
        });
    }

    public final void s0() {
        Runnable runnable = this.shapeFallbackRunnable;
        if (runnable != null) {
            this.b.resultWeb.removeCallbacks(runnable);
        }
        this.shapeFallbackRunnable = null;
    }

    public final void setBottomInsetPx(int i10) {
        if (this.bottomInsetPx == i10) {
            return;
        }
        this.bottomInsetPx = i10;
        g0();
    }

    public final void setImmersiveFraction(float f10) {
        float fM = C5685n.m(f10, 0.0f, 1.0f);
        if (this.immersiveFraction == fM) {
            return;
        }
        this.immersiveFraction = fM;
        d0();
        U1();
    }

    public final void setOnChromeBlockingChanged(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onChromeBlockingChanged = interfaceC5074l;
    }

    public final void setOnContentMetricsChanged(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onContentMetricsChanged = interfaceC5063a;
    }

    public final void setOnContentScrollChanged(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onContentScrollChanged = interfaceC5063a;
    }

    public final void setOnFolderChildClick(p9.p<? super SessionArtifact, ? super Integer, Y8.t> pVar) {
        this.onFolderChildClick = pVar;
    }

    public final void setOnUserDragContent(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onUserDragContent = interfaceC5063a;
    }

    public final void setTopInsetPx(int i10) {
        if (this.topInsetPx == i10) {
            return;
        }
        this.topInsetPx = i10;
        g0();
        X1();
    }

    public final void t0(final InterfaceC5074l<? super Bitmap, Y8.t> onDone) {
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            onDone.invoke(null);
            return;
        }
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        Activity activityB = N.b(context);
        Window window = activityB != null ? activityB.getWindow() : null;
        if (window == null) {
            onDone.invoke(null);
            return;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i10 = iArr[0];
        int i11 = iArr[1];
        Rect rect = new Rect(i10, i11, i10 + width, i11 + height);
        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.p.h(bitmapCreateBitmap, "createBitmap(...)");
        try {
            PixelCopy.request(window, rect, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.stepos.ailauncher.task.detail.render.s
                @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                public final void onPixelCopyFinished(int i12) {
                    ArtifactContentView.u0(onDone, this, bitmapCreateBitmap, i12);
                }
            }, this.mainHandler);
        } catch (Exception e10) {
            C4148a.t(TAG, "PixelCopy snapshot failed", e10, false, 8, null);
            bitmapCreateBitmap.recycle();
            onDone.invoke(null);
        }
    }

    public final void u1(SessionArtifact folder, List<SessionArtifact> children) {
        kotlin.jvm.internal.p.i(folder, "folder");
        kotlin.jvm.internal.p.i(children, "children");
        this.renderGeneration++;
        D1(folder);
        h0(false);
        R0();
        LinearLayout resultFolderList = this.b.resultFolderList;
        kotlin.jvm.internal.p.h(resultFolderList, "resultFolderList");
        resultFolderList.removeAllViews();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        final int i10 = 0;
        for (Object obj : children) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            final SessionArtifact sessionArtifact = (SessionArtifact) obj;
            View viewInflate = layoutInflaterFrom.inflate(R$layout.item_agent_artifact, (ViewGroup) resultFolderList, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(R$id.iv_artifact_icon);
            if (imageView != null && sessionArtifact.getIconRes() != 0) {
                imageView.setImageResource(sessionArtifact.getIconRes());
            }
            TextView textView = (TextView) viewInflate.findViewById(R$id.tv_artifact_name);
            if (textView != null) {
                textView.setText(sessionArtifact.getName());
            }
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.render.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArtifactContentView.v1(this.f28724a, sessionArtifact, i10, view);
                }
            });
            resultFolderList.addView(viewInflate);
            i10 = i11;
        }
        Q1(this.b.resultFolderScroll);
        this.hasPresentedContent = true;
        InterfaceC5063a<Y8.t> interfaceC5063a = this.onContentMetricsChanged;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        a2(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.u
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactContentView.w1(this.f28727a);
            }
        });
    }

    public final void v0() {
        ImageView resultRenderMaskSnapshot = this.b.resultRenderMaskSnapshot;
        kotlin.jvm.internal.p.h(resultRenderMaskSnapshot, "resultRenderMaskSnapshot");
        Drawable drawable = resultRenderMaskSnapshot.getDrawable();
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        Bitmap bitmap = bitmapDrawable != null ? bitmapDrawable.getBitmap() : null;
        resultRenderMaskSnapshot.setRenderEffect(null);
        resultRenderMaskSnapshot.setImageDrawable(null);
        if (bitmap != null) {
            Bitmap bitmap2 = bitmap.isRecycled() ? null : bitmap;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
        }
    }

    public final boolean w0() {
        return this.b.resultWeb.D();
    }

    public final void x0(boolean disallow) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(disallow);
        }
    }

    public final void x1(String url) {
        final TaskWebView resultWeb = this.b.resultWeb;
        kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
        C4148a.k("PptTrace", "renderHtmlUrlWithFallback generation=" + this.renderGeneration + " url=" + La.K.S1(La.H.w1(url, '?', null, 2, null), com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME) + " queryLen=" + La.H.m1(url, '?', "").length() + " web=" + System.identityHashCode(resultWeb), false, 4, null);
        this.currentHtmlUrl = url;
        this.htmlFallbackDone = false;
        resultWeb.setOnTreatedAsDownload(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.render.E
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactContentView.y1(this.f28683a, (String) obj);
            }
        });
        Runnable runnable = this.htmlFallbackRunnable;
        if (runnable != null) {
            resultWeb.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.stepos.ailauncher.task.detail.render.F
            @Override // java.lang.Runnable
            public final void run() {
                ArtifactContentView.z1(this.f28684a, resultWeb);
            }
        };
        this.htmlFallbackRunnable = runnable2;
        resultWeb.postDelayed(runnable2, 4000L);
        this.awaitingWebPaint = true;
        resultWeb.O(url);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y0() {
        /*
            r3 = this;
            r6.q r0 = r3.b
            android.widget.FrameLayout r0 = r0.resultRenderMask
            java.lang.String r1 = "resultRenderMask"
            kotlin.jvm.internal.p.h(r0, r1)
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L11
            goto L21
        L11:
            r6.q r0 = r3.b
            android.widget.FrameLayout r0 = r0.resultInvalid
            java.lang.String r1 = "resultInvalid"
            kotlin.jvm.internal.p.h(r0, r1)
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L23
        L21:
            r0 = 1
            goto L24
        L23:
            r0 = 0
        L24:
            java.lang.Boolean r1 = r3.lastChromeBlocking
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            boolean r1 = kotlin.jvm.internal.p.d(r1, r2)
            if (r1 == 0) goto L31
            goto L42
        L31:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
            r3.lastChromeBlocking = r1
            p9.l<? super java.lang.Boolean, Y8.t> r3 = r3.onChromeBlockingChanged
            if (r3 == 0) goto L42
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r3.invoke(r0)
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.render.ArtifactContentView.y0():void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactContentView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        r6.q qVarB = r6.q.b(LayoutInflater.from(context), this, true);
        kotlin.jvm.internal.p.h(qVarB, "inflate(...)");
        this.b = qVarB;
        this.scope = kotlinx.coroutines.d.a(Y.c().plus(L0.b(null, 1, null)));
        this.htmlView = HtmlView.PREVIEW;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.snapshotBlurEffect = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactContentView.T1(this.f28693a);
            }
        });
        this.viewportFade = new I0();
        this.fadeTopPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.I
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Float.valueOf(ArtifactContentView.I0(this.f28688a));
            }
        });
        this.fadeBottomPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.J
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Float.valueOf(ArtifactContentView.F0(this.f28689a));
            }
        });
        this.fadeTopHoldPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.K
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Float.valueOf(ArtifactContentView.H0(this.f28690a));
            }
        });
        this.fadeBottomHoldPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.L
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Float.valueOf(ArtifactContentView.E0(this.f28691a));
            }
        });
        this.docTopRequested = Integer.MIN_VALUE;
        this.touchAxisSlop = C5685n.f(ViewConfiguration.get(context).getScaledTouchSlop() / 2, 1);
        setClipChildren(false);
        setClipToPadding(false);
        qVarB.resultWeb.setOnMainFrameLoadFailed(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.render.M
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactContentView.N(this.f28692a, (Integer) obj);
            }
        });
        qVarB.resultWeb.setOnContentFirstPaint(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactContentView.O(this.f28694a);
            }
        });
        qVarB.resultWeb.setOnShapeSettled(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactContentView.P(this.f28695a);
            }
        });
        qVarB.resultWeb.setOnViewportHeightChanged(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactContentView.Q(this.f28696a);
            }
        });
        qVarB.resultWeb.setOnPlainFlowDetected(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.render.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactContentView.R(this.f28697a, ((Boolean) obj).booleanValue());
            }
        });
        qVarB.resultWeb.setOnContentMetricsProbed(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactContentView.S(this.f28706a);
            }
        });
        qVarB.resultWeb.setOnScrollChanged(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.render.w
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactContentView.T(this.f28729a);
            }
        });
        qVarB.resultFallbackScroll.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.stepos.ailauncher.task.detail.render.G
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i11, int i12, int i13, int i14) {
                ArtifactContentView.U(this.f28686a, view, i11, i12, i13, i14);
            }
        });
        qVarB.resultFolderScroll.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.stepos.ailauncher.task.detail.render.H
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i11, int i12, int i13, int i14) {
                ArtifactContentView.V(this.f28687a, view, i11, i12, i13, i14);
            }
        });
    }

    public /* synthetic */ ArtifactContentView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
