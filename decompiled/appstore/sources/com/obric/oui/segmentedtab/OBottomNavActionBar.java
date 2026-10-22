package com.obric.oui.segmentedtab;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.common.wschannel.WsConstants;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.style.ShadowAnimator;
import com.obric.oui.common.style.l;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.f;
import com.obric.oui.material.o;
import com.tmall.wireless.tangram.structure.card.BannerCard;
import com.tmall.wireless.tangram.structure.card.FixCard;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import td.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b4\u0018\u0000 \u008b\u00022\u00020\u00012\u00020\u0002:\u0005^\u008c\u0002\u008d\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u000eJ\u000f\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0014J\u001f\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\"\u0010!J\u0017\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u001bH\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u001bH\u0002¢\u0006\u0004\b'\u0010%J\u001f\u0010*\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010,\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\f2\u0006\u00101\u001a\u00020\u000fH\u0016¢\u0006\u0004\b2\u0010\u0012J\u0017\u00104\u001a\u00020\f2\u0006\u00103\u001a\u00020\u000fH\u0016¢\u0006\u0004\b4\u0010\u0012J\u0019\u00107\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\f2\u0006\u00109\u001a\u00020\u000fH\u0016¢\u0006\u0004\b:\u0010\u0012J\u0017\u0010<\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u0007H\u0016¢\u0006\u0004\b<\u0010\u000eJ\u0017\u0010?\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020\f2\u0006\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0014¢\u0006\u0004\bE\u0010!J\u0017\u0010H\u001a\u00020\f2\b\u0010G\u001a\u0004\u0018\u00010F¢\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020\f2\b\u0010G\u001a\u0004\u0018\u00010J¢\u0006\u0004\bK\u0010LJ\u0011\u0010N\u001a\u0004\u0018\u00010MH\u0014¢\u0006\u0004\bN\u0010OJ\u0017\u0010Q\u001a\u00020\f2\u0006\u0010P\u001a\u00020MH\u0014¢\u0006\u0004\bQ\u0010RJ\u001f\u0010U\u001a\u00020\f2\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u0007H\u0014¢\u0006\u0004\bU\u0010VJ7\u0010\\\u001a\u00020\f2\u0006\u0010W\u001a\u00020\u000f2\u0006\u0010X\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\\\u0010]R\u0014\u0010`\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010c\u001a\u00020a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010bR\u0016\u0010e\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010dR\u0016\u0010g\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010fR\u0018\u0010i\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010hR(\u0010p\u001a\b\u0012\u0004\u0012\u0002050j8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u0016\u0010q\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010fR\u0016\u0010r\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010fR$\u0010v\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b*\u0010f\u001a\u0004\bt\u0010uR\u0014\u0010y\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010xR\u0016\u0010{\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010zR\u0016\u0010}\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010|R\u0016\u0010~\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010zR\u0016\u0010\u0081\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0013\u0010\u0080\u0001R'\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010f\u001a\u0005\b\u0083\u0001\u0010uR'\u0010\u0086\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0085\u0001\u0010|\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0005\b\u0088\u0001\u0010\u0012R.\u0010\u008a\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u001d\n\u0005\b\u0089\u0001\u0010|\u0012\u0005\b\u008c\u0001\u0010\u0014\u001a\u0006\b\u008a\u0001\u0010\u0087\u0001\"\u0005\b\u008b\u0001\u0010\u0012R\u0018\u0010\u008e\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010fR\u0018\u0010\u0090\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010zR\u0018\u0010\u0092\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010zR\u0018\u0010\u0094\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010zR\u0018\u0010\u0096\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010fR\u0018\u0010\u0098\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010fR\u0018\u0010\u009a\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010|R\u0018\u0010\u009c\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010fR\u0018\u0010\u009e\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010fR\u0018\u0010 \u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010zR\u0018\u0010¢\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¡\u0001\u0010fR\u0018\u0010¤\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b£\u0001\u0010|R\u001c\u0010¨\u0001\u001a\u0005\u0018\u00010¥\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R/\u0010\u00ad\u0001\u001a\u0018\u0012\u0004\u0012\u00020.\u0018\u00010©\u0001j\u000b\u0012\u0004\u0012\u00020.\u0018\u0001`ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R!\u0010°\u0001\u001a\f\u0012\u0005\u0012\u00030¯\u0001\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010kR\"\u0010²\u0001\u001a\f\u0012\u0005\u0012\u00030¯\u0001\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b±\u0001\u0010kR\u0016\u0010´\u0001\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b³\u0001\u0010xR\u0015\u0010µ\u0001\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010xR\u0018\u0010¹\u0001\u001a\u00030¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u0018\u0010»\u0001\u001a\u00030¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010¸\u0001R\u001c\u0010¿\u0001\u001a\u0005\u0018\u00010¼\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u001c\u0010Á\u0001\u001a\u0005\u0018\u00010¼\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010¾\u0001R\u0018\u0010Ã\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÂ\u0001\u0010zR\u0018\u0010Å\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÄ\u0001\u0010zR\u0018\u0010Ç\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÆ\u0001\u0010|R\u0018\u0010É\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÈ\u0001\u0010|R\u0017\u00109\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÊ\u0001\u0010|R\u0018\u0010Ì\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bË\u0001\u0010fR\u0018\u0010Î\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÍ\u0001\u0010fR\u0018\u0010Ð\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÏ\u0001\u0010|R1\u0010×\u0001\u001a\u00020\u001b2\u0007\u0010Ñ\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u0017\n\u0005\bÒ\u0001\u0010z\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001R\u0016\u0010Ù\u0001\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bØ\u0001\u0010xR \u0010Ý\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0Ú\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R\u001b\u0010à\u0001\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010ß\u0001R\u001b\u0010ã\u0001\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0001\u0010â\u0001R(\u0010ä\u0001\u001a\u00020\u00072\u0007\u0010ä\u0001\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bå\u0001\u0010u\"\u0005\bæ\u0001\u0010\u000eR*\u0010ç\u0001\u001a\u00020\u001b2\u0007\u0010ç\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bè\u0001\u0010Ô\u0001\"\u0006\bé\u0001\u0010Ö\u0001R)\u0010ë\u0001\u001a\u00020\u000f2\u0007\u0010ê\u0001\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\bë\u0001\u0010\u0087\u0001\"\u0005\bì\u0001\u0010\u0012R*\u0010í\u0001\u001a\u00020\u001b2\u0007\u0010í\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bî\u0001\u0010Ô\u0001\"\u0006\bï\u0001\u0010Ö\u0001R(\u0010ð\u0001\u001a\u00020\u00072\u0007\u0010ð\u0001\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bñ\u0001\u0010u\"\u0005\bò\u0001\u0010\u000eR*\u0010õ\u0001\u001a\u00020\u001b2\u0007\u0010Ñ\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bó\u0001\u0010Ô\u0001\"\u0006\bô\u0001\u0010Ö\u0001R(\u0010ö\u0001\u001a\u00020\u00072\u0007\u0010ö\u0001\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b÷\u0001\u0010u\"\u0005\bø\u0001\u0010\u000eR*\u0010ù\u0001\u001a\u00020\u001b2\u0007\u0010ù\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bú\u0001\u0010Ô\u0001\"\u0006\bû\u0001\u0010Ö\u0001R*\u0010ü\u0001\u001a\u00020\u001b2\u0007\u0010ü\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bý\u0001\u0010Ô\u0001\"\u0006\bþ\u0001\u0010Ö\u0001R*\u0010ÿ\u0001\u001a\u00020\u001b2\u0007\u0010ÿ\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0080\u0002\u0010Ô\u0001\"\u0006\b\u0081\u0002\u0010Ö\u0001R(\u0010\u0082\u0002\u001a\u00020\u00072\u0007\u0010\u0082\u0002\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0083\u0002\u0010u\"\u0005\b\u0084\u0002\u0010\u000eR(\u0010\u0085\u0002\u001a\u00020\u00072\u0007\u0010\u0085\u0002\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0086\u0002\u0010u\"\u0005\b\u0087\u0002\u0010\u000eR)\u0010\u0089\u0002\u001a\u00020\u000f2\u0007\u0010\u0088\u0002\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b\u0089\u0002\u0010\u0087\u0001\"\u0005\b\u008a\u0002\u0010\u0012¨\u0006\u008e\u0002"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", SlideCard.KEY_INDEX, "", "setFragments", "(I)V", "", "pressed", "c", "(Z)V", "n", "()V", "position", "m", "l", "b", "Landroid/graphics/Canvas;", "canvas", "", "cornerRadius", "e", "(Landroid/graphics/Canvas;F)V", "h", "f", "(Landroid/graphics/Canvas;)V", "g", "dp", "d", "(F)I", CloudControlInf.SP, "k", "Landroid/content/res/TypedArray;", "typedArray", "i", "(Landroid/content/Context;Landroid/content/res/TypedArray;)V", "j", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroidx/fragment/app/Fragment;", "getCurrentFragment", "()Landroidx/fragment/app/Fragment;", "enabled", "setEnabled", "apply", "applyContentMaterial", "Landroid/view/View;", "view", "setBackdropTarget", "(Landroid/view/View;)V", "isBackdropView", "updateBackdropTargetType", "srcType", "updateBackdropSrcType", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroid/graphics/drawable/Drawable;", "drawable", "invalidateDrawable", "(Landroid/graphics/drawable/Drawable;)V", "onDraw", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectListener;", "listener", "setOnTabSelectListener", "(Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectListener;)V", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectAnimListener;", "setOnTabSelectAnimListener", "(Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectAnimListener;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", WsConstants.KEY_CONNECTION_STATE, "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "a", "Landroid/content/Context;", "mContext", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mTabsContainer", "Lcom/obric/oui/layout/OUIFrameLayout;", "mContentRoot", "I", "mCurrentTabIndex", "Landroid/view/View;", "currentTabView", "", "Ljava/util/List;", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabList", "mPressedTab", "mLastTabIndex", "<set-?>", "getTabCount", "()I", "tabCount", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mDividerPaint", "F", "mTabPadding", "Z", "mTabSpaceEqual", "mTabWidth", "Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable;", "Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable;", "indicatorDrawable", "o", "getIndicatorSpacing", "indicatorSpacing", "p", "isIndicatorAnimEnable", "()Z", "setIndicatorAnimEnable", "q", "isIndicatorBounceEnable", "setIndicatorBounceEnable", "isIndicatorBounceEnable$annotations", "r", "mDividerColor", "s", "mDividerWidth", "t", "mDividerPadding", "u", "mTextSize", "v", "mTextSelectColor", "w", "mTextUnselectColor", FixCard.FixStyle.KEY_X, "mTextAllCaps", FixCard.FixStyle.KEY_Y, "mBarColor", "z", "mBarStrokeColor", "A", "mBarStrokeWidth", "B", "mHeight", "C", "mVibrateOnTabSelected", "Landroidx/fragment/app/FragmentManager;", "D", "Landroidx/fragment/app/FragmentManager;", "mFragmentManager", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "mFragments", "", "Lcom/obric/oui/common/style/Shadow;", "shadowsNormal", "G", "shadowsPressed", "H", "barPaint", "barStrokePaint", "Landroid/graphics/RectF;", "J", "Landroid/graphics/RectF;", "barRectF", "K", "barStrokeRectF", "Ljb/d;", "L", "Ljb/d;", "pressAnim", "M", "releaseAnim", "N", "pressScale", "O", "initScale", "P", "enableMaterial", "Q", "materialApplied", "R", "S", "materialSrcType", "T", "lastLayoutWidth", "U", "mIsFirstDraw", CommonKey.KEY_VALUE, "V", "getIndicatorCornerRadius", "()F", "setIndicatorCornerRadius", "(F)V", "indicatorCornerRadius", "W", "mTextPaint", "Landroid/util/SparseArray;", "a0", "Landroid/util/SparseArray;", "mInitSetMap", "b0", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectListener;", "mListener", "c0", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectAnimListener;", "mSelectAnimListener", "currentTab", "getCurrentTab", "setCurrentTab", "tabPadding", "getTabPadding", "setTabPadding", "tabSpaceEqual", "isTabSpaceEqual", "setTabSpaceEqual", "tabWidth", "getTabWidth", "setTabWidth", "indicatorColor", "getIndicatorColor", "setIndicatorColor", "getIndicatorHeight", "setIndicatorHeight", BannerCard.ATTR_INDICATOR_HEIGHT, "dividerColor", "getDividerColor", "setDividerColor", "dividerWidth", "getDividerWidth", "setDividerWidth", "dividerPadding", "getDividerPadding", "setDividerPadding", "textSize", "getTextSize", "setTextSize", "textSelectColor", "getTextSelectColor", "setTextSelectColor", "textUnselectColor", "getTextUnselectColor", "setTextUnselectColor", "textAllCaps", "isTextAllCaps", "setTextAllCaps", "d0", "TabSelectAnimListener", "TabSelectListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomNavActionBar extends OUIFrameLayout implements MaterialOwner {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final a f16553d0 = null;
    public float A;
    public int B;
    public boolean C;
    public FragmentManager D;
    public ArrayList E;
    public List F;
    public List G;
    public final Paint H;
    public final Paint I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final RectF f16554J;
    public final RectF K;
    public jb.d L;
    public jb.d M;
    public float N;
    public float O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public int S;
    public int T;
    public boolean U;
    public float V;
    public final Paint W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16555a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final SparseArray f16556a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f16557b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public TabSelectListener f16558b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OUIFrameLayout f16559c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public TabSelectAnimListener f16560c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f16562e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f16563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16564g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16565h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f16566i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f16567j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f16568k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f16569l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f16570m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ONaviIndicatorDrawable f16571n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f16572o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f16573p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f16574q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f16575r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f16576s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f16577t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f16578u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f16579v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f16580w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f16581x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f16582y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f16583z;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectAnimListener;", "", "onSelectAnimCancel", "", "onSelectAnimEnd", "onSelectAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface TabSelectAnimListener {
        void onSelectAnimCancel();

        void onSelectAnimEnd();

        void onSelectAnimStart();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectListener;", "", "onReselect", "", "position", "", "onSelect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface TabSelectListener {
        void onReselect(int r10);

        void onSelect(int r10);
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements ONaviIndicatorDrawable.AnimListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OBottomNavActionBar f16584a;

        public b(OBottomNavActionBar r10) {
            this.f16584a = r10;
        }

        @Override // com.obric.oui.segmentedtab.ONaviIndicatorDrawable.AnimListener
        public void onAnimCancel() {
            TabSelectAnimListener r10 = OBottomNavActionBar.a(this.f16584a);
            if (r10 == null) goto L7;
            r10.onSelectAnimCancel();
            return;
        }

        @Override // com.obric.oui.segmentedtab.ONaviIndicatorDrawable.AnimListener
        public void onAnimEnd() {
            TabSelectAnimListener r10 = OBottomNavActionBar.a(this.f16584a);
            if (r10 == null) goto L7;
            r10.onSelectAnimEnd();
            return;
        }

        @Override // com.obric.oui.segmentedtab.ONaviIndicatorDrawable.AnimListener
        public void onAnimStart() {
            TabSelectAnimListener r10 = OBottomNavActionBar.a(this.f16584a);
            if (r10 == null) goto L7;
            r10.onSelectAnimStart();
            return;
        }
    }

    static {
        f16553d0 = new a(null);
    }

    @JvmOverloads
    public OBottomNavActionBar(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final /* synthetic */ TabSelectAnimListener a(OBottomNavActionBar r10) {
        return r10.f16560c0;
    }

    private final void c(boolean r10) {
        jb.d r11 = this.L;
        if (r11 == null) goto L6;
        jb.d.c(r11, false, 1, null);
    L6:
        jb.d r12 = this.M;
        if (r12 == null) goto L10;
        jb.d.c(r12, false, 1, null);
    L10:
        if (r10 == false) goto L12;
        this.L = ShadowAnimator.c(this, this.O, this.N, getCurrentShadows(), this.G);
        return;
    L12:
        this.M = ShadowAnimator.c(this, this.N, this.O, getCurrentShadows(), this.F);
    }

    private final void i(Context r10, TypedArray r11) {
        List r12 = OUILayoutHelper.p(r10, r11, R$styleable.OTabLayout_shadow_normal);
        if (r12 != null) goto L5;
        r12 = OUILayoutHelper.p(r10, r11, R$styleable.OTabLayout_oui_widgetShadowNormal);
    L5:
        if (r12 == null) goto L7;
        this.F = r12;
        q.d(r12);
        Shadow r13 = (Shadow) b0.a0(r12, 0);
        List r14 = this.F;
        q.d(r14);
        setShadow(r13, (Shadow) b0.a0(r14, 1));
    L7:
        List r15 = OUILayoutHelper.p(r10, r11, R$styleable.OTabLayout_shadow_pressed);
        if (r15 != null) goto L10;
        r15 = OUILayoutHelper.p(r10, r11, R$styleable.OTabLayout_oui_widgetShadowPressed);
    L10:
        if (r15 == null) goto L13;
        this.G = r15;
        return;
    }

    private final void setFragments(int r10) {
        ArrayList r11 = this.E;
        if (r11 == null) goto L17;
        int r12 = r11.size();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L12;
        int r14 = r13 + 1;
        FragmentManager r15 = this.D;
        q.d(r15);
        FragmentTransaction r16 = r15.o();
        q.f(r16, "mFragmentManager!!.beginTransaction()");
        ArrayList r17 = this.E;
        q.d(r17);
        Object r18 = r17.get(r13);
        q.f(r18, "mFragments!![i]");
        Fragment r19 = (Fragment) r18;
        if (r13 != r10) goto L10;
        r16.A(r19);
    L11:
        r16.j();
        r13 = r14;
        goto L6
    L10:
        r16.r(r19);
        goto L11
    L12:
        this.f16561d = r10;
        return;
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r10) {
        if (this.Q != r10) goto L5;
        return;
    L5:
        this.Q = r10;
        f.b(this, r10, this.R);
        if (this.Q == false) goto L8;
        GradientDrawable r11 = new GradientDrawable();
        r11.setShape(0);
        r11.setCornerRadius(tc.f.u(this, 99));
        r11.setColor(0);
        setBackground(r11);
    L8:
        invalidate();
    }

    public final void b() {
        if (this.f16571n.l() == true) goto L6;
        View r10 = this.f16562e;
        q.d(r10);
        float r11 = r10.getLeft();
        View r12 = this.f16562e;
        q.d(r12);
        float r13 = r12.getRight();
        ONaviIndicatorDrawable r14 = this.f16571n;
        r14.o(r11, this.f16572o + this.A, r13 - r11, r14.k());
        return;
    }

    public final int d(float r10) {
        return (int) ((r10 * this.f16555a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        int r11 = r10.getAction();
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L6;
    L8:
        c(false);
    L11:
        return super.dispatchTouchEvent(r10);
    L6:
        if (r11 == 3) goto L8;
    L9:
        c(true);
        goto L11
    }

    public final void e(Canvas r10, float r11) {
        if (this.Q == false) goto L5;
        return;
    L5:
        this.H.setColor(this.f16582y);
        this.f16554J.set(0.0f, getPaddingTop(), getWidth(), getHeight() - getPaddingBottom());
        l.i(r10, this.f16554J, r11, this.H);
    }

    public final void f(Canvas r11) {
        if (this.f16571n.h() == true) goto L9;
        float r10 = this.f16576s;
        if (r10 <= 0.0f) goto L11;
        this.f16567j.setStrokeWidth(r10);
        this.f16567j.setColor(this.f16575r);
        int r12 = this.f16566i - 1;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L12;
        int r14 = r13 + 1;
        View r15 = this.f16557b.getChildAt(r13);
        r11.drawLine(getPaddingLeft() + r15.getRight(), this.f16577t, getPaddingLeft() + r15.getRight(), getHeight() - this.f16577t, this.f16567j);
        r13 = r14;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    public final void g(Canvas r10) {
        if (this.f16571n.h() == true) goto L5;
        b();
    L8:
        r10.translate(getPaddingLeft(), getPaddingTop());
        this.f16571n.draw(r10);
        r10.translate(-getPaddingLeft(), -getPaddingTop());
        return;
    L5:
        if (this.U == false) goto L8;
        this.U = false;
        b();
        goto L8
    }

    @Nullable
    public final Fragment getCurrentFragment() {
        ArrayList r10 = this.E;
        if (r10 != null) goto L6;
        return null;
    L6:
        return (Fragment) r10.get(this.f16561d);
    }

    public final int getCurrentTab() {
        return this.f16561d;
    }

    public final int getDividerColor() {
        return this.f16575r;
    }

    public final float getDividerPadding() {
        return this.f16577t;
    }

    public final float getDividerWidth() {
        return this.f16576s;
    }

    public final int getIndicatorColor() {
        return this.f16571n.i();
    }

    public final float getIndicatorCornerRadius() {
        return this.V;
    }

    public final float getIndicatorHeight() {
        return this.f16571n.k();
    }

    public final int getIndicatorSpacing() {
        return this.f16572o;
    }

    public final int getTabCount() {
        return this.f16566i;
    }

    @NotNull
    public final List<View> getTabList() {
        return this.f16563f;
    }

    public final float getTabPadding() {
        return this.f16568k;
    }

    public final float getTabWidth() {
        return this.f16570m;
    }

    public final int getTextSelectColor() {
        return this.f16579v;
    }

    public final float getTextSize() {
        return this.f16578u;
    }

    public final int getTextUnselectColor() {
        return this.f16580w;
    }

    public final void h(Canvas r10, float r11) {
        if (this.A <= 0.0f) goto L6;
        this.I.setColor(this.f16583z);
        this.I.setStrokeWidth(this.A);
        float r12 = 2;
        this.K.set(this.A / r12, getPaddingTop() + (this.A / r12), getWidth() - (this.A / r12), (getHeight() - getPaddingBottom()) - (this.A / r12));
        l.i(r10, this.K, r11, this.I);
        return;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r10) {
        q.g(r10, "drawable");
        super.invalidateDrawable(r10);
        if (q.b(r10, this.f16571n) == false) goto L6;
        invalidate();
        return;
    }

    public final void j(Context r13, AttributeSet r14) {
        q.g(r13, "context");
        this.f16571n.setCallback(this);
        TypedArray r15 = r13.obtainStyledAttributes(r14, R$styleable.OTabLayout);
        q.f(r15, "context.obtainStyledAttr…, R.styleable.OTabLayout)");
        this.f16571n.q(r15.getColor(R$styleable.OTabLayout_indicator_color, getResources().getColor(R$color.oui_fill_element_3)));
        this.f16571n.s(r15.getDimension(R$styleable.OTabLayout_indicator_height, -1.0f));
        this.f16571n.r(r15.getDimension(R$styleable.OTabLayout_indicator_corner_radius, -1.0f));
        setIndicatorCornerRadius(this.f16571n.j());
        this.f16572o = r15.getDimensionPixelSize(R$styleable.OTabLayout_indicator_spacing, d(4.0f));
        this.f16571n.p(r15.getBoolean(R$styleable.OTabLayout_indicator_anim_enable, false));
        this.f16574q = r15.getBoolean(R$styleable.OTabLayout_indicator_bounce_enable, true);
        this.f16557b.setPadding(getIndicatorSpacing(), 0, getIndicatorSpacing(), 0);
        this.f16559c.addView(this.f16557b);
        this.f16575r = r15.getColor(R$styleable.OTabLayout_divider_color, this.f16571n.i());
        this.f16576s = r15.getDimension(R$styleable.OTabLayout_divider_width, 0.0f);
        this.f16577t = r15.getDimension(R$styleable.OTabLayout_divider_padding, 0.0f);
        this.f16578u = r15.getDimension(R$styleable.OTabLayout_tab_textSize, d(10.0f));
        this.f16579v = r15.getColor(R$styleable.OTabLayout_tab_textSelectColor, this.f16555a.getColor(R$color.oui_text_1));
        this.f16580w = r15.getColor(R$styleable.OTabLayout_tab_textUnselectColor, this.f16555a.getColor(R$color.oui_text_3b));
        this.f16581x = r15.getBoolean(R$styleable.OTabLayout_tab_textAllCaps, false);
        this.f16569l = r15.getBoolean(R$styleable.OTabLayout_tab_space_equal, true);
        float r10 = r15.getDimension(R$styleable.OTabLayout_tab_width, d(-1.0f));
        this.f16570m = r10;
        int r11 = R$styleable.OTabLayout_tab_padding;
        if (this.f16569l == false) goto L5;
    L8:
        int r12 = d(0.0f);
    L9:
        this.f16568k = r15.getDimension(r11, r12);
        int r16 = r15.getColor(R$styleable.OTabLayout_bar_color, 0);
        this.f16582y = r16;
        this.f16583z = r15.getColor(R$styleable.OTabLayout_bar_stroke_color, r16);
        this.A = r15.getDimension(R$styleable.OTabLayout_bar_stroke_width, d(0.0f));
        this.C = r15.getBoolean(R$styleable.OTabLayout_vibrate_on_tab_selected, false);
        i(r13, r15);
        setShadowCornerRadius(tc.f.r(this, 99));
        if (this.P == false) goto L29;
        this.S = r15.getInt(R$styleable.OTabLayout_oui_widgetMaterialSrcType, -1);
        String r17 = r15.getString(R$styleable.OTabLayout_oui_widgetMaterial);
        if (r17 != null) goto L14;
        r17 = getResources().getString(R$string.oui_material_bg_floating);
    L14:
        com.obric.oui.material.b[] r18 = MaterialToken.parseSet(r17, !i.a(this));
        if (r18 == null) goto L17;
        boolean r19 = true;
    L18:
        this.P = r19;
        this.Q = r19;
        r15.recycle();
        if (this.Q == false) goto L30;
        setEnableShadowWidthRadius(true);
        setRadius(tc.f.r(this, 99));
        if (r18 == null) goto L31;
        int r110 = this.S;
        if (r110 != (-1)) goto L27;
        r110 = 2;
    L27:
        o.j(this, r18, false, r110, null, 10, null);
        GradientDrawable r111 = new GradientDrawable();
        r111.setShape(0);
        r111.setCornerRadius(tc.f.u(this, 99));
        r111.setColor(0);
        setBackground(r111);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        return;
    L31:
        return;
    L30:
        return;
    L17:
        r19 = false;
        goto L18
    L29:
        return;
    L5:
        if (r10 > 0.0f) goto L8;
        r12 = d(10.0f);
        goto L9
    }

    public final int k(float r10) {
        return (int) ((r10 * this.f16555a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public final void l() {
        View r10 = this.f16562e;
        q.d(r10);
        float r11 = r10.getLeft();
        View r12 = this.f16562e;
        q.d(r12);
        float r13 = r12.getRight();
        ONaviIndicatorDrawable r14 = this.f16571n;
        r14.t(r11, this.f16572o, r13 - r11, r14.k());
    }

    public final void m(int r10) {
        int r11 = this.f16566i;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L24;
        int r13 = r12 + 1;
        View r14 = this.f16557b.getChildAt(r12);
        if (r12 != r10) goto L7;
        boolean r15 = true;
    L8:
        ImageView r16 = (ImageView) r14.findViewById(R$id.tv_tab_icon);
        if (r15 == false) goto L12;
        int r17 = this.f16579v;
    L13:
        r16.setImageTintList(ColorStateList.valueOf(r17));
        td.c r18 = td.c.f24796a;
        if ((r14 instanceof OSegmentTabView) == false) goto L16;
        View r19 = r14;
    L17:
        OSegmentTabView r20 = (OSegmentTabView) r19;
        if (r20 == null) goto L21;
        r20.q(r15);
    L21:
        if (r15 == false) goto L23;
        this.f16562e = r14;
    L23:
        r12 = r13;
        goto L3
    L16:
        r19 = null;
        goto L17
    L12:
        r17 = this.f16580w;
        goto L13
    L7:
        r15 = false;
        goto L8
    }

    public final void n() {
        int r10 = this.f16566i;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L30;
        int r12 = r11 + 1;
        View r13 = this.f16557b.getChildAt(r11);
        float r14 = this.f16568k;
        r13.setPadding((int) r14, 0, (int) r14, 0);
        View r15 = r13.findViewById(R$id.tv_tab_title);
        if (r15 == null) goto L29;
        TextView r16 = (TextView) r15;
        if (r11 != this.f16561d) goto L9;
        boolean r17 = true;
    L11:
        if ((r13 instanceof OSegmentTabView) == false) goto L13;
        ((OSegmentTabView) r13).q(r17);
        r16.setTextSize(0, this.f16578u);
    L17:
        ImageView r18 = (ImageView) r13.findViewById(R$id.tv_tab_icon);
        if (r17 == false) goto L21;
        int r19 = this.f16579v;
    L22:
        r18.setImageTintList(ColorStateList.valueOf(r19));
        if (this.f16581x == false) goto L25;
        String r20 = r16.getText().toString();
        Locale r21 = Locale.ROOT;
        q.f(r21, "ROOT");
        String r22 = r20.toUpperCase(r21);
        q.f(r22, "this as java.lang.String).toUpperCase(locale)");
        r16.setText(r22);
    L25:
        if (r17 == false) goto L27;
        this.f16562e = r13;
    L27:
        r11 = r12;
        goto L3
    L21:
        r19 = this.f16580w;
        goto L22
    L13:
        if (r17 == false) goto L15;
        int r23 = this.f16579v;
    L16:
        r16.setTextColor(r23);
        r16.setTextSize(0, this.f16578u);
        goto L17
    L15:
        r23 = this.f16580w;
        goto L16
    L9:
        r17 = false;
        goto L11
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        super.onDraw(r10);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.f16566i <= 0) goto L10;
        float r11 = this.f16571n.j() + (this.f16572o / 2);
        e(r10, r11);
        h(r10, r11);
        f(r10);
        g(r10);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        this.f16571n.g(getHeight(), this.f16572o);
        if (getWidth() == this.T) goto L6;
        this.T = getWidth();
        this.U = true;
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        q.g(r10, WsConstants.KEY_CONNECTION_STATE);
        if ((r10 instanceof Bundle) == false) goto L9;
        Bundle r11 = (Bundle) r10;
        int r12 = r11.getInt("mCurrentTab");
        this.f16561d = r12;
        this.f16565h = r12;
        r10 = r11.getParcelable("instanceState");
        if (this.f16561d == 0) goto L9;
        if (this.f16557b.getChildCount() == 0) goto L9;
        m(this.f16561d);
    L9:
        super.onRestoreInstanceState(r10);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle r10 = new Bundle();
        r10.putInt("mCurrentTab", this.f16561d);
        r10.putParcelable("instanceState", super.onSaveInstanceState());
        return r10;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(@Nullable View r10) {
        o.n(this, r10);
    }

    public final void setCurrentTab(int r10) {
        int r11 = this.f16561d;
        if (r10 != r11) goto L10;
        TabSelectListener r12 = this.f16558b0;
        if (r12 == null) goto L20;
        if (r12 == null) goto L21;
        r12.onReselect(r11);
        return;
    L21:
        return;
    L20:
        return;
    L10:
        this.U = true;
        this.f16565h = r11;
        this.f16561d = r10;
        m(r10);
        setFragments(r10);
        TabSelectListener r13 = this.f16558b0;
        if (r13 == null) goto L16;
        if (r13 == null) goto L16;
        r13.onSelect(this.f16561d);
    L16:
        if (this.f16571n.h() == false) goto L18;
        l();
        return;
    L18:
        invalidate();
    }

    public final void setDividerColor(int r10) {
        this.f16575r = r10;
        invalidate();
    }

    public final void setDividerPadding(float r10) {
        this.f16577t = d(r10);
        invalidate();
    }

    public final void setDividerWidth(float r10) {
        this.f16576s = d(r10);
        invalidate();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        Iterator r11 = this.f16563f.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((View) r11.next()).setEnabled(r10);
        goto L4
    }

    public final void setIndicatorAnimEnable(boolean r10) {
        this.f16573p = r10;
    }

    public final void setIndicatorBounceEnable(boolean r10) {
        this.f16574q = r10;
    }

    public final void setIndicatorColor(int r10) {
        this.f16571n.q(r10);
    }

    public final void setIndicatorCornerRadius(float r10) {
        this.f16571n.r(d(r10));
        this.V = this.f16571n.j();
    }

    public final void setIndicatorHeight(float r10) {
        this.f16571n.s(d(r10));
    }

    public final void setOnTabSelectAnimListener(@Nullable TabSelectAnimListener r10) {
        this.f16560c0 = r10;
        if (r10 != null) goto L6;
        this.f16571n.m(null);
        return;
    L6:
        this.f16571n.m(new b(this));
    }

    public final void setOnTabSelectListener(@Nullable TabSelectListener r10) {
        this.f16558b0 = r10;
    }

    public final void setTabList(@NotNull List<View> r10) {
        q.g(r10, "<set-?>");
        this.f16563f = r10;
    }

    public final void setTabPadding(float r10) {
        this.f16568k = d(r10);
        n();
    }

    public final void setTabSpaceEqual(boolean r10) {
        this.f16569l = r10;
        n();
    }

    public final void setTabWidth(float r10) {
        this.f16570m = d(r10);
        n();
    }

    public final void setTextAllCaps(boolean r10) {
        this.f16581x = r10;
        n();
    }

    public final void setTextSelectColor(int r10) {
        this.f16579v = r10;
        n();
    }

    public final void setTextSize(float r10) {
        this.f16578u = k(r10);
        n();
    }

    public final void setTextUnselectColor(int r10) {
        this.f16580w = r10;
        n();
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r10) {
        this.S = r10;
        o.p(this, r10);
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r10) {
        if (this.R == r10) goto L9;
        this.R = r10;
        if (this.S == (-1)) goto L7;
        return;
    L7:
        o.q(this, r10);
        return;
    }

    @JvmOverloads
    public OBottomNavActionBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OBottomNavActionBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OBottomNavActionBar(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12, null, 8, null);
        this.f16563f = new ArrayList();
        this.f16564g = -1;
        this.f16567j = new Paint(1);
        this.f16571n = new ONaviIndicatorDrawable();
        this.f16573p = true;
        Paint r13 = new Paint(1);
        r13.setStyle(Paint.Style.FILL);
        this.H = r13;
        Paint r14 = new Paint(1);
        r14.setStyle(Paint.Style.STROKE);
        this.I = r14;
        this.f16554J = new RectF();
        this.K = new RectF();
        this.N = 0.988f;
        this.O = 1.0f;
        this.R = true;
        this.S = -1;
        this.T = -1;
        if (o.f(this) == true) goto L5;
    L7:
        boolean r15 = false;
    L8:
        this.P = r15;
        this.Q = r15;
        this.U = true;
        this.W = new Paint(1);
        this.f16556a0 = new SparseArray();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f16555a = r10;
        this.f16557b = new LinearLayout(r10);
        OUIFrameLayout r16 = new OUIFrameLayout(r10, null, 0, null, 14, null);
        this.f16559c = r16;
        r16.setRadius(tc.f.r(this, 99));
        this.f16559c.setChangeAlphaWhenPress(false);
        this.f16559c.setChangeAlphaWhenDisable(false);
        this.f16559c.setChangeAlphaWhenSelected(false);
        addView(this.f16559c);
        q.d(r11);
        String r17 = r11.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (q.b(r17, "-1") == false) goto L12;
        return;
    L12:
        if (q.b(r17, "-2") == true) goto L17;
        TypedArray r18 = r10.obtainStyledAttributes(r11, new int[]{R.attr.layout_height});
        q.f(r18, "context.obtainStyledAttributes(attrs, systemAttrs)");
        this.B = r18.getDimensionPixelSize(0, -2);
        r18.recycle();
        return;
    L17:
        return;
    L5:
        if (OMaterialHelper.w() == false) goto L7;
        r15 = true;
        goto L8
    }
}
