package com.stepos.agentframework.floatcard.view;

import E4.FloatCardAction;
import E4.FloatCardBadgeBorder;
import E4.FloatCardContent;
import E4.FloatCardOption;
import E4.FloatCardPage;
import E4.FloatCardRequest;
import E4.FloatCardRiskBadge;
import E4.d;
import E4.g;
import E4.m;
import E4.n;
import La.H;
import Z8.A;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.N;
import androidx.core.view.a0;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.R$color;
import com.stepos.agentframework.floatcard.R$dimen;
import com.stepos.agentframework.floatcard.R$drawable;
import com.stepos.agentframework.floatcard.R$id;
import com.stepos.agentframework.floatcard.R$string;
import com.stepos.agentframework.floatcard.api.FloatCardActionStyle;
import com.stepos.agentframework.floatcard.api.FloatCardOptionStyle;
import com.stepos.agentframework.floatcard.api.FloatCardRiskLevel;
import com.stepos.agentframework.floatcard.api.FloatCardSkipMode;
import com.stepos.agentframework.floatcard.api.FloatCardStatus;
import com.stepos.agentframework.floatcard.api.SelectionMode;
import com.stepos.agentframework.floatcard.view.t;
import com.stepos.agentframework.uikit.C2148w;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0011*\u0002½\u0001\u0018\u0000 Ë\u00012\u00020\u00012\u00020\u0002:\u0002Ì\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0010H\u0016¢\u0006\u0004\b \u0010\u0012J\u001f\u0010#\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0018H\u0016¢\u0006\u0004\b#\u0010\u001fJ\u0017\u0010$\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b$\u0010\u0017J\u000f\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b%\u0010\u0012J\u000f\u0010&\u001a\u00020\u0010H\u0002¢\u0006\u0004\b&\u0010\u0012J\u0017\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020'H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0018H\u0002¢\u0006\u0004\b-\u0010.J\u0011\u00100\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0004\b0\u00101J\u0015\u00104\u001a\b\u0012\u0004\u0012\u00020302H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u000206H\u0002¢\u0006\u0004\b7\u00108J\u0011\u0010:\u001a\u0004\u0018\u000109H\u0002¢\u0006\u0004\b:\u0010;J\u0019\u0010>\u001a\u0004\u0018\u00010=2\u0006\u0010<\u001a\u00020'H\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0010H\u0002¢\u0006\u0004\b@\u0010\u0012J\u000f\u0010A\u001a\u00020\u0010H\u0002¢\u0006\u0004\bA\u0010\u0012J\u001f\u0010D\u001a\u00020\u00102\u0006\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020/H\u0002¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020\u00102\u0006\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020/H\u0002¢\u0006\u0004\bF\u0010EJ\u0017\u0010G\u001a\u00020\u00182\u0006\u0010C\u001a\u00020/H\u0002¢\u0006\u0004\bG\u0010HJ\u001f\u0010I\u001a\u00020\u00102\u0006\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020/H\u0002¢\u0006\u0004\bI\u0010EJ\u001f\u0010J\u001a\u00020\u00102\u0006\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020/H\u0002¢\u0006\u0004\bJ\u0010EJ!\u0010N\u001a\u00020\u00102\u0006\u0010L\u001a\u00020K2\b\u0010!\u001a\u0004\u0018\u00010MH\u0002¢\u0006\u0004\bN\u0010OJ\u001f\u0010P\u001a\u00020\u00102\u0006\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020/H\u0002¢\u0006\u0004\bP\u0010EJ'\u0010U\u001a\u00020\u00102\u0006\u0010B\u001a\u00020=2\u0006\u0010R\u001a\u00020Q2\u0006\u0010T\u001a\u00020SH\u0002¢\u0006\u0004\bU\u0010VJ\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00020\f0W2\u0006\u0010T\u001a\u00020SH\u0002¢\u0006\u0004\bX\u0010YJ\u0017\u0010[\u001a\u00020Z2\u0006\u0010!\u001a\u00020\fH\u0002¢\u0006\u0004\b[\u0010\\J\u0017\u0010_\u001a\u00020Z2\u0006\u0010^\u001a\u00020]H\u0002¢\u0006\u0004\b_\u0010`J\u0017\u0010b\u001a\u00020\u00102\u0006\u0010a\u001a\u00020ZH\u0002¢\u0006\u0004\bb\u0010cJ\u001f\u0010f\u001a\u00020\u00182\u0006\u0010T\u001a\u00020S2\u0006\u0010e\u001a\u00020dH\u0002¢\u0006\u0004\bf\u0010gJ\u0017\u0010h\u001a\u00020\u00102\u0006\u0010B\u001a\u00020=H\u0002¢\u0006\u0004\bh\u0010iJ/\u0010k\u001a\u00020Z2\u0006\u0010B\u001a\u00020=2\u0006\u0010j\u001a\u00020Q2\u0006\u0010T\u001a\u00020S2\u0006\u0010e\u001a\u00020dH\u0002¢\u0006\u0004\bk\u0010lJ/\u0010m\u001a\u00020Z2\u0006\u0010B\u001a\u00020=2\u0006\u0010j\u001a\u00020Q2\u0006\u0010T\u001a\u00020S2\u0006\u0010e\u001a\u00020dH\u0002¢\u0006\u0004\bm\u0010lJ\u001f\u0010n\u001a\u00020\u00182\u0006\u0010T\u001a\u00020S2\u0006\u0010e\u001a\u00020dH\u0002¢\u0006\u0004\bn\u0010gJ\u001f\u0010o\u001a\u00020\u00182\u0006\u0010T\u001a\u00020S2\u0006\u0010e\u001a\u00020dH\u0002¢\u0006\u0004\bo\u0010gJ\u001f\u0010p\u001a\u00020\u00102\u0006\u0010T\u001a\u00020S2\u0006\u0010e\u001a\u00020dH\u0002¢\u0006\u0004\bp\u0010qJ\u001f\u0010r\u001a\u00020\u00102\u0006\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020/H\u0002¢\u0006\u0004\br\u0010EJ\u001f\u0010s\u001a\u00020\u00102\u0006\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020/H\u0002¢\u0006\u0004\bs\u0010EJ\u000f\u0010t\u001a\u00020\u0010H\u0002¢\u0006\u0004\bt\u0010\u0012J\u000f\u0010u\u001a\u00020\u0010H\u0002¢\u0006\u0004\bu\u0010\u0012J\u000f\u0010v\u001a\u00020\u0010H\u0002¢\u0006\u0004\bv\u0010\u0012J\u000f\u0010w\u001a\u00020\u0010H\u0002¢\u0006\u0004\bw\u0010\u0012J\u000f\u0010x\u001a\u00020\u0018H\u0002¢\u0006\u0004\bx\u0010.J\u0017\u0010y\u001a\u00020\u00182\u0006\u0010C\u001a\u00020/H\u0002¢\u0006\u0004\by\u0010HJ\u000f\u0010z\u001a\u00020\u0018H\u0002¢\u0006\u0004\bz\u0010.J\u0017\u0010{\u001a\u00020\u00182\u0006\u0010C\u001a\u00020/H\u0002¢\u0006\u0004\b{\u0010HJ\u000f\u0010|\u001a\u00020\u0018H\u0002¢\u0006\u0004\b|\u0010.J\u0019\u0010}\u001a\u0004\u0018\u0001092\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b}\u0010~J\u0017\u0010\u007f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u007f\u0010\u0017J\u001a\u0010\u0080\u0001\u001a\u00020\u00102\u0006\u0010R\u001a\u00020QH\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0019\u0010\u0082\u0001\u001a\u00020\u00102\u0006\u0010B\u001a\u00020=H\u0002¢\u0006\u0005\b\u0082\u0001\u0010iJ\u001b\u0010\u0084\u0001\u001a\u00020\u00102\u0007\u0010\u0083\u0001\u001a\u00020\u0018H\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0011\u0010\u0086\u0001\u001a\u00020\u0010H\u0002¢\u0006\u0005\b\u0086\u0001\u0010\u0012J\u0011\u0010\u0087\u0001\u001a\u00020\u0010H\u0002¢\u0006\u0005\b\u0087\u0001\u0010\u0012J\u0011\u0010\u0088\u0001\u001a\u00020\u0010H\u0002¢\u0006\u0005\b\u0088\u0001\u0010\u0012J\u0019\u0010\u0089\u0001\u001a\u00020\u00102\u0006\u0010<\u001a\u00020'H\u0002¢\u0006\u0005\b\u0089\u0001\u0010*J\u001b\u0010\u008b\u0001\u001a\u00020\u00182\u0007\u0010\u008a\u0001\u001a\u00020ZH\u0002¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0019\u0010\u008d\u0001\u001a\u00020\u00102\u0006\u0010B\u001a\u00020=H\u0002¢\u0006\u0005\b\u008d\u0001\u0010iJ\u0019\u0010\u008e\u0001\u001a\u00020\u00102\u0006\u0010B\u001a\u00020=H\u0002¢\u0006\u0005\b\u008e\u0001\u0010iJ&\u0010\u0091\u0001\u001a\u00020\u00102\u0007\u0010\u008f\u0001\u001a\u00020\f2\t\b\u0002\u0010\u0090\u0001\u001a\u00020\fH\u0002¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J%\u0010\u0095\u0001\u001a\u00020\u00102\u0007\u0010\u008f\u0001\u001a\u00020\f2\b\u0010\u0094\u0001\u001a\u00030\u0093\u0001H\u0002¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u001b\u0010\u0098\u0001\u001a\u00020'2\u0007\u0010\u0097\u0001\u001a\u00020'H\u0002¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0017\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0006\u0010\u009a\u0001R\u0015\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\b\u0010\u009b\u0001R2\u0010\u009d\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u009c\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\u0018\u0010¤\u0001\u001a\u00030£\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R$\u0010§\u0001\u001a\u000f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0¦\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u0018\u0010©\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b©\u0001\u0010NR\u0019\u0010ª\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010\u008d\u0001R\u0018\u0010«\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b«\u0001\u0010NR\u0018\u0010¬\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¬\u0001\u0010NR\u001c\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001b\u0010°\u0001\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R$\u0010²\u0001\u001a\u000f\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020'0¦\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b²\u0001\u0010¨\u0001R\u0018\u0010´\u0001\u001a\u00030³\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u0018\u0010¶\u0001\u001a\u00030³\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010µ\u0001R\u0018\u0010¸\u0001\u001a\u00030·\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u0018\u0010»\u0001\u001a\u00030º\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u0018\u0010¾\u0001\u001a\u00030½\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0017\u0010Â\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u0017\u0010\u008a\u0001\u001a\u00020Z8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÃ\u0001\u0010Ä\u0001R\u0014\u0010Æ\u0001\u001a\u00020\f8F¢\u0006\b\u001a\u0006\bÅ\u0001\u0010Á\u0001R\u0019\u0010È\u0001\u001a\u0004\u0018\u00010Z8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÇ\u0001\u0010Ä\u0001R\u001c\u0010Ê\u0001\u001a\b\u0012\u0004\u0012\u00020/028BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÉ\u0001\u00105¨\u0006Í\u0001"}, d2 = {"Lcom/stepos/agentframework/floatcard/view/p;", "Landroid/widget/FrameLayout;", "LE4/o;", "Landroid/content/Context;", "context", "LE4/k;", "request", "LE4/q;", "dispatcher", "<init>", "(Landroid/content/Context;LE4/k;LE4/q;)V", "", "", "LE4/n;", "T0", "()Ljava/util/Map;", "LY8/t;", "onAttachedToWindow", "()V", "onDetachedFromWindow", "LE4/c;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "e", "(LE4/c;)V", "", ChatTracker.PREVIEW_LOADING, "message", Const.INTENT_KEY_UMID, "(ZLjava/lang/String;)V", "retryable", "c", "(Ljava/lang/String;Z)V", "destroy", "text", "isFinal", "f", "N0", "Y", "P", "", "index", "v0", "(I)V", "L0", "()I", "z0", "()Z", "LE4/j;", "k0", "()LE4/j;", "", "LE4/g;", "j0", "()Ljava/util/List;", "Lcom/stepos/agentframework/floatcard/api/FloatCardSkipMode;", "n0", "()Lcom/stepos/agentframework/floatcard/api/FloatCardSkipMode;", "LE4/a;", "m0", "()LE4/a;", "position", "LF4/c;", "u0", "(I)LF4/c;", ExifInterface.GPS_DIRECTION_TRUE, "J", "pageBinding", "page", ExifInterface.LATITUDE_SOUTH, "(LF4/c;LE4/j;)V", ExifInterface.LONGITUDE_WEST, "C0", "(LE4/j;)Z", "L", "b0", "Landroid/widget/TextView;", "textView", "", "Z", "(Landroid/widget/TextView;Ljava/lang/CharSequence;)V", "Q", "Landroid/widget/LinearLayout;", "container", "LE4/g$b;", "selection", ExifInterface.LONGITUDE_EAST, "(LF4/c;Landroid/widget/LinearLayout;LE4/g$b;)V", "", "Q0", "(LE4/g$b;)Ljava/util/Set;", "Landroid/view/View;", "i0", "(Ljava/lang/String;)Landroid/view/View;", "LE4/g$a;", "action", "c0", "(LE4/g$a;)Landroid/view/View;", "row", "H", "(Landroid/view/View;)V", "LE4/h;", "option", "B0", "(LE4/g$b;LE4/h;)Z", "V0", "(LF4/c;)V", "parent", "g0", "(LF4/c;Landroid/widget/LinearLayout;LE4/g$b;LE4/h;)Landroid/view/View;", "e0", "F0", "x0", "w0", "(LE4/g$b;LE4/h;)V", "X", "N", "G0", "H0", "q0", "t0", "l0", "K0", "R0", "S0", "y0", "s0", "(LE4/c;)LE4/a;", "R", "F", "(Landroid/widget/LinearLayout;)V", "U0", x5.d.EXTRA_ENABLED, "setInteractiveEnabled", "(Z)V", "W0", "X0", "P0", "G", "view", "A0", "(Landroid/view/View;)Z", "I", "D0", "actionId", "payloadValue", "p0", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Bundle;", "payload", "o0", "(Ljava/lang/String;Landroid/os/Bundle;)V", UxipConstants.f30680s, "r0", "(I)I", "LE4/k;", "LE4/q;", "Lkotlin/Function0;", "onContentHeightSettled", "Lp9/a;", "getOnContentHeightSettled", "()Lp9/a;", "setOnContentHeightSettled", "(Lp9/a;)V", "LF4/d;", "binding", "LF4/d;", "", "values", "Ljava/util/Map;", "isLoading", "currentPageIndex", "imeVisible", "isSubmitting", "LE4/s;", "activeInputView", "LE4/s;", "currentPageBinding", "LF4/c;", "pageBindingPositions", "Ljava/lang/Runnable;", "pagerHeightUpdateRunnable", "Ljava/lang/Runnable;", "rippleDelayRunnable", "Landroid/view/View$OnLayoutChangeListener;", "vpLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "Lcom/stepos/agentframework/floatcard/view/t;", "pageAdapter", "Lcom/stepos/agentframework/floatcard/view/t;", "com/stepos/agentframework/floatcard/view/p$c", "pageChangeCallback", "Lcom/stepos/agentframework/floatcard/view/p$c;", "getCardId", "()Ljava/lang/String;", "cardId", "getView", "()Landroid/view/View;", "getBusinessType", "businessType", "getContentView", "contentView", "getPages", "pages", "Companion", Const.INTENT_KEY_APIKEY, "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class p extends FrameLayout implements E4.o {

    @Deprecated
    public static final float DEFAULT_BADGE_CORNER_DP = 4.0f;

    @Deprecated
    public static final int OPTIONS_VISIBLE_DEFAULT = 3;

    @Deprecated
    public static final int OPTIONS_VISIBLE_WITH_IME = 2;

    @Deprecated
    public static final String OPTION_ROW_TAG = "float_card_option_row";

    @Deprecated
    public static final long RIPPLE_DELAY_MS = 150;
    private E4.s activeInputView;
    private final F4.d binding;
    private F4.c currentPageBinding;
    private int currentPageIndex;
    private final E4.q dispatcher;
    private boolean imeVisible;
    private boolean isLoading;
    private boolean isSubmitting;
    private InterfaceC5063a<Y8.t> onContentHeightSettled;
    private final t pageAdapter;
    private final Map<F4.c, Integer> pageBindingPositions;
    private final c pageChangeCallback;
    private final Runnable pagerHeightUpdateRunnable;
    private FloatCardRequest request;
    private final Runnable rippleDelayRunnable;
    private final Map<String, E4.n> values;
    private final View.OnLayoutChangeListener vpLayoutChangeListener;
    private static final a Companion = new a(null);
    private static final FloatCardAction DEFAULT_SUBMIT_ACTION = new FloatCardAction("submit", "", FloatCardActionStyle.Primary, null, 8, null);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/floatcard/view/p$a;", "", "<init>", "()V", "", "OPTION_ROW_TAG", "Ljava/lang/String;", "", "OPTIONS_VISIBLE_DEFAULT", "I", "OPTIONS_VISIBLE_WITH_IME", "", "RIPPLE_DELAY_MS", "J", "", "DEFAULT_BADGE_CORNER_DP", "F", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[FloatCardRiskLevel.values().length];
            try {
                iArr[FloatCardRiskLevel.High.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FloatCardRiskLevel.Medium.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FloatCardRiskLevel.Low.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FloatCardOptionStyle.values().length];
            try {
                iArr2[FloatCardOptionStyle.Audio.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FloatCardOptionStyle.Checkmark.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FloatCardOptionStyle.Plain.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/stepos/agentframework/floatcard/view/p$c", "Landroidx/viewpager2/widget/ViewPager2$i;", "", "position", "LY8/t;", "onPageSelected", "(I)V", VoiceWakeupReceiver.EXTRA_STATE, "onPageScrollStateChanged", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends ViewPager2.i {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrollStateChanged(int state) {
            if (state == 0) {
                p pVar = p.this;
                F4.c cVarU0 = pVar.u0(pVar.currentPageIndex);
                if (cVarU0 == null) {
                    cVarU0 = p.this.currentPageBinding;
                }
                pVar.currentPageBinding = cVarU0;
                p.this.X0();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int position) {
            if (position == p.this.currentPageIndex) {
                return;
            }
            p.this.currentPageIndex = position;
            p pVar = p.this;
            pVar.currentPageBinding = pVar.u0(position);
            p.this.Y();
            p.this.W0();
            p.this.P0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, FloatCardRequest request, E4.q dispatcher) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(dispatcher, "dispatcher");
        this.request = request;
        this.dispatcher = dispatcher;
        F4.d dVarB = F4.d.b(LayoutInflater.from(context), this, true);
        kotlin.jvm.internal.p.h(dVarB, "inflate(...)");
        this.binding = dVarB;
        this.values = new LinkedHashMap();
        this.pageBindingPositions = new LinkedHashMap();
        this.pagerHeightUpdateRunnable = new Runnable() { // from class: com.stepos.agentframework.floatcard.view.i
            @Override // java.lang.Runnable
            public final void run() {
                p.M0(this.f23283a);
            }
        };
        this.rippleDelayRunnable = new Runnable() { // from class: com.stepos.agentframework.floatcard.view.j
            @Override // java.lang.Runnable
            public final void run() {
                p.O0(this.f23284a);
            }
        };
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.stepos.agentframework.floatcard.view.k
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                p.Y0(this.f23285a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.vpLayoutChangeListener = onLayoutChangeListener;
        t tVar = new t(C1173v.m(), new p9.p() { // from class: com.stepos.agentframework.floatcard.view.l
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return p.I0(this.f23286a, (F4.c) obj, (FloatCardPage) obj2);
            }
        }, new p9.p() { // from class: com.stepos.agentframework.floatcard.view.m
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return p.J0(this.f23287a, ((Integer) obj).intValue(), (F4.c) obj2);
            }
        });
        this.pageAdapter = tVar;
        c cVar = new c();
        this.pageChangeCallback = cVar;
        setClipChildren(false);
        setClipToPadding(false);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        dVarB.viewPager.setAdapter(tVar);
        dVarB.viewPager.j(cVar);
        dVarB.viewPager.addOnLayoutChangeListener(onLayoutChangeListener);
        N0(this.request.getContent());
    }

    public static final a0 E0(p pVar, View view, a0 insets) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        boolean zR = insets.r(a0.o.b());
        if (pVar.imeVisible != zR) {
            pVar.imeVisible = zR;
            pVar.P0();
        }
        return insets;
    }

    public static final Y8.t I0(p pVar, F4.c pageBinding, FloatCardPage page) {
        kotlin.jvm.internal.p.i(pageBinding, "pageBinding");
        kotlin.jvm.internal.p.i(page, "page");
        pVar.S(pageBinding, page);
        return Y8.t.f7040a;
    }

    public static final Y8.t J0(p pVar, int i10, F4.c pageBinding) {
        kotlin.jvm.internal.p.i(pageBinding, "pageBinding");
        pVar.pageBindingPositions.put(pageBinding, Integer.valueOf(i10));
        if (i10 == pVar.currentPageIndex) {
            pVar.currentPageBinding = pageBinding;
            pVar.R(pVar.request.getContent());
            pVar.setInteractiveEnabled(!pVar.isLoading);
        }
        pVar.P0();
        return Y8.t.f7040a;
    }

    public static final void K(p pVar, View view) {
        pVar.H0();
    }

    public static final void M(p pVar, View view) {
        pVar.H0();
    }

    public static final void M0(p pVar) {
        pVar.X0();
    }

    public static final void O(p pVar, View view) {
        if (!pVar.y0() || pVar.isLoading || pVar.isSubmitting) {
            return;
        }
        pVar.G0();
    }

    public static final void O0(p pVar) {
        pVar.G0();
    }

    public static final void U(p pVar, View view) {
        int i10 = pVar.currentPageIndex;
        if (i10 > 0) {
            pVar.v0(i10 - 1);
        }
    }

    public static final void V(p pVar, int i10, View view) {
        int i11 = pVar.currentPageIndex;
        if (i11 < i10 - 1) {
            pVar.v0(i11 + 1);
        }
    }

    public static final void Y0(p pVar, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18 = i12 - i10;
        int i19 = i13 - i11;
        boolean z10 = i18 != i16 - i14;
        boolean z11 = i19 != i17 - i15;
        if (i18 > 0) {
            if (z10 || z11) {
                pVar.P0();
            }
        }
    }

    public static final Y8.t a0(p pVar, String url) {
        kotlin.jvm.internal.p.i(url, "url");
        pVar.dispatcher.a(new d.LinkClicked(pVar.request.getCardId(), pVar.request.getBusinessType(), pVar.request.getPayload(), url));
        return Y8.t.f7040a;
    }

    public static final void d0(p pVar, g.ActionButton actionButton, View view) {
        if (pVar.isLoading) {
            return;
        }
        pVar.o0(actionButton.getId(), actionButton.getPayload());
    }

    public static final void f0(FloatCardOption floatCardOption, p pVar, g.Selection selection, F4.c cVar, View view) {
        if (!floatCardOption.getEnabled() || pVar.isLoading) {
            return;
        }
        if (pVar.F0(selection, floatCardOption)) {
            pVar.removeCallbacks(pVar.rippleDelayRunnable);
            pVar.postDelayed(pVar.rippleDelayRunnable, 150L);
        } else {
            pVar.V0(cVar);
            pVar.U0(cVar);
        }
    }

    private final List<FloatCardPage> getPages() {
        return this.request.getContent().a();
    }

    public static final void h0(FloatCardOption floatCardOption, p pVar, g.Selection selection, F4.c cVar, View view) {
        if (!floatCardOption.getEnabled() || pVar.isLoading) {
            return;
        }
        if (pVar.F0(selection, floatCardOption)) {
            pVar.removeCallbacks(pVar.rippleDelayRunnable);
            pVar.postDelayed(pVar.rippleDelayRunnable, 150L);
        } else {
            pVar.V0(cVar);
            pVar.U0(cVar);
        }
    }

    private final void setInteractiveEnabled(boolean enabled) {
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        F4.c cVar = this.currentPageBinding;
        if (cVar != null && (linearLayout = cVar.layoutOptions) != null) {
            linearLayout.setEnabled(enabled);
        }
        boolean z10 = false;
        if (cVar != null && (textView2 = cVar.btnConfirm) != null) {
            textView2.setEnabled(enabled && y0());
        }
        this.binding.ivPagePrev.setEnabled(enabled && this.currentPageIndex > 0);
        this.binding.ivPageNext.setEnabled(enabled && this.currentPageIndex < L0() - 1);
        if (enabled && n0() == FloatCardSkipMode.Enabled) {
            z10 = true;
        }
        if (L0() <= 1) {
            FloatCardPage floatCardPageK0 = k0();
            if ((floatCardPageK0 != null ? floatCardPageK0.getRiskBadge() : null) == null) {
                if (cVar == null || (textView = cVar.tvSkipInline) == null) {
                    return;
                }
                textView.setEnabled(z10);
                return;
            }
        }
        this.binding.tvSkip.setEnabled(z10);
        this.binding.tvSkip.setClickable(z10);
        this.binding.tvSkip.setAlpha(z10 ? 1.0f : 0.35f);
    }

    public final boolean A0(View view) {
        return kotlin.jvm.internal.p.d(view.getTag(), OPTION_ROW_TAG);
    }

    public final boolean B0(g.Selection selection, FloatCardOption option) {
        E4.n nVar = this.values.get(selection.getId());
        n.Selected selected = nVar instanceof n.Selected ? (n.Selected) nVar : null;
        List<String> listA = selected != null ? selected.a() : null;
        if (listA == null) {
            listA = C1173v.m();
        }
        if (listA.contains(option.getId())) {
            return true;
        }
        return listA.isEmpty() && option.getSelected();
    }

    public final boolean C0(FloatCardPage page) {
        return L0() <= 1 && page.getRiskBadge() == null && page.getSkipMode() != FloatCardSkipMode.Hidden;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D0(F4.c r6) {
        /*
            r5 = this;
            F4.d r0 = r5.binding
            androidx.viewpager2.widget.ViewPager2 r0 = r0.viewPager
            java.lang.String r1 = "viewPager"
            kotlin.jvm.internal.p.h(r0, r1)
            int r1 = r0.getWidth()
            if (r1 > 0) goto L10
            goto L60
        L10:
            r2 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2)
            r2 = 0
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r2)
            android.widget.LinearLayout r3 = r6.layoutPageContent
            java.lang.String r4 = "layoutPageContent"
            kotlin.jvm.internal.p.h(r3, r4)
            r3.measure(r1, r2)
            r5.I(r6)
            r3.measure(r1, r2)
            int r1 = r3.getMeasuredHeight()
            if (r1 > 0) goto L32
            goto L60
        L32:
            android.view.ViewGroup$LayoutParams r2 = r0.getLayoutParams()
            int r3 = r2.height
            if (r3 == r1) goto L3f
            r2.height = r1
            r0.setLayoutParams(r2)
        L3f:
            java.util.Map<F4.c, java.lang.Integer> r0 = r5.pageBindingPositions
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L51
            int r1 = r5.currentPageIndex
            int r0 = r0.intValue()
            if (r0 != r1) goto L53
        L51:
            r5.currentPageBinding = r6
        L53:
            p9.a r6 = r5.getOnContentHeightSettled()
            if (r6 == 0) goto L60
            r0 = 0
            r5.setOnContentHeightSettled(r0)
            r6.invoke()
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.floatcard.view.p.D0(F4.c):void");
    }

    public final void E(F4.c pageBinding, LinearLayout container, g.Selection selection) {
        Set<String> setQ0 = Q0(selection);
        if (!setQ0.isEmpty()) {
            this.values.put(selection.getId(), new n.Selected(F.m1(setQ0)));
        }
        String title = selection.getTitle();
        if (title != null) {
            if (H.x0(title)) {
                title = null;
            }
            if (title != null) {
                container.addView(i0(title));
            }
        }
        int i10 = 0;
        for (Object obj : selection.c()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            container.addView(g0(pageBinding, container, selection, (FloatCardOption) obj));
            i10 = i11;
        }
    }

    public final void F(LinearLayout container) {
        for (int i10 = 0; i10 < 3; i10++) {
            View view = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, r0(23));
            layoutParams.setMarginStart(r0(20));
            layoutParams.setMarginEnd(r0(20));
            layoutParams.topMargin = r0(16);
            if (i10 == 2) {
                layoutParams.bottomMargin = r0(16);
            }
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(R$drawable.bg_float_card_skeleton);
            container.addView(view);
        }
    }

    public final boolean F0(g.Selection selection, FloatCardOption option) {
        int i10 = b.$EnumSwitchMapping$1[selection.getOptionStyle().ordinal()];
        if (i10 == 1) {
            w0(selection, option);
            return false;
        }
        if (i10 != 2 && i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return x0(selection, option);
    }

    public final void G(int position) {
        F4.c cVarU0 = u0(position);
        if (cVarU0 == null) {
            return;
        }
        D0(cVarU0);
    }

    public final void G0() {
        if (this.isLoading) {
            return;
        }
        if (z0()) {
            q0();
        } else {
            v0(this.currentPageIndex + 1);
        }
    }

    public final void H(View row) throws Resources.NotFoundException {
        row.setTag(OPTION_ROW_TAG);
        ViewGroup.LayoutParams layoutParams = row.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.float_card_horizontal_padding);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams2.topMargin = getResources().getDimensionPixelSize(R$dimen.float_card_option_gap);
        }
    }

    public final void H0() {
        if (this.isLoading) {
            return;
        }
        Iterator<T> it = j0().iterator();
        while (it.hasNext()) {
            this.values.remove(((E4.g) it.next()).getId());
        }
        if (z0()) {
            t0();
        } else {
            v0(this.currentPageIndex + 1);
        }
    }

    public final void I(F4.c pageBinding) {
        LinearLayout layoutOptions = pageBinding.layoutOptions;
        kotlin.jvm.internal.p.h(layoutOptions, "layoutOptions");
        MaxHeightScrollView scrollOptions = pageBinding.scrollOptions;
        kotlin.jvm.internal.p.h(scrollOptions, "scrollOptions");
        int i10 = this.request.getOptions().getExpandAllOptions() ? Integer.MAX_VALUE : this.imeVisible ? 2 : 3;
        int paddingTop = layoutOptions.getPaddingTop() + layoutOptions.getPaddingBottom();
        int childCount = layoutOptions.getChildCount();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = layoutOptions.getChildAt(i13);
            kotlin.jvm.internal.p.f(childAt);
            if (A0(childAt)) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
                int measuredHeight = childAt.getMeasuredHeight() + (layoutParams2 != null ? layoutParams2.topMargin : 0) + (layoutParams2 != null ? layoutParams2.bottomMargin : 0);
                i11++;
                if (i11 > i10) {
                    scrollOptions.setMaxHeight(paddingTop + C5685n.f(i12 / 2, r0(16)));
                    scrollOptions.setVerticalFadingEdgeEnabled(true);
                    scrollOptions.setVerticalScrollBarEnabled(true);
                    return;
                }
                paddingTop += measuredHeight;
                i12 = measuredHeight;
            }
        }
        if (paddingTop > 0) {
            scrollOptions.setMaxHeight(paddingTop);
            scrollOptions.setVerticalFadingEdgeEnabled(false);
            scrollOptions.setVerticalScrollBarEnabled(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J() {
        /*
            r6 = this;
            F4.d r0 = r6.binding
            android.widget.TextView r0 = r0.tvSkip
            java.lang.String r1 = "tvSkip"
            kotlin.jvm.internal.p.h(r0, r1)
            com.stepos.agentframework.floatcard.api.FloatCardSkipMode r1 = r6.n0()
            com.stepos.agentframework.floatcard.api.FloatCardSkipMode r2 = com.stepos.agentframework.floatcard.api.FloatCardSkipMode.Hidden
            r3 = 0
            if (r1 != r2) goto L1b
            r6 = 8
            r0.setVisibility(r6)
            r0.setOnClickListener(r3)
            return
        L1b:
            E4.a r2 = r6.m0()
            com.stepos.agentframework.floatcard.api.FloatCardSkipMode r4 = com.stepos.agentframework.floatcard.api.FloatCardSkipMode.Enabled
            r5 = 0
            if (r1 != r4) goto L2a
            boolean r1 = r6.isLoading
            if (r1 != 0) goto L2a
            r1 = 1
            goto L2b
        L2a:
            r1 = r5
        L2b:
            r0.setVisibility(r5)
            if (r2 == 0) goto L41
            java.lang.String r2 = r2.getLabel()
            if (r2 == 0) goto L41
            boolean r4 = La.H.x0(r2)
            if (r4 != 0) goto L3d
            goto L3e
        L3d:
            r2 = r3
        L3e:
            if (r2 == 0) goto L41
            goto L50
        L41:
            android.content.Context r2 = r6.getContext()
            int r4 = com.stepos.agentframework.floatcard.R$string.float_card_skip
            java.lang.String r2 = r2.getString(r4)
            java.lang.String r4 = "getString(...)"
            kotlin.jvm.internal.p.h(r2, r4)
        L50:
            r0.setText(r2)
            r0.setEnabled(r1)
            r0.setClickable(r1)
            if (r1 == 0) goto L5e
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L61
        L5e:
            r2 = 1051931443(0x3eb33333, float:0.35)
        L61:
            r0.setAlpha(r2)
            if (r1 == 0) goto L6f
            com.stepos.agentframework.floatcard.view.b r1 = new com.stepos.agentframework.floatcard.view.b
            r1.<init>()
            r0.setOnClickListener(r1)
            return
        L6f:
            r0.setOnClickListener(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.floatcard.view.p.J():void");
    }

    public final boolean K0(FloatCardPage page) {
        List<E4.g> listC = page.c();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listC) {
            if (obj instanceof g.Selection) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() != 1) {
            return false;
        }
        g.Selection selection = (g.Selection) arrayList.get(0);
        if (selection.getMode() != SelectionMode.Single) {
            return false;
        }
        int i10 = b.$EnumSwitchMapping$1[selection.getOptionStyle().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return true;
                }
                throw new NoWhenBranchMatchedException();
            }
            if (C5685n.f(getPages().indexOf(page), 0) < L0() - 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void L(F4.c r5, E4.FloatCardPage r6) {
        /*
            r4 = this;
            android.widget.TextView r5 = r5.tvSkipInline
            java.lang.String r0 = "tvSkipInline"
            kotlin.jvm.internal.p.h(r5, r0)
            boolean r0 = r4.C0(r6)
            r1 = 0
            if (r0 != 0) goto L17
            r4 = 8
            r5.setVisibility(r4)
            r5.setOnClickListener(r1)
            return
        L17:
            E4.a r0 = r6.getSkipAction()
            com.stepos.agentframework.floatcard.api.FloatCardSkipMode r6 = r6.getSkipMode()
            com.stepos.agentframework.floatcard.api.FloatCardSkipMode r2 = com.stepos.agentframework.floatcard.api.FloatCardSkipMode.Enabled
            r3 = 0
            if (r6 != r2) goto L26
            r6 = 1
            goto L27
        L26:
            r6 = r3
        L27:
            r5.setVisibility(r3)
            if (r0 == 0) goto L3d
            java.lang.String r0 = r0.getLabel()
            if (r0 == 0) goto L3d
            boolean r2 = La.H.x0(r0)
            if (r2 != 0) goto L39
            goto L3a
        L39:
            r0 = r1
        L3a:
            if (r0 == 0) goto L3d
            goto L4c
        L3d:
            android.content.Context r0 = r4.getContext()
            int r2 = com.stepos.agentframework.floatcard.R$string.float_card_skip
            java.lang.String r0 = r0.getString(r2)
            java.lang.String r2 = "getString(...)"
            kotlin.jvm.internal.p.h(r0, r2)
        L4c:
            r5.setText(r0)
            r5.setEnabled(r6)
            r5.setClickable(r6)
            if (r6 == 0) goto L5a
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L5d
        L5a:
            r0 = 1051931443(0x3eb33333, float:0.35)
        L5d:
            r5.setAlpha(r0)
            if (r6 == 0) goto L6b
            com.stepos.agentframework.floatcard.view.d r6 = new com.stepos.agentframework.floatcard.view.d
            r6.<init>()
            r5.setOnClickListener(r6)
            return
        L6b:
            r5.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.floatcard.view.p.L(F4.c, E4.j):void");
    }

    public final int L0() {
        return C5685n.f(getPages().size(), 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N(F4.c r5, E4.FloatCardPage r6) {
        /*
            r4 = this;
            java.util.Map<F4.c, java.lang.Integer> r0 = r4.pageBindingPositions
            java.lang.Object r0 = r0.get(r5)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r1 = 0
            if (r0 == 0) goto L10
            int r0 = r0.intValue()
            goto L1c
        L10:
            java.util.List r0 = r4.getPages()
            int r0 = r0.indexOf(r6)
            int r0 = v9.C5685n.f(r0, r1)
        L1c:
            int r2 = r4.L0()
            r3 = 1
            int r2 = r2 - r3
            if (r0 < r2) goto L25
            goto L26
        L25:
            r3 = r1
        L26:
            boolean r6 = r4.S0(r6)
            r0 = 8
            java.lang.String r2 = "btnConfirm"
            if (r6 != 0) goto L39
            android.widget.TextView r4 = r5.btnConfirm
            kotlin.jvm.internal.p.h(r4, r2)
            r4.setVisibility(r0)
            return
        L39:
            android.widget.TextView r6 = r5.btnConfirm
            kotlin.jvm.internal.p.h(r6, r2)
            boolean r2 = r4.isLoading
            if (r2 != 0) goto L43
            goto L44
        L43:
            r1 = r0
        L44:
            r6.setVisibility(r1)
            android.widget.TextView r6 = r5.btnConfirm
            if (r3 == 0) goto L77
            E4.k r0 = r4.request
            E4.c r0 = r0.getContent()
            E4.a r0 = r4.s0(r0)
            if (r0 == 0) goto L67
            java.lang.String r0 = r0.getLabel()
            if (r0 == 0) goto L67
            boolean r1 = La.H.x0(r0)
            if (r1 != 0) goto L64
            goto L65
        L64:
            r0 = 0
        L65:
            if (r0 != 0) goto L84
        L67:
            android.content.Context r0 = r4.getContext()
            int r1 = com.stepos.agentframework.floatcard.R$string.float_card_confirm
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = "getString(...)"
            kotlin.jvm.internal.p.h(r0, r1)
            goto L84
        L77:
            android.content.Context r0 = r4.getContext()
            int r1 = com.stepos.agentframework.floatcard.R$string.float_card_next
            java.lang.String r0 = r0.getString(r1)
            kotlin.jvm.internal.p.f(r0)
        L84:
            r6.setText(r0)
            android.widget.TextView r5 = r5.btnConfirm
            com.stepos.agentframework.floatcard.view.o r6 = new com.stepos.agentframework.floatcard.view.o
            r6.<init>()
            r5.setOnClickListener(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.floatcard.view.p.N(F4.c, E4.j):void");
    }

    public final void N0(FloatCardContent content) {
        this.values.clear();
        this.currentPageIndex = 0;
        this.isSubmitting = false;
        this.pageBindingPositions.clear();
        this.currentPageBinding = null;
        this.pageAdapter.e(getPages());
        this.binding.viewPager.m(0, false);
        Y();
        W0();
        X0();
    }

    public final void P() {
        FloatCardPage floatCardPageK0 = k0();
        E4.s inputView = floatCardPageK0 != null ? floatCardPageK0.getInputView() : null;
        FloatCardPage floatCardPageK02 = k0();
        boolean zD = floatCardPageK02 != null ? kotlin.jvm.internal.p.d(floatCardPageK02.getShowInput(), Boolean.TRUE) : false;
        E4.s sVar = this.activeInputView;
        if (sVar != null && sVar != inputView && sVar != null) {
            sVar.hide();
        }
        this.activeInputView = inputView;
        if (inputView != null) {
            if (zD) {
                inputView.show();
            } else {
                inputView.hide();
            }
        }
    }

    public final void P0() {
        this.binding.viewPager.removeCallbacks(this.pagerHeightUpdateRunnable);
        this.binding.viewPager.post(this.pagerHeightUpdateRunnable);
    }

    public final void Q(F4.c pageBinding, FloatCardPage page) {
        LinearLayout layoutOptions = pageBinding.layoutOptions;
        kotlin.jvm.internal.p.h(layoutOptions, "layoutOptions");
        layoutOptions.removeAllViews();
        for (E4.g gVar : page.c()) {
            if (gVar instanceof g.Selection) {
                E(pageBinding, layoutOptions, (g.Selection) gVar);
            } else if (gVar instanceof g.ActionButton) {
                layoutOptions.addView(c0((g.ActionButton) gVar));
            } else if (!(gVar instanceof g.TextInput)) {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final Set<String> Q0(g.Selection selection) {
        E4.n nVar = this.values.get(selection.getId());
        n.Selected selected = nVar instanceof n.Selected ? (n.Selected) nVar : null;
        if (selected != null) {
            return F.q1(selected.a());
        }
        List<FloatCardOption> listC = selection.c();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listC) {
            if (((FloatCardOption) obj).getSelected()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((FloatCardOption) it.next()).getId());
        }
        return F.q1(arrayList2);
    }

    public final void R(FloatCardContent content) {
        boolean z10 = this.isLoading || content.getStatus() == FloatCardStatus.Loading;
        F4.c cVar = this.currentPageBinding;
        if (cVar == null) {
            return;
        }
        LinearLayout layoutOptions = cVar.layoutOptions;
        kotlin.jvm.internal.p.h(layoutOptions, "layoutOptions");
        if (z10 && layoutOptions.getChildCount() == 0) {
            F(layoutOptions);
        }
        if (z10) {
            TextView btnConfirm = cVar.btnConfirm;
            kotlin.jvm.internal.p.h(btnConfirm, "btnConfirm");
            btnConfirm.setVisibility(8);
        }
    }

    public final boolean R0() {
        FloatCardPage floatCardPageK0 = k0();
        if (floatCardPageK0 != null) {
            return S0(floatCardPageK0);
        }
        return false;
    }

    public final void S(F4.c pageBinding, FloatCardPage page) {
        b0(pageBinding, page);
        W(pageBinding, page);
        L(pageBinding, page);
        Q(pageBinding, page);
        X(pageBinding, page);
        N(pageBinding, page);
        U0(pageBinding);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00cf A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean S0(E4.FloatCardPage r7) {
        /*
            r6 = this;
            java.util.List r0 = r7.c()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        Lf:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L21
            java.lang.Object r2 = r0.next()
            boolean r3 = r2 instanceof E4.g.Selection
            if (r3 == 0) goto Lf
            r1.add(r2)
            goto Lf
        L21:
            boolean r0 = r6.K0(r7)
            r2 = 0
            if (r0 == 0) goto L29
            return r2
        L29:
            boolean r0 = r1.isEmpty()
            r3 = 1
            if (r0 == 0) goto L31
            goto L4a
        L31:
            java.util.Iterator r0 = r1.iterator()
        L35:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L4a
            java.lang.Object r4 = r0.next()
            E4.g$b r4 = (E4.g.Selection) r4
            com.stepos.agentframework.floatcard.api.FloatCardOptionStyle r4 = r4.getOptionStyle()
            com.stepos.agentframework.floatcard.api.FloatCardOptionStyle r5 = com.stepos.agentframework.floatcard.api.FloatCardOptionStyle.Checkmark
            if (r4 != r5) goto L35
            return r3
        L4a:
            java.util.List r0 = r6.getPages()
            int r0 = r0.indexOf(r7)
            int r0 = v9.C5685n.f(r0, r2)
            int r4 = r6.L0()
            int r4 = r4 - r3
            if (r0 < r4) goto L5f
            r0 = r3
            goto L60
        L5f:
            r0 = r2
        L60:
            boolean r4 = r1.isEmpty()
            if (r4 != 0) goto L96
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L6d
            goto L86
        L6d:
            java.util.Iterator r1 = r1.iterator()
        L71:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L86
            java.lang.Object r4 = r1.next()
            E4.g$b r4 = (E4.g.Selection) r4
            com.stepos.agentframework.floatcard.api.FloatCardOptionStyle r4 = r4.getOptionStyle()
            com.stepos.agentframework.floatcard.api.FloatCardOptionStyle r5 = com.stepos.agentframework.floatcard.api.FloatCardOptionStyle.Audio
            if (r4 != r5) goto L96
            goto L71
        L86:
            if (r0 == 0) goto L95
            E4.k r7 = r6.request
            E4.c r7 = r7.getContent()
            E4.a r6 = r6.s0(r7)
            if (r6 == 0) goto L95
            return r3
        L95:
            return r2
        L96:
            if (r0 != 0) goto L99
            return r3
        L99:
            java.util.List r7 = r7.c()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            boolean r0 = r7 instanceof java.util.Collection
            if (r0 == 0) goto Lad
            r0 = r7
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lad
            goto Lc2
        Lad:
            java.util.Iterator r7 = r7.iterator()
        Lb1:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto Lc2
            java.lang.Object r0 = r7.next()
            E4.g r0 = (E4.g) r0
            boolean r0 = r0 instanceof E4.g.Selection
            if (r0 == 0) goto Lb1
            goto Lce
        Lc2:
            E4.k r7 = r6.request
            E4.c r7 = r7.getContent()
            E4.a r6 = r6.s0(r7)
            if (r6 == 0) goto Lcf
        Lce:
            return r3
        Lcf:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.floatcard.view.p.S0(E4.j):boolean");
    }

    public final void T() {
        final int iL0 = L0();
        boolean z10 = iL0 > 1;
        FloatCardPage floatCardPageK0 = k0();
        boolean z11 = (floatCardPageK0 != null ? floatCardPageK0.getRiskBadge() : null) != null;
        boolean z12 = n0() != FloatCardSkipMode.Hidden;
        boolean z13 = z10 || z11;
        boolean z14 = z10 || (z13 && z12);
        LinearLayout layoutToolbar = this.binding.layoutToolbar;
        kotlin.jvm.internal.p.h(layoutToolbar, "layoutToolbar");
        layoutToolbar.setVisibility(z14 ? 0 : 8);
        LinearLayout layoutPagination = this.binding.layoutPagination;
        kotlin.jvm.internal.p.h(layoutPagination, "layoutPagination");
        layoutPagination.setVisibility(z10 ? 0 : 8);
        if (z10) {
            this.binding.tvPagination.setText(getContext().getString(R$string.float_card_pagination_format, Integer.valueOf(this.currentPageIndex + 1), Integer.valueOf(iL0)));
            int i10 = this.currentPageIndex;
            boolean z15 = i10 > 0;
            boolean z16 = i10 < iL0 + (-1);
            this.binding.ivPagePrev.setEnabled(z15);
            this.binding.ivPagePrev.setAlpha(z15 ? 1.0f : 0.35f);
            this.binding.ivPageNext.setEnabled(z16);
            this.binding.ivPageNext.setAlpha(z16 ? 1.0f : 0.35f);
            this.binding.ivPagePrev.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.floatcard.view.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p.U(this.f23267a, view);
                }
            });
            this.binding.ivPageNext.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.floatcard.view.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p.V(this.f23280a, iL0, view);
                }
            });
        }
        if (z13 && z12) {
            J();
            return;
        }
        TextView tvSkip = this.binding.tvSkip;
        kotlin.jvm.internal.p.h(tvSkip, "tvSkip");
        tvSkip.setVisibility(8);
        this.binding.tvSkip.setOnClickListener(null);
    }

    public final Map<String, E4.n> T0() {
        return kotlin.collections.a.A(this.values);
    }

    public final void U0(F4.c pageBinding) {
        boolean z10 = y0() && !this.isLoading;
        pageBinding.btnConfirm.setEnabled(z10);
        pageBinding.btnConfirm.setBackgroundResource(z10 ? R$drawable.bg_float_card_confirm_enabled : R$drawable.bg_float_card_confirm_disabled);
        pageBinding.btnConfirm.setTextColor(androidx.core.content.a.c(getContext(), z10 ? R$color.float_card_confirm_enabled_text : R$color.float_card_confirm_disabled_text));
        pageBinding.btnConfirm.setAlpha(1.0f);
    }

    public final void V0(F4.c pageBinding) {
        Pair pair;
        ImageView imageView;
        LinearLayout layoutOptions = pageBinding.layoutOptions;
        kotlin.jvm.internal.p.h(layoutOptions, "layoutOptions");
        List<E4.g> listJ0 = j0();
        ArrayList<g.Selection> arrayList = new ArrayList();
        for (Object obj : listJ0) {
            if (obj instanceof g.Selection) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (g.Selection selection : arrayList) {
            List<FloatCardOption> listC = selection.c();
            ArrayList arrayList3 = new ArrayList(C1174w.x(listC, 10));
            Iterator<T> it = listC.iterator();
            while (it.hasNext()) {
                arrayList3.add(Y8.j.a(selection, (FloatCardOption) it.next()));
            }
            A.E(arrayList2, arrayList3);
        }
        int childCount = layoutOptions.getChildCount();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = layoutOptions.getChildAt(i11);
            if (kotlin.jvm.internal.p.d(childAt.getTag(), OPTION_ROW_TAG) && (pair = (Pair) F.t0(arrayList2, i10)) != null) {
                g.Selection selection2 = (g.Selection) pair.a();
                i10++;
                boolean zB0 = B0(selection2, (FloatCardOption) pair.b());
                childAt.setSelected(zB0);
                if (selection2.getOptionStyle() == FloatCardOptionStyle.Checkmark && (imageView = (ImageView) childAt.findViewById(R$id.iv_option_trailing)) != null) {
                    imageView.setImageResource(zB0 ? R$drawable.ic_float_card_check_selected : R$drawable.ic_float_card_check_unselected);
                }
            }
        }
    }

    public final void W(F4.c pageBinding, FloatCardPage page) {
        Triple triple;
        FloatCardRiskBadge riskBadge = page.getRiskBadge();
        if (riskBadge == null) {
            TextView tvRiskBadge = pageBinding.tvRiskBadge;
            kotlin.jvm.internal.p.h(tvRiskBadge, "tvRiskBadge");
            tvRiskBadge.setVisibility(8);
            return;
        }
        int i10 = b.$EnumSwitchMapping$0[riskBadge.getLevel().ordinal()];
        if (i10 == 1) {
            triple = new Triple(Integer.valueOf(R$color.float_card_risk_high_bg), Integer.valueOf(R$color.float_card_risk_high_text), Integer.valueOf(R$drawable.bg_float_card_risk_high));
        } else if (i10 == 2) {
            triple = new Triple(Integer.valueOf(R$color.float_card_risk_medium_bg), Integer.valueOf(R$color.float_card_risk_medium_text), Integer.valueOf(R$drawable.bg_float_card_risk_medium));
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            triple = new Triple(Integer.valueOf(R$color.float_card_risk_low_bg), Integer.valueOf(R$color.float_card_risk_low_text), Integer.valueOf(R$drawable.bg_float_card_risk_low));
        }
        int iIntValue = ((Number) triple.a()).intValue();
        int iIntValue2 = ((Number) triple.b()).intValue();
        int iIntValue3 = ((Number) triple.c()).intValue();
        FloatCardBadgeBorder border = riskBadge.getBorder();
        if (riskBadge.getFillColor() == null && border == null) {
            pageBinding.tvRiskBadge.setBackgroundResource(iIntValue3);
        } else {
            float f10 = getResources().getDisplayMetrics().density;
            Integer fillColor = riskBadge.getFillColor();
            int iIntValue4 = fillColor != null ? fillColor.intValue() : androidx.core.content.a.c(getContext(), iIntValue);
            TextView textView = pageBinding.tvRiskBadge;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(C5685n.e(border != null ? border.getCornerRadiusDp() : 4.0f, 0.0f) * f10);
            gradientDrawable.setColor(iIntValue4);
            if (border != null) {
                gradientDrawable.setStroke((int) ((C5685n.e(border.getWidthDp(), 0.0f) * f10) + 0.5f), border.getColor());
            }
            textView.setBackground(gradientDrawable);
        }
        pageBinding.tvRiskBadge.setTextColor(androidx.core.content.a.c(getContext(), iIntValue2));
        pageBinding.tvRiskBadge.setText(riskBadge.getLabel());
        TextView tvRiskBadge2 = pageBinding.tvRiskBadge;
        kotlin.jvm.internal.p.h(tvRiskBadge2, "tvRiskBadge");
        tvRiskBadge2.setVisibility(0);
    }

    public final void W0() {
        this.binding.viewPager.setUserInputEnabled(L0() > 1 && !this.isLoading);
    }

    public final void X(F4.c pageBinding, FloatCardPage page) {
        List<E4.m> listE = page.e();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listE) {
            if (obj instanceof m.Warning) {
                arrayList.add(obj);
            }
        }
        m.Warning warning = (m.Warning) F.s0(arrayList);
        if (warning != null) {
            TextView tvDescription = pageBinding.tvDescription;
            kotlin.jvm.internal.p.h(tvDescription, "tvDescription");
            tvDescription.setVisibility(0);
            pageBinding.tvDescription.setTextColor(androidx.core.content.a.c(getContext(), R$color.float_card_waveform));
            TextView tvDescription2 = pageBinding.tvDescription;
            kotlin.jvm.internal.p.h(tvDescription2, "tvDescription");
            Z(tvDescription2, warning.getMessage());
        }
    }

    public final void X0() {
        F4.c cVarU0 = u0(this.currentPageIndex);
        if (cVarU0 == null && (cVarU0 = this.currentPageBinding) == null) {
            return;
        }
        D0(cVarU0);
    }

    public final void Y() {
        T();
        P();
    }

    public final void Z(TextView textView, CharSequence text) {
        C2148w.b(textView, text, 0, new InterfaceC5074l() { // from class: com.stepos.agentframework.floatcard.view.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return p.a0(this.f23288a, (String) obj);
            }
        }, 4, null);
    }

    public final void b0(F4.c pageBinding, FloatCardPage page) {
        TextView tvTitle = pageBinding.tvTitle;
        kotlin.jvm.internal.p.h(tvTitle, "tvTitle");
        Z(tvTitle, page.getTitle());
        ViewGroup.LayoutParams layoutParams = pageBinding.tvTitle.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
        if (bVar != null) {
            int i10 = C0(page) ? 1 : 2;
            if (bVar.f12613N != i10) {
                bVar.f12613N = i10;
                pageBinding.tvTitle.requestLayout();
            }
        }
        String subtitle = page.getSubtitle();
        if (subtitle == null || H.x0(subtitle)) {
            pageBinding.tvTitle.setTextSize(16.0f);
            TextView tvSubtitle = pageBinding.tvSubtitle;
            kotlin.jvm.internal.p.h(tvSubtitle, "tvSubtitle");
            tvSubtitle.setVisibility(8);
        } else {
            pageBinding.tvTitle.setTextSize(16.0f);
            TextView tvSubtitle2 = pageBinding.tvSubtitle;
            kotlin.jvm.internal.p.h(tvSubtitle2, "tvSubtitle");
            tvSubtitle2.setVisibility(0);
            TextView tvSubtitle3 = pageBinding.tvSubtitle;
            kotlin.jvm.internal.p.h(tvSubtitle3, "tvSubtitle");
            Z(tvSubtitle3, subtitle);
        }
        String description = page.getDescription();
        if (description == null || H.x0(description)) {
            TextView tvDescription = pageBinding.tvDescription;
            kotlin.jvm.internal.p.h(tvDescription, "tvDescription");
            tvDescription.setVisibility(8);
            return;
        }
        TextView tvDescription2 = pageBinding.tvDescription;
        kotlin.jvm.internal.p.h(tvDescription2, "tvDescription");
        tvDescription2.setVisibility(0);
        TextView tvDescription3 = pageBinding.tvDescription;
        kotlin.jvm.internal.p.h(tvDescription3, "tvDescription");
        Z(tvDescription3, description);
        pageBinding.tvDescription.setTextColor(androidx.core.content.a.c(getContext(), R$color.float_card_text_secondary));
    }

    @Override // E4.p
    public void c(String message, boolean retryable) {
        TextView textView;
        kotlin.jvm.internal.p.i(message, "message");
        this.isLoading = false;
        this.isSubmitting = false;
        ProgressBar progressLoading = this.binding.progressLoading;
        kotlin.jvm.internal.p.h(progressLoading, "progressLoading");
        progressLoading.setVisibility(8);
        this.binding.tvError.setText(message);
        TextView tvError = this.binding.tvError;
        kotlin.jvm.internal.p.h(tvError, "tvError");
        tvError.setVisibility(0);
        F4.c cVar = this.currentPageBinding;
        if (cVar != null && (textView = cVar.btnConfirm) != null) {
            textView.setVisibility(R0() ? 0 : 8);
        }
        setInteractiveEnabled(true);
        F4.c cVar2 = this.currentPageBinding;
        if (cVar2 != null) {
            U0(cVar2);
        }
        W0();
        X0();
    }

    public final View c0(final g.ActionButton action) {
        TextView textView = new TextView(getContext());
        textView.setText(action.getLabel());
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        textView.setTextSize(16.0f);
        textView.setBackgroundResource(R$drawable.bg_float_card_confirm_enabled);
        textView.setTextColor(androidx.core.content.a.c(textView.getContext(), R$color.float_card_confirm_enabled_text));
        textView.setEnabled(!this.isLoading);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, textView.getResources().getDimensionPixelSize(R$dimen.float_card_confirm_height));
        layoutParams.setMarginStart(r0(20));
        layoutParams.setMarginEnd(r0(20));
        layoutParams.topMargin = r0(8);
        textView.setLayoutParams(layoutParams);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.floatcard.view.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.d0(this.f23274a, action, view);
            }
        });
        return textView;
    }

    @Override // E4.p
    public void d(boolean loading, String message) {
        F4.c cVar;
        TextView textView;
        this.isLoading = loading;
        if (!loading) {
            this.isSubmitting = false;
        }
        ProgressBar progressLoading = this.binding.progressLoading;
        kotlin.jvm.internal.p.h(progressLoading, "progressLoading");
        progressLoading.setVisibility(loading ? 0 : 8);
        TextView tvError = this.binding.tvError;
        kotlin.jvm.internal.p.h(tvError, "tvError");
        tvError.setVisibility(8);
        F4.c cVar2 = this.currentPageBinding;
        if (cVar2 != null && (textView = cVar2.btnConfirm) != null) {
            textView.setVisibility(!loading && R0() ? 0 : 8);
        }
        setInteractiveEnabled(!loading);
        if (loading && (cVar = this.currentPageBinding) != null) {
            U0(cVar);
        }
        W0();
        X0();
    }

    @Override // E4.p
    public void destroy() {
        LinearLayout linearLayout;
        E4.s sVar = this.activeInputView;
        if (sVar != null) {
            sVar.hide();
        }
        this.activeInputView = null;
        setOnContentHeightSettled(null);
        this.values.clear();
        this.pageBindingPositions.clear();
        F4.c cVar = this.currentPageBinding;
        if (cVar != null && (linearLayout = cVar.layoutOptions) != null) {
            linearLayout.removeAllViews();
        }
        this.currentPageBinding = null;
        this.binding.viewPager.removeCallbacks(this.pagerHeightUpdateRunnable);
        removeCallbacks(this.rippleDelayRunnable);
        this.binding.viewPager.removeOnLayoutChangeListener(this.vpLayoutChangeListener);
        this.binding.viewPager.r(this.pageChangeCallback);
        this.binding.viewPager.setAdapter(null);
    }

    @Override // E4.p
    public void e(FloatCardContent content) {
        kotlin.jvm.internal.p.i(content, "content");
        this.request = FloatCardRequest.b(this.request, null, null, null, null, content, null, null, 111, null);
        N0(content);
    }

    public final View e0(final F4.c pageBinding, LinearLayout parent, final g.Selection selection, final FloatCardOption option) throws Resources.NotFoundException {
        F4.b bVarC = F4.b.c(LayoutInflater.from(getContext()), parent, false);
        kotlin.jvm.internal.p.h(bVarC, "inflate(...)");
        bVarC.tvOptionLabel.setText(option.getLabel());
        bVarC.tvOptionLabel.setEnabled(option.getEnabled());
        bVarC.b().setEnabled(option.getEnabled());
        LinearLayout linearLayoutB = bVarC.b();
        kotlin.jvm.internal.p.h(linearLayoutB, "getRoot(...)");
        H(linearLayoutB);
        boolean zB0 = B0(selection, option);
        bVarC.b().setSelected(zB0);
        bVarC.ivOptionTrailing.setImageResource(zB0 ? R$drawable.ic_float_card_check_selected : R$drawable.ic_float_card_check_unselected);
        bVarC.b().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.floatcard.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.f0(option, this, selection, pageBinding, view);
            }
        });
        LinearLayout linearLayoutB2 = bVarC.b();
        kotlin.jvm.internal.p.h(linearLayoutB2, "getRoot(...)");
        return linearLayoutB2;
    }

    @Override // E4.p
    public void f(String text, boolean isFinal) {
        FloatCardPage floatCardPageK0;
        FloatCardPage floatCardPageK02;
        kotlin.jvm.internal.p.i(text, "text");
        if (!isFinal || this.isLoading) {
            return;
        }
        String string = H.D1(text).toString();
        if (string.length() == 0 || (floatCardPageK0 = k0()) == null) {
            return;
        }
        List<E4.g> listC = floatCardPageK0.c();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listC) {
            if (obj instanceof g.Selection) {
                arrayList.add(obj);
            }
        }
        g.Selection selection = (g.Selection) F.s0(arrayList);
        if (selection == null) {
            return;
        }
        Set<String> setQ0 = Q0(selection);
        SelectionMode mode = selection.getMode();
        SelectionMode selectionMode = SelectionMode.Single;
        if (mode == selectionMode) {
            setQ0.clear();
            setQ0.add(string);
        } else {
            setQ0.add(string);
        }
        this.values.put(selection.getId(), new n.Selected(F.m1(setQ0)));
        if (selection.getMode() == selectionMode && l0()) {
            G0();
            return;
        }
        F4.c cVar = this.currentPageBinding;
        if (cVar != null && (floatCardPageK02 = k0()) != null) {
            Q(cVar, floatCardPageK02);
        }
        F4.c cVar2 = this.currentPageBinding;
        if (cVar2 != null) {
            U0(cVar2);
        }
    }

    public final View g0(final F4.c pageBinding, LinearLayout parent, final g.Selection selection, final FloatCardOption option) throws Resources.NotFoundException {
        if (selection.getOptionStyle() == FloatCardOptionStyle.Checkmark) {
            return e0(pageBinding, parent, selection, option);
        }
        F4.a aVarC = F4.a.c(LayoutInflater.from(getContext()), parent, false);
        kotlin.jvm.internal.p.h(aVarC, "inflate(...)");
        LinearLayout linearLayoutB = aVarC.b();
        kotlin.jvm.internal.p.h(linearLayoutB, "getRoot(...)");
        H(linearLayoutB);
        aVarC.tvOptionLabel.setText(option.getLabel());
        aVarC.tvOptionLabel.setEnabled(option.getEnabled());
        aVarC.b().setEnabled(option.getEnabled());
        aVarC.b().setSelected(B0(selection, option));
        if (selection.getOptionStyle() == FloatCardOptionStyle.Plain) {
            aVarC.tvOptionLabel.setTextColor(androidx.core.content.a.c(getContext(), R$color.float_card_option_text));
        }
        aVarC.b().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.floatcard.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.h0(option, this, selection, pageBinding, view);
            }
        });
        LinearLayout linearLayoutB2 = aVarC.b();
        kotlin.jvm.internal.p.h(linearLayoutB2, "getRoot(...)");
        return linearLayoutB2;
    }

    public final String getBusinessType() {
        return this.request.getBusinessType();
    }

    @Override // E4.p
    public String getCardId() {
        return this.request.getCardId();
    }

    @Override // E4.o
    public View getContentView() {
        F4.c cVarU0 = u0(this.currentPageIndex);
        if (cVarU0 == null) {
            cVarU0 = this.currentPageBinding;
        }
        if (cVarU0 != null) {
            return cVarU0.layoutPageContent;
        }
        return null;
    }

    public InterfaceC5063a<Y8.t> getOnContentHeightSettled() {
        return this.onContentHeightSettled;
    }

    @Override // E4.p
    public View getView() {
        return this;
    }

    public final View i0(String text) {
        TextView textView = new TextView(getContext());
        textView.setText(text);
        textView.setTextSize(14.0f);
        textView.setIncludeFontPadding(false);
        textView.setTextColor(androidx.core.content.a.c(textView.getContext(), R$color.float_card_text_secondary));
        textView.setPadding(r0(20), r0(8), r0(20), r0(4));
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return textView;
    }

    public final List<E4.g> j0() {
        List<E4.g> listC;
        FloatCardPage floatCardPageK0 = k0();
        return (floatCardPageK0 == null || (listC = floatCardPageK0.c()) == null) ? C1173v.m() : listC;
    }

    public final FloatCardPage k0() {
        return (FloatCardPage) F.t0(getPages(), this.currentPageIndex);
    }

    public final boolean l0() {
        FloatCardPage floatCardPageK0 = k0();
        if (floatCardPageK0 != null) {
            return K0(floatCardPageK0);
        }
        return false;
    }

    public final FloatCardAction m0() {
        FloatCardPage floatCardPageK0 = k0();
        if (floatCardPageK0 != null) {
            return floatCardPageK0.getSkipAction();
        }
        return null;
    }

    public final FloatCardSkipMode n0() {
        FloatCardSkipMode skipMode;
        FloatCardPage floatCardPageK0 = k0();
        return (floatCardPageK0 == null || (skipMode = floatCardPageK0.getSkipMode()) == null) ? FloatCardSkipMode.Hidden : skipMode;
    }

    public final void o0(String actionId, Bundle payload) {
        this.dispatcher.a(new d.ActionClicked(this.request.getCardId(), this.request.getBusinessType(), this.request.getPayload(), actionId, payload));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        N.u0(this, new androidx.core.view.A() { // from class: com.stepos.agentframework.floatcard.view.h
            @Override // androidx.core.view.A
            public final a0 a(View view, a0 a0Var) {
                return p.E0(this.f23282a, view, a0Var);
            }
        });
        N.e0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        N.u0(this, null);
        removeCallbacks(this.rippleDelayRunnable);
        this.binding.viewPager.removeCallbacks(this.pagerHeightUpdateRunnable);
        super.onDetachedFromWindow();
    }

    public final void p0(String actionId, String payloadValue) {
        E4.q qVar = this.dispatcher;
        String cardId = this.request.getCardId();
        String businessType = this.request.getBusinessType();
        Bundle payload = this.request.getPayload();
        Bundle bundle = new Bundle();
        if (payloadValue.length() > 0) {
            bundle.putString(UxipConstants.f30680s, payloadValue);
        }
        Y8.t tVar = Y8.t.f7040a;
        qVar.a(new d.ActionClicked(cardId, businessType, payload, actionId, bundle));
    }

    public final void q0() {
        if (!y0() || this.isSubmitting) {
            return;
        }
        this.isSubmitting = true;
        t0();
    }

    public final int r0(int value) {
        return (int) ((value * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final FloatCardAction s0(FloatCardContent content) {
        FloatCardAction submitAction = content.getSubmitAction();
        if (submitAction != null) {
            return submitAction;
        }
        List<FloatCardPage> pages = getPages();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = pages.iterator();
        while (it.hasNext()) {
            A.E(arrayList, ((FloatCardPage) it.next()).c());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof g.Selection) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            if (((g.Selection) it2.next()).getMode() == SelectionMode.Multiple) {
                return DEFAULT_SUBMIT_ACTION;
            }
        }
        return null;
    }

    @Override // E4.o
    public void setOnContentHeightSettled(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onContentHeightSettled = interfaceC5063a;
    }

    public final void t0() {
        String id;
        Bundle bundle;
        FloatCardAction floatCardActionS0 = s0(this.request.getContent());
        E4.q qVar = this.dispatcher;
        String cardId = this.request.getCardId();
        String businessType = this.request.getBusinessType();
        Bundle payload = this.request.getPayload();
        if (floatCardActionS0 == null || (id = floatCardActionS0.getId()) == null) {
            id = "submit";
        }
        Map mapA = kotlin.collections.a.A(this.values);
        if (floatCardActionS0 == null || (bundle = floatCardActionS0.getPayload()) == null) {
            bundle = new Bundle();
        }
        qVar.a(new d.Submit(cardId, businessType, payload, id, mapA, bundle));
    }

    public final F4.c u0(int position) {
        View childAt = this.binding.viewPager.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView == null) {
            return null;
        }
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(position);
        t.a aVar = viewHolderFindViewHolderForAdapterPosition instanceof t.a ? (t.a) viewHolderFindViewHolderForAdapterPosition : null;
        if (aVar != null) {
            return aVar.getBinding();
        }
        return null;
    }

    public final void v0(int index) {
        int iN = C5685n.n(index, 0, C5685n.f(L0() - 1, 0));
        boolean z10 = L0() > 1;
        if (z10) {
            G(iN);
        }
        this.binding.viewPager.m(iN, z10);
    }

    public final void w0(g.Selection selection, FloatCardOption option) {
        Set<String> setQ0 = Q0(selection);
        boolean zContains = setQ0.contains(option.getId());
        setQ0.clear();
        setQ0.add(option.getId());
        this.values.put(selection.getId(), new n.Selected(F.m1(setQ0)));
        p0((zContains && option.getIsPlaying()) ? "option_pause" : "option_play", option.getId());
    }

    public final boolean x0(g.Selection selection, FloatCardOption option) {
        Set<String> setQ0 = Q0(selection);
        SelectionMode mode = selection.getMode();
        SelectionMode selectionMode = SelectionMode.Single;
        if (mode == selectionMode) {
            setQ0.clear();
            setQ0.add(option.getId());
        } else {
            boolean zContains = setQ0.contains(option.getId());
            String id = option.getId();
            if (zContains) {
                setQ0.remove(id);
            } else {
                setQ0.add(id);
            }
        }
        this.values.put(selection.getId(), new n.Selected(F.m1(setQ0)));
        return selection.getMode() == selectionMode && l0();
    }

    public final boolean y0() {
        for (E4.g gVar : j0()) {
            if (gVar instanceof g.Selection) {
                g.Selection selection = (g.Selection) gVar;
                if (selection.getRequired()) {
                    E4.n nVar = this.values.get(selection.getId());
                    n.Selected selected = nVar instanceof n.Selected ? (n.Selected) nVar : null;
                    List<String> listA = selected != null ? selected.a() : null;
                    if (listA == null || listA.isEmpty()) {
                        return false;
                    }
                } else {
                    continue;
                }
            }
        }
        return true;
    }

    public final boolean z0() {
        return this.currentPageIndex >= L0() - 1;
    }
}
