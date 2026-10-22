package com.stepos.ailauncher.chat.view;

import Ua.C1060i;
import Z8.C1173v;
import Z8.C1174w;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.C1398p;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatui.AgentChatLayout;
import com.stepos.agentframework.chatui.ChatMessageAdapter;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.T1;
import com.stepos.agentframework.chatui.view.ChatRecycleView;
import com.stepos.agentframework.util.E;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.media.TtsMediaFocusController;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.sla.SlaChatController;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.chat.wake.C3172w;
import com.stepos.ailauncher.chat.wake.ChatSnapshotState;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.sheet.R$dimen;
import com.stepos.ailauncher.sheet.SheetSettleState;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import u4.m;
import v9.C5685n;
import y7.G;

@Metadata(d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002Ó\u0001\u0018\u0000 \u0086\u00022\u00020\u0001:\u0002\u0087\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0018\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u000eJ'\u0010!\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\n¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\f¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b'\u0010\u0015J\r\u0010(\u001a\u00020\f¢\u0006\u0004\b(\u0010&J\u0015\u0010)\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b)\u0010$J\r\u0010*\u001a\u00020\n¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0012¢\u0006\u0004\b-\u0010\u0015J\r\u0010.\u001a\u00020\f¢\u0006\u0004\b.\u0010&J\r\u0010/\u001a\u00020\n¢\u0006\u0004\b/\u0010+J\u0015\u00101\u001a\u00020\f2\u0006\u00100\u001a\u00020\n¢\u0006\u0004\b1\u0010\u000eJ\u0019\u00103\u001a\u00020\f2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b3\u0010\u0015J\u0015\u00106\u001a\u00020\f2\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0015\u00109\u001a\u00020\f2\u0006\u00108\u001a\u00020\n¢\u0006\u0004\b9\u0010\u000eJ\r\u0010:\u001a\u00020\f¢\u0006\u0004\b:\u0010&J\u0015\u0010<\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u0006¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u00020\f¢\u0006\u0004\b>\u0010&J\u000f\u0010?\u001a\u00020\fH\u0014¢\u0006\u0004\b?\u0010&J\u000f\u0010@\u001a\u00020\fH\u0014¢\u0006\u0004\b@\u0010&J\u000f\u0010A\u001a\u00020\fH\u0002¢\u0006\u0004\bA\u0010&J\u000f\u0010B\u001a\u00020\fH\u0002¢\u0006\u0004\bB\u0010&J\u0011\u0010C\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\fH\u0002¢\u0006\u0004\bE\u0010&J\u000f\u0010F\u001a\u00020\fH\u0002¢\u0006\u0004\bF\u0010&J\u001f\u0010I\u001a\u00020\f2\u0006\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u0012H\u0002¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\fH\u0002¢\u0006\u0004\bK\u0010&J\u000f\u0010L\u001a\u00020\fH\u0002¢\u0006\u0004\bL\u0010&J1\u0010Q\u001a\u00020\f2\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u00062\b\b\u0002\u0010P\u001a\u00020\nH\u0002¢\u0006\u0004\bQ\u0010RJ\u0017\u0010T\u001a\u00020\f2\u0006\u0010S\u001a\u00020\u001eH\u0002¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\fH\u0002¢\u0006\u0004\bV\u0010&J\u000f\u0010W\u001a\u00020\fH\u0002¢\u0006\u0004\bW\u0010&J\u0017\u0010X\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\bX\u0010\u0015J!\u0010Z\u001a\u00020\f2\b\u0010Y\u001a\u0004\u0018\u00010\u00122\u0006\u0010,\u001a\u00020\u0012H\u0002¢\u0006\u0004\bZ\u0010JJ\u000f\u0010[\u001a\u00020\fH\u0002¢\u0006\u0004\b[\u0010&J\u0017\u0010]\u001a\u00020\f2\u0006\u0010\\\u001a\u00020\u0006H\u0002¢\u0006\u0004\b]\u0010=J\u0017\u0010`\u001a\u00020\f2\u0006\u0010_\u001a\u00020^H\u0002¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020^H\u0002¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020\fH\u0002¢\u0006\u0004\bd\u0010&J\u000f\u0010e\u001a\u00020\fH\u0002¢\u0006\u0004\be\u0010&J\u0017\u0010f\u001a\u00020\f2\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\bf\u00107J\u0017\u0010h\u001a\u00020\f2\u0006\u0010g\u001a\u00020\nH\u0002¢\u0006\u0004\bh\u0010\u000eJ\u0017\u0010j\u001a\u00020\f2\u0006\u0010i\u001a\u00020^H\u0002¢\u0006\u0004\bj\u0010aJ\u000f\u0010k\u001a\u00020\fH\u0002¢\u0006\u0004\bk\u0010&J\u0017\u0010m\u001a\u00020\f2\u0006\u0010l\u001a\u00020\nH\u0002¢\u0006\u0004\bm\u0010\u000eJ\u000f\u0010n\u001a\u00020\fH\u0002¢\u0006\u0004\bn\u0010&J\u0017\u0010q\u001a\u00020\f2\u0006\u0010p\u001a\u00020oH\u0002¢\u0006\u0004\bq\u0010rJ\u0017\u0010u\u001a\u00020\f2\u0006\u0010t\u001a\u00020sH\u0002¢\u0006\u0004\bu\u0010vJ\u000f\u0010w\u001a\u00020\fH\u0002¢\u0006\u0004\bw\u0010&J\u0017\u0010y\u001a\u00020\f2\u0006\u0010x\u001a\u00020\u0012H\u0002¢\u0006\u0004\by\u0010\u0015J\u0017\u0010{\u001a\u00020z2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b{\u0010|R\u001e\u0010\u0082\u0001\u001a\u00020}8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R \u0010\u0087\u0001\u001a\u00030\u0083\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0084\u0001\u0010\u007f\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001d\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0006¢\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\u008e\u0001\u001a\u00030\u008d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001b\u0010\u0090\u0001\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0019\u0010\u0095\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0017\u0010\u0097\u0001\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0017\u0010\u0099\u0001\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0098\u0001R\u0017\u0010\u009a\u0001\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u0098\u0001R\u0018\u0010\u009c\u0001\u001a\u00030\u009b\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0018\u0010\u009e\u0001\u001a\u00030\u009b\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009d\u0001R\u0018\u0010\u009f\u0001\u001a\u00030\u009b\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0001\u0010\u009d\u0001R\u0018\u0010 \u0001\u001a\u00030\u009b\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b \u0001\u0010\u009d\u0001R\u0017\u0010¡\u0001\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010\u0098\u0001R2\u0010£\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010¢\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R2\u0010©\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010¢\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b©\u0001\u0010¤\u0001\u001a\u0006\bª\u0001\u0010¦\u0001\"\u0006\b«\u0001\u0010¨\u0001R2\u0010¬\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010¢\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010¤\u0001\u001a\u0006\b\u00ad\u0001\u0010¦\u0001\"\u0006\b®\u0001\u0010¨\u0001R@\u0010²\u0001\u001a\u0019\u0012\f\u0012\n\u0012\u0005\u0012\u00030±\u00010°\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010¯\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R8\u0010¸\u0001\u001a\u0011\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010¯\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¸\u0001\u0010³\u0001\u001a\u0006\b¹\u0001\u0010µ\u0001\"\u0006\bº\u0001\u0010·\u0001R:\u0010»\u0001\u001a\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\f\u0018\u00010¯\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b»\u0001\u0010³\u0001\u001a\u0006\b¼\u0001\u0010µ\u0001\"\u0006\b½\u0001\u0010·\u0001R\u0018\u0010¿\u0001\u001a\u00030¾\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001c\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001b\u0010Ä\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R \u0010Ç\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120Æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001c\u0010Ê\u0001\u001a\u0005\u0018\u00010É\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u0019\u0010Ì\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u001b\u0010Î\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u001c\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ð\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u0018\u0010Ô\u0001\u001a\u00030Ó\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u0018\u0010×\u0001\u001a\u00030Ö\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R\u001b\u0010Ù\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010Ï\u0001R\u001c\u0010Û\u0001\u001a\u0005\u0018\u00010Ú\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R\u0019\u0010Ý\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010Í\u0001R\u0019\u0010Þ\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010\u0096\u0001R\u0019\u0010ß\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010Í\u0001R\u001b\u0010à\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0001\u0010Ï\u0001R\u001b\u0010á\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0001\u0010â\u0001R\u0019\u0010ã\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0001\u0010Í\u0001R\u0019\u0010ä\u0001\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010\u0091\u0001R\u001b\u0010å\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010Ï\u0001R!\u0010é\u0001\u001a\u0004\u0018\u00010o8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bæ\u0001\u0010\u007f\u001a\u0006\bç\u0001\u0010è\u0001R\"\u0010î\u0001\u001a\u0005\u0018\u00010ê\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bë\u0001\u0010\u007f\u001a\u0006\bì\u0001\u0010í\u0001R!\u0010ñ\u0001\u001a\u0004\u0018\u00010o8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bï\u0001\u0010\u007f\u001a\u0006\bð\u0001\u0010è\u0001R\"\u0010ô\u0001\u001a\u0005\u0018\u00010ê\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bò\u0001\u0010\u007f\u001a\u0006\bó\u0001\u0010í\u0001R!\u0010÷\u0001\u001a\u0004\u0018\u00010o8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bõ\u0001\u0010\u007f\u001a\u0006\bö\u0001\u0010è\u0001R\u0019\u0010ø\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0001\u0010Í\u0001R\u0019\u0010ù\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010Í\u0001R\u0019\u0010ú\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0001\u0010Í\u0001R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001f\u0010û\u0001R\u001c\u0010ý\u0001\u001a\u0005\u0018\u00010ü\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bý\u0001\u0010þ\u0001R\u001c\u0010\u0080\u0002\u001a\u0005\u0018\u00010ÿ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0002\u0010\u0081\u0002R\u001c\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0082\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0002\u0010\u0084\u0002R\u0019\u0010\u0085\u0002\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0002\u0010Í\u0001¨\u0006\u0088\u0002"}, d2 = {"Lcom/stepos/ailauncher/chat/view/UnifiedChatHostView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "visible", "LY8/t;", "setConversationPageVisible", "(Z)V", "E1", "sampleVisible", "h1", "", "sessionId", "U0", "(Ljava/lang/String;)V", "name", com.stepos.ailauncher.sla.G.NETWORK_ONLINE, "n1", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "asBack", "setSidebarAsBack", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "pendingSessionLoad", "o0", "(Lcom/stepos/agentframework/chatcore/SessionHandler;Landroidx/lifecycle/LifecycleOwner;Z)V", "v1", "(Ljava/lang/String;)Z", "E0", "()V", "Q0", "Z0", "J0", "M0", "()Z", "reason", "g1", SdCardDbCreator.FIELD_LASTLOC_ID, "I0", "external", "setExternalSessionHome", "greeting", "p1", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "n0", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "hidden", "setContentHiddenForWakeFloating", "u1", "level", "B1", "(I)V", "e1", "onAttachedToWindow", "onDetachedFromWindow", "z0", "f1", "G0", "()Ljava/lang/String;", "y1", "X0", "agentId", "deviceId", "V0", "(Ljava/lang/String;Ljava/lang/String;)V", "j0", "h0", "rowId", "dotId", "textId", "hideWhenOffline", "b1", "(IIIZ)V", "owner", "v0", "(Landroidx/lifecycle/LifecycleOwner;)V", "m0", "H0", "l1", "expectedSessionId", "Y0", "T0", HomeGestureEligibilityContract.EXTRA_GENERATION, "s1", "", "t", "i0", "(F)V", "B0", "()F", "F0", "A0", "x1", ChatTracker.STAGE_FULL, "z1", "topDp", "l0", "w1", "isEmpty", "k0", "j1", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "S0", "(Landroid/view/View;)V", "Lu4/m$d;", "tree", "R0", "(Lu4/m$d;)V", "A1", "status", "d1", "Lcom/stepos/agentframework/AgentUIConfig;", "y0", "(Landroidx/lifecycle/LifecycleOwner;)Lcom/stepos/agentframework/AgentUIConfig;", "Lcom/stepos/ailauncher/chat/util/g;", "keepScreenOnController$delegate", "LY8/h;", "getKeepScreenOnController", "()Lcom/stepos/ailauncher/chat/util/g;", "keepScreenOnController", "Lcom/stepos/ailauncher/chat/media/TtsMediaFocusController;", "ttsMediaFocusController$delegate", "getTtsMediaFocusController", "()Lcom/stepos/ailauncher/chat/media/TtsMediaFocusController;", "ttsMediaFocusController", "Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;", "chatLayout", "Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;", "getChatLayout", "()Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;", "Landroid/widget/LinearLayout;", "chrome", "Landroid/widget/LinearLayout;", "lastSettleState", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", "Landroid/animation/ValueAnimator;", "chromeAppearAnim", "Landroid/animation/ValueAnimator;", "chromeAppearGeneration", "I", "topFade", "Landroid/view/View;", "topBlur", "bottomFade", "Landroid/widget/ImageView;", "btnSidebar", "Landroid/widget/ImageView;", "btnNewSession", "btnMore", "btnClose", "chromeActions", "Lkotlin/Function0;", "onSidebarClick", "Lp9/a;", "getOnSidebarClick", "()Lp9/a;", "setOnSidebarClick", "(Lp9/a;)V", "onNewSessionClick", "getOnNewSessionClick", "setOnNewSessionClick", "onCloseClick", "getOnCloseClick", "setOnCloseClick", "Lkotlin/Function1;", "", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "onOpenArtifacts", "Lp9/l;", "getOnOpenArtifacts", "()Lp9/l;", "setOnOpenArtifacts", "(Lp9/l;)V", "onEmptyStateChanged", "getOnEmptyStateChanged", "setOnEmptyStateChanged", "onConversationChanged", "getOnConversationChanged", "setOnConversationChanged", "Lcom/stepos/ailauncher/chat/view/t;", "moreMenuPopup", "Lcom/stepos/ailauncher/chat/view/t;", "Lcom/stepos/ailauncher/chat/view/b6;", "chromeGlass", "Lcom/stepos/ailauncher/chat/view/b6;", "sessionHandler", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "", "lastLeftHiddenIds", "Ljava/util/Set;", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$c;", "snapshotUse", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$c;", "snapshotVisible", "Z", "snapshotTargetSessionId", "Ljava/lang/String;", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$a;", "pendingSnapshotRestore", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$a;", "com/stepos/ailauncher/chat/view/UnifiedChatHostView$f", "snapshotSource", "Lcom/stepos/ailauncher/chat/view/UnifiedChatHostView$f;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "snapshotFrameObserver", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "lastMarkedVisibleSessionId", "Lcom/stepos/ailauncher/chat/view/sla/SlaChatController;", "slaController", "Lcom/stepos/ailauncher/chat/view/sla/SlaChatController;", "messageListCacheTrimmed", "sessionSwitchRecoverGeneration", "isExternalSession", "agentTitleText", "agentOnline", "Ljava/lang/Boolean;", "showingEmptyHome", "settleState", "agentGreetingText", "agentEmptyBlock$delegate", "getAgentEmptyBlock", "()Landroid/view/View;", "agentEmptyBlock", "Landroid/widget/TextView;", "agentGreeting$delegate", "getAgentGreeting", "()Landroid/widget/TextView;", "agentGreeting", "chromeTitleBlock$delegate", "getChromeTitleBlock", "chromeTitleBlock", "chromeTitle$delegate", "getChromeTitle", "chromeTitle", "agentOfflineHint$delegate", "getAgentOfflineHint", "agentOfflineHint", "emptyMessage", "awaitingRestoredConversation", "emptyConfirmedByConversationCallback", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/stepos/agentframework/chatcore/session/AgentSession$h;", "sessionCreatedCallback", "Lcom/stepos/agentframework/chatcore/session/AgentSession$h;", "Lcom/stepos/ailauncher/chat/view/c8;", "sessionCreatedSink", "Lcom/stepos/ailauncher/chat/view/c8;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "adapterEmptyObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "emptyRecomputePosted", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnifiedChatHostView extends FrameLayout {
    private static final float BOTTOM_FADE_EXPANDED_SAFE_AREA_DP = 12.0f;
    private static final float BOTTOM_FADE_MAX_OVERLAP_DP = 200.0f;
    private static final float BOTTOM_FADE_MINIFIED_SAFE_AREA_DP = 12.0f;
    private static final float CHROME_APPEAR_BLUR_PX = 40.0f;
    private static final long CHROME_APPEAR_DURATION_MS = 300;
    private static final float CHROME_COLLAPSED_TOP_DP = 32.0f;
    private static final float CHROME_FADE_TOP_DP = 72.0f;
    private static final int DEFAULT_MESSAGE_LIST_CACHE_SIZE = 2;
    private static final float MESSAGE_LIST_FULL_TOP_DP = 86.0f;
    private static final long SESSION_SWITCH_FAST_RECOVER_MS = 400;
    private static final String TAG = "UnifiedChatHostView";
    private static final float TOP_BLUR_HALF_HEIGHT_DP = 28.0f;
    private RecyclerView.AdapterDataObserver adapterEmptyObserver;

    /* renamed from: agentEmptyBlock$delegate, reason: from kotlin metadata */
    private final Y8.h agentEmptyBlock;

    /* renamed from: agentGreeting$delegate, reason: from kotlin metadata */
    private final Y8.h agentGreeting;
    private String agentGreetingText;

    /* renamed from: agentOfflineHint$delegate, reason: from kotlin metadata */
    private final Y8.h agentOfflineHint;
    private Boolean agentOnline;
    private String agentTitleText;
    private boolean awaitingRestoredConversation;
    private final View bottomFade;
    private final ImageView btnClose;
    private final ImageView btnMore;
    private final ImageView btnNewSession;
    private final ImageView btnSidebar;
    private final LauncherChatLayout chatLayout;
    private final LinearLayout chrome;
    private final View chromeActions;
    private ValueAnimator chromeAppearAnim;
    private int chromeAppearGeneration;
    private C2773b6 chromeGlass;

    /* renamed from: chromeTitle$delegate, reason: from kotlin metadata */
    private final Y8.h chromeTitle;

    /* renamed from: chromeTitleBlock$delegate, reason: from kotlin metadata */
    private final Y8.h chromeTitleBlock;
    private boolean emptyConfirmedByConversationCallback;
    private boolean emptyMessage;
    private boolean emptyRecomputePosted;
    private boolean isExternalSession;

    /* renamed from: keepScreenOnController$delegate, reason: from kotlin metadata */
    private final Y8.h keepScreenOnController;
    private Set<String> lastLeftHiddenIds;
    private String lastMarkedVisibleSessionId;
    private SheetSettleState lastSettleState;
    private LifecycleOwner lifecycleOwner;
    private boolean messageListCacheTrimmed;
    private final C2963t moreMenuPopup;
    private InterfaceC5063a<Y8.t> onCloseClick;
    private InterfaceC5074l<? super String, Y8.t> onConversationChanged;
    private InterfaceC5074l<? super Boolean, Y8.t> onEmptyStateChanged;
    private InterfaceC5063a<Y8.t> onNewSessionClick;
    private InterfaceC5074l<? super List<SessionArtifact>, Y8.t> onOpenArtifacts;
    private InterfaceC5063a<Y8.t> onSidebarClick;
    private ChatSnapshotState.Snapshot pendingSnapshotRestore;
    private AgentSession.h sessionCreatedCallback;
    private InterfaceC2786c8 sessionCreatedSink;
    private SessionHandler sessionHandler;
    private int sessionSwitchRecoverGeneration;
    private SheetSettleState settleState;
    private boolean showingEmptyHome;
    private SlaChatController slaController;
    private final ViewTreeObserver.OnPreDrawListener snapshotFrameObserver;
    private final f snapshotSource;
    private String snapshotTargetSessionId;
    private ChatSnapshotState.c snapshotUse;
    private boolean snapshotVisible;
    private final View topBlur;
    private final View topFade;

    /* renamed from: ttsMediaFocusController$delegate, reason: from kotlin metadata */
    private final Y8.h ttsMediaFocusController;
    private static final PathInterpolator CHROME_APPEAR_INTERPOLATOR = new PathInterpolator(0.4f, 0.0f, 0.1f, 1.0f);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetSettleState.values().length];
            try {
                iArr[SheetSettleState.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetSettleState.HALF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/chat/view/UnifiedChatHostView$c", "Lcom/stepos/agentframework/chatui/T1$a;", "LY8/t;", "onPlayStarted", "()V", "onPlayStopped", "", "code", "message", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements T1.a {
        public c() {
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public void a(String code, String message) {
            kotlin.jvm.internal.p.i(code, "code");
            kotlin.jvm.internal.p.i(message, "message");
            C4148a.u(UnifiedChatHostView.TAG, "tts error code=" + code + " msg=" + message + " -> release keepScreenOn + focus", false, 4, null);
            UnifiedChatHostView.this.getKeepScreenOnController().l("tts");
            UnifiedChatHostView.this.getTtsMediaFocusController().c0();
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public /* bridge */ void b(String str) {
            super.b(str);
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public void onPlayStarted() {
            UnifiedChatHostView.this.getKeepScreenOnController().f("tts", 300000L);
            UnifiedChatHostView.this.getTtsMediaFocusController().t();
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public void onPlayStopped() {
            UnifiedChatHostView.this.getKeepScreenOnController().l("tts");
            UnifiedChatHostView.this.getTtsMediaFocusController().c0();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/chat/view/UnifiedChatHostView$d", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "LY8/t;", "onChanged", "()V", "", "positionStart", "itemCount", "onItemRangeInserted", "(II)V", "onItemRangeRemoved", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends RecyclerView.AdapterDataObserver {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            UnifiedChatHostView.this.j1();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int positionStart, int itemCount) {
            UnifiedChatHostView.this.j1();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            UnifiedChatHostView.this.j1();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class e implements InterfaceC5074l<Object, Boolean> {
        public static final e INSTANCE = new e();

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            return Boolean.valueOf(obj instanceof DisplayMessage);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/chat/view/UnifiedChatHostView$f", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$b;", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f implements ChatSnapshotState.b {
        public f() {
        }

        @Override // com.stepos.ailauncher.chat.wake.ChatSnapshotState.b
        public void a() {
            UnifiedChatHostView.i1(UnifiedChatHostView.this, false, 1, null);
        }

        @Override // com.stepos.ailauncher.chat.wake.ChatSnapshotState.b
        public void b() {
            ChatSnapshotState.c cVar;
            if (UnifiedChatHostView.this.snapshotVisible && UnifiedChatHostView.this.isShown() && (cVar = UnifiedChatHostView.this.snapshotUse) != null && cVar.getFinalSnapshotSaved()) {
                UnifiedChatHostView.this.snapshotVisible = false;
                UnifiedChatHostView.this.E1(true);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/view/UnifiedChatHostView$g", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "onAnimationCancel", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g extends AnimatorListenerAdapter {
        final /* synthetic */ int $generation;
        final /* synthetic */ UnifiedChatHostView this$0;

        public g(int i10, UnifiedChatHostView unifiedChatHostView) {
            this.$generation = i10;
            this.this$0 = unifiedChatHostView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if (this.$generation != this.this$0.chromeAppearGeneration) {
                return;
            }
            this.this$0.chromeAppearAnim = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if (this.$generation != this.this$0.chromeAppearGeneration) {
                return;
            }
            this.this$0.i0(1.0f);
            this.this$0.F0();
            this.this$0.chromeAppearAnim = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnifiedChatHostView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final View C0(UnifiedChatHostView unifiedChatHostView) {
        return unifiedChatHostView.findViewById(R$id.unified_chrome_title_block);
    }

    public static final TtsMediaFocusController C1(Context context, final UnifiedChatHostView unifiedChatHostView) {
        TtsMediaFocusController ttsMediaFocusController = new TtsMediaFocusController(context);
        ttsMediaFocusController.g0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.C9
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UnifiedChatHostView.D1(this.f25739a);
            }
        });
        return ttsMediaFocusController;
    }

    public static final TextView D0(UnifiedChatHostView unifiedChatHostView) {
        return (TextView) unifiedChatHostView.findViewById(R$id.unified_chrome_title);
    }

    public static final Y8.t D1(UnifiedChatHostView unifiedChatHostView) {
        C4148a.k(TAG, "AudioFocus lost -> stop TTS", false, 4, null);
        unifiedChatHostView.u1();
        return Y8.t.f7040a;
    }

    public static final Y8.t I(UnifiedChatHostView unifiedChatHostView) {
        unifiedChatHostView.w1();
        return Y8.t.f7040a;
    }

    public static final void J(UnifiedChatHostView unifiedChatHostView, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        unifiedChatHostView.w1();
    }

    public static final void K(UnifiedChatHostView unifiedChatHostView, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        unifiedChatHostView.w1();
    }

    public static final com.stepos.ailauncher.chat.util.g K0(final UnifiedChatHostView unifiedChatHostView) {
        return new com.stepos.ailauncher.chat.util.g(TAG, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.B9
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UnifiedChatHostView.L0(this.f25723a);
            }
        }, null, 4, null);
    }

    public static final void L(UnifiedChatHostView unifiedChatHostView, View view) {
        InterfaceC5063a<Y8.t> interfaceC5063a = unifiedChatHostView.onSidebarClick;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final View L0(UnifiedChatHostView unifiedChatHostView) {
        return unifiedChatHostView;
    }

    public static final void M(UnifiedChatHostView unifiedChatHostView, View view) {
        InterfaceC5063a<Y8.t> interfaceC5063a = unifiedChatHostView.onNewSessionClick;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void N(UnifiedChatHostView unifiedChatHostView, View view) {
        InterfaceC5063a<Y8.t> interfaceC5063a = unifiedChatHostView.onCloseClick;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final Y8.t N0(UnifiedChatHostView unifiedChatHostView, List artifacts) {
        kotlin.jvm.internal.p.i(artifacts, "artifacts");
        InterfaceC5074l<? super List<SessionArtifact>, Y8.t> interfaceC5074l = unifiedChatHostView.onOpenArtifacts;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(artifacts);
        }
        return Y8.t.f7040a;
    }

    public static final void O(UnifiedChatHostView unifiedChatHostView, View view) {
        unifiedChatHostView.X0();
    }

    public static final Y8.t O0(UnifiedChatHostView unifiedChatHostView, m.FolderMessage tree) {
        kotlin.jvm.internal.p.i(tree, "tree");
        unifiedChatHostView.R0(tree);
        return Y8.t.f7040a;
    }

    public static final Y8.t P(UnifiedChatHostView unifiedChatHostView, String agentId, String deviceId) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        unifiedChatHostView.V0(agentId, deviceId);
        return Y8.t.f7040a;
    }

    public static final Y8.t P0(UnifiedChatHostView unifiedChatHostView) {
        unifiedChatHostView.A1();
        return Y8.t.f7040a;
    }

    public static final void Q(UnifiedChatHostView unifiedChatHostView, View view) {
        ChatTracker.INSTANCE.E(unifiedChatHostView.G0(), ChatTracker.TOPBAR_MENU);
        unifiedChatHostView.S0(unifiedChatHostView.chromeActions);
    }

    public static final Y8.t W0(UnifiedChatHostView unifiedChatHostView, String str, String str2, Result result) {
        Object value = result.getValue();
        if (Result.h(value)) {
            SidebarDataSource.INSTANCE.e(str, str2, ((Boolean) value).booleanValue());
        }
        Object value2 = result.getValue();
        Boolean bool = Boolean.FALSE;
        if (Result.g(value2)) {
            value2 = bool;
        }
        if (((Boolean) value2).booleanValue()) {
            unifiedChatHostView.n1(unifiedChatHostView.agentTitleText, Boolean.TRUE);
        } else {
            Toast.makeText(unifiedChatHostView.getContext(), R$string.chat_agent_offline_toast, 0).show();
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void c1(UnifiedChatHostView unifiedChatHostView, int i10, int i11, int i12, boolean z10, int i13, Object obj) {
        if ((i13 & 8) != 0) {
            z10 = false;
        }
        unifiedChatHostView.b1(i10, i11, i12, z10);
    }

    public static final View e0(UnifiedChatHostView unifiedChatHostView) {
        return unifiedChatHostView.findViewById(R$id.unified_agent_empty_block);
    }

    public static final TextView f0(UnifiedChatHostView unifiedChatHostView) {
        return (TextView) unifiedChatHostView.findViewById(R$id.unified_agent_greeting);
    }

    public static final View g0(UnifiedChatHostView unifiedChatHostView) {
        return unifiedChatHostView.findViewById(R$id.unified_agent_offline_hint);
    }

    private final View getAgentEmptyBlock() {
        return (View) this.agentEmptyBlock.getValue();
    }

    private final TextView getAgentGreeting() {
        return (TextView) this.agentGreeting.getValue();
    }

    private final View getAgentOfflineHint() {
        return (View) this.agentOfflineHint.getValue();
    }

    private final TextView getChromeTitle() {
        return (TextView) this.chromeTitle.getValue();
    }

    private final View getChromeTitleBlock() {
        return (View) this.chromeTitleBlock.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.stepos.ailauncher.chat.util.g getKeepScreenOnController() {
        return (com.stepos.ailauncher.chat.util.g) this.keepScreenOnController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TtsMediaFocusController getTtsMediaFocusController() {
        return (TtsMediaFocusController) this.ttsMediaFocusController.getValue();
    }

    public static /* synthetic */ void i1(UnifiedChatHostView unifiedChatHostView, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        unifiedChatHostView.h1(z10);
    }

    public static final void k1(UnifiedChatHostView unifiedChatHostView) {
        boolean z10 = false;
        unifiedChatHostView.emptyRecomputePosted = false;
        List<com.stepos.agentframework.chatui.S1> listG = unifiedChatHostView.chatLayout.getAdapter().G();
        if ((listG instanceof Collection) && listG.isEmpty()) {
            z10 = true;
        } else {
            Iterator<T> it = listG.iterator();
            while (it.hasNext()) {
                if (!(((com.stepos.agentframework.chatui.S1) it.next()) instanceof com.stepos.agentframework.chatui.k2)) {
                    break;
                }
            }
            z10 = true;
        }
        unifiedChatHostView.k0(z10);
    }

    public static final void m1(int i10, UnifiedChatHostView unifiedChatHostView, String str) {
        if (i10 == unifiedChatHostView.sessionSwitchRecoverGeneration && unifiedChatHostView.chatLayout.w8() && unifiedChatHostView.J0(str)) {
            unifiedChatHostView.Y0(str, "fast_probe");
        }
    }

    public static /* synthetic */ void o1(UnifiedChatHostView unifiedChatHostView, String str, Boolean bool, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bool = null;
        }
        unifiedChatHostView.n1(str, bool);
    }

    public static final void p0(UnifiedChatHostView unifiedChatHostView, String it) {
        kotlin.jvm.internal.p.i(it, "it");
        unifiedChatHostView.Q0(it);
    }

    public static final Y8.t q0(UnifiedChatHostView unifiedChatHostView, String str) {
        unifiedChatHostView.Y0(str, "guard_timeout");
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void q1(UnifiedChatHostView unifiedChatHostView, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        unifiedChatHostView.p1(str);
    }

    public static final Y8.t r0(UnifiedChatHostView unifiedChatHostView, DisplayMessage m10) {
        InterfaceC5074l<? super String, Y8.t> interfaceC5074l;
        SessionHandler sessionHandler;
        AgentSession.AgentConversation agentConversationR1;
        kotlin.jvm.internal.p.i(m10, "m");
        String str = null;
        if (m10.getRole() == AgentRole.USER) {
            C4148a.d(TAG, "onReceiveMessage user traceId=" + m10.getTraceId(), false, 4, null);
            unifiedChatHostView.emptyConfirmedByConversationCallback = false;
            unifiedChatHostView.k0(false);
        }
        String sessionId = m10.getSessionId();
        if (sessionId.length() <= 0) {
            sessionId = null;
        }
        if (sessionId != null || ((sessionHandler = unifiedChatHostView.sessionHandler) != null && (agentConversationR1 = sessionHandler.R1()) != null && (sessionId = agentConversationR1.B()) != null && sessionId.length() > 0)) {
            str = sessionId;
        }
        if (str != null && (interfaceC5074l = unifiedChatHostView.onConversationChanged) != null) {
            interfaceC5074l.invoke(str);
        }
        return Y8.t.f7040a;
    }

    public static final boolean r1(UnifiedChatHostView unifiedChatHostView) {
        unifiedChatHostView.z0();
        return true;
    }

    public static final Y8.t s0(UnifiedChatHostView unifiedChatHostView, String sid) {
        kotlin.jvm.internal.p.i(sid, "sid");
        InterfaceC5074l<? super String, Y8.t> interfaceC5074l = unifiedChatHostView.onConversationChanged;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(sid);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t t0(UnifiedChatHostView unifiedChatHostView, List msgList) {
        AgentSession.AgentConversation agentConversationR1;
        String strB;
        kotlin.jvm.internal.p.i(msgList, "msgList");
        boolean z10 = false;
        unifiedChatHostView.awaitingRestoredConversation = false;
        if (msgList.isEmpty() && unifiedChatHostView.chatLayout.getAdapter().G().isEmpty()) {
            z10 = true;
        }
        unifiedChatHostView.emptyConfirmedByConversationCallback = z10;
        unifiedChatHostView.k0(z10);
        unifiedChatHostView.f1();
        InterfaceC5074l<? super String, Y8.t> interfaceC5074l = unifiedChatHostView.onConversationChanged;
        if (interfaceC5074l != null) {
            SessionHandler sessionHandler = unifiedChatHostView.sessionHandler;
            String str = null;
            if (sessionHandler != null && (agentConversationR1 = sessionHandler.R1()) != null && (strB = agentConversationR1.B()) != null && strB.length() > 0) {
                str = strB;
            }
            interfaceC5074l.invoke(str);
        }
        return Y8.t.f7040a;
    }

    public static final void t1(int i10, UnifiedChatHostView unifiedChatHostView, ValueAnimator va2) {
        kotlin.jvm.internal.p.i(va2, "va");
        if (i10 != unifiedChatHostView.chromeAppearGeneration) {
            return;
        }
        Object animatedValue = va2.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        unifiedChatHostView.i0(((Float) animatedValue).floatValue());
    }

    public static final Y8.t u0(UnifiedChatHostView unifiedChatHostView, w4.e eVar, List msgList) {
        AgentSession.AgentConversation agentConversationR1;
        String strB;
        kotlin.jvm.internal.p.i(msgList, "msgList");
        boolean z10 = false;
        unifiedChatHostView.awaitingRestoredConversation = false;
        if (msgList.isEmpty() && unifiedChatHostView.chatLayout.getAdapter().G().isEmpty()) {
            z10 = true;
        }
        unifiedChatHostView.emptyConfirmedByConversationCallback = z10;
        unifiedChatHostView.k0(z10);
        unifiedChatHostView.f1();
        InterfaceC5074l<? super String, Y8.t> interfaceC5074l = unifiedChatHostView.onConversationChanged;
        if (interfaceC5074l != null) {
            SessionHandler sessionHandler = unifiedChatHostView.sessionHandler;
            String str = null;
            if (sessionHandler != null && (agentConversationR1 = sessionHandler.R1()) != null && (strB = agentConversationR1.B()) != null && strB.length() > 0) {
                str = strB;
            }
            interfaceC5074l.invoke(str);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t w0(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final Y8.t x0(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public final void A0() {
        this.chromeAppearGeneration++;
        ValueAnimator valueAnimator = this.chromeAppearAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.chromeAppearAnim = null;
    }

    public final void A1() {
        E.Companion companion = com.stepos.agentframework.util.E.INSTANCE;
        com.stepos.agentframework.util.E eA = companion.a();
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        com.stepos.agentframework.util.C c10 = com.stepos.agentframework.util.C.INSTANCE;
        boolean zE = com.stepos.agentframework.util.E.e(eA, context, c10.b(), false, null, 12, null);
        com.stepos.agentframework.util.E eA2 = companion.a();
        Context context2 = getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        com.stepos.agentframework.util.E.k(eA2, context2, c10.b(), !zE, null, 8, null);
        d1(zE ? "close" : "open");
        if (!zE) {
            com.stepos.agentframework.chatui.util.d dVar = com.stepos.agentframework.chatui.util.d.INSTANCE;
            Context context3 = getContext();
            kotlin.jvm.internal.p.h(context3, "getContext(...)");
            dVar.o(context3, R$string.auto_read_on, this);
            return;
        }
        u1();
        com.stepos.agentframework.chatui.util.d dVar2 = com.stepos.agentframework.chatui.util.d.INSTANCE;
        Context context4 = getContext();
        kotlin.jvm.internal.p.h(context4, "getContext(...)");
        dVar2.o(context4, R$string.auto_read_off, this);
    }

    public final float B0() {
        return getResources().getDisplayMetrics().density * 54.0f;
    }

    public final void B1(int level) {
        if (level < 20) {
            return;
        }
        com.stepos.ailauncher.common.imageloader.g gVar = com.stepos.ailauncher.common.imageloader.g.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        gVar.F(context, level);
        this.chatLayout.getMessageList().setItemViewCacheSize(0);
        this.messageListCacheTrimmed = true;
    }

    public final void E0() {
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null) {
            return;
        }
        sessionHandler.V0(this.chatLayout);
        sessionHandler.b3(this.chatLayout);
        sessionHandler.x1();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E1(boolean r4) {
        /*
            r3 = this;
            if (r4 != 0) goto Ld
            boolean r4 = r3.snapshotVisible
            r0 = 0
            if (r4 == 0) goto La
            r3.h1(r0)
        La:
            r3.snapshotVisible = r0
            return
        Ld:
            java.lang.String r4 = r3.G0()
            if (r4 != 0) goto L14
            goto L55
        L14:
            boolean r0 = r3.emptyMessage
            if (r0 != 0) goto L55
            boolean r0 = r3.awaitingRestoredConversation
            if (r0 != 0) goto L55
            com.stepos.ailauncher.chat.view.LauncherChatLayout r0 = r3.chatLayout
            boolean r0 = r0.w8()
            if (r0 == 0) goto L25
            goto L55
        L25:
            java.lang.String r0 = r3.snapshotTargetSessionId
            r1 = 1
            if (r0 == 0) goto L32
            boolean r0 = r3.J0(r0)
            r0 = r0 ^ r1
            if (r0 != r1) goto L32
            return
        L32:
            boolean r0 = r3.snapshotVisible
            if (r0 == 0) goto L46
            com.stepos.ailauncher.chat.wake.ChatSnapshotState$c r0 = r3.snapshotUse
            if (r0 == 0) goto L3f
            java.lang.String r0 = r0.getSessionId()
            goto L40
        L3f:
            r0 = 0
        L40:
            boolean r0 = kotlin.jvm.internal.p.d(r0, r4)
            if (r0 != 0) goto L50
        L46:
            com.stepos.ailauncher.chat.wake.w r0 = com.stepos.ailauncher.chat.wake.C3172w.INSTANCE
            com.stepos.ailauncher.chat.view.UnifiedChatHostView$f r2 = r3.snapshotSource
            com.stepos.ailauncher.chat.wake.ChatSnapshotState$c r4 = r0.c(r4, r2)
            r3.snapshotUse = r4
        L50:
            r3.snapshotVisible = r1
            r3.z0()
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.UnifiedChatHostView.E1(boolean):void");
    }

    public final void F0() {
        this.btnSidebar.setAlpha(1.0f);
        this.chromeActions.setAlpha(1.0f);
        this.btnClose.setAlpha(1.0f);
        View chromeTitleBlock = getChromeTitleBlock();
        if (chromeTitleBlock != null) {
            chromeTitleBlock.setAlpha(1.0f);
        }
        View chromeTitleBlock2 = getChromeTitleBlock();
        if (chromeTitleBlock2 != null) {
            chromeTitleBlock2.setRenderEffect(null);
        }
        this.chatLayout.getMessageList().setTranslationY(0.0f);
    }

    public final String G0() {
        AgentSession.AgentConversation agentConversationR1;
        String strB;
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null || (strB = agentConversationR1.B()) == null || strB.length() <= 0) {
            return null;
        }
        return strB;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H0() {
        /*
            r6 = this;
            com.stepos.ailauncher.chat.view.LauncherChatLayout r0 = r6.chatLayout
            android.widget.ImageView r0 = r0.getScrollToBottomButton()
            android.view.ViewParent r1 = r0.getParent()
            boolean r2 = r1 instanceof android.view.ViewGroup
            r3 = 0
            if (r2 == 0) goto L12
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            goto L13
        L12:
            r1 = r3
        L13:
            if (r1 != 0) goto L16
            goto L18
        L16:
            if (r1 != r6) goto L19
        L18:
            return
        L19:
            android.view.ViewGroup$LayoutParams r2 = r0.getLayoutParams()
            boolean r4 = r2 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r4 == 0) goto L24
            android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
            goto L25
        L24:
            r2 = r3
        L25:
            android.view.ViewGroup$LayoutParams r4 = r0.getLayoutParams()
            if (r4 == 0) goto L40
            int r4 = r4.width
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r5 = r4.intValue()
            if (r5 <= 0) goto L38
            goto L39
        L38:
            r4 = r3
        L39:
            if (r4 == 0) goto L40
            int r4 = r4.intValue()
            goto L4f
        L40:
            r4 = 30
            float r4 = (float) r4
            android.content.res.Resources r5 = r6.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            float r5 = r5.density
            float r4 = r4 * r5
            int r4 = (int) r4
        L4f:
            r1.removeView(r0)
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r1.<init>(r4, r4)
            r4 = 81
            r1.gravity = r4
            r4 = 0
            if (r2 == 0) goto L61
            int r5 = r2.bottomMargin
            goto L62
        L61:
            r5 = r4
        L62:
            r1.bottomMargin = r5
            if (r2 == 0) goto L6b
            int r5 = r2.getMarginStart()
            goto L6c
        L6b:
            r5 = r4
        L6c:
            r1.setMarginStart(r5)
            if (r2 == 0) goto L76
            int r2 = r2.getMarginEnd()
            goto L77
        L76:
            r2 = r4
        L77:
            r1.setMarginEnd(r2)
            android.view.View r2 = r6.bottomFade
            int r2 = r6.indexOfChild(r2)
            int r2 = r2 + 1
            int r5 = r6.getChildCount()
            int r2 = v9.C5685n.n(r2, r4, r5)
            r6.addView(r0, r2, r1)
            r0.setOutlineProvider(r3)
            android.content.res.Resources r6 = r6.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            float r6 = r6.density
            r1 = 1090519040(0x41000000, float:8.0)
            float r6 = r6 * r1
            r0.setTranslationZ(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.UnifiedChatHostView.H0():void");
    }

    public final boolean I0() {
        AgentSession.AgentConversation agentConversationR1;
        boolean z10 = this.emptyMessage;
        boolean z11 = this.awaitingRestoredConversation;
        boolean z12 = this.emptyConfirmedByConversationCallback;
        SessionHandler sessionHandler = this.sessionHandler;
        String strB = (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) ? null : agentConversationR1.B();
        return Q9.a(z10, z11, false, z12, strB == null || strB.length() == 0);
    }

    public final boolean J0(String sessionId) {
        AgentSession.AgentConversation agentConversationR1;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) {
            return false;
        }
        return kotlin.jvm.internal.p.d(agentConversationR1.getSessionId(), sessionId) || kotlin.jvm.internal.p.d(agentConversationR1.getTempSessionId(), sessionId) || kotlin.jvm.internal.p.d(agentConversationR1.B(), sessionId);
    }

    public final boolean M0() {
        AgentSession.AgentConversation agentConversationR1;
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) {
            return false;
        }
        List listP = C1173v.p(agentConversationR1.B(), agentConversationR1.getSessionId(), agentConversationR1.getTempSessionId());
        ArrayList arrayList = new ArrayList(C1174w.x(listP, 10));
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            arrayList.add(La.H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List listG0 = Z8.F.g0(arrayList2);
        if (listG0.isEmpty()) {
            return false;
        }
        if (!sessionHandler.k2()) {
            this.lastLeftHiddenIds = Z8.Y.e();
            return false;
        }
        List list = listG0;
        if (kotlin.jvm.internal.p.d(Z8.F.r1(list), this.lastLeftHiddenIds)) {
            return true;
        }
        this.lastLeftHiddenIds = Z8.F.r1(list);
        C4148a.k(TAG, "leaveIfCurrentSessionHidden ids=" + listG0, false, 4, null);
        C3172w.INSTANCE.g();
        q1(this, null, 1, null);
        AgentChatLayout.K3(this.chatLayout, false, null, null, 6, null);
        return true;
    }

    public final void Q0(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        InterfaceC5074l<? super String, Y8.t> interfaceC5074l = this.onConversationChanged;
        if (interfaceC5074l != null) {
            if (sessionId.length() <= 0) {
                sessionId = null;
            }
            interfaceC5074l.invoke(sessionId);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:2:0x0000, B:5:0x000a, B:9:0x002e, B:8:0x001f), top: B:17:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R0(u4.m.FolderMessage r7) {
        /*
            r6 = this;
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L35
            p9.p r0 = com.stepos.agentframework.chatui.AgentFileSyncBridge.b()     // Catch: java.lang.Throwable -> L35
            java.lang.String r1 = "getContext(...)"
            if (r0 == 0) goto L1f
            android.content.Context r2 = r6.getContext()     // Catch: java.lang.Throwable -> L35
            kotlin.jvm.internal.p.h(r2, r1)     // Catch: java.lang.Throwable -> L35
            java.lang.Object r0 = r0.invoke(r2, r7)     // Catch: java.lang.Throwable -> L35
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L35
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L35
            r2 = 1
            if (r0 != r2) goto L1f
            goto L2e
        L1f:
            com.stepos.agentframework.chatui.folder.FolderTreeSheet r0 = new com.stepos.agentframework.chatui.folder.FolderTreeSheet     // Catch: java.lang.Throwable -> L35
            android.content.Context r6 = r6.getContext()     // Catch: java.lang.Throwable -> L35
            kotlin.jvm.internal.p.h(r6, r1)     // Catch: java.lang.Throwable -> L35
            r0.<init>(r6, r7)     // Catch: java.lang.Throwable -> L35
            r0.show()     // Catch: java.lang.Throwable -> L35
        L2e:
            Y8.t r6 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L35
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L35
            goto L41
        L35:
            r0 = move-exception
            r6 = r0
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L41:
            java.lang.Throwable r2 = kotlin.Result.e(r6)
            if (r2 == 0) goto L53
            r4 = 8
            r5 = 0
            java.lang.String r0 = "UnifiedChatHostView"
            java.lang.String r1 = "openFileTree failed"
            r3 = 0
            h8.C4148a.t(r0, r1, r2, r3, r4, r5)
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.UnifiedChatHostView.R0(u4.m$d):void");
    }

    public final void S0(View anchor) {
        if (this.moreMenuPopup.f()) {
            this.moreMenuPopup.e();
            return;
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner == null) {
            return;
        }
        C1060i.d(C1398p.a(lifecycleOwner), null, null, new UnifiedChatHostView$openMoreMenu$1(this, anchor, null), 3, null);
    }

    public final void T0() {
        int i10 = this.chromeAppearGeneration + 1;
        this.chromeAppearGeneration = i10;
        ValueAnimator valueAnimator = this.chromeAppearAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.chrome.setVisibility(0);
        i0(0.0f);
        s1(i10);
    }

    public final void U0(String sessionId) {
        ChatSnapshotState.Snapshot aVarM = C3172w.INSTANCE.m();
        if (sessionId == null || !kotlin.jvm.internal.p.d(aVarM.getSessionId(), sessionId) || aVarM.getPosition() < 0) {
            aVarM = null;
        }
        this.pendingSnapshotRestore = aVarM;
        this.chatLayout.setSkipScrollToBottom(aVarM != null);
    }

    public final void V0(final String agentId, final String deviceId) {
        IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
        if (iExternalAgentBindService == null) {
            Toast.makeText(getContext(), R$string.chat_agent_offline_toast, 0).show();
        } else {
            iExternalAgentBindService.queryDeviceAgentOnline(deviceId, agentId, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.D9
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return UnifiedChatHostView.W0(this.f25757a, deviceId, agentId, (Result) obj);
                }
            });
        }
    }

    public final void X0() {
        AgentSession.AgentConversation agentConversationR1;
        String agentId;
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null || (agentId = agentConversationR1.getAgentId()) == null) {
            return;
        }
        String deviceId = agentConversationR1.getDeviceId();
        if (deviceId == null) {
            deviceId = "";
        }
        if (La.H.x0(agentId) || La.H.x0(deviceId)) {
            return;
        }
        V0(agentId, deviceId);
    }

    public final void Y0(String expectedSessionId, String reason) {
        if (expectedSessionId != null) {
            if (expectedSessionId.length() <= 0) {
                expectedSessionId = null;
            }
            if (expectedSessionId == null) {
                return;
            }
            if (!J0(expectedSessionId)) {
                C4148a.u(TAG, "session switch recover skip (" + reason + "): top!=expected expected=" + expectedSessionId, false, 4, null);
                return;
            }
            E0();
            this.chatLayout.d8();
            C4148a.u(TAG, "session switch recover (" + reason + "): restoreVisibleSession expected=" + expectedSessionId, false, 4, null);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("recover-");
            sb2.append(reason);
            g1(sb2.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Z0() {
        /*
            r9 = this;
            r0 = 0
            r9.E1(r0)
            com.stepos.ailauncher.chat.view.sla.SlaChatController r1 = r9.slaController
            if (r1 == 0) goto Lb
            r1.Q0()
        Lb:
            com.stepos.agentframework.chatcore.SessionHandler r1 = r9.sessionHandler
            if (r1 != 0) goto L11
            goto La3
        L11:
            com.stepos.ailauncher.chat.view.LauncherChatLayout r2 = r9.chatLayout
            boolean r2 = r1.d2(r2)
            com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r3 = r1.R1()
            r4 = 1
            if (r3 == 0) goto L34
            java.lang.String r5 = r3.getSessionId()
            int r6 = r5.length()
            if (r6 != 0) goto L2c
            java.lang.String r5 = r3.getTempSessionId()
        L2c:
            boolean r3 = r1.i2(r5)
            if (r3 != r4) goto L34
            r3 = r4
            goto L35
        L34:
            r3 = r0
        L35:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "releaseSessionBindings owned="
            r5.append(r6)
            r5.append(r2)
            java.lang.String r6 = " active="
            r5.append(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "UnifiedChatHostView"
            r7 = 4
            r8 = 0
            h8.C4148a.k(r6, r5, r0, r7, r8)
            int r5 = r9.sessionSwitchRecoverGeneration
            int r5 = r5 + r4
            r9.sessionSwitchRecoverGeneration = r5
            com.stepos.ailauncher.chat.view.LauncherChatLayout r4 = r9.chatLayout
            r4.setOnSessionSwitchGuardTimeout(r8)
            com.stepos.agentframework.chatcore.session.AgentSession$h r4 = r1.getSessionCreatedCallback()
            com.stepos.agentframework.chatcore.session.AgentSession$h r5 = r9.sessionCreatedCallback
            if (r4 != r5) goto L6b
            r1.M3(r8)
        L6b:
            r9.sessionCreatedCallback = r8
            r9.sessionCreatedSink = r8
            com.stepos.ailauncher.chat.input.ChatStopActions r4 = com.stepos.ailauncher.chat.input.ChatStopActions.INSTANCE
            r4.g(r9, r1)
            com.stepos.ailauncher.chat.view.LauncherChatLayout r4 = r9.chatLayout
            r4.w7()
            r9.sessionHandler = r8
            if (r2 == 0) goto La3
            if (r3 != 0) goto La3
            com.stepos.ailauncher.chat.manager.AgentConfig$a r9 = com.stepos.ailauncher.chat.manager.AgentConfig.INSTANCE
            com.stepos.ailauncher.chat.manager.AgentConfig r9 = r9.a()
            boolean r9 = r9.p(r1)
            if (r9 != 0) goto La3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "release owned completed float handler="
            r9.append(r2)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            h8.C4148a.k(r6, r9, r0, r7, r8)
            r1.d3()
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.UnifiedChatHostView.Z0():void");
    }

    public final void a1() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.chatLayout.T();
            this.chatLayout.Y5(false);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "reloadMessages failed", thE, false, 8, null);
        }
    }

    public final void b1(int rowId, int dotId, int textId, boolean hideWhenOffline) {
        Boolean bool = this.agentOnline;
        boolean z10 = bool != null && (!hideWhenOffline || bool.booleanValue());
        View viewFindViewById = findViewById(rowId);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(z10 ? 0 : 8);
        }
        if (z10) {
            View viewFindViewById2 = findViewById(dotId);
            if (viewFindViewById2 != null) {
                kotlin.jvm.internal.p.f(bool);
                viewFindViewById2.setBackgroundResource(bool.booleanValue() ? R$drawable.dot_status_online_chat : R$drawable.dot_status_offline_chat);
            }
            TextView textView = (TextView) findViewById(textId);
            if (textView != null) {
                textView.setText(bool.booleanValue() ? R$string.chat_external_agent_subtitle_online : R$string.chat_external_agent_subtitle_offline);
            }
        }
    }

    public final void d1(String status) {
        AgentSession.AgentConversation agentConversationR1;
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner == null) {
            return;
        }
        SessionHandler sessionHandler = this.sessionHandler;
        Object obj = null;
        String strB = (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) ? null : agentConversationR1.B();
        Ka.j jVarF = SequencesKt___SequencesKt.F(Z8.F.d0(this.chatLayout.getAdapter().G()), e.INSTANCE);
        kotlin.jvm.internal.p.g(jVarF, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Iterator it = jVarF.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((DisplayMessage) next).getMessageId().length() > 0) {
                obj = next;
                break;
            }
        }
        ChatTracker.INSTANCE.F(C1398p.a(lifecycleOwner), strB, (DisplayMessage) obj, status);
    }

    public final void e1() {
        if (this.messageListCacheTrimmed) {
            this.chatLayout.getMessageList().setItemViewCacheSize(2);
            this.messageListCacheTrimmed = false;
        }
    }

    public final void f1() {
        ChatSnapshotState.Snapshot aVar = this.pendingSnapshotRestore;
        if (aVar == null) {
            return;
        }
        String strE = aVar.getSessionId();
        if (strE == null) {
            strE = "";
        }
        if (J0(strE)) {
            this.pendingSnapshotRestore = null;
            if (aVar.getMessageId() != null) {
                this.chatLayout.u6(aVar.getMessageId(), aVar.getDisplayOffset(), aVar.getPosition(), aVar.getOffset());
            } else {
                this.chatLayout.x6(aVar.getPosition(), aVar.getOffset());
            }
        }
    }

    public final void g1(String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        SessionHandler sessionHandler = this.sessionHandler;
        C4148a.k(TAG, "restoreVisibleSession reason=" + reason + " painted=" + (sessionHandler != null ? sessionHandler.N2() : 0) + " pending=" + (sessionHandler != null ? sessionHandler.Q2() : null) + " owned=" + (sessionHandler != null ? Boolean.valueOf(sessionHandler.d2(this.chatLayout)) : null), false, 4, null);
        a1();
    }

    public final LauncherChatLayout getChatLayout() {
        return this.chatLayout;
    }

    public final InterfaceC5063a<Y8.t> getOnCloseClick() {
        return this.onCloseClick;
    }

    public final InterfaceC5074l<String, Y8.t> getOnConversationChanged() {
        return this.onConversationChanged;
    }

    public final InterfaceC5074l<Boolean, Y8.t> getOnEmptyStateChanged() {
        return this.onEmptyStateChanged;
    }

    public final InterfaceC5063a<Y8.t> getOnNewSessionClick() {
        return this.onNewSessionClick;
    }

    public final InterfaceC5074l<List<SessionArtifact>, Y8.t> getOnOpenArtifacts() {
        return this.onOpenArtifacts;
    }

    public final InterfaceC5063a<Y8.t> getOnSidebarClick() {
        return this.onSidebarClick;
    }

    public final void h0() {
        c1(this, R$id.unified_chrome_status, R$id.unified_chrome_status_dot, R$id.unified_chrome_status_text, false, 8, null);
        b1(R$id.unified_agent_status, R$id.unified_agent_status_dot, R$id.unified_agent_status_text, true);
    }

    public final void h1(boolean sampleVisible) {
        ChatSnapshotState.c cVar = this.snapshotUse;
        if (cVar == null) {
            return;
        }
        if (sampleVisible && C3172w.INSTANCE.e(cVar)) {
            z0();
        }
        C3172w.INSTANCE.k(cVar);
    }

    public final void i0(float t10) {
        float fM = C5685n.m(t10, 0.0f, 1.0f);
        this.btnSidebar.setAlpha(fM);
        this.chromeActions.setAlpha(fM);
        this.btnClose.setAlpha(fM);
        View chromeTitleBlock = getChromeTitleBlock();
        if (chromeTitleBlock != null) {
            chromeTitleBlock.setAlpha(fM);
        }
        float f10 = 1.0f - fM;
        float f11 = 40.0f * f10;
        View chromeTitleBlock2 = getChromeTitleBlock();
        if (chromeTitleBlock2 != null) {
            if (f11 < 0.5f) {
                chromeTitleBlock2.setRenderEffect(null);
            } else {
                chromeTitleBlock2.setRenderEffect(RenderEffect.createBlurEffect(f11, f11, Shader.TileMode.DECAL));
            }
        }
        this.chatLayout.getMessageList().setTranslationY((-B0()) * f10);
    }

    public final void j0() {
        String str = this.agentTitleText;
        TextView chromeTitle = getChromeTitle();
        if (chromeTitle != null) {
            chromeTitle.setText(str == null ? "" : str);
        }
        View chromeTitleBlock = getChromeTitleBlock();
        if (chromeTitleBlock != null) {
            chromeTitleBlock.setVisibility((str == null || this.showingEmptyHome) ? 4 : 0);
        }
    }

    public final void j1() {
        if (this.emptyRecomputePosted) {
            return;
        }
        this.emptyRecomputePosted = true;
        post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.u9
            @Override // java.lang.Runnable
            public final void run() {
                UnifiedChatHostView.k1(this.f26382a);
            }
        });
    }

    public final void k0(boolean isEmpty) {
        this.emptyMessage = isEmpty;
        boolean z10 = isEmpty && !this.awaitingRestoredConversation;
        this.showingEmptyHome = z10;
        String str = this.agentGreetingText;
        TextView agentGreeting = getAgentGreeting();
        if (agentGreeting != null) {
            agentGreeting.setText(str == null ? "" : str);
        }
        View agentEmptyBlock = getAgentEmptyBlock();
        if (agentEmptyBlock != null) {
            agentEmptyBlock.setVisibility((!z10 || str == null) ? 8 : 0);
        }
        j0();
        y1();
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = this.onEmptyStateChanged;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
    }

    public final void l0(float topDp) {
        int i10 = (int) (topDp * getResources().getDisplayMetrics().density);
        ChatRecycleView messageList = this.chatLayout.getMessageList();
        if (messageList.getPaddingTop() == i10) {
            return;
        }
        messageList.setPadding(messageList.getPaddingLeft(), i10, messageList.getPaddingRight(), messageList.getPaddingBottom());
    }

    public final void l1(final String sessionId) {
        final int i10 = this.sessionSwitchRecoverGeneration + 1;
        this.sessionSwitchRecoverGeneration = i10;
        this.chatLayout.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.view.I9
            @Override // java.lang.Runnable
            public final void run() {
                UnifiedChatHostView.m1(i10, this, sessionId);
            }
        }, 400L);
    }

    public final void m0() {
        ImageView scrollToBottomButton = this.chatLayout.getScrollToBottomButton();
        ViewGroup.LayoutParams layoutParams = scrollToBottomButton.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int i10 = (int) (30 * getResources().getDisplayMetrics().density);
        layoutParams.width = i10;
        layoutParams.height = i10;
        scrollToBottomButton.setLayoutParams(layoutParams);
    }

    public final void n0(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        SheetSettleState sheetSettleState = SheetSettleState.FULL;
        boolean z10 = true;
        boolean z11 = state == sheetSettleState;
        if (!z11 && state != SheetSettleState.HALF) {
            z10 = false;
        }
        this.topFade.setVisibility(z11 ? 0 : 8);
        this.topBlur.setVisibility(z10 ? 0 : 8);
        l0(z11 ? 86.0f : 32.0f);
        this.settleState = state;
        z1(z11);
        w1();
        x1(state);
        SheetSettleState sheetSettleState2 = this.lastSettleState;
        this.lastSettleState = state;
        if (state != sheetSettleState) {
            A0();
            F0();
            this.chrome.setVisibility(8);
            l0(CHROME_COLLAPSED_TOP_DP);
            return;
        }
        l0(MESSAGE_LIST_FULL_TOP_DP);
        if (sheetSettleState2 == SheetSettleState.HALF) {
            T0();
            return;
        }
        A0();
        F0();
        this.chrome.setVisibility(0);
    }

    public final void n1(String name, Boolean online) {
        if (name == null || La.H.x0(name)) {
            name = null;
        }
        this.agentTitleText = name;
        if (online == null || name == null) {
            online = null;
        }
        this.agentOnline = online;
        j0();
        h0();
        y1();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o0(com.stepos.agentframework.chatcore.SessionHandler r6, android.view.LifecycleOwner r7, boolean r8) {
        /*
            r5 = this;
            java.lang.String r0 = "handler"
            kotlin.jvm.internal.p.i(r6, r0)
            java.lang.String r0 = "lifecycleOwner"
            kotlin.jvm.internal.p.i(r7, r0)
            r5.sessionHandler = r6
            r5.lifecycleOwner = r7
            com.stepos.ailauncher.chat.view.LauncherChatLayout r0 = r5.chatLayout
            r1 = 0
            r0.U6(r1)
            r0 = 0
            r5.lastMarkedVisibleSessionId = r0
            r5.v0(r7)
            r5.awaitingRestoredConversation = r8
            r5.emptyConfirmedByConversationCallback = r1
            com.stepos.ailauncher.chat.view.v9 r8 = new com.stepos.ailauncher.chat.view.v9
            r8.<init>()
            r5.sessionCreatedSink = r8
            com.stepos.ailauncher.chat.view.V9 r2 = new com.stepos.ailauncher.chat.view.V9
            r2.<init>(r8)
            r5.sessionCreatedCallback = r2
            r6.M3(r2)
            com.stepos.ailauncher.chat.view.LauncherChatLayout r8 = r5.chatLayout
            r8.k3(r6)
            com.stepos.ailauncher.chat.input.ChatStopActions r8 = com.stepos.ailauncher.chat.input.ChatStopActions.INSTANCE
            r8.l(r5, r6)
            com.stepos.ailauncher.chat.view.sla.SlaChatController r8 = r5.slaController
            java.lang.String r2 = "getContext(...)"
            if (r8 == 0) goto L49
            boolean r3 = r8.B0(r6)
            if (r3 == 0) goto L46
            goto L47
        L46:
            r8 = r0
        L47:
            if (r8 != 0) goto L5e
        L49:
            com.stepos.ailauncher.chat.view.sla.SlaChatController r8 = new com.stepos.ailauncher.chat.view.sla.SlaChatController
            android.content.Context r3 = r5.getContext()
            kotlin.jvm.internal.p.h(r3, r2)
            r8.<init>(r3, r6)
            com.stepos.ailauncher.chat.view.sla.SlaChatController r3 = r5.slaController
            if (r3 == 0) goto L5c
            r3.e0()
        L5c:
            r5.slaController = r8
        L5e:
            com.stepos.ailauncher.chat.view.LauncherChatLayout r3 = r5.chatLayout
            r4 = 2
            com.stepos.ailauncher.chat.view.sla.SlaChatController.w0(r8, r3, r0, r4, r0)
            com.stepos.ailauncher.chat.view.Z3 r8 = com.stepos.ailauncher.chat.view.Z3.INSTANCE
            android.content.Context r3 = r5.getContext()
            kotlin.jvm.internal.p.h(r3, r2)
            r8.c(r3)
            com.stepos.ailauncher.chat.view.LauncherChatLayout r8 = r5.chatLayout
            com.stepos.agentframework.AgentUIConfig r7 = r5.y0(r7)
            r8.setAgentUiConfig(r7)
            com.stepos.ailauncher.chat.view.LauncherChatLayout r7 = r5.chatLayout
            r7.setEmptyShowEnable(r1)
            com.stepos.ailauncher.chat.view.LauncherChatLayout r7 = r5.chatLayout
            com.stepos.ailauncher.chat.view.w9 r8 = new com.stepos.ailauncher.chat.view.w9
            r8.<init>()
            r7.setOnSessionSwitchGuardTimeout(r8)
            com.stepos.ailauncher.chat.tts.a r7 = com.stepos.ailauncher.chat.tts.a.INSTANCE
            com.stepos.ailauncher.chat.view.LauncherChatLayout r8 = r5.chatLayout
            r7.n(r8)
            com.stepos.ailauncher.chat.view.LauncherChatLayout r7 = r5.chatLayout
            com.stepos.ailauncher.chat.view.x9 r8 = new com.stepos.ailauncher.chat.view.x9
            r8.<init>()
            r7.setOnReceiveMessage(r8)
            com.stepos.ailauncher.chat.view.LauncherChatLayout r7 = r5.chatLayout
            com.stepos.ailauncher.chat.view.y9 r8 = new com.stepos.ailauncher.chat.view.y9
            r8.<init>()
            r7.setOnSessionKeyVisible(r8)
            com.stepos.ailauncher.chat.view.LauncherChatLayout r7 = r5.chatLayout
            com.stepos.ailauncher.chat.view.UnifiedChatHostView$c r8 = new com.stepos.ailauncher.chat.view.UnifiedChatHostView$c
            r8.<init>()
            r7.setTtsPlayerListener(r8)
            com.stepos.ailauncher.chat.view.LauncherChatLayout r7 = r5.chatLayout
            com.stepos.ailauncher.chat.view.z9 r8 = new com.stepos.ailauncher.chat.view.z9
            r8.<init>()
            r7.setOnMessagesApplied(r8)
            com.stepos.ailauncher.chat.view.LauncherChatLayout r7 = r5.chatLayout
            com.stepos.ailauncher.chat.view.A9 r8 = new com.stepos.ailauncher.chat.view.A9
            r8.<init>()
            r7.setOnCurrentConversationChanged(r8)
            com.stepos.ailauncher.chat.view.LauncherChatLayout r7 = r5.chatLayout
            com.stepos.agentframework.chatui.ChatMessageAdapter r7 = r7.getAdapter()
            java.util.List r7 = r7.G()
            boolean r7 = r7.isEmpty()
            r5.k0(r7)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "bind done handler="
            r5.append(r7)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r6 = 4
            java.lang.String r7 = "UnifiedChatHostView"
            h8.C4148a.d(r7, r5, r1, r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.UnifiedChatHostView.o0(com.stepos.agentframework.chatcore.SessionHandler, androidx.lifecycle.LifecycleOwner, boolean):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.snapshotFrameObserver);
        if (this.adapterEmptyObserver == null) {
            d dVar = new d();
            this.chatLayout.getAdapter().registerAdapterDataObserver(dVar);
            this.adapterEmptyObserver = dVar;
            j1();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        E1(false);
        getViewTreeObserver().removeOnPreDrawListener(this.snapshotFrameObserver);
        super.onDetachedFromWindow();
        getKeepScreenOnController().n();
        getTtsMediaFocusController().c0();
        RecyclerView.AdapterDataObserver adapterDataObserver = this.adapterEmptyObserver;
        if (adapterDataObserver != null) {
            this.chatLayout.getAdapter().unregisterAdapterDataObserver(adapterDataObserver);
        }
        this.adapterEmptyObserver = null;
        A0();
        F0();
        this.moreMenuPopup.e();
        this.lifecycleOwner = null;
        this.sessionSwitchRecoverGeneration++;
    }

    public final void p1(String greeting) {
        h1(false);
        this.snapshotUse = null;
        this.snapshotVisible = false;
        this.snapshotTargetSessionId = null;
        this.pendingSnapshotRestore = null;
        this.chatLayout.setSkipScrollToBottom(false);
        this.awaitingRestoredConversation = false;
        if (greeting == null || La.H.x0(greeting)) {
            greeting = null;
        }
        this.agentGreetingText = greeting;
        k0(true);
    }

    public final void s1(final int generation) {
        ValueAnimator valueAnimator = this.chromeAppearAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.setInterpolator(CHROME_APPEAR_INTERPOLATOR);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.view.F9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                UnifiedChatHostView.t1(generation, this, valueAnimator2);
            }
        });
        valueAnimatorOfFloat.addListener(new g(generation, this));
        valueAnimatorOfFloat.start();
        this.chromeAppearAnim = valueAnimatorOfFloat;
    }

    public final void setContentHiddenForWakeFloating(boolean hidden) {
        setVisibility(hidden ? 4 : 0);
    }

    public final void setConversationPageVisible(boolean visible) {
        boolean zU6 = this.chatLayout.U6(visible);
        if (!visible) {
            this.lastMarkedVisibleSessionId = null;
            return;
        }
        String strG0 = G0();
        if (strG0 == null) {
            strG0 = "";
        }
        if (zU6 && kotlin.jvm.internal.p.d(strG0, this.lastMarkedVisibleSessionId)) {
            return;
        }
        this.lastMarkedVisibleSessionId = strG0;
        this.chatLayout.e5();
    }

    public final void setExternalSessionHome(boolean external) {
        this.isExternalSession = external;
    }

    public final void setOnCloseClick(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onCloseClick = interfaceC5063a;
    }

    public final void setOnConversationChanged(InterfaceC5074l<? super String, Y8.t> interfaceC5074l) {
        this.onConversationChanged = interfaceC5074l;
    }

    public final void setOnEmptyStateChanged(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onEmptyStateChanged = interfaceC5074l;
    }

    public final void setOnNewSessionClick(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onNewSessionClick = interfaceC5063a;
    }

    public final void setOnOpenArtifacts(InterfaceC5074l<? super List<SessionArtifact>, Y8.t> interfaceC5074l) {
        this.onOpenArtifacts = interfaceC5074l;
    }

    public final void setOnSidebarClick(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onSidebarClick = interfaceC5063a;
    }

    public final void setSidebarAsBack(boolean asBack) {
        this.btnSidebar.setImageResource(asBack ? R$drawable.ic_back_new : R$drawable.ic_chrome_sidebar);
        this.btnSidebar.setContentDescription(asBack ? getContext().getString(R$string.common_back) : null);
    }

    public final void u1() {
        com.stepos.ailauncher.chat.tts.a.INSTANCE.x();
        this.chatLayout.p7();
    }

    public final void v0(LifecycleOwner owner) {
        C2773b6 c2773b6 = this.chromeGlass;
        if (c2773b6 != null) {
            c2773b6.t();
        }
        C2773b6 c2773b62 = new C2773b6(owner, false, 2, null);
        C2773b6.p(c2773b62, new View[]{this.btnSidebar, this.chromeActions, this.btnClose}, y7.o.INSTANCE.i(), false, 4, null);
        c2773b62.i(new View[]{this.topBlur}, G.a.f43886a.g(), Float.valueOf(getResources().getDimension(R$dimen.ail_sheet_corner) / getResources().getDisplayMetrics().density), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.G9
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return UnifiedChatHostView.w0((A7.B) obj);
            }
        });
        C2773b6.j(c2773b62, new View[]{this.bottomFade}, null, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.H9
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return UnifiedChatHostView.x0((A7.B) obj);
            }
        }, 6, null);
        this.chromeGlass = c2773b62;
    }

    public final boolean v1(String sessionId) {
        SessionHandler sessionHandler;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0 || (sessionHandler = this.sessionHandler) == null) {
            return false;
        }
        C2739j.d(sessionId);
        this.snapshotTargetSessionId = sessionId;
        ChatSnapshotState.Snapshot aVar = this.pendingSnapshotRestore;
        if (!kotlin.jvm.internal.p.d(aVar != null ? aVar.getSessionId() : null, sessionId)) {
            this.pendingSnapshotRestore = null;
            this.chatLayout.setSkipScrollToBottom(false);
        }
        if (J0(sessionId)) {
            return false;
        }
        i1(this, false, 1, null);
        this.snapshotVisible = false;
        E0();
        this.chatLayout.Z7(sessionId);
        sessionHandler.N0(sessionId);
        l1(sessionId);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0013 A[PHI: r1
      0x0013: PHI (r1v16 java.lang.Integer) = (r1v1 java.lang.Integer), (r1v6 java.lang.Integer) binds: [B:3:0x0011, B:10:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w1() {
        /*
            r10 = this;
            android.content.res.Resources r0 = r10.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            com.stepos.ailauncher.chat.view.LauncherChatLayout r1 = r10.chatLayout
            java.lang.Integer r1 = r1.y8()
            r2 = 0
            if (r1 == 0) goto L19
        L13:
            int r1 = r1.intValue()
        L17:
            r5 = r1
            goto L39
        L19:
            com.stepos.ailauncher.chat.view.LauncherChatLayout r1 = r10.chatLayout
            com.stepos.agentframework.chatui.view.ChatRecycleView r1 = r1.getMessageList()
            int r1 = r1.getPaddingBottom()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r3 = r1.intValue()
            if (r3 <= 0) goto L2e
            goto L2f
        L2e:
            r1 = r2
        L2f:
            if (r1 == 0) goto L32
            goto L13
        L32:
            com.stepos.ailauncher.chat.view.LauncherChatLayout r1 = r10.chatLayout
            int r1 = r1.getPaddingBottom()
            goto L17
        L39:
            r1 = 1128792064(0x43480000, float:200.0)
            float r1 = r1 * r0
            int r9 = (int) r1
            r1 = 1094713344(0x41400000, float:12.0)
            float r0 = r0 * r1
            int r6 = (int) r0
            com.stepos.ailauncher.chat.view.LauncherChatLayout r0 = r10.chatLayout
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r1 = r0 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r1 == 0) goto L4e
            android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
            goto L4f
        L4e:
            r0 = r2
        L4f:
            r1 = 0
            if (r0 == 0) goto L56
            int r0 = r0.bottomMargin
            r8 = r0
            goto L57
        L56:
            r8 = r1
        L57:
            com.stepos.ailauncher.chat.view.h9 r3 = com.stepos.ailauncher.chat.view.C2842h9.INSTANCE
            com.stepos.ailauncher.sheet.SheetSettleState r4 = r10.settleState
            r7 = r6
            int r0 = r3.a(r4, r5, r6, r7, r8, r9)
            android.view.View r3 = r10.bottomFade
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            boolean r4 = r3 instanceof android.widget.FrameLayout.LayoutParams
            if (r4 == 0) goto L6d
            r2 = r3
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
        L6d:
            if (r2 != 0) goto L70
            goto L78
        L70:
            int r3 = r2.height
            if (r3 != r0) goto L79
            int r3 = r2.bottomMargin
            if (r3 != 0) goto L79
        L78:
            return
        L79:
            r2.height = r0
            r2.bottomMargin = r1
            android.view.View r10 = r10.bottomFade
            r10.setLayoutParams(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.UnifiedChatHostView.w1():void");
    }

    public final void x1(SheetSettleState state) {
        Pair pairA;
        float f10 = getResources().getDisplayMetrics().density;
        int i10 = b.$EnumSwitchMapping$0[state.ordinal()];
        if (i10 == 1) {
            pairA = Y8.j.a(Float.valueOf(76.0f), Float.valueOf(15.2f));
        } else {
            if (i10 != 2) {
                ChatRecycleView.p(this.chatLayout.getMessageList(), 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                return;
            }
            pairA = Y8.j.a(Float.valueOf(40.0f), Float.valueOf(12.0f));
        }
        this.chatLayout.getMessageList().o(((Number) pairA.a()).floatValue() * f10, 144.0f * f10, ((Number) pairA.b()).floatValue() * f10, f10 * 28.8f);
    }

    public final AgentUIConfig y0(LifecycleOwner lifecycleOwner) {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        return C6.a(context, lifecycleOwner);
    }

    public final void y1() {
        boolean z10;
        boolean zD = kotlin.jvm.internal.p.d(this.agentOnline, Boolean.FALSE);
        List<com.stepos.agentframework.chatui.S1> listG = this.chatLayout.getAdapter().G();
        if ((listG instanceof Collection) && listG.isEmpty()) {
            z10 = false;
        } else {
            Iterator<T> it = listG.iterator();
            while (it.hasNext()) {
                if (!(((com.stepos.agentframework.chatui.S1) it.next()) instanceof com.stepos.agentframework.chatui.k2)) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        }
        View agentOfflineHint = getAgentOfflineHint();
        if (agentOfflineHint != null) {
            agentOfflineHint.setVisibility((!zD || z10) ? 8 : 0);
        }
        this.chatLayout.s7(zD && z10);
    }

    public final void z0() {
        int iFindLastVisibleItemPosition;
        View viewFindViewByPosition;
        ChatSnapshotState.c cVar = this.snapshotUse;
        if (cVar != null && this.snapshotVisible) {
            C3172w c3172w = C3172w.INSTANCE;
            if (c3172w.e(cVar)) {
                ChatRecycleView messageList = this.chatLayout.getMessageList();
                if (!isShown() || getWindowVisibility() != 0 || !messageList.isLaidOut() || messageList.isLayoutRequested() || messageList.isComputingLayout() || messageList.hasPendingAdapterUpdates() || this.chatLayout.getSkipScrollToBottom() || !kotlin.jvm.internal.p.d(G0(), cVar.getSessionId()) || this.emptyMessage || this.awaitingRestoredConversation || this.chatLayout.w8()) {
                    return;
                }
                RecyclerView.LayoutManager layoutManager = messageList.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager == null || (iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition()) == -1 || (viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindLastVisibleItemPosition)) == null) {
                    return;
                }
                ChatMessageAdapter adapter = this.chatLayout.getAdapter();
                if (adapter.Q(iFindLastVisibleItemPosition)) {
                    return;
                }
                com.stepos.agentframework.chatui.S1 s1S = adapter.S(iFindLastVisibleItemPosition);
                DisplayMessage displayMessage = s1S instanceof DisplayMessage ? (DisplayMessage) s1S : null;
                c3172w.d(cVar, displayMessage != null ? adapter.V(iFindLastVisibleItemPosition) : iFindLastVisibleItemPosition, (linearLayoutManager.getHeight() - linearLayoutManager.getPaddingBottom()) - linearLayoutManager.getDecoratedBottom(viewFindViewByPosition), displayMessage != null ? displayMessage.getMessageId() : null, adapter.E(iFindLastVisibleItemPosition));
            }
        }
    }

    public final void z1(boolean full) {
        ViewGroup.LayoutParams layoutParams = this.topBlur.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        int i10 = (int) ((full ? CHROME_FADE_TOP_DP : 28.0f) * getResources().getDisplayMetrics().density);
        if (layoutParams2.height == i10 && layoutParams2.topMargin == 0) {
            return;
        }
        layoutParams2.height = i10;
        layoutParams2.topMargin = 0;
        this.topBlur.setLayoutParams(layoutParams2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnifiedChatHostView(final Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.keepScreenOnController = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.i9
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UnifiedChatHostView.K0(this.f26178a);
            }
        });
        this.ttsMediaFocusController = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.k9
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UnifiedChatHostView.C1(context, this);
            }
        });
        this.moreMenuPopup = new C2963t(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.l9
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return UnifiedChatHostView.N0(this.f26239a, (List) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.m9
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return UnifiedChatHostView.O0(this.f26253a, (m.FolderMessage) obj);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.n9
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UnifiedChatHostView.P0(this.f26270a);
            }
        });
        this.lastLeftHiddenIds = Z8.Y.e();
        this.snapshotSource = new f();
        this.snapshotFrameObserver = new ViewTreeObserver.OnPreDrawListener() { // from class: com.stepos.ailauncher.chat.view.o9
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return UnifiedChatHostView.r1(this.f26284a);
            }
        };
        this.settleState = SheetSettleState.HIDDEN;
        this.agentEmptyBlock = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.p9
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UnifiedChatHostView.e0(this.f26295a);
            }
        });
        this.agentGreeting = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.q9
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UnifiedChatHostView.f0(this.f26308a);
            }
        });
        this.chromeTitleBlock = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.r9
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UnifiedChatHostView.C0(this.f26322a);
            }
        });
        this.chromeTitle = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.s9
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UnifiedChatHostView.D0(this.f26332a);
            }
        });
        this.agentOfflineHint = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.t9
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UnifiedChatHostView.g0(this.f26369a);
            }
        });
        this.emptyMessage = true;
        View.inflate(context, R$layout.view_unified_chat_host, this);
        View viewFindViewById = findViewById(R$id.aclChat);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        LauncherChatLayout launcherChatLayout = (LauncherChatLayout) viewFindViewById;
        this.chatLayout = launcherChatLayout;
        launcherChatLayout.Q3(getResources().getDimensionPixelSize(com.stepos.ailauncher.chat.R$dimen.unified_chat_message_horizontal_inset));
        m0();
        setClipChildren(false);
        ChatRecycleView messageList = launcherChatLayout.getMessageList();
        messageList.setClipToPadding(false);
        messageList.setVerticalFadingEdgeEnabled(false);
        l0(MESSAGE_LIST_FULL_TOP_DP);
        View viewFindViewById2 = findViewById(R$id.unified_chrome);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById2;
        this.chrome = linearLayout;
        linearLayout.forceHasOverlappingRendering(false);
        View viewFindViewById3 = findViewById(R$id.unified_btn_sidebar);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById3;
        this.btnSidebar = imageView;
        View viewFindViewById4 = findViewById(R$id.unified_btn_new_session);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        ImageView imageView2 = (ImageView) viewFindViewById4;
        this.btnNewSession = imageView2;
        View viewFindViewById5 = findViewById(R$id.unified_btn_more);
        kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
        ImageView imageView3 = (ImageView) viewFindViewById5;
        this.btnMore = imageView3;
        View viewFindViewById6 = findViewById(R$id.unified_btn_close);
        kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
        ImageView imageView4 = (ImageView) viewFindViewById6;
        this.btnClose = imageView4;
        View viewFindViewById7 = findViewById(R$id.unified_chrome_actions);
        kotlin.jvm.internal.p.h(viewFindViewById7, "findViewById(...)");
        this.chromeActions = viewFindViewById7;
        View viewFindViewById8 = findViewById(R$id.ll_chat_top_fade);
        kotlin.jvm.internal.p.h(viewFindViewById8, "findViewById(...)");
        this.topFade = viewFindViewById8;
        View viewFindViewById9 = findViewById(R$id.v_chat_top_fade);
        kotlin.jvm.internal.p.h(viewFindViewById9, "findViewById(...)");
        this.topBlur = viewFindViewById9;
        View viewFindViewById10 = findViewById(R$id.v_chat_bottom_fade);
        kotlin.jvm.internal.p.h(viewFindViewById10, "findViewById(...)");
        this.bottomFade = viewFindViewById10;
        H0();
        launcherChatLayout.setOnOverlayGeometryChanged(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.E9
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UnifiedChatHostView.I(this.f25768a);
            }
        });
        launcherChatLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.view.J9
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                UnifiedChatHostView.J(this.f25842a, view, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        });
        launcherChatLayout.getMessageList().addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.view.K9
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                UnifiedChatHostView.K(this.f25860a, view, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        });
        w1();
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.L9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UnifiedChatHostView.L(this.f25868a, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.M9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UnifiedChatHostView.M(this.f25886a, view);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.N9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UnifiedChatHostView.N(this.f25903a, view);
            }
        });
        View viewFindViewById11 = findViewById(R$id.unified_agent_offline_reconnect);
        if (viewFindViewById11 != null) {
            viewFindViewById11.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.O9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UnifiedChatHostView.O(this.f25915a, view);
                }
            });
        }
        launcherChatLayout.setAgentOfflineReconnectListener(new p9.p() { // from class: com.stepos.ailauncher.chat.view.P9
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return UnifiedChatHostView.P(this.f25926a, (String) obj, (String) obj2);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.j9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UnifiedChatHostView.Q(this.f26207a, view);
            }
        });
    }

    public /* synthetic */ UnifiedChatHostView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
