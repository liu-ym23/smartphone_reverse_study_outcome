package com.stepos.ailauncher.chat.manager;

import Z8.C1173v;
import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.chat.R$anim;
import com.stepos.ailauncher.chat.R$bool;
import com.stepos.ailauncher.chat.R$color;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.R$style;
import com.stepos.ailauncher.chat.activity.C2436g;
import com.stepos.ailauncher.chat.activity.PermissionDialogActivity;
import com.stepos.ailauncher.chat.activity.StepAssistantActivity;
import com.stepos.ailauncher.chat.manager.ClawVMManager;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.common.permission.C3193j;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator;
import com.stepos.ailauncher.foundation.account.AccountInfo;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.sla.SlaRouter;
import com.stepos.policy.sdk.PolicyManager;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import o6.C5009a;
import p7.AppUI;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import stepos.support.v7.app.c;
import t5.C5511d;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002¤\u0001\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002½\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\bH\u0082\u0010¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001a\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u0017J\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u0003J%\u0010 \u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u0018H\u0002¢\u0006\u0004\b \u0010\u001bJ\u001f\u0010\"\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020!2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0012H\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010*\u001a\u00020)H\u0003¢\u0006\u0004\b+\u0010,J!\u0010/\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b/\u00100J)\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000602012\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b3\u00104J'\u00107\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0002¢\u0006\u0004\b7\u00108J'\u0010?\u001a\u00020\u00122\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=H\u0002¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u00020\u0012*\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bA\u0010BJ\u0019\u0010D\u001a\u00020\n2\b\b\u0002\u0010C\u001a\u00020\u0012H\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u0012H\u0002¢\u0006\u0004\bG\u0010EJ5\u0010L\u001a\u00020\n2\b\u0010I\u001a\u0004\u0018\u00010H2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010J\u001a\u00020\u00122\b\b\u0002\u0010K\u001a\u00020\u0012H\u0002¢\u0006\u0004\bL\u0010MJ\u001f\u0010O\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0006H\u0002¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\nH\u0002¢\u0006\u0004\bQ\u0010\u0003J\u001f\u0010T\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010S\u001a\u00020RH\u0002¢\u0006\u0004\bT\u0010UJ\u0011\u0010V\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bV\u0010WJ+\u0010Z\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010X\u001a\u00020\u00122\b\b\u0002\u0010Y\u001a\u00020\u0012H\u0007¢\u0006\u0004\bZ\u0010[J\r\u0010\\\u001a\u00020\u0012¢\u0006\u0004\b\\\u0010]J\r\u0010^\u001a\u00020\u0012¢\u0006\u0004\b^\u0010]J\r\u0010_\u001a\u00020\u0012¢\u0006\u0004\b_\u0010]J\r\u0010`\u001a\u00020\u0012¢\u0006\u0004\b`\u0010]J\r\u0010a\u001a\u00020\u0012¢\u0006\u0004\ba\u0010]J\r\u0010b\u001a\u00020\u0012¢\u0006\u0004\bb\u0010]J\r\u0010c\u001a\u00020\u0012¢\u0006\u0004\bc\u0010]J\r\u0010d\u001a\u00020\u0012¢\u0006\u0004\bd\u0010]J\u0015\u0010e\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\be\u0010fJ'\u0010g\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018¢\u0006\u0004\bg\u0010hJ\u0015\u0010i\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\bi\u0010\u0017J\u0015\u0010k\u001a\u00020\u00122\u0006\u0010j\u001a\u00020\u0012¢\u0006\u0004\bk\u0010\u0015J\u0015\u0010l\u001a\u00020\u00122\u0006\u0010j\u001a\u00020\u0012¢\u0006\u0004\bl\u0010\u0015J\u0015\u0010m\u001a\u00020\u00122\u0006\u0010j\u001a\u00020\u0012¢\u0006\u0004\bm\u0010\u0015J\u0015\u0010n\u001a\u00020\u00122\u0006\u0010j\u001a\u00020\u0012¢\u0006\u0004\bn\u0010\u0015J\u0018\u0010p\u001a\u00020\n2\u0006\u0010o\u001a\u00020\u0012H\u0086@¢\u0006\u0004\bp\u0010qJ\u0015\u0010r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\br\u0010\u0017JK\u0010v\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010s\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00182\u0010\b\u0002\u0010t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00182\u0010\b\u0002\u0010u\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018¢\u0006\u0004\bv\u0010wJ\u0015\u0010x\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\bx\u0010fJ5\u0010}\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010y\u001a\u00020\u00122\b\b\u0002\u0010z\u001a\u00020\u00122\n\b\u0002\u0010|\u001a\u0004\u0018\u00010{¢\u0006\u0004\b}\u0010~J.\u0010\u0080\u0001\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010|\u001a\u0004\u0018\u00010{2\b\b\u0002\u0010\u007f\u001a\u00020\u0012¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0017\u0010\u0082\u0001\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0005\b\u0082\u0001\u0010\u0017J\u0017\u0010\u0083\u0001\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0005\b\u0083\u0001\u0010\u0017J8\u0010\u0084\u0001\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010y\u001a\u00020\u00122\b\b\u0002\u0010z\u001a\u00020\u00122\n\b\u0002\u0010|\u001a\u0004\u0018\u00010{¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J.\u0010\u0086\u0001\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010|\u001a\u0004\u0018\u00010{2\b\b\u0002\u0010\u007f\u001a\u00020\u0012¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0017\u0010\u0088\u0001\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b¢\u0006\u0005\b\u0088\u0001\u0010fJ\u0017\u0010\u0089\u0001\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0005\b\u0089\u0001\u0010\u0017J \u0010\u008a\u0001\u001a\u00020\n2\u000e\u0010|\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0018\u0010\u008c\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u000f\u0010\u008e\u0001\u001a\u00020\n¢\u0006\u0005\b\u008e\u0001\u0010\u0003J\u000f\u0010\u008f\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u008f\u0001\u0010]J2\u0010\u0092\u0001\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u00122\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\u0018¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J%\u0010\u0094\u0001\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u0018¢\u0006\u0005\b\u0094\u0001\u0010\u001bJH\u0010\u0098\u0001\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\r\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\u00182\u000f\b\u0002\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\u00182\u000f\b\u0002\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\u0018¢\u0006\u0005\b\u0098\u0001\u0010wJ!\u0010\u009a\u0001\u001a\u00020\n2\r\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\u000401H\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u000f\u0010\u009c\u0001\u001a\u00020\n¢\u0006\u0005\b\u009c\u0001\u0010\u0003J\u000f\u0010\u009d\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u009d\u0001\u0010]R\u0017\u0010\u009e\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001b\u0010 \u0001\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u001b\u0010¢\u0001\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010¡\u0001R\u001b\u0010£\u0001\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¡\u0001R\u0018\u0010¥\u0001\u001a\u00030¤\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001b\u0010§\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001b\u0010©\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010¨\u0001R$\u0010«\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060ª\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001b\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010\u009f\u0001R&\u0010®\u0001\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b®\u0001\u0010x\u001a\u0005\b¯\u0001\u0010]\"\u0005\b°\u0001\u0010ER\u0017\u0010±\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b±\u0001\u0010\u009f\u0001R\u0017\u0010²\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b²\u0001\u0010\u009f\u0001R\u0017\u0010³\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b³\u0001\u0010\u009f\u0001R\u0017\u0010´\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b´\u0001\u0010\u009f\u0001R\u0017\u0010µ\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\bµ\u0001\u0010\u009f\u0001R\u0017\u0010¶\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b¶\u0001\u0010\u009f\u0001R\u0018\u0010¸\u0001\u001a\u00030·\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R!\u0010º\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R!\u0010¼\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010»\u0001¨\u0006¾\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/AuthManager;", "", "<init>", "()V", "Landroid/app/Dialog;", C3081a.FOCUS_DIALOG_NAME, "", "prefix", "Landroid/content/Context;", "context", "LY8/t;", "H1", "(Landroid/app/Dialog;Ljava/lang/String;Landroid/content/Context;)V", "Landroid/app/Activity;", "q0", "(Landroid/content/Context;)Landroid/app/Activity;", "K1", "(Landroid/app/Dialog;)V", "", "declined", "S0", "(Z)Z", "j0", "(Landroid/content/Context;)V", "Lkotlin/Function0;", "onAgentOpened", "J0", "(Landroid/content/Context;Lp9/a;)V", "r0", "C0", "n0", "onSuccess", "F1", "Lstepos/support/v7/app/c;", "J", "(Lstepos/support/v7/app/c;Landroid/content/Context;)V", "l0", "(Landroid/content/Context;)Landroid/content/Context;", "granted", "L1", "(Landroid/content/Context;Z)V", "Landroid/widget/CheckBox;", "checkBox", "W0", "(Landroid/content/Context;Landroid/widget/CheckBox;)V", "Landroid/view/View;", "overlay", "U0", "(Landroid/view/View;Landroid/widget/CheckBox;)V", "", "Lkotlin/Pair;", "G0", "(Landroid/content/Context;)Ljava/util/List;", "title", QueryAlgorithmBundle.KEY_CATEGORY, "E0", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/widget/TextView;", AppUI.TYPE_WIDGET, "Landroid/text/Spannable;", "buffer", "Landroid/view/MotionEvent;", "event", "u0", "(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z", "y0", "(Landroid/app/Dialog;)Z", "dismissLive", "g0", "(Z)V", DidiCardProvider.ACTION_DISMISS, "L0", "Landroid/view/Window;", "window", "forceCoverApp", "keepHostKeyboard", "H0", "(Landroid/view/Window;Landroid/content/Context;ZZ)V", "tag", "i1", "(Landroid/app/Dialog;Ljava/lang/String;)Z", "M0", "", "str", "I", "(Landroid/content/Context;I)Ljava/lang/String;", "k0", "()Ljava/lang/String;", "showLoginDialog", "fromAutoPrompt", "N", "(Landroid/content/Context;ZZ)Z", "U", "()Z", "Y", "A0", "K", "v0", "e0", ExifInterface.GPS_DIRECTION_TRUE, "x0", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroid/content/Context;)Z", "c0", "(Landroid/content/Context;Lp9/a;)Z", "D0", AbstractC3297l.KEY_AUTH, "R0", "N0", "T0", "P0", x5.d.EXTRA_ENABLED, "G1", "(ZLe9/c;)Ljava/lang/Object;", "B0", "onLoginSuccess", "onCancel", "onLoginStarted", "q1", "(Landroid/content/Context;Lp9/a;Lp9/a;Lp9/a;)V", "Z", "continueCheck", "isCoverApp", "Lcom/stepos/ailauncher/chat/manager/AuthManager$a;", "listener", "b0", "(Landroid/content/Context;ZZLcom/stepos/ailauncher/chat/manager/AuthManager$a;)Z", "force", "L", "(Landroid/content/Context;Lcom/stepos/ailauncher/chat/manager/AuthManager$a;Z)Z", "t0", "Y0", "v1", "(Landroid/content/Context;ZZLcom/stepos/ailauncher/chat/manager/AuthManager$a;)V", "c1", "(Landroid/content/Context;Lcom/stepos/ailauncher/chat/manager/AuthManager$a;Z)V", "p0", "h1", "O0", "(Lp9/a;)V", "i0", "()Lp9/a;", "f0", ExifInterface.LATITUDE_SOUTH, "requireMic", "onReady", "Q", "(Landroid/content/Context;ZLp9/a;)V", "E1", "onAgree", "onRefuse", "onDismiss", "j1", "dialogs", "o0", "(Ljava/util/List;)V", "m0", "w0", "TAG", "Ljava/lang/String;", "agentOpenDialog", "Lstepos/support/v7/app/c;", "agentConfigDialog", "loginHintDialog", "com/stepos/ailauncher/chat/manager/AuthManager$loginHintAccountCallback$1", "loginHintAccountCallback", "Lcom/stepos/ailauncher/chat/manager/AuthManager$loginHintAccountCallback$1;", "privacyAuthDialog", "Landroid/app/Dialog;", "expressAuthDialog", "", "authLayerIds", "Ljava/util/Map;", "agentPromptDeclinedUid", "isNavigatingToPolicy", "z0", "Q0", "KEY_PRIVACY_AGREED", "KEY_PRIVACY_AUTO_DECLINED", "KEY_AGENT_OPENED", "KEY_VM_OPEN", "KEY_IMPROVE_ASSISTANT", "KEY_VOICE_TRAINING", "Landroid/net/Uri;", "VOICE_CONSENT_URI", "Landroid/net/Uri;", "pendingExpressAuthCallback", "Lp9/a;", "expressAuthCancelledListener", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AuthManager {
    public static final String KEY_AGENT_OPENED = "step_assistant_agent_opened";
    public static final String KEY_IMPROVE_ASSISTANT = "step_assistant_improve";
    public static final String KEY_PRIVACY_AGREED = "step_assistant_privacy_agreed";
    public static final String KEY_PRIVACY_AUTO_DECLINED = "step_assistant_privacy_auto_declined";
    public static final String KEY_VM_OPEN = "step_assistant_vm_opened";
    public static final String KEY_VOICE_TRAINING = "step_voice_training";
    private static final String TAG = "AuthManager";
    private static final Uri VOICE_CONSENT_URI;
    private static stepos.support.v7.app.c agentConfigDialog;
    private static stepos.support.v7.app.c agentOpenDialog;
    private static volatile String agentPromptDeclinedUid;
    private static volatile InterfaceC5063a<Y8.t> expressAuthCancelledListener;
    private static Dialog expressAuthDialog;
    private static volatile boolean isNavigatingToPolicy;
    private static stepos.support.v7.app.c loginHintDialog;
    private static volatile InterfaceC5063a<Y8.t> pendingExpressAuthCallback;
    private static Dialog privacyAuthDialog;
    public static final AuthManager INSTANCE = new AuthManager();
    private static final AuthManager$loginHintAccountCallback$1 loginHintAccountCallback = new com.stepos.ailauncher.foundation.account.i() { // from class: com.stepos.ailauncher.chat.manager.AuthManager$loginHintAccountCallback$1
        @Override // com.stepos.ailauncher.foundation.account.i
        public void a(AccountInfo accountInfo) {
            String accountId = accountInfo != null ? accountInfo.getAccountId() : null;
            if (accountId == null || accountId.length() == 0) {
                return;
            }
            Function2.b(new AuthManager$loginHintAccountCallback$1$accountStateChanged$1(null));
        }
    };
    private static final Map<Dialog, String> authLayerIds = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/AuthManager$a;", "", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a();

        void b();
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/chat/manager/AuthManager$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AppUI.TYPE_WIDGET, "LY8/t;", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", Const.SP_KEY_DEVICE_SENSORS, "updateDrawState", "(Landroid/text/TextPaint;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends ClickableSpan {
        final /* synthetic */ String $category;
        final /* synthetic */ Context $context;
        final /* synthetic */ int $linkColor;
        final /* synthetic */ String $phrase;

        public b(Context context, String str, String str2, int i10) {
            this.$context = context;
            this.$phrase = str;
            this.$category = str2;
            this.$linkColor = i10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.p.i(widget, "widget");
            AuthManager.INSTANCE.E0(this.$context, this.$phrase, this.$category);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            kotlin.jvm.internal.p.i(ds, "ds");
            ds.setColor(this.$linkColor);
            ds.setUnderlineText(false);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/chat/manager/AuthManager$c", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AppUI.TYPE_WIDGET, "LY8/t;", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", Const.SP_KEY_DEVICE_SENSORS, "updateDrawState", "(Landroid/text/TextPaint;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends ClickableSpan {
        final /* synthetic */ int $brandBlue;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $linkText;

        public c(Context context, String str, int i10) {
            this.$context = context;
            this.$linkText = str;
            this.$brandBlue = i10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.p.i(widget, "widget");
            AuthManager.INSTANCE.E0(this.$context, this.$linkText, "pp");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            kotlin.jvm.internal.p.i(ds, "ds");
            ds.setColor(this.$brandBlue);
            ds.setUnderlineText(false);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.stepos.ailauncher.chat.manager.AuthManager$loginHintAccountCallback$1] */
    static {
        Uri uri = Uri.parse("content://com.stepos.ability.voicewakeup.permission/consent");
        kotlin.jvm.internal.p.h(uri, "parse(...)");
        VOICE_CONSENT_URI = uri;
    }

    public static final void A1(CheckBox checkBox, Context context, CheckBox checkBox2, CheckBox checkBox3, a aVar, Dialog dialog, boolean z10, View view) throws Resources.NotFoundException {
        if (checkBox.isChecked()) {
            AuthManager authManager = INSTANCE;
            authManager.R0(true);
            authManager.N0(true);
            PolicyManager.INSTANCE.saveAgreeStatus(context, 1);
            if (checkBox2.isChecked()) {
                authManager.P0(true);
                try {
                    context.getContentResolver().notifyChange(C5511d.INSTANCE.a(), null);
                } catch (Exception unused) {
                }
            }
            C5009a.y(C5009a.INSTANCE, KEY_VOICE_TRAINING, checkBox3.isChecked(), false, 4, null);
            AuthManager authManager2 = INSTANCE;
            authManager2.L1(context, checkBox3.isChecked());
            if (aVar != null) {
                aVar.b();
            }
            dialog.dismiss();
            if (z10) {
                O(authManager2, context, false, false, 6, null);
            }
        }
    }

    public static final void B1(a aVar, DialogInterface dialogInterface) {
        INSTANCE.S0(true);
        if (aVar != null) {
            aVar.a();
        }
    }

    public static final void C1(Dialog dialog, DialogInterface dialogInterface) {
        AuthManager authManager = INSTANCE;
        authManager.K1(dialog);
        if (privacyAuthDialog == dialog) {
            privacyAuthDialog = null;
        }
        authManager.M0();
    }

    public static final void D1(CheckBox checkBox, TextView textView) {
        boolean zIsChecked = checkBox.isChecked();
        textView.setEnabled(zIsChecked);
        textView.setAlpha(zIsChecked ? 1.0f : 0.25f);
    }

    public static final void F0(Context context, String str, String str2, PolicySdkResultBean policySdkResultBean) {
        if (policySdkResultBean.getCode() != 0) {
            Function2.b(new AuthManager$openPolicy$3$1(context, str, str2, null));
        }
    }

    public static /* synthetic */ void I0(AuthManager authManager, Window window, Context context, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        authManager.H0(window, context, z10, z11);
    }

    public static final boolean I1(Dialog dialog) {
        return dialog.isShowing();
    }

    public static final Y8.t J1(Dialog dialog) {
        try {
            Result.Companion companion = Result.INSTANCE;
            dialog.dismiss();
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t K0(final Context context, final InterfaceC5063a interfaceC5063a) throws Resources.NotFoundException {
        INSTANCE.c1(context, new a() { // from class: com.stepos.ailauncher.chat.manager.AuthManager$promptAgentOpenWithoutShell$1$1
            @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
            public void a() {
            }

            @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
            public void b() {
                AuthManager authManager = AuthManager.INSTANCE;
                authManager.D0(context);
                if (AuthManager.O(authManager, context, false, false, 6, null)) {
                    Function2.b(new AuthManager$promptAgentOpenWithoutShell$1$1$onAgreeClick$1(interfaceC5063a, null));
                }
            }
        }, true);
        return Y8.t.f7040a;
    }

    public static /* synthetic */ boolean O(AuthManager authManager, Context context, boolean z10, boolean z11, int i10, Object obj) throws Resources.NotFoundException {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        return authManager.N(context, z10, z11);
    }

    public static final Y8.t P(Context context, String str) {
        C2698h c2698h = C2698h.INSTANCE;
        if (!c2698h.j(str) && !c2698h.k(str) && !c2698h.i()) {
            Function2.b(new AuthManager$checkAppAuth$1$1(context, null));
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t R(Context context, boolean z10, Intent launch) {
        kotlin.jvm.internal.p.i(launch, "$this$launch");
        int iC = C3193j.INSTANCE.c(context);
        PermissionDialogActivity.Companion companion = PermissionDialogActivity.INSTANCE;
        launch.putExtra(companion.b(), companion.d());
        launch.putExtra(PermissionDialogActivity.INTENT_KEY_EXPRESS_REQUIRE_MIC, z10);
        if (iC > 0) {
            launch.putExtra(PermissionDialogActivity.INTENT_KEY_HOST_TASK_ID, iC);
        }
        return Y8.t.f7040a;
    }

    public static final void V0(CheckBox checkBox, View view) {
        checkBox.setChecked(!checkBox.isChecked());
    }

    public static final Y8.t W(Context context) {
        if (com.stepos.ailauncher.foundation.account.f.INSTANCE.v()) {
            return Y8.t.f7040a;
        }
        Context applicationContext = context.getApplicationContext();
        final Context context2 = applicationContext == null ? context : applicationContext;
        r1(INSTANCE, context2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.N
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AuthManager.X(context2);
            }
        }, null, null, 12, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t X(Context context) {
        INSTANCE.j0(context);
        return Y8.t.f7040a;
    }

    public static final boolean X0(SpannableString spannableString, View view, MotionEvent motionEvent) {
        AuthManager authManager = INSTANCE;
        kotlin.jvm.internal.p.g(view, "null cannot be cast to non-null type android.widget.TextView");
        kotlin.jvm.internal.p.f(motionEvent);
        return authManager.u0((TextView) view, spannableString, motionEvent);
    }

    public static final void Z0(DialogInterface dialogInterface, int i10) {
    }

    public static final Y8.t a0(Intent launch) {
        kotlin.jvm.internal.p.i(launch, "$this$launch");
        PermissionDialogActivity.Companion companion = PermissionDialogActivity.INSTANCE;
        launch.putExtra(companion.b(), companion.e());
        return Y8.t.f7040a;
    }

    public static final void a1(stepos.support.v7.app.c cVar, DialogInterface dialogInterface) {
        AuthManager authManager = INSTANCE;
        authManager.K1(cVar);
        if (agentConfigDialog == cVar) {
            agentConfigDialog = null;
        }
        authManager.M0();
    }

    public static final Y8.t b1() {
        Y8.t tVar;
        try {
            Result.Companion companion = Result.INSTANCE;
            stepos.support.v7.app.c cVar = agentConfigDialog;
            if (cVar != null) {
                cVar.dismiss();
                tVar = Y8.t.f7040a;
            } else {
                tVar = null;
            }
            Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean d0(AuthManager authManager, Context context, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5063a = null;
        }
        return authManager.c0(context, interfaceC5063a);
    }

    public static /* synthetic */ void d1(AuthManager authManager, Context context, a aVar, boolean z10, int i10, Object obj) throws Resources.NotFoundException {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        authManager.c1(context, aVar, z10);
    }

    public static final void e1(a aVar, Context context, DialogInterface dialogInterface, int i10) throws Resources.NotFoundException {
        AuthManager authManager = INSTANCE;
        authManager.N0(true);
        if (aVar != null) {
            aVar.b();
        } else {
            O(authManager, context, false, false, 6, null);
        }
    }

    public static final void f1(a aVar, DialogInterface dialogInterface, int i10) {
        AuthManager authManager = INSTANCE;
        authManager.C0();
        authManager.L0(false);
        if (aVar != null) {
            aVar.a();
        }
    }

    public static final void g1(stepos.support.v7.app.c cVar, DialogInterface dialogInterface) {
        if (agentOpenDialog == cVar) {
            INSTANCE.K1(cVar);
            agentOpenDialog = null;
        } else {
            INSTANCE.K1(cVar);
        }
        INSTANCE.M0();
    }

    public static /* synthetic */ void h0(AuthManager authManager, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        authManager.g0(z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void k1(AuthManager authManager, Context context, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, InterfaceC5063a interfaceC5063a3, int i10, Object obj) throws Resources.NotFoundException {
        if ((i10 & 4) != 0) {
            interfaceC5063a2 = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.u
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AuthManager.l1();
                }
            };
        }
        if ((i10 & 8) != 0) {
            interfaceC5063a3 = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.v
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AuthManager.m1();
                }
            };
        }
        authManager.j1(context, interfaceC5063a, interfaceC5063a2, interfaceC5063a3);
    }

    public static final Y8.t l1() {
        return Y8.t.f7040a;
    }

    public static final Y8.t m1() {
        return Y8.t.f7040a;
    }

    public static final void n1(Dialog dialog, InterfaceC5063a interfaceC5063a, View view) {
        dialog.dismiss();
        interfaceC5063a.invoke();
    }

    public static final void o1(Dialog dialog, InterfaceC5063a interfaceC5063a, View view) {
        U0 u02 = U0.INSTANCE;
        u02.u(true);
        u02.v(true);
        dialog.dismiss();
        interfaceC5063a.invoke();
    }

    public static final void p1(Dialog dialog, InterfaceC5063a interfaceC5063a, DialogInterface dialogInterface) {
        AuthManager authManager = INSTANCE;
        authManager.K1(dialog);
        if (expressAuthDialog == dialog) {
            expressAuthDialog = null;
        }
        authManager.M0();
        interfaceC5063a.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void r1(AuthManager authManager, Context context, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, InterfaceC5063a interfaceC5063a3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5063a = null;
        }
        if ((i10 & 4) != 0) {
            interfaceC5063a2 = null;
        }
        if ((i10 & 8) != 0) {
            interfaceC5063a3 = null;
        }
        authManager.q1(context, interfaceC5063a, interfaceC5063a2, interfaceC5063a3);
    }

    public static final Y8.t s0(Context context) {
        PermissionDialogActivity.Companion.h(PermissionDialogActivity.INSTANCE, context, null, 2, null);
        return Y8.t.f7040a;
    }

    public static final void s1(boolean[] zArr, InterfaceC5063a interfaceC5063a, Context context, InterfaceC5063a interfaceC5063a2, DialogInterface dialogInterface, int i10) {
        zArr[0] = true;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        if (interfaceC5063a2 != null) {
            INSTANCE.F1(context, interfaceC5063a2);
        } else {
            INSTANCE.B0(context);
        }
    }

    public static final void t1(DialogInterface dialogInterface, int i10) {
    }

    public static final void u1(stepos.support.v7.app.c cVar, boolean[] zArr, InterfaceC5063a interfaceC5063a, DialogInterface dialogInterface) {
        AuthManager authManager = INSTANCE;
        authManager.K1(cVar);
        if (loginHintDialog == cVar) {
            loginHintDialog = null;
        }
        authManager.M0();
        if (zArr[0] || interfaceC5063a == null) {
            return;
        }
        interfaceC5063a.invoke();
    }

    public static /* synthetic */ void w1(AuthManager authManager, Context context, boolean z10, boolean z11, a aVar, int i10, Object obj) throws Resources.NotFoundException {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            z11 = true;
        }
        if ((i10 & 8) != 0) {
            aVar = null;
        }
        authManager.v1(context, z10, z11, aVar);
    }

    public static final void x1(boolean[] zArr, List list, CheckBox checkBox, TextView textView, CompoundButton compoundButton, boolean z10) {
        kotlin.jvm.internal.p.i(compoundButton, "<unused var>");
        if (zArr[0]) {
            return;
        }
        zArr[0] = true;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((CheckBox) it.next()).setChecked(z10);
        }
        zArr[0] = false;
        D1(checkBox, textView);
    }

    public static final void y1(boolean[] zArr, CheckBox checkBox, List list, CheckBox checkBox2, TextView textView, CompoundButton compoundButton, boolean z10) {
        kotlin.jvm.internal.p.i(compoundButton, "<unused var>");
        if (!zArr[0]) {
            boolean z11 = true;
            zArr[0] = true;
            List list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (!((CheckBox) it.next()).isChecked()) {
                        z11 = false;
                        break;
                    }
                }
            }
            checkBox.setChecked(z11);
            zArr[0] = false;
        }
        D1(checkBox2, textView);
    }

    public static final void z1(a aVar, Dialog dialog, View view) {
        INSTANCE.S0(true);
        if (aVar != null) {
            aVar.a();
        }
        dialog.dismiss();
    }

    public final boolean A0() {
        String strK0 = k0();
        if (strK0 == null) {
            return false;
        }
        return C5009a.g(C5009a.INSTANCE, KEY_PRIVACY_AUTO_DECLINED + strK0, false, false, 4, null);
    }

    public final void B0(final Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (com.stepos.ailauncher.foundation.account.f.INSTANCE.v()) {
            O(this, context, false, false, 6, null);
        } else {
            ClawVMManager.INSTANCE.a().n(context, new ClawVMManager.b() { // from class: com.stepos.ailauncher.chat.manager.AuthManager$jumpToLoginPage$1
                @Override // com.stepos.ailauncher.chat.manager.ClawVMManager.b
                public void a() {
                    Function2.b(new AuthManager$jumpToLoginPage$1$onLoginSuccess$1(context, null));
                }
            });
        }
    }

    public final void C0() {
        agentPromptDeclinedUid = k0();
    }

    public final void D0(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        context.sendBroadcast(new Intent(StepAssistantActivity.ACTION_AGENT_OPENED_FROM_DIALOG).setPackage(context.getPackageName()));
    }

    public final void E0(final Context context, final String title, final String category) {
        boolean z10 = true;
        isNavigatingToPolicy = true;
        List listR = C1173v.r(privacyAuthDialog, expressAuthDialog);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((Dialog) obj).isShowing()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            W.INSTANCE.b((Dialog) it.next());
        }
        String language = PolicySdkToolsUtils.INSTANCE.getLanguage();
        if (language != null && !La.H.x0(language)) {
            z10 = false;
        }
        if (z10) {
            language = null;
        }
        if (language == null) {
            language = "zh_CN";
        }
        PolicySdk.getOnlinePolicyMethod(context, language, category, title, Boolean.TRUE, new PolicySdk.PolicySdkCallback() { // from class: com.stepos.ailauncher.chat.manager.J
            @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
            public final void getResult(PolicySdkResultBean policySdkResultBean) {
                AuthManager.F0(context, title, category, policySdkResultBean);
            }
        });
    }

    public final void E1(Context context, final InterfaceC5063a<Y8.t> onSuccess) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(onSuccess, "onSuccess");
        ClawVMManager.INSTANCE.a().n(context, new ClawVMManager.b() { // from class: com.stepos.ailauncher.chat.manager.AuthManager$startExpressLoginFlow$1
            @Override // com.stepos.ailauncher.chat.manager.ClawVMManager.b
            public void a() {
                Function2.b(new AuthManager$startExpressLoginFlow$1$onLoginSuccess$1(onSuccess, null));
            }
        });
    }

    public final void F1(Context context, final InterfaceC5063a<Y8.t> onSuccess) {
        if (com.stepos.ailauncher.foundation.account.f.INSTANCE.v()) {
            onSuccess.invoke();
        } else {
            ClawVMManager.INSTANCE.a().n(context, new ClawVMManager.b() { // from class: com.stepos.ailauncher.chat.manager.AuthManager$startLoginThen$1
                @Override // com.stepos.ailauncher.chat.manager.ClawVMManager.b
                public void a() {
                    Function2.b(new AuthManager$startLoginThen$1$onLoginSuccess$1(onSuccess, null));
                }
            });
        }
    }

    public final List<Pair<String, String>> G0(Context context) {
        return C1173v.p(Y8.j.a(context.getString(R$string.privacy_all_link_user_agreement), "up"), Y8.j.a(context.getString(R$string.privacy_all_link_privacy_policy), "pp"), Y8.j.a(context.getString(R$string.privacy_all_link_voiceprint), "vrs"), Y8.j.a(context.getString(R$string.privacy_all_link_improvement), "ueip"));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G1(boolean r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.ailauncher.chat.manager.AuthManager$syncImproveAssistantToCloud$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ailauncher.chat.manager.AuthManager$syncImproveAssistantToCloud$1 r0 = (com.stepos.ailauncher.chat.manager.AuthManager$syncImproveAssistantToCloud$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.manager.AuthManager$syncImproveAssistantToCloud$1 r0 = new com.stepos.ailauncher.chat.manager.AuthManager$syncImproveAssistantToCloud$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r8 = f9.C4063a.g()
            int r1 = r0.label
            java.lang.String r2 = "AuthManager"
            r3 = 1
            if (r1 == 0) goto L3f
            if (r1 != r3) goto L37
            boolean r7 = r0.Z$0
            java.lang.Object r8 = r0.L$1
            com.stepos.ailauncher.chat.api.UserSwitchBody r8 = (com.stepos.ailauncher.chat.api.UserSwitchBody) r8
            java.lang.Object r8 = r0.L$0
            com.stepos.ailauncher.chat.api.UserSwitchApi r8 = (com.stepos.ailauncher.chat.api.UserSwitchApi) r8
            kotlin.C4849c.b(r6)     // Catch: java.lang.Exception -> L35
            goto L71
        L35:
            r6 = move-exception
            goto Lad
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            kotlin.C4849c.b(r6)
            com.stepos.net.HttpManager r6 = com.stepos.net.HttpManager.INSTANCE     // Catch: java.lang.Exception -> L35
            java.lang.String r1 = "botMsg"
            java.lang.Class<com.stepos.ailauncher.chat.api.UserSwitchApi> r4 = com.stepos.ailauncher.chat.api.UserSwitchApi.class
            java.lang.Object r6 = r6.create(r4, r1)     // Catch: java.lang.Exception -> L35
            com.stepos.ailauncher.chat.api.UserSwitchApi r6 = (com.stepos.ailauncher.chat.api.UserSwitchApi) r6     // Catch: java.lang.Exception -> L35
            com.stepos.ailauncher.chat.api.UserSwitchBody r1 = new com.stepos.ailauncher.chat.api.UserSwitchBody     // Catch: java.lang.Exception -> L35
            java.lang.String r4 = "privacy_authorized"
            java.lang.String r5 = java.lang.String.valueOf(r7)     // Catch: java.lang.Exception -> L35
            r1.<init>(r4, r5)     // Catch: java.lang.Exception -> L35
            java.lang.Object r4 = g9.h.a(r6)     // Catch: java.lang.Exception -> L35
            r0.L$0 = r4     // Catch: java.lang.Exception -> L35
            java.lang.Object r4 = g9.h.a(r1)     // Catch: java.lang.Exception -> L35
            r0.L$1 = r4     // Catch: java.lang.Exception -> L35
            r0.Z$0 = r7     // Catch: java.lang.Exception -> L35
            r0.label = r3     // Catch: java.lang.Exception -> L35
            java.lang.Object r6 = r6.setUserSwitch(r1, r0)     // Catch: java.lang.Exception -> L35
            if (r6 != r8) goto L71
            return r8
        L71:
            com.stepos.ailauncher.chat.api.UserSwitchResponse r6 = (com.stepos.ailauncher.chat.api.UserSwitchResponse) r6     // Catch: java.lang.Exception -> L35
            int r8 = r6.getCode()     // Catch: java.lang.Exception -> L35
            java.lang.String r0 = r6.getMsg()     // Catch: java.lang.Exception -> L35
            java.lang.String r6 = r6.getTrace_id()     // Catch: java.lang.Exception -> L35
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35
            r1.<init>()     // Catch: java.lang.Exception -> L35
            java.lang.String r3 = "syncImproveAssistant: enabled="
            r1.append(r3)     // Catch: java.lang.Exception -> L35
            r1.append(r7)     // Catch: java.lang.Exception -> L35
            java.lang.String r3 = ", code="
            r1.append(r3)     // Catch: java.lang.Exception -> L35
            r1.append(r8)     // Catch: java.lang.Exception -> L35
            java.lang.String r8 = ", msg="
            r1.append(r8)     // Catch: java.lang.Exception -> L35
            r1.append(r0)     // Catch: java.lang.Exception -> L35
            java.lang.String r8 = ", trace_id="
            r1.append(r8)     // Catch: java.lang.Exception -> L35
            r1.append(r6)     // Catch: java.lang.Exception -> L35
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Exception -> L35
            android.util.Log.d(r2, r6)     // Catch: java.lang.Exception -> L35
            goto Lce
        Lad:
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "syncImproveAssistant failed: enabled="
            r8.append(r0)
            r8.append(r7)
            java.lang.String r7 = ", error="
            r8.append(r7)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            android.util.Log.w(r2, r6)
        Lce:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.AuthManager.G1(boolean, e9.c):java.lang.Object");
    }

    public final void H0(Window window, Context context, boolean forceCoverApp, boolean keepHostKeyboard) {
        if (window == null) {
            return;
        }
        if (keepHostKeyboard) {
            window.addFlags(8);
        } else {
            window.setSoftInputMode(C2436g.INSTANCE.b(window.getAttributes().softInputMode));
        }
        window.clearFlags(1048576);
        if (forceCoverApp) {
            com.stepos.ailauncher.container.dialog.f.h(window, context);
        }
    }

    public final void H1(final Dialog dialog, String prefix, Context context) {
        Window window;
        View decorView;
        Activity activityQ0 = q0(context);
        View rootView = (activityQ0 == null || (window = activityQ0.getWindow()) == null || (decorView = window.getDecorView()) == null) ? null : decorView.getRootView();
        if (rootView == null) {
            Log.w(TAG, "skip panel tracking for ownerless auth dialog prefix=" + prefix);
            return;
        }
        com.stepos.ailauncher.chat.panelui.i iVar = com.stepos.ailauncher.chat.panelui.i.INSTANCE;
        String strC = iVar.c(prefix);
        authLayerIds.put(dialog, strC);
        iVar.e(strC, PanelHomePolicy.DISMISS_TOP_ONLY, rootView, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.z
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(AuthManager.I1(dialog));
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.B
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AuthManager.J1(dialog);
            }
        }, new com.stepos.ailauncher.chat.panelui.c(dialog));
    }

    public final String I(Context context, int str) throws Resources.NotFoundException {
        String strP = La.D.P(" ", 8);
        return strP + context.getResources().getString(str) + strP;
    }

    public final void J(stepos.support.v7.app.c dialog, Context context) {
        int identifier = context.getResources().getIdentifier("alertTitle", "id", context.getPackageName());
        View viewFindViewById = identifier != 0 ? dialog.findViewById(identifier) : null;
        if (viewFindViewById == null) {
            viewFindViewById = dialog.findViewById(R.id.title);
        }
        TextView textView = viewFindViewById instanceof TextView ? (TextView) viewFindViewById : null;
        if (textView != null) {
            textView.setGravity(17);
        }
    }

    public final void J0(final Context context, final InterfaceC5063a<Y8.t> onAgentOpened) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        com.stepos.ailauncher.chat.wake.homebar.g.INSTANCE.d(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.C
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AuthManager.K0(context, onAgentOpened);
            }
        });
    }

    public final boolean K() {
        String strK0 = k0();
        if (strK0 == null) {
            return false;
        }
        return C5009a.g(C5009a.INSTANCE, KEY_AGENT_OPENED + strK0, false, false, 4, null);
    }

    public final void K1(Dialog dialog) {
        if (dialog == null) {
            return;
        }
        W.INSTANCE.a(dialog);
        String strRemove = authLayerIds.remove(dialog);
        if (strRemove != null) {
            com.stepos.ailauncher.chat.panelui.i.INSTANCE.d(strRemove);
        }
    }

    public final boolean L(Context context, a listener, boolean force) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(context, "context");
        if (K()) {
            return true;
        }
        c1(context, listener, force);
        return false;
    }

    public final void L0(boolean dismiss) {
        stepos.support.v7.app.c cVar = agentOpenDialog;
        Y8.t tVar = null;
        agentOpenDialog = null;
        K1(cVar);
        if (dismiss) {
            try {
                Result.Companion companion = Result.INSTANCE;
                if (cVar != null) {
                    cVar.dismiss();
                    tVar = Y8.t.f7040a;
                }
                Result.b(tVar);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void L1(Context context, boolean granted) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_id", INSTANCE.k0());
        contentValues.put("granted", Integer.valueOf(granted ? 1 : 0));
        try {
            context.getContentResolver().update(VOICE_CONSENT_URI, contentValues, null, null);
        } catch (Exception unused) {
        }
    }

    public final boolean M(Context context, boolean z10) {
        kotlin.jvm.internal.p.i(context, "context");
        return O(this, context, z10, false, 4, null);
    }

    public final void M0() {
        com.stepos.ailauncher.container.m0 m0Var = com.stepos.ailauncher.container.m0.INSTANCE;
        if (m0Var.h()) {
            m0Var.j();
        }
    }

    public final boolean N(final Context context, boolean showLoginDialog, boolean fromAutoPrompt) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(context, "context");
        boolean zV = com.stepos.ailauncher.foundation.account.f.INSTANCE.v();
        Log.i("checkAppAuth", "checkAppAuth start logged=" + zV + " showLoginDialog=" + showLoginDialog + " fromAutoPrompt=" + fromAutoPrompt);
        if (!zV) {
            if (showLoginDialog) {
                r1(this, context, null, null, null, 14, null);
            } else {
                Toast.makeText(context, R$string.auth_not_login, 0).show();
                B0(context);
            }
            return false;
        }
        if (!Y()) {
            if (fromAutoPrompt && A0()) {
                Log.i("checkAppAuth", "skip privacy auto prompt: user declined");
                return false;
            }
            w1(this, context, true, true ^ (context instanceof Activity), null, 8, null);
            return false;
        }
        if (!K()) {
            d1(this, context, null, false, 6, null);
            return false;
        }
        boolean zE0 = e0();
        Log.i("VmConfigDiag", "auth localVmOpen=" + zE0 + " pollRunning=" + C2698h.INSTANCE.i());
        if (zE0) {
            ClawVMManager.INSTANCE.a().z(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.s
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AuthManager.P(context, (String) obj);
                }
            });
            return true;
        }
        t0(context);
        return false;
    }

    public final boolean N0(boolean auth) {
        String strK0 = k0();
        if (strK0 == null) {
            return false;
        }
        if (auth) {
            agentPromptDeclinedUid = null;
        }
        boolean zY = C5009a.y(C5009a.INSTANCE, KEY_AGENT_OPENED + strK0, auth, false, 4, null);
        U0.INSTANCE.t();
        x5.h.INSTANCE.h(auth);
        return zY;
    }

    public final void O0(InterfaceC5063a<Y8.t> listener) {
        expressAuthCancelledListener = listener;
    }

    public final boolean P0(boolean auth) {
        String strK0 = k0();
        if (strK0 == null) {
            return false;
        }
        boolean zY = C5009a.y(C5009a.INSTANCE, "step_assistant_improve" + strK0, auth, false, 4, null);
        Function2.a(new AuthManager$setImproveAssistant$1(auth, null));
        return zY;
    }

    public final void Q(final Context context, final boolean requireMic, InterfaceC5063a<Y8.t> onReady) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(onReady, "onReady");
        if (S() && U0.INSTANCE.l()) {
            onReady.invoke();
        } else {
            pendingExpressAuthCallback = onReady;
            PermissionDialogActivity.INSTANCE.g(context, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.K
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AuthManager.R(context, requireMic, (Intent) obj);
                }
            });
        }
    }

    public final void Q0(boolean z10) {
        isNavigatingToPolicy = z10;
    }

    public final boolean R0(boolean auth) {
        IHomeGestureCoordinator iHomeGestureCoordinator;
        String strK0 = k0();
        if (strK0 == null) {
            return false;
        }
        if (auth) {
            S0(false);
        }
        boolean zY = C5009a.y(C5009a.INSTANCE, KEY_PRIVACY_AGREED + strK0, auth, false, 4, null);
        if (zY && auth) {
            com.stepos.ailauncher.common.startup.g.INSTANCE.q();
            com.stepos.ailauncher.chat.tts.f fVar = com.stepos.ailauncher.chat.tts.f.INSTANCE;
            C3197a c3197a = C3197a.INSTANCE;
            fVar.h(c3197a.a());
            com.stepos.ailauncher.container.i0.INSTANCE.a(c3197a.a());
        }
        U0.INSTANCE.t();
        if (zY && (iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class)) != null) {
            iHomeGestureCoordinator.notifyTopologyChanged(auth ? "privacy-granted" : "privacy-revoked");
        }
        return zY;
    }

    public final boolean S() {
        return Y() && K();
    }

    public final boolean S0(boolean declined) {
        String strK0 = k0();
        if (strK0 == null) {
            return false;
        }
        return C5009a.y(C5009a.INSTANCE, KEY_PRIVACY_AUTO_DECLINED + strK0, declined, false, 4, null);
    }

    public final boolean T() {
        String strK0 = k0();
        if (strK0 == null) {
            return false;
        }
        return C5009a.g(C5009a.INSTANCE, "step_assistant_improve" + strK0, false, false, 4, null);
    }

    public final boolean T0(boolean auth) {
        String strK0 = k0();
        if (strK0 == null) {
            return false;
        }
        C5009a c5009a = C5009a.INSTANCE;
        boolean zG = C5009a.g(c5009a, KEY_VM_OPEN + strK0, false, false, 4, null);
        boolean zY = C5009a.y(c5009a, KEY_VM_OPEN + strK0, auth, false, 4, null);
        Log.i("VmConfigDiag", "local write previous=" + zG + " requested=" + auth + " saved=" + zY);
        return zY;
    }

    public final boolean U() {
        return com.stepos.ailauncher.foundation.account.f.INSTANCE.v();
    }

    public final void U0(View overlay, final CheckBox checkBox) {
        if (overlay != null) {
            overlay.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.manager.D
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AuthManager.V0(checkBox, view);
                }
            });
        }
    }

    public final boolean V(final Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (com.stepos.ailauncher.foundation.account.f.INSTANCE.v()) {
            return true;
        }
        com.stepos.ailauncher.chat.wake.homebar.g.INSTANCE.d(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.M
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AuthManager.W(context);
            }
        });
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void W0(Context context, CheckBox checkBox) {
        String string;
        CharSequence text = checkBox.getText();
        if (text == null || (string = text.toString()) == null) {
            return;
        }
        final SpannableString spannableString = new SpannableString(string);
        if (La.D.X(string, "*", false, 2, null)) {
            spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.a.c(context, R$color.privacy_all_star)), 0, 1, 33);
        }
        int iC = androidx.core.content.a.c(context, R$color.privacy_all_link);
        for (Pair<String, String> pair : G0(context)) {
            String strA = pair.a();
            String strB = pair.b();
            int iU0 = La.H.u0(string, strA, 0, false, 6, null);
            while (iU0 >= 0) {
                int length = strA.length() + iU0;
                spannableString.setSpan(new b(context, strA, strB, iC), iU0, length, 33);
                iU0 = La.H.u0(string, strA, length, false, 4, null);
            }
        }
        checkBox.setText(spannableString);
        checkBox.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.ailauncher.chat.manager.t
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AuthManager.X0(spannableString, view, motionEvent);
            }
        });
    }

    public final boolean Y() {
        String strK0 = k0();
        if (strK0 == null) {
            return false;
        }
        return C5009a.g(C5009a.INSTANCE, KEY_PRIVACY_AGREED + strK0, false, false, 4, null);
    }

    public final void Y0(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        stepos.support.v7.app.c cVar = agentConfigDialog;
        if (cVar == null || !cVar.isShowing()) {
            Context contextThemeWrapper = new ContextThemeWrapper(context, R$style.ChatBaseTheme);
            c.a aVar = new c.a(contextThemeWrapper);
            aVar.t(R$string.agent_config_dialog_title);
            aVar.l(contextThemeWrapper.getString(R$string.agent_config_dialog_message));
            aVar.n(contextThemeWrapper.getString(R$string.oobe_configuring_got_it), new DialogInterface.OnClickListener() { // from class: com.stepos.ailauncher.chat.manager.p
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    AuthManager.Z0(dialogInterface, i10);
                }
            });
            final stepos.support.v7.app.c cVarC = aVar.c();
            cVarC.setCanceledOnTouchOutside(false);
            cVarC.setCancelable(false);
            cVarC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.ailauncher.chat.manager.A
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AuthManager.a1(cVarC, dialogInterface);
                }
            });
            I0(this, cVarC.getWindow(), context, false, true, 4, null);
            agentConfigDialog = cVarC;
            kotlin.jvm.internal.p.f(cVarC);
            boolean zI1 = i1(cVarC, "agent_config");
            C2698h c2698h = C2698h.INSTANCE;
            Log.i("VmConfigDiag", "configDialog shown=" + zI1 + " pollRunning=" + c2698h.i());
            if (!zI1) {
                K1(cVarC);
                agentConfigDialog = null;
                return;
            }
            H1(cVarC, "auth_agent_config", context);
            J(cVarC, contextThemeWrapper);
            c2698h.o(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.L
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AuthManager.b1();
                }
            });
            if (c2698h.i()) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            ClawVMManager.INSTANCE.a().m(applicationContext);
            c2698h.p(applicationContext);
        }
    }

    public final boolean Z(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (Y()) {
            return true;
        }
        PermissionDialogActivity.Companion companion = PermissionDialogActivity.INSTANCE;
        if (companion.f() != 0) {
            return false;
        }
        companion.g(context, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.I
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AuthManager.a0((Intent) obj);
            }
        });
        return false;
    }

    public final boolean b0(Context context, boolean continueCheck, boolean isCoverApp, a listener) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(context, "context");
        if (Y()) {
            return true;
        }
        v1(context, continueCheck, isCoverApp, listener);
        return false;
    }

    public final boolean c0(Context context, InterfaceC5063a<Y8.t> onAgentOpened) {
        kotlin.jvm.internal.p.i(context, "context");
        if (!Y()) {
            r0(context);
            return false;
        }
        if (K()) {
            return true;
        }
        J0(context, onAgentOpened);
        return false;
    }

    public final void c1(final Context context, final a listener, boolean force) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(context, "context");
        if (force) {
            agentPromptDeclinedUid = null;
            g0(true);
        } else if (y0(agentOpenDialog)) {
            return;
        } else {
            h0(this, false, 1, null);
        }
        c.a aVar = new c.a(l0(context));
        aVar.t(R$string.agent_auth_title);
        aVar.k(R$string.agent_auth_desc);
        aVar.s(I(context, R$string.agent_auth_open), new DialogInterface.OnClickListener() { // from class: com.stepos.ailauncher.chat.manager.V
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) throws Resources.NotFoundException {
                AuthManager.e1(listener, context, dialogInterface, i10);
            }
        });
        aVar.n(I(context, R$string.agent_auth_refuse), new DialogInterface.OnClickListener() { // from class: com.stepos.ailauncher.chat.manager.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                AuthManager.f1(listener, dialogInterface, i10);
            }
        });
        aVar.i(-2, 2);
        final stepos.support.v7.app.c cVarC = aVar.c();
        cVarC.setCanceledOnTouchOutside(false);
        cVarC.setCancelable(false);
        cVarC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.ailauncher.chat.manager.r
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AuthManager.g1(cVarC, dialogInterface);
            }
        });
        I0(this, cVarC.getWindow(), context, false, false, 12, null);
        agentOpenDialog = cVarC;
        kotlin.jvm.internal.p.f(cVarC);
        if (i1(cVarC, "agent")) {
            H1(cVarC, "auth_agent", context);
            return;
        }
        K1(cVarC);
        if (agentOpenDialog == cVarC) {
            agentOpenDialog = null;
        }
    }

    public final boolean e0() {
        String strK0 = k0();
        if (strK0 == null) {
            return false;
        }
        return C5009a.g(C5009a.INSTANCE, KEY_VM_OPEN + strK0, false, false, 4, null);
    }

    public final void f0() {
        InterfaceC5063a<Y8.t> interfaceC5063a;
        boolean z10 = pendingExpressAuthCallback != null;
        pendingExpressAuthCallback = null;
        if (!z10 || (interfaceC5063a = expressAuthCancelledListener) == null) {
            return;
        }
        interfaceC5063a.invoke();
    }

    public final void g0(boolean dismissLive) {
        stepos.support.v7.app.c cVar = agentOpenDialog;
        if (cVar == null) {
            return;
        }
        if (dismissLive || !y0(cVar)) {
            L0(true);
        }
    }

    public final void h1(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        SlaRouter.INSTANCE.N(context);
    }

    public final InterfaceC5063a<Y8.t> i0() {
        InterfaceC5063a<Y8.t> interfaceC5063a = pendingExpressAuthCallback;
        pendingExpressAuthCallback = null;
        return interfaceC5063a;
    }

    public final boolean i1(Dialog dialog, String tag) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            dialog.show();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(TAG, "dialog.show failed (" + tag + ")", thE);
        }
        return Result.h(objB);
    }

    public final void j0(Context context) {
        S0 s02 = S0.INSTANCE;
        if (!s02.c()) {
            r0(context);
            return;
        }
        s02.d(context);
        if (Y() && K() && e0()) {
            s02.a("login_resume_ready");
        }
    }

    public final void j1(Context context, final InterfaceC5063a<Y8.t> onAgree, final InterfaceC5063a<Y8.t> onRefuse, final InterfaceC5063a<Y8.t> onDismiss) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(onAgree, "onAgree");
        kotlin.jvm.internal.p.i(onRefuse, "onRefuse");
        kotlin.jvm.internal.p.i(onDismiss, "onDismiss");
        Dialog dialog = expressAuthDialog;
        if (dialog == null || !dialog.isShowing()) {
            View viewInflate = LayoutInflater.from(context).inflate(R$layout.dialog_express_auth, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R$id.express_auth_intro);
            String string = textView.getText().toString();
            String string2 = context.getString(R$string.express_auth_privacy_link);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            int iU0 = La.H.u0(string, string2, 0, false, 6, null);
            if (iU0 >= 0) {
                SpannableString spannableString = new SpannableString(string);
                spannableString.setSpan(new c(context, string2, androidx.core.content.a.c(context, R$color.express_auth_btn_text)), iU0, string2.length() + iU0, 33);
                textView.setText(spannableString);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            final Dialog dialog2 = new Dialog(context, R$style.ChatBaseTheme_Transparent_Dialog);
            dialog2.setContentView(viewInflate);
            dialog2.setCanceledOnTouchOutside(false);
            dialog2.setCancelable(false);
            ((TextView) viewInflate.findViewById(R$id.express_auth_refuse)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.manager.F
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AuthManager.n1(dialog2, onRefuse, view);
                }
            });
            ((TextView) viewInflate.findViewById(R$id.express_auth_agree)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.manager.G
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AuthManager.o1(dialog2, onAgree, view);
                }
            });
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.ailauncher.chat.manager.H
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AuthManager.p1(dialog2, onDismiss, dialogInterface);
                }
            });
            Window window = dialog2.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setLayout(-1, -1);
                window.setWindowAnimations(R$style.PrivacyAllDialogAnim);
            }
            expressAuthDialog = dialog2;
            if (!i1(dialog2, "express")) {
                K1(dialog2);
                expressAuthDialog = null;
                return;
            }
            H1(dialog2, "auth_express", context);
            View viewFindViewById = viewInflate.findViewById(R$id.express_auth_card);
            if (viewFindViewById != null) {
                viewFindViewById.startAnimation(AnimationUtils.loadAnimation(context, R$anim.slide_up));
            }
        }
    }

    public final String k0() {
        String strK;
        try {
            strK = com.stepos.ailauncher.foundation.account.f.INSTANCE.k();
        } catch (Throwable unused) {
        }
        if (strK.length() > 0) {
            return strK;
        }
        return null;
    }

    public final Context l0(Context context) {
        return context instanceof Activity ? context : new ContextThemeWrapper(context, R$style.ChatBaseTheme);
    }

    public final void m0() {
        Y8.t tVar;
        List<Dialog> listP = C1173v.p(agentOpenDialog, agentConfigDialog, privacyAuthDialog, loginHintDialog, expressAuthDialog);
        agentOpenDialog = null;
        agentConfigDialog = null;
        privacyAuthDialog = null;
        loginHintDialog = null;
        expressAuthDialog = null;
        for (Dialog dialog : listP) {
            INSTANCE.K1(dialog);
            try {
                Result.Companion companion = Result.INSTANCE;
                if (dialog != null) {
                    dialog.dismiss();
                    tVar = Y8.t.f7040a;
                } else {
                    tVar = null;
                }
                Result.b(tVar);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        M0();
    }

    public final void n0() {
        stepos.support.v7.app.c cVar;
        Object objB;
        if (com.stepos.ailauncher.foundation.account.f.INSTANCE.v() && (cVar = loginHintDialog) != null) {
            if (!cVar.isShowing()) {
                cVar = null;
            }
            if (cVar == null) {
                return;
            }
            loginHintDialog = null;
            K1(cVar);
            try {
                Result.Companion companion = Result.INSTANCE;
                cVar.dismiss();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "dismiss login hint after account login failed", thE);
            }
        }
    }

    public final void o0(List<? extends Dialog> dialogs) {
        Object objB;
        kotlin.jvm.internal.p.i(dialogs, "dialogs");
        Log.i(TAG, "leaving policy viewer: dismiss covered auth dialogs count=" + dialogs.size());
        isNavigatingToPolicy = false;
        for (Dialog dialog : dialogs) {
            if (privacyAuthDialog == dialog) {
                privacyAuthDialog = null;
            }
            if (expressAuthDialog == dialog) {
                expressAuthDialog = null;
            }
            INSTANCE.K1(dialog);
            try {
                Result.Companion companion = Result.INSTANCE;
                dialog.dismiss();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "dismiss policy-covered auth dialog failed", thE);
            }
        }
    }

    public final boolean p0(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        SlaRouter slaRouter = SlaRouter.INSTANCE;
        if (slaRouter.n(context)) {
            return true;
        }
        if (slaRouter.m()) {
            return false;
        }
        h1(context);
        return false;
    }

    public final Activity q0(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
            kotlin.jvm.internal.p.h(context, "getBaseContext(...)");
        }
        return (Activity) context;
    }

    public final void q1(final Context context, final InterfaceC5063a<Y8.t> onLoginSuccess, final InterfaceC5063a<Y8.t> onCancel, final InterfaceC5063a<Y8.t> onLoginStarted) {
        kotlin.jvm.internal.p.i(context, "context");
        com.stepos.ailauncher.foundation.account.f fVar = com.stepos.ailauncher.foundation.account.f.INSTANCE;
        fVar.z(loginHintAccountCallback);
        if (fVar.v()) {
            n0();
            if (onLoginSuccess != null) {
                onLoginSuccess.invoke();
                return;
            }
            return;
        }
        stepos.support.v7.app.c cVar = loginHintDialog;
        if (cVar == null || !cVar.isShowing()) {
            final boolean[] zArr = {false};
            c.a aVar = new c.a(l0(context));
            aVar.t(R$string.login_dialog_title);
            aVar.k(R$string.login_dialog_message);
            aVar.r(R$string.login_dialog_btn, new DialogInterface.OnClickListener() { // from class: com.stepos.ailauncher.chat.manager.w
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    AuthManager.s1(zArr, onLoginStarted, context, onLoginSuccess, dialogInterface, i10);
                }
            });
            aVar.m(R$string.login_dialog_wait, new DialogInterface.OnClickListener() { // from class: com.stepos.ailauncher.chat.manager.x
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    AuthManager.t1(dialogInterface, i10);
                }
            });
            final stepos.support.v7.app.c cVarC = aVar.c();
            cVarC.setCanceledOnTouchOutside(false);
            cVarC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.ailauncher.chat.manager.y
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AuthManager.u1(cVarC, zArr, onCancel, dialogInterface);
                }
            });
            I0(this, cVarC.getWindow(), context, false, false, 12, null);
            loginHintDialog = cVarC;
            kotlin.jvm.internal.p.f(cVarC);
            if (i1(cVarC, "login")) {
                H1(cVarC, "auth_login", context);
                return;
            }
            K1(cVarC);
            loginHintDialog = null;
            if (onCancel != null) {
                onCancel.invoke();
            }
        }
    }

    public final void r0(final Context context) {
        com.stepos.ailauncher.chat.wake.homebar.g.INSTANCE.d(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.E
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AuthManager.s0(context);
            }
        });
    }

    public final void t0(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Y0(context);
    }

    public final boolean u0(TextView widget, Spannable buffer, MotionEvent event) {
        Layout layout;
        if ((event.getAction() != 0 && event.getAction() != 1) || (layout = widget.getLayout()) == null) {
            return false;
        }
        int x10 = (((int) event.getX()) - widget.getTotalPaddingLeft()) + widget.getScrollX();
        int lineForVertical = layout.getLineForVertical((((int) event.getY()) - widget.getTotalPaddingTop()) + widget.getScrollY());
        float f10 = x10;
        if (f10 < layout.getLineLeft(lineForVertical) || f10 > layout.getLineRight(lineForVertical)) {
            return false;
        }
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f10);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) buffer.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
        kotlin.jvm.internal.p.f(clickableSpanArr);
        if (clickableSpanArr.length == 0) {
            return false;
        }
        if (event.getAction() == 1) {
            clickableSpanArr[0].onClick(widget);
        }
        return true;
    }

    public final boolean v0() {
        String strK0 = k0();
        if (strK0 == null) {
            return false;
        }
        return C5009a.b(C5009a.INSTANCE, KEY_AGENT_OPENED + strK0, false, 2, null);
    }

    public final void v1(final Context context, final boolean continueCheck, boolean isCoverApp, final a listener) throws Resources.NotFoundException {
        Context context2;
        kotlin.jvm.internal.p.i(context, "context");
        Dialog dialog = privacyAuthDialog;
        if (dialog == null || !dialog.isShowing()) {
            Context contextL0 = l0(context);
            View viewInflate = LayoutInflater.from(contextL0).inflate(R$layout.dialog_privacy_all, (ViewGroup) null);
            final CheckBox checkBox = (CheckBox) viewInflate.findViewById(R$id.cb_user_agreement);
            final CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R$id.cb_voiceprint);
            final CheckBox checkBox3 = (CheckBox) viewInflate.findViewById(R$id.cb_improvement);
            final CheckBox checkBox4 = (CheckBox) viewInflate.findViewById(R$id.cb_agree_all);
            TextView textView = (TextView) viewInflate.findViewById(R$id.tv_cancel);
            final TextView textView2 = (TextView) viewInflate.findViewById(R$id.tv_confirm);
            final List listP = C1173v.p(checkBox, checkBox2, checkBox3);
            kotlin.jvm.internal.p.f(checkBox);
            W0(context, checkBox);
            kotlin.jvm.internal.p.f(checkBox2);
            W0(context, checkBox2);
            kotlin.jvm.internal.p.f(checkBox3);
            W0(context, checkBox3);
            U0(viewInflate.findViewById(R$id.overlay_cb_user_agreement), checkBox);
            U0(viewInflate.findViewById(R$id.overlay_cb_voiceprint), checkBox2);
            U0(viewInflate.findViewById(R$id.overlay_cb_improvement), checkBox3);
            final Dialog dialog2 = new Dialog(contextL0, R$style.ChatBaseTheme_Transparent_Dialog);
            dialog2.setContentView(viewInflate);
            dialog2.setCanceledOnTouchOutside(false);
            final boolean[] zArr = {false};
            checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.stepos.ailauncher.chat.manager.O
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    AuthManager.x1(zArr, listP, checkBox, textView2, compoundButton, z10);
                }
            });
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.stepos.ailauncher.chat.manager.P
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    AuthManager.y1(zArr, checkBox4, listP, checkBox, textView2, compoundButton, z10);
                }
            };
            Iterator it = listP.iterator();
            while (it.hasNext()) {
                ((CheckBox) it.next()).setOnCheckedChangeListener(onCheckedChangeListener);
            }
            D1(checkBox, textView2);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.manager.Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AuthManager.z1(listener, dialog2, view);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.manager.S
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Resources.NotFoundException {
                    AuthManager.A1(checkBox, context, checkBox3, checkBox2, listener, dialog2, continueCheck, view);
                }
            });
            dialog2.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.stepos.ailauncher.chat.manager.T
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    AuthManager.B1(listener, dialogInterface);
                }
            });
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.ailauncher.chat.manager.U
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AuthManager.C1(dialog2, dialogInterface);
                }
            });
            Window window = dialog2.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setLayout(-1, -1);
                window.setDimAmount(0.0f);
                window.setWindowAnimations(R$style.PrivacyAllDialogAnim);
                window.addFlags(Integer.MIN_VALUE);
                window.setNavigationBarColor(0);
                new androidx.core.view.b0(window, window.getDecorView()).d(context.getResources().getBoolean(R$bool.chat_light_status_bar));
                context2 = context;
                I0(INSTANCE, window, context2, isCoverApp, false, 8, null);
            } else {
                context2 = context;
            }
            privacyAuthDialog = dialog2;
            if (!i1(dialog2, "privacy")) {
                K1(dialog2);
                privacyAuthDialog = null;
                return;
            }
            H1(dialog2, "auth_privacy", context2);
            View viewFindViewById = viewInflate.findViewById(R$id.ll_privacy_all_card);
            if (viewFindViewById != null) {
                viewFindViewById.startAnimation(AnimationUtils.loadAnimation(context2, R$anim.slide_up));
            }
        }
    }

    public final boolean w0() {
        List listP = C1173v.p(agentOpenDialog, agentConfigDialog, privacyAuthDialog, loginHintDialog, expressAuthDialog);
        if ((listP instanceof Collection) && listP.isEmpty()) {
            return false;
        }
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            if (INSTANCE.y0((Dialog) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean x0() {
        return U() && Y() && K() && !e0();
    }

    public final boolean y0(Dialog dialog) {
        Window window;
        View decorView;
        if (dialog == null || !dialog.isShowing() || (window = dialog.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return false;
        }
        return decorView.isAttachedToWindow();
    }

    public final boolean z0() {
        return isNavigatingToPolicy;
    }
}
