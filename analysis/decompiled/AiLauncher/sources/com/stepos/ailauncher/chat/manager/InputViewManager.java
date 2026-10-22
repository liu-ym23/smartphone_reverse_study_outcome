package com.stepos.ailauncher.chat.manager;

import Ua.C1060i;
import Z8.C1165m;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatui.dialog.DialogC1998i;
import com.stepos.agentframework.chatui.dialog.DislikeReportDialog;
import com.stepos.agentframework.chatui.view.C2069d0;
import com.stepos.ailauncher.chat.api.ActionViewApi;
import com.stepos.ailauncher.chat.broadcast.RecentsWindowMonitor;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.model.ActionBarConfig;
import com.stepos.ailauncher.chat.view.ActionView;
import com.stepos.ailauncher.chat.view.BaseInputView;
import com.stepos.ailauncher.chat.view.C2963t;
import com.stepos.ailauncher.chat.view.ChatView;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.chat.wake.DialogC3116e0;
import com.stepos.ailauncher.common.utils.C3202f;
import com.stepos.ailauncher.network.RetrofitProvider;
import h9.InterfaceC4149a;
import io.ktor.http.ContentType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import y4.InterfaceC5940b;

@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004µ\u0001¶\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J#\u0010\"\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00040 H\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010%\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0007H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\tH\u0002¢\u0006\u0004\b(\u0010)J\u0015\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\u0004¢\u0006\u0004\b2\u0010\u0003J\u0015\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\f¢\u0006\u0004\b4\u00105J\u0015\u00106\u001a\u00020\u00042\u0006\u00103\u001a\u00020\f¢\u0006\u0004\b6\u00105J\r\u00107\u001a\u00020\t¢\u0006\u0004\b7\u00108J\u0015\u00109\u001a\u00020\u00042\u0006\u00103\u001a\u00020\f¢\u0006\u0004\b9\u00105J\u0015\u0010:\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b:\u0010;J\r\u0010<\u001a\u00020\u0004¢\u0006\u0004\b<\u0010\u0003J\u0015\u0010=\u001a\u00020\u00042\u0006\u00103\u001a\u00020\f¢\u0006\u0004\b=\u00105J\u0015\u0010>\u001a\u00020\u00042\u0006\u00103\u001a\u00020\f¢\u0006\u0004\b>\u00105J\u0019\u0010@\u001a\u00020\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b@\u0010AJ\u0015\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0007¢\u0006\u0004\bC\u0010AJ\r\u0010D\u001a\u00020\u0004¢\u0006\u0004\bD\u0010\u0003J\u0017\u0010G\u001a\u00020\u00042\b\b\u0002\u0010F\u001a\u00020E¢\u0006\u0004\bG\u0010HJ\r\u0010I\u001a\u00020\u0004¢\u0006\u0004\bI\u0010\u0003J\u0019\u0010K\u001a\u00020\u00042\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\bK\u0010AJ\u0015\u0010L\u001a\u00020\t2\u0006\u00103\u001a\u00020\f¢\u0006\u0004\bL\u0010MJ\r\u0010N\u001a\u00020\u0004¢\u0006\u0004\bN\u0010\u0003J\u000f\u0010O\u001a\u0004\u0018\u00010\f¢\u0006\u0004\bO\u0010PJ\u0015\u0010Q\u001a\u00020\u00042\u0006\u00103\u001a\u00020\f¢\u0006\u0004\bQ\u00105J\r\u0010R\u001a\u00020\u0004¢\u0006\u0004\bR\u0010\u0003J\u0015\u0010S\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\bS\u00105J\u0015\u0010T\u001a\u00020\t2\u0006\u00103\u001a\u00020\f¢\u0006\u0004\bT\u0010MJ\u0015\u0010U\u001a\u00020\u00042\u0006\u00103\u001a\u00020\f¢\u0006\u0004\bU\u00105J\u0015\u0010V\u001a\u00020\u00042\u0006\u00103\u001a\u00020\f¢\u0006\u0004\bV\u00105J\r\u0010W\u001a\u00020\u0004¢\u0006\u0004\bW\u0010\u0003J\r\u0010X\u001a\u00020\u0004¢\u0006\u0004\bX\u0010\u0003J\u000f\u0010Z\u001a\u0004\u0018\u00010Y¢\u0006\u0004\bZ\u0010[J\u000f\u0010\\\u001a\u0004\u0018\u00010Y¢\u0006\u0004\b\\\u0010[J\u0015\u0010]\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b]\u00105J\u000f\u0010^\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b^\u0010PJ\r\u0010_\u001a\u00020\u0004¢\u0006\u0004\b_\u0010\u0003J\u000f\u0010`\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b`\u0010PJ\u000f\u0010a\u001a\u0004\u0018\u00010\f¢\u0006\u0004\ba\u0010PJ\r\u0010c\u001a\u00020b¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\be\u0010PJ\r\u0010f\u001a\u00020\u0004¢\u0006\u0004\bf\u0010\u0003J\u0015\u0010g\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0007¢\u0006\u0004\bg\u0010\u000bJ\u0017\u0010h\u001a\u0004\u0018\u00010\f2\u0006\u0010$\u001a\u00020\u0007¢\u0006\u0004\bh\u0010iJ\u0017\u0010l\u001a\u00020\u00042\b\u0010k\u001a\u0004\u0018\u00010j¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u0004\u0018\u00010j¢\u0006\u0004\bn\u0010oJ!\u0010q\u001a\u00020\u00042\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040 ¢\u0006\u0004\bq\u0010#J!\u0010r\u001a\u00020\u00042\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040 ¢\u0006\u0004\br\u0010#R\u0014\u0010s\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\bs\u0010tR\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00020v0u8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0014\u0010y\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\by\u0010tR \u0010|\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0{0z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}R \u0010~\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0{0z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010}R \u0010\u007f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0{0z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u007f\u0010}R!\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u0082\u0001\u001a\u00020E8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0084\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010\u0016R!\u0010\u0085\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0081\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010\u0016R,\u0010\u0088\u0001\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e0\u0087\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001b\u0010\u008a\u0001\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R)\u0010\u008d\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040 0\u008c\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010xR\u001c\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070z8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010}R$\u0010\u008f\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010Y0{0z8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010}R\u001c\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070z8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010}R\u001c\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001c\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0018\u0010\u0097\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010\u0016R\u0018\u0010\u0098\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010\u0016R\u0018\u0010\u0099\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010\u0016R\u0018\u0010\u009a\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010\u0016R\u001b\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0018\u0010\u009e\u0001\u001a\u00030\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010¡\u0001\u001a\u00030 \u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R!\u0010£\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010\u0081\u0001R\u0019\u0010¤\u0001\u001a\u00020E8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010\u0083\u0001R\u0018\u0010¥\u0001\u001a\u00030\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010\u009f\u0001R+\u0010¬\u0001\u001a\r §\u0001*\u0005\u0018\u00010¦\u00010¦\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001R\u001c\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R#\u0010°\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010Y\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010\u0081\u0001R\u0018\u0010±\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b±\u0001\u0010\u0016R\u0017\u0010²\u0001\u001a\u00020E8\u0006X\u0086T¢\u0006\b\n\u0006\b²\u0001\u0010\u0083\u0001R\u001f\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020\f0{8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010\u0081\u0001R\u0017\u0010´\u0001\u001a\u00020E8\u0002X\u0082T¢\u0006\b\n\u0006\b´\u0001\u0010\u0083\u0001¨\u0006·\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/InputViewManager;", "", "<init>", "()V", "LY8/t;", "p0", "R0", "", "action", "", "M0", "(Ljava/lang/String;)Z", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "target", "Lkotlin/Pair;", "Landroid/os/Bundle;", "event", "j0", "(Lcom/stepos/ailauncher/chat/view/BaseInputView;Lkotlin/Pair;)V", "N", "Landroid/content/Context;", "context", "Z", "(Landroid/content/Context;)Z", "", ExifInterface.LONGITUDE_WEST, "()I", "Landroid/view/View;", "view", "g0", "(Landroid/view/View;)V", "U", "Lkotlin/Function1;", "Ly4/b;", "u0", "(Lp9/l;)V", "sessionId", "I0", "(Lcom/stepos/ailauncher/chat/view/BaseInputView;Ljava/lang/String;)Z", "isShowing", "Q0", "(Z)V", "Landroid/app/Application;", ContentType.Application.TYPE, "G0", "(Landroid/app/Application;)V", "Lcom/stepos/ailauncher/chat/view/ActionView;", "actionView", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/ailauncher/chat/view/ActionView;)V", "o0", "inputView", SdCardDbCreator.FIELD_LASTLOC_ID, "(Lcom/stepos/ailauncher/chat/view/BaseInputView;)V", "h1", "C0", "()Z", "Y0", "b1", "(Landroid/content/Context;)V", "D0", "P0", "j1", "pressToTalkCancelReason", "e1", "(Ljava/lang/String;)V", "stopReason", "X", "S0", "", "durationMs", "Q", "(J)V", "i1", "reason", "c0", "K0", "(Lcom/stepos/ailauncher/chat/view/BaseInputView;)Z", "m0", "B0", "()Lcom/stepos/ailauncher/chat/view/BaseInputView;", "N0", "a0", "b0", "J0", "L", "V0", "k0", "h0", "Landroid/app/Activity;", "x0", "()Landroid/app/Activity;", "z0", "O0", "w0", "e0", "r0", "t0", "Lcom/stepos/ailauncher/chat/manager/InputViewManager$a;", "T0", "()Lcom/stepos/ailauncher/chat/manager/InputViewManager$a;", "q0", "f0", "L0", "s0", "(Ljava/lang/String;)Lcom/stepos/ailauncher/chat/view/BaseInputView;", "Lcom/stepos/ailauncher/chat/wake/e0;", C3081a.FOCUS_DIALOG_NAME, "Z0", "(Lcom/stepos/ailauncher/chat/wake/e0;)V", "y0", "()Lcom/stepos/ailauncher/chat/wake/e0;", "listener", "M", "X0", "TAG", "Ljava/lang/String;", "", "Lcom/stepos/ailauncher/chat/manager/InputViewManager$WakeBlockingWindowId;", "WAKE_BLOCKING_WINDOW_WHITELIST", "Ljava/util/Set;", "CHAT_MAIN_ACTIVITY_NAME", "", "Ljava/lang/ref/WeakReference;", "inputViewList", "Ljava/util/List;", "dependentInputViewList", "actionViewList", "agentInputView", "Ljava/lang/ref/WeakReference;", "agentVoiceRearmUntilUptimeMs", "J", "pendingAgentVoiceRearmAfterChatLeave", "pickInitiator", "pickResultDispatchSuspended", "LZ8/m;", "pendingPickEvents", "LZ8/m;", "currentWakeDialog", "Lcom/stepos/ailauncher/chat/wake/e0;", "", "wakeDialogVisibilityListeners", "fixedInputFragmentList", "activeActivities", "markedActivities", "Landroid/view/WindowManager;", "windowManager", "Landroid/view/WindowManager;", "Lcom/stepos/ailauncher/chat/view/ChatView;", "floatChatView", "Lcom/stepos/ailauncher/chat/view/ChatView;", "isFloatViewAdded", "isRemovingFloatView", "pendingShowAfterRemove", "isFixedMode", "appContext", "Landroid/content/Context;", "LUa/M;", "managerScope", "LUa/M;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "preparedWakeInputView", "preparedWakeInputUntilUptimeMs", "managerMainScope", "Lcom/stepos/ailauncher/chat/api/ActionViewApi;", "kotlin.jvm.PlatformType", "actionViewApi$delegate", "LY8/h;", "v0", "()Lcom/stepos/ailauncher/chat/api/ActionViewApi;", "actionViewApi", "Lcom/stepos/ailauncher/chat/model/ActionBarConfig;", "actionBarConfig", "Lcom/stepos/ailauncher/chat/model/ActionBarConfig;", "currentActivity", "chatMainActivityResumed", "AGENT_VOICE_REARM_MS", "aiKeyActiveInput", "WAKE_PREPARED_INPUT_LEASE_MS", "WakeBlockingWindowId", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InputViewManager {
    public static final long AGENT_VOICE_REARM_MS = 800;
    private static final String CHAT_MAIN_ACTIVITY_NAME = "ChatMainActivity";
    private static final String TAG = "InputViewManager";
    private static final long WAKE_PREPARED_INPUT_LEASE_MS = 500;
    private static volatile ActionBarConfig actionBarConfig;
    private static WeakReference<BaseInputView> agentInputView;
    private static long agentVoiceRearmUntilUptimeMs;
    private static Context appContext;
    private static volatile boolean chatMainActivityResumed;
    private static WeakReference<Activity> currentActivity;
    private static DialogC3116e0 currentWakeDialog;
    private static ChatView floatChatView;
    private static boolean isFloatViewAdded;
    private static boolean isRemovingFloatView;
    private static boolean pendingAgentVoiceRearmAfterChatLeave;
    private static boolean pendingShowAfterRemove;
    private static WeakReference<BaseInputView> pickInitiator;
    private static boolean pickResultDispatchSuspended;
    private static long preparedWakeInputUntilUptimeMs;
    private static WeakReference<BaseInputView> preparedWakeInputView;
    private static WindowManager windowManager;
    public static final InputViewManager INSTANCE = new InputViewManager();
    public static final Set<WakeBlockingWindowId> WAKE_BLOCKING_WINDOW_WHITELIST = Z8.Y.j(WakeBlockingWindowId.SELECT_TEXT_DIALOG, WakeBlockingWindowId.MESSAGE_LONG_PRESS_MENU, WakeBlockingWindowId.SOURCES_PANEL, WakeBlockingWindowId.DISLIKE_REPORT_DIALOG, WakeBlockingWindowId.DELETE_CONFIRM_DIALOG, WakeBlockingWindowId.INPUT_MORE_PANEL, WakeBlockingWindowId.INPUT_ATTACHMENT_ADD_MENU, WakeBlockingWindowId.TITLE_MORE_MENU);
    private static final List<WeakReference<BaseInputView>> inputViewList = new ArrayList();
    private static final List<WeakReference<BaseInputView>> dependentInputViewList = new ArrayList();
    private static final List<WeakReference<ActionView>> actionViewList = new ArrayList();
    private static final C1165m<Pair<String, Bundle>> pendingPickEvents = new C1165m<>();
    private static final Set<InterfaceC5074l<Boolean, Y8.t>> wakeDialogVisibilityListeners = new LinkedHashSet();
    private static final List<String> fixedInputFragmentList = new ArrayList();
    private static final List<WeakReference<Activity>> activeActivities = new ArrayList();
    private static final List<String> markedActivities = new ArrayList();
    private static boolean isFixedMode = true;
    private static final Ua.M managerScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.b()));
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final Ua.M managerMainScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c()));

    /* renamed from: actionViewApi$delegate, reason: from kotlin metadata */
    private static final Y8.h actionViewApi = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.k0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return InputViewManager.K();
        }
    });
    private static WeakReference<BaseInputView> aiKeyActiveInput = new WeakReference<>(null);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/InputViewManager$WakeBlockingWindowId;", "", "<init>", "(Ljava/lang/String;I)V", "SELECT_TEXT_DIALOG", "MESSAGE_LONG_PRESS_MENU", "SOURCES_PANEL", "DISLIKE_REPORT_DIALOG", "DELETE_CONFIRM_DIALOG", "INPUT_MORE_PANEL", "INPUT_ATTACHMENT_ADD_MENU", "TITLE_MORE_MENU", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class WakeBlockingWindowId {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ WakeBlockingWindowId[] $VALUES;
        public static final WakeBlockingWindowId SELECT_TEXT_DIALOG = new WakeBlockingWindowId("SELECT_TEXT_DIALOG", 0);
        public static final WakeBlockingWindowId MESSAGE_LONG_PRESS_MENU = new WakeBlockingWindowId("MESSAGE_LONG_PRESS_MENU", 1);
        public static final WakeBlockingWindowId SOURCES_PANEL = new WakeBlockingWindowId("SOURCES_PANEL", 2);
        public static final WakeBlockingWindowId DISLIKE_REPORT_DIALOG = new WakeBlockingWindowId("DISLIKE_REPORT_DIALOG", 3);
        public static final WakeBlockingWindowId DELETE_CONFIRM_DIALOG = new WakeBlockingWindowId("DELETE_CONFIRM_DIALOG", 4);
        public static final WakeBlockingWindowId INPUT_MORE_PANEL = new WakeBlockingWindowId("INPUT_MORE_PANEL", 5);
        public static final WakeBlockingWindowId INPUT_ATTACHMENT_ADD_MENU = new WakeBlockingWindowId("INPUT_ATTACHMENT_ADD_MENU", 6);
        public static final WakeBlockingWindowId TITLE_MORE_MENU = new WakeBlockingWindowId("TITLE_MORE_MENU", 7);

        private static final /* synthetic */ WakeBlockingWindowId[] $values() {
            return new WakeBlockingWindowId[]{SELECT_TEXT_DIALOG, MESSAGE_LONG_PRESS_MENU, SOURCES_PANEL, DISLIKE_REPORT_DIALOG, DELETE_CONFIRM_DIALOG, INPUT_MORE_PANEL, INPUT_ATTACHMENT_ADD_MENU, TITLE_MORE_MENU};
        }

        static {
            WakeBlockingWindowId[] wakeBlockingWindowIdArr$values = $values();
            $VALUES = wakeBlockingWindowIdArr$values;
            $ENTRIES = kotlin.enums.a.a(wakeBlockingWindowIdArr$values);
        }

        private WakeBlockingWindowId(String str, int i10) {
        }

        public static InterfaceC4149a<WakeBlockingWindowId> getEntries() {
            return $ENTRIES;
        }

        public static WakeBlockingWindowId valueOf(String str) {
            return (WakeBlockingWindowId) Enum.valueOf(WakeBlockingWindowId.class, str);
        }

        public static WakeBlockingWindowId[] values() {
            return (WakeBlockingWindowId[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/InputViewManager$a;", "", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "candidateInputView", "", "Lcom/stepos/ailauncher/chat/manager/InputViewManager$WakeBlockingWindowId;", "dismissedWindows", "<init>", "(Lcom/stepos/ailauncher/chat/view/BaseInputView;Ljava/util/Set;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "getCandidateInputView", "()Lcom/stepos/ailauncher/chat/view/BaseInputView;", "Ljava/util/Set;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Set;", Const.INTENT_KEY_APIKEY, "()Z", "dismissed", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.manager.InputViewManager$a, reason: from toString */
    public static final /* data */ class WakeUiPreparationResult {
        private final BaseInputView candidateInputView;
        private final Set<WakeBlockingWindowId> dismissedWindows;

        /* JADX WARN: Multi-variable type inference failed */
        public WakeUiPreparationResult(BaseInputView baseInputView, Set<? extends WakeBlockingWindowId> dismissedWindows) {
            kotlin.jvm.internal.p.i(dismissedWindows, "dismissedWindows");
            this.candidateInputView = baseInputView;
            this.dismissedWindows = dismissedWindows;
        }

        public final boolean a() {
            return !this.dismissedWindows.isEmpty();
        }

        public final Set<WakeBlockingWindowId> b() {
            return this.dismissedWindows;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WakeUiPreparationResult)) {
                return false;
            }
            WakeUiPreparationResult wakeUiPreparationResult = (WakeUiPreparationResult) other;
            return kotlin.jvm.internal.p.d(this.candidateInputView, wakeUiPreparationResult.candidateInputView) && kotlin.jvm.internal.p.d(this.dismissedWindows, wakeUiPreparationResult.dismissedWindows);
        }

        public int hashCode() {
            BaseInputView baseInputView = this.candidateInputView;
            return ((baseInputView == null ? 0 : baseInputView.hashCode()) * 31) + this.dismissedWindows.hashCode();
        }

        public String toString() {
            return "WakeUiPreparationResult(candidateInputView=" + this.candidateInputView + ", dismissedWindows=" + this.dismissedWindows + ")";
        }
    }

    @Metadata(d1 = {"\u0000k\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001f\u0010\u001dJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J+\u0010-\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u0010\u0014¨\u00060"}, d2 = {"com/stepos/ailauncher/chat/manager/InputViewManager$b", "Ly4/b;", "Ly4/b$f;", "listener", "LY8/t;", "setOnSendMessageListener", "(Ly4/b$f;)V", "Ly4/b$d;", "setOnImageClickListener", "(Ly4/b$d;)V", "Ly4/b$c;", "setOnFileClickListener", "(Ly4/b$c;)V", "Ly4/b$b;", "setOnCancelListener", "(Ly4/b$b;)V", "Ly4/b$a;", "setOnBtnPlusClickListener", "(Ly4/b$a;)V", Const.INTENT_KEY_UMID, "()V", "e", "", "isReplying", "setReplyingStatus", "(Z)V", "", "text", "setInputTxt", "(Ljava/lang/String;)V", "message", "f", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Lcom/stepos/agentframework/AgentUIConfig;", "agentUIConfig", "c", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/stepos/agentframework/AgentUIConfig;)V", "destroy", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC5940b {
        public static final Y8.t n(SessionHandler sessionHandler, InterfaceC5940b forEachDependentInputView) {
            kotlin.jvm.internal.p.i(forEachDependentInputView, "$this$forEachDependentInputView");
            forEachDependentInputView.b(sessionHandler);
            return Y8.t.f7040a;
        }

        public static final Y8.t o(InterfaceC5940b forEachDependentInputView) {
            kotlin.jvm.internal.p.i(forEachDependentInputView, "$this$forEachDependentInputView");
            forEachDependentInputView.d();
            return Y8.t.f7040a;
        }

        public static final Y8.t p(InterfaceC5940b forEachDependentInputView) {
            kotlin.jvm.internal.p.i(forEachDependentInputView, "$this$forEachDependentInputView");
            forEachDependentInputView.destroy();
            return Y8.t.f7040a;
        }

        public static final Y8.t q(String str, InterfaceC5940b forEachDependentInputView) {
            kotlin.jvm.internal.p.i(forEachDependentInputView, "$this$forEachDependentInputView");
            forEachDependentInputView.f(str);
            return Y8.t.f7040a;
        }

        public static final Y8.t r(InterfaceC5940b forEachDependentInputView) {
            kotlin.jvm.internal.p.i(forEachDependentInputView, "$this$forEachDependentInputView");
            forEachDependentInputView.e();
            return Y8.t.f7040a;
        }

        public static final Y8.t s(String str, InterfaceC5940b forEachDependentInputView) {
            kotlin.jvm.internal.p.i(forEachDependentInputView, "$this$forEachDependentInputView");
            forEachDependentInputView.setInputTxt(str);
            return Y8.t.f7040a;
        }

        public static final Y8.t t(boolean z10, InterfaceC5940b forEachDependentInputView) {
            kotlin.jvm.internal.p.i(forEachDependentInputView, "$this$forEachDependentInputView");
            forEachDependentInputView.setReplyingStatus(z10);
            return Y8.t.f7040a;
        }

        @Override // y4.InterfaceC5940b, y4.InterfaceC5939a
        public /* bridge */ <T extends View> T a(int i10) {
            return (T) super.a(i10);
        }

        @Override // y4.InterfaceC5939a
        public void b(final SessionHandler handler) {
            InputViewManager.INSTANCE.u0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.H0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InputViewManager.b.n(handler, (InterfaceC5940b) obj);
                }
            });
        }

        @Override // y4.InterfaceC5939a
        public void c(Context context, AttributeSet attrs, AgentUIConfig agentUIConfig) {
            kotlin.jvm.internal.p.i(context, "context");
        }

        @Override // y4.InterfaceC5940b
        public void d() {
            InputViewManager.INSTANCE.u0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.F0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InputViewManager.b.o((InterfaceC5940b) obj);
                }
            });
        }

        @Override // y4.InterfaceC5939a
        public void destroy() {
            InputViewManager.INSTANCE.u0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.E0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InputViewManager.b.p((InterfaceC5940b) obj);
                }
            });
        }

        @Override // y4.InterfaceC5940b
        public void e() {
            InputViewManager.INSTANCE.u0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.I0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InputViewManager.b.r((InterfaceC5940b) obj);
                }
            });
        }

        @Override // y4.InterfaceC5940b
        public void f(final String message) {
            InputViewManager.INSTANCE.u0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.D0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InputViewManager.b.q(message, (InterfaceC5940b) obj);
                }
            });
        }

        @Override // y4.InterfaceC5939a
        public View getView() {
            BaseInputView baseInputView;
            Object obj;
            View view;
            List list = InputViewManager.dependentInputViewList;
            Context context = null;
            if (list.isEmpty()) {
                list = null;
            }
            if (list != null && (obj = (WeakReference) Z8.F.C0(list)) != null) {
                InterfaceC5940b interfaceC5940b = obj instanceof InterfaceC5940b ? (InterfaceC5940b) obj : null;
                if (interfaceC5940b != null && (view = interfaceC5940b.getView()) != null) {
                    return view;
                }
            }
            WeakReference weakReference = InputViewManager.agentInputView;
            if (weakReference != null && (baseInputView = (BaseInputView) weakReference.get()) != null) {
                context = baseInputView.getContext();
            }
            return new View(context);
        }

        @Override // y4.InterfaceC5940b
        public /* bridge */ void setInputMoreBtnEnable(boolean z10) {
            super.setInputMoreBtnEnable(z10);
        }

        @Override // y4.InterfaceC5940b
        public void setInputTxt(final String text) {
            kotlin.jvm.internal.p.i(text, "text");
            InputViewManager.INSTANCE.u0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.C0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InputViewManager.b.s(text, (InterfaceC5940b) obj);
                }
            });
        }

        @Override // y4.InterfaceC5940b
        public void setOnBtnPlusClickListener(InterfaceC5940b.a listener) {
        }

        @Override // y4.InterfaceC5940b
        public void setOnCancelListener(InterfaceC5940b.InterfaceC0556b listener) {
        }

        @Override // y4.InterfaceC5940b
        public void setOnFileClickListener(InterfaceC5940b.c listener) {
        }

        @Override // y4.InterfaceC5940b
        public void setOnImageClickListener(InterfaceC5940b.d listener) {
        }

        @Override // y4.InterfaceC5940b
        public /* bridge */ void setOnLoadingBubbleListener(InterfaceC5940b.e eVar) {
            super.setOnLoadingBubbleListener(eVar);
        }

        @Override // y4.InterfaceC5940b
        public void setOnSendMessageListener(InterfaceC5940b.f listener) {
        }

        @Override // y4.InterfaceC5940b
        public void setReplyingStatus(final boolean isReplying) {
            InputViewManager.INSTANCE.u0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.G0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InputViewManager.b.t(isReplying, (InterfaceC5940b) obj);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\n¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/chat/manager/InputViewManager$c", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "p0", "Landroid/os/Bundle;", "p1", "LY8/t;", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityPaused", "(Landroid/app/Activity;)V", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "onActivityDestroyed", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final boolean d(Activity activity, WeakReference it) {
            kotlin.jvm.internal.p.i(it, "it");
            return it.get() == null || it.get() == activity;
        }

        public static final boolean e(Activity activity, WeakReference it) {
            kotlin.jvm.internal.p.i(it, "it");
            return it.get() == null || it.get() == activity;
        }

        public static final boolean f(Activity activity, WeakReference it) {
            kotlin.jvm.internal.p.i(it, "it");
            return it.get() == null || it.get() == activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity p02, Bundle p12) {
            kotlin.jvm.internal.p.i(p02, "p0");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(final Activity p02) {
            kotlin.jvm.internal.p.i(p02, "p0");
            Z8.A.L(InputViewManager.activeActivities, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.J0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(InputViewManager.c.d(p02, (WeakReference) obj));
                }
            });
            WeakReference weakReference = InputViewManager.currentActivity;
            if ((weakReference != null ? (Activity) weakReference.get() : null) == p02) {
                InputViewManager.currentActivity = null;
            }
            if (kotlin.jvm.internal.p.d(p02.getClass().getSimpleName(), InputViewManager.CHAT_MAIN_ACTIVITY_NAME)) {
                InputViewManager.chatMainActivityResumed = false;
            }
            if (InputViewManager.activeActivities.isEmpty() && InputViewManager.isFloatViewAdded) {
                InputViewManager.INSTANCE.D0();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity p02) {
            kotlin.jvm.internal.p.i(p02, "p0");
            if (kotlin.jvm.internal.p.d(p02.getClass().getSimpleName(), InputViewManager.CHAT_MAIN_ACTIVITY_NAME)) {
                InputViewManager.chatMainActivityResumed = false;
                InputViewManager.pendingAgentVoiceRearmAfterChatLeave = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity p02) {
            kotlin.jvm.internal.p.i(p02, "p0");
            if (kotlin.jvm.internal.p.d(p02.getClass().getSimpleName(), InputViewManager.CHAT_MAIN_ACTIVITY_NAME)) {
                InputViewManager.chatMainActivityResumed = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity p02, Bundle p12) {
            kotlin.jvm.internal.p.i(p02, "p0");
            kotlin.jvm.internal.p.i(p12, "p1");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(final Activity p02) {
            kotlin.jvm.internal.p.i(p02, "p0");
            Z8.A.L(InputViewManager.activeActivities, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.K0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(InputViewManager.c.e(p02, (WeakReference) obj));
                }
            });
            InputViewManager.activeActivities.add(new WeakReference(p02));
            InputViewManager.currentActivity = new WeakReference(p02);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(final Activity p02) {
            kotlin.jvm.internal.p.i(p02, "p0");
            Z8.A.L(InputViewManager.activeActivities, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.L0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(InputViewManager.c.f(p02, (WeakReference) obj));
                }
            });
            WeakReference weakReference = InputViewManager.currentActivity;
            if ((weakReference != null ? (Activity) weakReference.get() : null) == p02) {
                InputViewManager.currentActivity = null;
            }
            if (kotlin.jvm.internal.p.d(p02.getClass().getSimpleName(), InputViewManager.CHAT_MAIN_ACTIVITY_NAME)) {
                InputViewManager.INSTANCE.c0("ChatMainActivity.onStop");
            }
        }
    }

    public static final Activity A0(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return null;
        }
        return activity;
    }

    public static final void E0() {
        INSTANCE.D0();
    }

    public static final void F0(Context context) {
        INSTANCE.b1(context);
    }

    public static final Activity H0() {
        return INSTANCE.z0();
    }

    public static final ActionViewApi K() {
        return (ActionViewApi) RetrofitProvider.newRetrofit$default("https://biz-gw.zyql.com/", null, false, false, false, 30, null).c(ActionViewApi.class);
    }

    public static final boolean O(WeakReference it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.get() == null;
    }

    public static final void P(ActionView actionView, ActionBarConfig actionBarConfig2) {
        actionView.e(actionBarConfig2);
    }

    public static /* synthetic */ void R(InputViewManager inputViewManager, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 800;
        }
        inputViewManager.Q(j10);
    }

    public static final boolean T(ActionView actionView, WeakReference it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.get() == null || kotlin.jvm.internal.p.d(it.get(), actionView);
    }

    public static final boolean U0(WeakReference it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.get() == null;
    }

    public static final boolean V(WeakReference it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.get() == null;
    }

    public static final boolean W0(BaseInputView baseInputView, WeakReference it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.get(), baseInputView);
    }

    public static final boolean Y(WeakReference it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.get() == null;
    }

    public static final void c1(Context context) {
        InputViewManager inputViewManager = INSTANCE;
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        inputViewManager.b1(applicationContext);
    }

    public static /* synthetic */ void d0(InputViewManager inputViewManager, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        inputViewManager.c0(str);
    }

    public static final boolean d1(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 4 || isFixedMode) {
            return false;
        }
        INSTANCE.D0();
        return true;
    }

    public static /* synthetic */ void f1(InputViewManager inputViewManager, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        inputViewManager.e1(str);
    }

    public static final boolean g1(WeakReference it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.get() == null;
    }

    public static final void i0() {
        INSTANCE.h0();
    }

    public static final boolean k1(BaseInputView baseInputView, WeakReference it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.get(), baseInputView);
    }

    public static final void l0() {
        INSTANCE.k0();
    }

    public static final boolean n0(WeakReference it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.get() == null;
    }

    public final BaseInputView B0() {
        WeakReference weakReference = (WeakReference) Z8.F.E0(inputViewList);
        if (weakReference != null) {
            return (BaseInputView) weakReference.get();
        }
        return null;
    }

    public final boolean C0() {
        return pickResultDispatchSuspended;
    }

    public final void D0() {
        if (!kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.manager.l0
                @Override // java.lang.Runnable
                public final void run() {
                    InputViewManager.E0();
                }
            });
            return;
        }
        if (isRemovingFloatView) {
            return;
        }
        if (isFloatViewAdded || floatChatView != null) {
            isRemovingFloatView = true;
            pendingShowAfterRemove = false;
            ChatView chatView = floatChatView;
            try {
                if (chatView != null) {
                    try {
                        INSTANCE.g0(chatView);
                        WindowManager windowManager2 = windowManager;
                        if (windowManager2 != null) {
                            windowManager2.removeViewImmediate(chatView);
                        }
                    } catch (Exception e10) {
                        Log.e(TAG, "hideFloatInputView: 移除悬浮窗失败", e10);
                        floatChatView = null;
                        isFloatViewAdded = false;
                        isRemovingFloatView = false;
                        if (pendingShowAfterRemove) {
                            pendingShowAfterRemove = false;
                            final Context context = appContext;
                            if (context != null) {
                                mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.manager.m0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        InputViewManager.F0(context);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                Log.d(TAG, "hideFloatInputView: 悬浮 InputView 已移除");
                floatChatView = null;
                isFloatViewAdded = false;
                isRemovingFloatView = false;
                if (pendingShowAfterRemove) {
                    pendingShowAfterRemove = false;
                    final Context context2 = appContext;
                    if (context2 != null) {
                        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.manager.m0
                            @Override // java.lang.Runnable
                            public final void run() {
                                InputViewManager.F0(context2);
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                floatChatView = null;
                isFloatViewAdded = false;
                isRemovingFloatView = false;
                if (pendingShowAfterRemove) {
                    pendingShowAfterRemove = false;
                    final Context context3 = appContext;
                    if (context3 != null) {
                        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.manager.m0
                            @Override // java.lang.Runnable
                            public final void run() {
                                InputViewManager.F0(context3);
                            }
                        });
                    }
                }
                throw th;
            }
        }
    }

    public final void G0(Application application) {
        kotlin.jvm.internal.p.i(application, "application");
        appContext = application.getApplicationContext();
        Object systemService = application.getSystemService("window");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        windowManager = (WindowManager) systemService;
        R0();
        C3202f.INSTANCE.g(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.s0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return InputViewManager.H0();
            }
        });
        List<String> list = markedActivities;
        list.add("MainActivity");
        list.add("HomeActivity");
        application.registerActivityLifecycleCallbacks(new c());
    }

    public final boolean I0(BaseInputView view, String sessionId) {
        AgentSession.AgentConversation agentConversationR1;
        SessionHandler sessionHandler = view.getSessionHandler();
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) {
            return false;
        }
        return kotlin.jvm.internal.p.d(sessionId, agentConversationR1.B()) || kotlin.jvm.internal.p.d(sessionId, agentConversationR1.getSessionId()) || kotlin.jvm.internal.p.d(sessionId, agentConversationR1.getTempSessionId());
    }

    public final boolean J0(BaseInputView inputView) {
        kotlin.jvm.internal.p.i(inputView, "inputView");
        WeakReference<BaseInputView> weakReference = agentInputView;
        return (weakReference != null ? weakReference.get() : null) == inputView;
    }

    public final boolean K0(BaseInputView inputView) {
        BaseInputView baseInputView;
        kotlin.jvm.internal.p.i(inputView, "inputView");
        WeakReference<BaseInputView> weakReference = agentInputView;
        if (weakReference == null || (baseInputView = weakReference.get()) == null || inputView != baseInputView) {
            return false;
        }
        long j10 = agentVoiceRearmUntilUptimeMs;
        return j10 != 0 && SystemClock.uptimeMillis() < j10;
    }

    public final void L(BaseInputView inputView) {
        kotlin.jvm.internal.p.i(inputView, "inputView");
        List<WeakReference<BaseInputView>> list = dependentInputViewList;
        list.add(new WeakReference<>(inputView));
        if (list.isEmpty()) {
            list = null;
        }
        if (list != null) {
            List<WeakReference<BaseInputView>> list2 = list;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                list = null;
            } else {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (((WeakReference) it.next()).get() != null) {
                        break;
                    }
                }
                list = null;
            }
            if (list != null) {
                if ((agentInputView != null ? list : null) != null) {
                    INSTANCE.U();
                }
            }
        }
    }

    public final boolean L0(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        return s0(sessionId) != null;
    }

    public final void M(InterfaceC5074l<? super Boolean, Y8.t> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        wakeDialogVisibilityListeners.add(listener);
        listener.invoke(Boolean.valueOf(y0() != null));
    }

    public final boolean M0(String action) {
        int iHashCode = action.hashCode();
        return iHashCode != -1096657407 ? iHashCode != -1096652660 ? iHashCode == -542308068 && action.equals("com.stepos.voiceassistant.ACTION.FILE_PICK_CANCEL") : action.equals("com.stepos.voiceassistant.ACTION.PICK_IMG") : action.equals("com.stepos.voiceassistant.ACTION.PICK_DOC");
    }

    public final void N() {
        final ActionBarConfig actionBarConfig2 = actionBarConfig;
        if (actionBarConfig2 == null) {
            return;
        }
        List<WeakReference<ActionView>> list = actionViewList;
        Z8.A.L(list, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.z0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InputViewManager.O((WeakReference) obj));
            }
        });
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            final ActionView actionView = (ActionView) ((WeakReference) it.next()).get();
            if (actionView != null) {
                actionView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.manager.A0
                    @Override // java.lang.Runnable
                    public final void run() {
                        InputViewManager.P(actionView, actionBarConfig2);
                    }
                });
            }
        }
    }

    public final void N0(BaseInputView inputView) {
        kotlin.jvm.internal.p.i(inputView, "inputView");
        agentInputView = new WeakReference<>(inputView);
    }

    public final void O0(BaseInputView view) {
        kotlin.jvm.internal.p.i(view, "view");
        aiKeyActiveInput = new WeakReference<>(view);
    }

    public final void P0(BaseInputView inputView) {
        kotlin.jvm.internal.p.i(inputView, "inputView");
        List<WeakReference<BaseInputView>> list = inputViewList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (kotlin.jvm.internal.p.d(((WeakReference) it.next()).get(), inputView)) {
                    Log.d(TAG, "markInputView: inputView already exists, skip adding");
                    return;
                }
            }
        }
        List<WeakReference<BaseInputView>> list2 = inputViewList;
        list2.add(new WeakReference<>(inputView));
        Log.d(TAG, "markInputView: inputView added " + inputView + ", total count: " + list2.size());
    }

    public final void Q(long durationMs) {
        agentVoiceRearmUntilUptimeMs = SystemClock.uptimeMillis() + durationMs;
        Log.d(TAG, "armAgentVoiceRearm: voice blocked for " + durationMs + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
    }

    public final void Q0(boolean isShowing) {
        Iterator it = Z8.F.m1(wakeDialogVisibilityListeners).iterator();
        while (it.hasNext()) {
            ((InterfaceC5074l) it.next()).invoke(Boolean.valueOf(isShowing));
        }
    }

    public final void R0() {
        C1060i.d(managerMainScope, null, null, new InputViewManager$observePickFileEvents$1(null), 3, null);
    }

    public final void S(final ActionView actionView) {
        if (actionView == null) {
            return;
        }
        List<WeakReference<ActionView>> list = actionViewList;
        Z8.A.L(list, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.u0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InputViewManager.T(actionView, (WeakReference) obj));
            }
        });
        list.add(new WeakReference<>(actionView));
        N();
    }

    public final void S0() {
        com.stepos.ailauncher.chat.wake.Q.INSTANCE.h("InputViewManager.onMinusOneSwipedAway");
    }

    public final WakeUiPreparationResult T0() {
        BaseInputView baseInputView;
        boolean z10;
        if (!kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("InputViewManager.prepareForWake must run on main thread");
        }
        f0();
        List<WeakReference<BaseInputView>> list = inputViewList;
        Z8.A.L(list, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.o0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InputViewManager.U0((WeakReference) obj));
            }
        });
        List listV = Z8.B.V(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = listV.iterator();
        while (it.hasNext()) {
            BaseInputView baseInputView2 = (BaseInputView) ((WeakReference) it.next()).get();
            if (baseInputView2 != null) {
                arrayList.add(baseInputView2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((BaseInputView) obj).d8()) {
                arrayList2.add(obj);
            }
        }
        BaseInputView baseInputView3 = (BaseInputView) Z8.F.s0(arrayList2);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = arrayList2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                baseInputView = null;
                break;
            }
            baseInputView = (BaseInputView) it2.next();
            View viewJd = baseInputView.jd();
            Set<WakeBlockingWindowId> set = WAKE_BLOCKING_WINDOW_WHITELIST;
            Set<WakeBlockingWindowId> setP6 = baseInputView.p6(set.contains(WakeBlockingWindowId.INPUT_MORE_PANEL), set.contains(WakeBlockingWindowId.INPUT_ATTACHMENT_ADD_MENU));
            boolean z11 = true;
            if (setP6.isEmpty()) {
                z10 = false;
            } else {
                Z8.A.E(linkedHashSet, setP6);
                z10 = true;
            }
            WakeBlockingWindowId wakeBlockingWindowId = WakeBlockingWindowId.SELECT_TEXT_DIALOG;
            if (set.contains(wakeBlockingWindowId) && com.stepos.agentframework.chatui.dialog.N.INSTANCE.a(viewJd)) {
                linkedHashSet.add(wakeBlockingWindowId);
                z10 = true;
            }
            WakeBlockingWindowId wakeBlockingWindowId2 = WakeBlockingWindowId.MESSAGE_LONG_PRESS_MENU;
            if (set.contains(wakeBlockingWindowId2) && com.stepos.agentframework.chatui.task.view.B.h(viewJd)) {
                linkedHashSet.add(wakeBlockingWindowId2);
                z10 = true;
            }
            WakeBlockingWindowId wakeBlockingWindowId3 = WakeBlockingWindowId.SOURCES_PANEL;
            if (set.contains(wakeBlockingWindowId3) && C2069d0.INSTANCE.b(viewJd)) {
                linkedHashSet.add(wakeBlockingWindowId3);
                z10 = true;
            }
            WakeBlockingWindowId wakeBlockingWindowId4 = WakeBlockingWindowId.DISLIKE_REPORT_DIALOG;
            if (set.contains(wakeBlockingWindowId4) && DislikeReportDialog.INSTANCE.b(viewJd)) {
                linkedHashSet.add(wakeBlockingWindowId4);
                z10 = true;
            }
            WakeBlockingWindowId wakeBlockingWindowId5 = WakeBlockingWindowId.DELETE_CONFIRM_DIALOG;
            if (set.contains(wakeBlockingWindowId5) && DialogC1998i.INSTANCE.a(viewJd)) {
                linkedHashSet.add(wakeBlockingWindowId5);
                z10 = true;
            }
            WakeBlockingWindowId wakeBlockingWindowId6 = WakeBlockingWindowId.TITLE_MORE_MENU;
            if (set.contains(wakeBlockingWindowId6) && C2963t.INSTANCE.f(viewJd)) {
                linkedHashSet.add(wakeBlockingWindowId6);
            } else {
                z11 = z10;
            }
            if (z11) {
                break;
            }
        }
        if (baseInputView != null) {
            baseInputView3 = baseInputView;
        }
        if (!linkedHashSet.isEmpty() && baseInputView3 != null) {
            preparedWakeInputView = new WeakReference<>(baseInputView3);
            preparedWakeInputUntilUptimeMs = SystemClock.uptimeMillis() + 500;
            Log.d(TAG, "prepareForWake: dismissed=" + Z8.F.A0(linkedHashSet, null, null, null, 0, null, null, 63, null) + " candidate=" + baseInputView3.getClass().getSimpleName());
        } else if (preparedWakeInputUntilUptimeMs <= SystemClock.uptimeMillis()) {
            f0();
        }
        return new WakeUiPreparationResult(baseInputView3, linkedHashSet);
    }

    public final void U() {
        BaseInputView baseInputView;
        BaseInputView baseInputView2;
        BaseInputView baseInputView3;
        BaseInputView baseInputView4;
        BaseInputView baseInputView5;
        BaseInputView baseInputView6;
        BaseInputView baseInputView7;
        List<WeakReference<BaseInputView>> list = dependentInputViewList;
        Z8.A.L(list, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.y0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InputViewManager.V((WeakReference) obj));
            }
        });
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Object obj = ((WeakReference) it.next()).get();
            InterfaceC5940b interfaceC5940b = obj instanceof InterfaceC5940b ? (InterfaceC5940b) obj : null;
            if (interfaceC5940b != null) {
                WeakReference<BaseInputView> weakReference = agentInputView;
                interfaceC5940b.setOnCancelListener((weakReference == null || (baseInputView7 = weakReference.get()) == null) ? null : baseInputView7.getCancelListener());
                WeakReference<BaseInputView> weakReference2 = agentInputView;
                if (weakReference2 != null && (baseInputView6 = weakReference2.get()) != null) {
                    baseInputView6.getImageClickListener();
                }
                interfaceC5940b.setOnImageClickListener(null);
                WeakReference<BaseInputView> weakReference3 = agentInputView;
                if (weakReference3 != null && (baseInputView5 = weakReference3.get()) != null) {
                    baseInputView5.getFileClickListener();
                }
                interfaceC5940b.setOnFileClickListener(null);
                WeakReference<BaseInputView> weakReference4 = agentInputView;
                interfaceC5940b.setOnSendMessageListener((weakReference4 == null || (baseInputView4 = weakReference4.get()) == null) ? null : baseInputView4.getSendMessageListener());
                WeakReference<BaseInputView> weakReference5 = agentInputView;
                if (weakReference5 != null && (baseInputView3 = weakReference5.get()) != null) {
                    baseInputView3.getBtnPlusClickListener();
                }
                interfaceC5940b.setOnBtnPlusClickListener(null);
            }
        }
        WeakReference<BaseInputView> weakReference6 = agentInputView;
        if (weakReference6 != null && (baseInputView2 = weakReference6.get()) != null) {
            baseInputView2.setSubscribeInputView(new b());
        }
        WeakReference<BaseInputView> weakReference7 = agentInputView;
        if (weakReference7 == null || (baseInputView = weakReference7.get()) == null) {
            return;
        }
        baseInputView.setReplyingStatus(baseInputView.getIsSysReplying());
    }

    public final void V0(final BaseInputView inputView) {
        kotlin.jvm.internal.p.i(inputView, "inputView");
        Z8.A.L(dependentInputViewList, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.B0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InputViewManager.W0(inputView, (WeakReference) obj));
            }
        });
    }

    public final int W() {
        return !isFixedMode ? 262440 : 296;
    }

    public final void X(String stopReason) {
        kotlin.jvm.internal.p.i(stopReason, "stopReason");
        List<WeakReference<BaseInputView>> list = inputViewList;
        Z8.A.L(list, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.r0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InputViewManager.Y((WeakReference) obj));
            }
        });
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            BaseInputView baseInputView = (BaseInputView) ((WeakReference) it.next()).get();
            if (baseInputView != null) {
                baseInputView.x5(stopReason);
            }
        }
    }

    public final void X0(InterfaceC5074l<? super Boolean, Y8.t> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        wakeDialogVisibilityListeners.remove(listener);
    }

    public final void Y0(BaseInputView inputView) {
        kotlin.jvm.internal.p.i(inputView, "inputView");
        if (!pickResultDispatchSuspended) {
            return;
        }
        pickResultDispatchSuspended = false;
        pickInitiator = new WeakReference<>(inputView);
        C1165m<Pair<String, Bundle>> c1165m = pendingPickEvents;
        if (c1165m.isEmpty()) {
            Log.d(TAG, "resumePickResultDispatch: no pending event, target=" + inputView);
            return;
        }
        Log.i(TAG, "resumePickResultDispatch: flush " + c1165m.size() + " event(s), target=" + inputView);
        while (true) {
            C1165m<Pair<String, Bundle>> c1165m2 = pendingPickEvents;
            if (c1165m2.isEmpty()) {
                return;
            } else {
                j0(inputView, c1165m2.removeFirst());
            }
        }
    }

    public final boolean Z(Context context) {
        if (Settings.canDrawOverlays(context)) {
            return true;
        }
        Log.w(TAG, "checkOverlayPermission: 缺少 SYSTEM_ALERT_WINDOW 权限，无法显示悬浮 InputView。请在「设置 → 应用 → 特殊应用权限 → 悬浮窗」中为本应用开启权限。");
        return false;
    }

    public final void Z0(DialogC3116e0 dialog) {
        boolean z10 = currentWakeDialog != null;
        currentWakeDialog = dialog;
        boolean z11 = dialog != null;
        if (z10 != z11) {
            Q0(z11);
        }
    }

    public final void a0() {
        agentInputView = new WeakReference<>(null);
    }

    public final void a1(BaseInputView inputView) {
        kotlin.jvm.internal.p.i(inputView, "inputView");
        pickInitiator = new WeakReference<>(inputView);
        pickResultDispatchSuspended = false;
        C1165m<Pair<String, Bundle>> c1165m = pendingPickEvents;
        if (c1165m.isEmpty()) {
            return;
        }
        Log.w(TAG, "setPickInitiator: clear " + c1165m.size() + " stale pending event(s)");
        c1165m.clear();
    }

    public final void b0(BaseInputView view) {
        kotlin.jvm.internal.p.i(view, "view");
        WeakReference<BaseInputView> weakReference = agentInputView;
        if ((weakReference != null ? weakReference.get() : null) == view) {
            agentInputView = new WeakReference<>(null);
        }
    }

    public final void b1(final Context context) {
        Activity activity;
        kotlin.jvm.internal.p.i(context, "context");
        if (!kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.manager.p0
                @Override // java.lang.Runnable
                public final void run() {
                    InputViewManager.c1(context);
                }
            });
            return;
        }
        if (isRemovingFloatView) {
            pendingShowAfterRemove = true;
            Log.d(TAG, "showFloatInputView: remove in progress, defer show");
            return;
        }
        if (!isFloatViewAdded && Z(context)) {
            Context applicationContext = appContext;
            if (applicationContext == null) {
                applicationContext = context.getApplicationContext();
            }
            Context context2 = applicationContext;
            kotlin.jvm.internal.p.f(context2);
            ChatView chatView = new ChatView(context2, null, 0, 6, null);
            floatChatView = chatView;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 2038;
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.gravity = 80;
            layoutParams.format = -3;
            layoutParams.flags = INSTANCE.W();
            chatView.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.ailauncher.chat.manager.q0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return InputViewManager.d1(view, motionEvent);
                }
            });
            try {
                WindowManager windowManager2 = windowManager;
                if (windowManager2 != null) {
                    windowManager2.addView(chatView, layoutParams);
                }
                WindowManager windowManager3 = windowManager;
                kotlin.jvm.internal.p.f(windowManager3);
                chatView.setWindowManager(windowManager3);
                WeakReference<Activity> weakReference = currentActivity;
                if (weakReference != null && (activity = weakReference.get()) != null) {
                    chatView.setActivity(activity);
                }
                isFloatViewAdded = true;
                Log.d(TAG, "showFloatInputView: 悬浮 InputView 已添加，isFixedMode=" + isFixedMode);
            } catch (Exception e10) {
                Log.e(TAG, "showFloatInputView: 添加悬浮窗失败", e10);
                floatChatView = null;
                isFloatViewAdded = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c0(java.lang.String r5) {
        /*
            r4 = this;
            r4 = 0
            com.stepos.ailauncher.chat.manager.InputViewManager.pendingAgentVoiceRearmAfterChatLeave = r4
            long r0 = com.stepos.ailauncher.chat.manager.InputViewManager.agentVoiceRearmUntilUptimeMs
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto Lc
            return
        Lc:
            com.stepos.ailauncher.chat.manager.InputViewManager.agentVoiceRearmUntilUptimeMs = r2
            if (r5 == 0) goto L28
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = " ("
            r4.append(r0)
            r4.append(r5)
            java.lang.String r5 = ")"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            if (r4 != 0) goto L2a
        L28:
            java.lang.String r4 = ""
        L2a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "clearAgentVoiceRearm: agent voice input ready"
            r5.append(r0)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "InputViewManager"
            android.util.Log.d(r5, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.InputViewManager.c0(java.lang.String):void");
    }

    public final void e0() {
        aiKeyActiveInput = new WeakReference<>(null);
    }

    public final void e1(String pressToTalkCancelReason) {
        List<WeakReference<BaseInputView>> list = inputViewList;
        Z8.A.L(list, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.t0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InputViewManager.g1((WeakReference) obj));
            }
        });
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            BaseInputView baseInputView = (BaseInputView) ((WeakReference) it.next()).get();
            if (baseInputView != null) {
                baseInputView.yc(pressToTalkCancelReason);
            }
        }
    }

    public final void f0() {
        preparedWakeInputView = null;
        preparedWakeInputUntilUptimeMs = 0L;
    }

    public final void g0(View view) {
        WindowManager windowManager2;
        view.setOnTouchListener(null);
        view.setEnabled(false);
        view.setClickable(false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        layoutParams2.flags |= 24;
        try {
            if (view.isAttachedToWindow() && (windowManager2 = windowManager) != null) {
                windowManager2.updateViewLayout(view, layoutParams2);
            }
            Log.d(TAG, "disableFloatWindowInput: disabled touch/focus before remove");
        } catch (Exception e10) {
            Log.w(TAG, "disableFloatWindowInput: update flags failed before remove", e10);
        }
    }

    public final void h0() {
        if (!kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.manager.n0
                @Override // java.lang.Runnable
                public final void run() {
                    InputViewManager.i0();
                }
            });
            return;
        }
        if (isRemovingFloatView) {
            Log.d(TAG, "disableFocus: skip while removing float window");
            return;
        }
        ChatView chatView = floatChatView;
        if (chatView != null) {
            try {
                ViewGroup.LayoutParams layoutParams = chatView.getLayoutParams();
                WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
                if (layoutParams2 == null) {
                    return;
                }
                layoutParams2.flags |= 8;
                WindowManager windowManager2 = windowManager;
                if (windowManager2 != null) {
                    windowManager2.updateViewLayout(chatView, layoutParams2);
                }
                Log.d(TAG, "disableFocus: 悬浮窗焦点已禁用");
            } catch (Exception e10) {
                Log.e(TAG, "disableFocus: 更新悬浮窗焦点失败", e10);
            }
        }
    }

    public final void h1(BaseInputView inputView) {
        kotlin.jvm.internal.p.i(inputView, "inputView");
        WeakReference<BaseInputView> weakReference = pickInitiator;
        if ((weakReference != null ? weakReference.get() : null) != inputView) {
            return;
        }
        pickResultDispatchSuspended = true;
        Log.i(TAG, "suspendPickResultDispatch: inputView=" + inputView);
    }

    public final void i1() {
        if (pendingAgentVoiceRearmAfterChatLeave) {
            pendingAgentVoiceRearmAfterChatLeave = false;
            R(this, 0L, 1, null);
        }
    }

    public final void j0(BaseInputView target, Pair<String, Bundle> event) {
        Log.d(TAG, "dispatchPickEvent: action=" + ((Object) event.e()) + ", target=" + target);
        target.R6(event.e(), event.f());
        String strE = event.e();
        if (kotlin.jvm.internal.p.d(strE, "com.stepos.voiceassistant.ACTION.PICK_DOC") || kotlin.jvm.internal.p.d(strE, "com.stepos.voiceassistant.ACTION.FILE_PICK_CANCEL")) {
            pickInitiator = null;
        }
    }

    public final void j1(final BaseInputView inputView) {
        kotlin.jvm.internal.p.i(inputView, "inputView");
        List<WeakReference<BaseInputView>> list = inputViewList;
        Z8.A.L(list, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.w0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InputViewManager.k1(inputView, (WeakReference) obj));
            }
        });
        Log.d(TAG, "remove mark input view: " + inputView + Const.STR_MART_COMMA + list.size());
    }

    public final void k0() {
        if (!kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.manager.x0
                @Override // java.lang.Runnable
                public final void run() {
                    InputViewManager.l0();
                }
            });
            return;
        }
        if (isRemovingFloatView) {
            Log.d(TAG, "enableFocus: skip while removing float window");
            return;
        }
        ChatView chatView = floatChatView;
        if (chatView != null) {
            try {
                ViewGroup.LayoutParams layoutParams = chatView.getLayoutParams();
                WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
                if (layoutParams2 == null) {
                    return;
                }
                layoutParams2.flags &= -9;
                WindowManager windowManager2 = windowManager;
                if (windowManager2 != null) {
                    windowManager2.updateViewLayout(chatView, layoutParams2);
                }
                Log.d(TAG, "enableFocus: 悬浮窗焦点已启用");
            } catch (Exception e10) {
                Log.e(TAG, "enableFocus: 更新悬浮窗焦点失败", e10);
            }
        }
    }

    public final void m0() {
        List<WeakReference<BaseInputView>> list = inputViewList;
        Z8.A.L(list, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.v0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InputViewManager.n0((WeakReference) obj));
            }
        });
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            BaseInputView baseInputView = (BaseInputView) ((WeakReference) it.next()).get();
            if (baseInputView != null && (baseInputView.S7() || baseInputView.R7())) {
                if (baseInputView.Y7()) {
                    baseInputView.s4();
                }
            }
        }
    }

    public final void o0() {
        if (actionBarConfig != null) {
            N();
        } else {
            p0();
        }
    }

    public final void p0() {
        C1060i.d(managerScope, null, null, new InputViewManager$fetchActionBarConfig$1(null), 3, null);
    }

    public final BaseInputView q0() {
        WeakReference<BaseInputView> weakReference = preparedWakeInputView;
        BaseInputView baseInputView = weakReference != null ? weakReference.get() : null;
        if (baseInputView != null && preparedWakeInputUntilUptimeMs > SystemClock.uptimeMillis() && baseInputView.d8()) {
            return baseInputView;
        }
        f0();
        return null;
    }

    public final BaseInputView r0() {
        WeakReference<BaseInputView> weakReferencePrevious;
        BaseInputView baseInputView;
        if (RecentsWindowMonitor.INSTANCE.l()) {
            return null;
        }
        List<WeakReference<BaseInputView>> list = inputViewList;
        ListIterator<WeakReference<BaseInputView>> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                weakReferencePrevious = null;
                break;
            }
            weakReferencePrevious = listIterator.previous();
            WeakReference<BaseInputView> weakReference = weakReferencePrevious;
            BaseInputView baseInputView2 = weakReference.get();
            if (baseInputView2 != null && baseInputView2.Y7() && (baseInputView = weakReference.get()) != null && baseInputView.isEnabled()) {
                break;
            }
        }
        WeakReference<BaseInputView> weakReference2 = weakReferencePrevious;
        if (weakReference2 != null) {
            return weakReference2.get();
        }
        return null;
    }

    public final BaseInputView s0(String sessionId) {
        WeakReference<BaseInputView> weakReferencePrevious;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0 || RecentsWindowMonitor.INSTANCE.l()) {
            return null;
        }
        boolean zL = com.stepos.ailauncher.common.utils.v.INSTANCE.l();
        List<WeakReference<BaseInputView>> list = inputViewList;
        ListIterator<WeakReference<BaseInputView>> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                weakReferencePrevious = null;
                break;
            }
            weakReferencePrevious = listIterator.previous();
            BaseInputView baseInputView = weakReferencePrevious.get();
            boolean zD8 = false;
            if (baseInputView != null && baseInputView.isEnabled() && INSTANCE.I0(baseInputView, sessionId)) {
                zD8 = zL ? baseInputView.d8() : baseInputView.Y7();
            }
            if (zD8) {
                break;
            }
        }
        WeakReference<BaseInputView> weakReference = weakReferencePrevious;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final BaseInputView t0() {
        WeakReference<BaseInputView> weakReferencePrevious;
        if (RecentsWindowMonitor.INSTANCE.l()) {
            return null;
        }
        List<WeakReference<BaseInputView>> list = inputViewList;
        ListIterator<WeakReference<BaseInputView>> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                weakReferencePrevious = null;
                break;
            }
            weakReferencePrevious = listIterator.previous();
            BaseInputView baseInputView = weakReferencePrevious.get();
            if (baseInputView != null && baseInputView.isEnabled() && baseInputView.d8() && !baseInputView.R7() && (baseInputView.a8() || baseInputView.getListenModeActive())) {
                break;
            }
        }
        WeakReference<BaseInputView> weakReference = weakReferencePrevious;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void u0(InterfaceC5074l<? super InterfaceC5940b, Y8.t> action) {
        Iterator<T> it = dependentInputViewList.iterator();
        while (it.hasNext()) {
            BaseInputView baseInputView = (BaseInputView) ((WeakReference) it.next()).get();
            if (baseInputView != null) {
                action.invoke(baseInputView);
            }
        }
    }

    public final ActionViewApi v0() {
        return (ActionViewApi) actionViewApi.getValue();
    }

    public final BaseInputView w0() {
        return aiKeyActiveInput.get();
    }

    public final Activity x0() {
        WeakReference<Activity> weakReference = currentActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final DialogC3116e0 y0() {
        return currentWakeDialog;
    }

    public final Activity z0() {
        WeakReference<Activity> weakReference = currentActivity;
        Object obj = null;
        Activity activityA0 = A0(weakReference != null ? weakReference.get() : null);
        if (activityA0 != null) {
            return activityA0;
        }
        List<WeakReference<Activity>> list = activeActivities;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Activity activityA02 = A0((Activity) ((WeakReference) it.next()).get());
            if (activityA02 != null) {
                arrayList.add(activityA02);
            }
        }
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Object objPrevious = listIterator.previous();
            if (kotlin.jvm.internal.p.d(((Activity) objPrevious).getClass().getSimpleName(), CHAT_MAIN_ACTIVITY_NAME)) {
                obj = objPrevious;
                break;
            }
        }
        Activity activity = (Activity) obj;
        return activity != null ? activity : (Activity) Z8.F.E0(arrayList);
    }
}
