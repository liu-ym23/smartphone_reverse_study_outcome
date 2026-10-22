package com.stepos.policy.sdk;

import Z2.AbstractC0114a;
import Z2.AbstractC0149x;
import Z2.D0;
import Z2.E0;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import androidx.room.AbstractC0351g;
import androidx.room.C0346b;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.policy.sdk.activity.PolicyWebViewActivity;
import com.stepos.policy.sdk.bean.CustomDeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.PolicyFileDataResultBean;
import com.stepos.policy.sdk.bean.PolicyNewestPathResultBean;
import com.stepos.policy.sdk.bean.PolicyRecordBaseInfo;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.manager.WithdrawalManager;
import com.stepos.policy.sdk.manager.WithdrawalManagerWithoutSecureService;
import com.stepos.policy.sdk.net.PolicySdkRetrofitCreator;
import com.stepos.policy.sdk.util.PolicySdkFileUtils;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkUtil;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.ReadClipboardUtils;
import f1.AbstractC0557a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stepos.support.v7.app.DialogInterfaceC0865j;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002¢\u0006\u0006\bï\u0001\u0010ð\u0001J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0006J+\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u000eJS\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\"\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010\"\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J'\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0007¢\u0006\u0004\b&\u0010'JC\u0010-\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\t0*H\u0007¢\u0006\u0004\b-\u0010.J\u0089\u0001\u0010;\u001a\u0004\u0018\u00010:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004052\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\b;\u0010<JY\u0010=\u001a\u0004\u0018\u00010:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\b=\u0010>JG\u0010@\u001a\u00020?2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b@\u0010AJy\u0010B\u001a\u0004\u0018\u00010:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004052\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\bB\u0010CJI\u0010D\u001a\u0004\u0018\u00010:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\bD\u0010EJy\u0010L\u001a\u0004\u0018\u00010:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004052\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u0010G\u001a\u00020\u00072\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\bL\u0010MJy\u0010Q\u001a\u0004\u0018\u00010?2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004052\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u0010P\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\bQ\u0010RJI\u0010U\u001a\u0004\u0018\u00010:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u00042\u0006\u00109\u001a\u00020TH\u0007¢\u0006\u0004\bU\u0010VJY\u0010Y\u001a\u0004\u0018\u00010:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010W\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u00042\u0006\u00109\u001a\u00020TH\u0007¢\u0006\u0004\bY\u0010ZJy\u0010[\u001a\u0004\u0018\u00010:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004052\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u0010P\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\b[\u0010\\JA\u0010]\u001a\u0004\u0018\u00010:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\b]\u0010^JI\u0010_\u001a\u0004\u0018\u00010?2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\b_\u0010`JI\u0010b\u001a\u0004\u0018\u00010?2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010a\u001a\u00020\f2\u0006\u00101\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\bb\u0010cJq\u0010d\u001a\u0004\u0018\u00010?2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004052\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\bd\u0010eJ7\u0010f\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004052\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u0010P\u001a\u00020\u0004H\u0007¢\u0006\u0004\bf\u0010gJ\u0017\u0010h\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\bh\u0010\u000bJ\u0097\u0001\u0010p\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010i\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u00042\u001a\u0010o\u001a\u0016\u0012\u0004\u0012\u00020m\u0018\u00010lj\n\u0012\u0004\u0012\u00020m\u0018\u0001`n2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004052\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u0010P\u001a\u00020\u00042\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\t0*H\u0007¢\u0006\u0004\bp\u0010qJK\u0010r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\t0*H\u0007¢\u0006\u0004\br\u0010sJ\u0097\u0001\u0010t\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010i\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u00042\u001a\u0010o\u001a\u0016\u0012\u0004\u0012\u00020m\u0018\u00010lj\n\u0012\u0004\u0012\u00020m\u0018\u0001`n2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004052\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u0010P\u001a\u00020\u00042\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\t0*H\u0007¢\u0006\u0004\bt\u0010qJO\u0010u\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004052\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u0010P\u001a\u00020\u0004H\u0007¢\u0006\u0004\bu\u0010vJ\u0093\u0001\u0010z\u001a\u0004\u0018\u00010:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u00072\u000e\u0010w\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001052\u000e\u0010x\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001052\u0006\u00101\u001a\u00020\u00042\b\u0010y\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004052\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u00109\u001a\u00020TH\u0007¢\u0006\u0004\bz\u0010{Jc\u0010|\u001a\u0004\u0018\u00010:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u00072\u000e\u0010w\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001052\u000e\u0010x\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001052\u0006\u00101\u001a\u00020\u00042\b\u0010y\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020H2\u0006\u00109\u001a\u00020TH\u0007¢\u0006\u0004\b|\u0010}J^\u0010\u0080\u0001\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010~\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u007f\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\t0*H\u0007¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\"\u0010\u0082\u0001\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0004H\u0007¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\"\u0010\u0084\u0001\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0004H\u0007¢\u0006\u0006\b\u0084\u0001\u0010\u0083\u0001J1\u0010\u0086\u0001\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00022\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u0004H\u0087@ø\u0001\u0000¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J*\u0010\u0088\u0001\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0004H\u0007¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J2\u0010\u008a\u0001\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0007¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J*\u0010\u008c\u0001\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0004H\u0007¢\u0006\u0006\b\u008c\u0001\u0010\u0089\u0001J^\u0010\u008f\u0001\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u007f\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\t0*H\u0007¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\\\u0010\u0091\u0001\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u007f\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010\u008e\u0001\u001a\u00030\u008d\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0*H\u0007¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001JT\u0010\u0094\u0001\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u007f\u001a\u00020\u00042\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u008d\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0*H\u0007¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J4\u0010\u0096\u0001\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\b\u0010\u008e\u0001\u001a\u00030\u008d\u00012\u0006\u0010\u007f\u001a\u00020\u0004H\u0007¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J7\u0010\u0099\u0001\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0004H\u0082@ø\u0001\u0000¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J-\u0010\u009e\u0001\u001a\u00020\t2\u0007\u0010\u009b\u0001\u001a\u00020\u00022\u0007\u0010\u009c\u0001\u001a\u00020\u00042\u0007\u0010\u009d\u0001\u001a\u00020\fH\u0007¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001Jn\u0010£\u0001\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\u0007\u0010\u009c\u0001\u001a\u00020\u00042\u0007\u0010\u009d\u0001\u001a\u00020\f28\u0010,\u001a4\u0012*\u0012(\u0012\u0004\u0012\u00020m\u0018\u00010lj\n\u0012\u0004\u0012\u00020m\u0018\u0001`n¢\u0006\u000f\b \u0001\u0012\n\b¡\u0001\u0012\u0005\b\b(¢\u0001\u0012\u0004\u0012\u00020\t0*H\u0007¢\u0006\u0006\b£\u0001\u0010¤\u0001Jk\u0010§\u0001\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0019\u0010¦\u0001\u001a\u0014\u0012\u0005\u0012\u00030¥\u00010lj\t\u0012\u0005\u0012\u00030¥\u0001`n24\u0010,\u001a0\u0012&\u0012$\u0012\u0004\u0012\u00020m0lj\b\u0012\u0004\u0012\u00020m`n¢\u0006\u000f\b \u0001\u0012\n\b¡\u0001\u0012\u0005\b\b(¢\u0001\u0012\u0004\u0012\u00020\t0*H\u0007¢\u0006\u0006\b§\u0001\u0010¨\u0001Jk\u0010ª\u0001\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0019\u0010¦\u0001\u001a\u0014\u0012\u0005\u0012\u00030©\u00010lj\t\u0012\u0005\u0012\u00030©\u0001`n24\u0010,\u001a0\u0012&\u0012$\u0012\u0004\u0012\u00020m0lj\b\u0012\u0004\u0012\u00020m`n¢\u0006\u000f\b \u0001\u0012\n\b¡\u0001\u0012\u0005\b\b(¢\u0001\u0012\u0004\u0012\u00020\t0*H\u0007¢\u0006\u0006\bª\u0001\u0010¨\u0001J\u001a\u0010«\u0001\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0006\b«\u0001\u0010¬\u0001J#\u0010®\u0001\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0007\u0010\u00ad\u0001\u001a\u00020\fH\u0007¢\u0006\u0006\b®\u0001\u0010¯\u0001J-\u0010±\u0001\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00042\t\u0010°\u0001\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0006\b±\u0001\u0010²\u0001J\"\u0010³\u0001\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0006\b³\u0001\u0010´\u0001JP\u0010µ\u0001\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u007f\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0*H\u0007¢\u0006\u0006\bµ\u0001\u0010¶\u0001JE\u0010·\u0001\u001a\u0012\u0012\u0004\u0012\u00020m0lj\b\u0012\u0004\u0012\u00020m`n2\u0006\u0010\u0003\u001a\u00020\u00022\u0019\u0010¦\u0001\u001a\u0014\u0012\u0005\u0012\u00030©\u00010lj\t\u0012\u0005\u0012\u00030©\u0001`nH\u0007¢\u0006\u0006\b·\u0001\u0010¸\u0001R\u001d\u0010º\u0001\u001a\u00030¹\u00018\u0006¢\u0006\u0010\n\u0006\bº\u0001\u0010»\u0001\u001a\u0006\b¼\u0001\u0010½\u0001R)\u0010¾\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¾\u0001\u0010¿\u0001\u001a\u0006\bÀ\u0001\u0010Á\u0001\"\u0006\bÂ\u0001\u0010Ã\u0001R)\u0010Ä\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÄ\u0001\u0010¿\u0001\u001a\u0006\bÅ\u0001\u0010Á\u0001\"\u0006\bÆ\u0001\u0010Ã\u0001R)\u0010Ç\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÇ\u0001\u0010¿\u0001\u001a\u0006\bÈ\u0001\u0010Á\u0001\"\u0006\bÉ\u0001\u0010Ã\u0001R)\u0010Ê\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÊ\u0001\u0010¿\u0001\u001a\u0006\bË\u0001\u0010Á\u0001\"\u0006\bÌ\u0001\u0010Ã\u0001R)\u0010Í\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÍ\u0001\u0010Î\u0001\u001a\u0006\bÏ\u0001\u0010Ð\u0001\"\u0006\bÑ\u0001\u0010Ò\u0001R5\u0010Ó\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÓ\u0001\u0010Ô\u0001\u001a\u0006\bÕ\u0001\u0010Ö\u0001\"\u0006\b×\u0001\u0010Ø\u0001R\u001d\u0010Ù\u0001\u001a\u00030¹\u00018\u0006¢\u0006\u0010\n\u0006\bÙ\u0001\u0010»\u0001\u001a\u0006\bÚ\u0001\u0010½\u0001R)\u0010Û\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÛ\u0001\u0010¿\u0001\u001a\u0006\bÜ\u0001\u0010Á\u0001\"\u0006\bÝ\u0001\u0010Ã\u0001R)\u0010Þ\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÞ\u0001\u0010¿\u0001\u001a\u0006\bß\u0001\u0010Á\u0001\"\u0006\bà\u0001\u0010Ã\u0001R)\u0010á\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bá\u0001\u0010¿\u0001\u001a\u0006\bâ\u0001\u0010Á\u0001\"\u0006\bã\u0001\u0010Ã\u0001R)\u0010ä\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bä\u0001\u0010¿\u0001\u001a\u0006\bå\u0001\u0010Á\u0001\"\u0006\bæ\u0001\u0010Ã\u0001R)\u0010ç\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bç\u0001\u0010Î\u0001\u001a\u0006\bè\u0001\u0010Ð\u0001\"\u0006\bé\u0001\u0010Ò\u0001R\u001d\u0010ë\u0001\u001a\u00030ê\u00018\u0006¢\u0006\u0010\n\u0006\bë\u0001\u0010ì\u0001\u001a\u0006\bí\u0001\u0010î\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006ñ\u0001"}, d2 = {"Lcom/stepos/policy/sdk/PolicyManager;", "", "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "", "getPolicyOperateJson", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getPolicyOperate", "", "saveReadClipboardStatus", "(Landroid/content/Context;)V", "", "getReadClipboardStatus", "(Landroid/content/Context;)I", "status", "saveAgreeStatus", "(Landroid/content/Context;I)V", "getAgreeStatus", "LV/f;", "dataStoreKey", "getDataStoreString", "(Landroid/content/Context;LV/f;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSecureServiceVersionCode", "appId", "appSecret", "versionName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "policyCategoryMap", "initSDK", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "isOperateSuccess", "operateJson", "savePolicyOperate", "(Landroid/content/Context;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "category", "toPath", "copyPolicyFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;", "policyRecordRequest", "Lkotlin/Function1;", "Lcom/stepos/policy/sdk/bean/PolicySdkResultBean;", "callBackPolicyResult", "uploadPolicyOperateRecord", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;Lkotlin/jvm/functions/Function1;)V", "methodType", "secondaryConfirmation", "title", "userPrivacyPolicyName", "userCategory", "privacyPolicyName", "", "categoryList", "userId", "Lstepos/support/v7/app/S;", "permissionDialogClickListener", "Lstepos/support/v7/app/j;", "showReGrantTwoPolicyDialogAndUploadRecord", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/S;)Lstepos/support/v7/app/j;", "showReGrantTwoPolicyDialog", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/S;)Lstepos/support/v7/app/j;", "Lstepos/support/v7/app/U;", "createReGrantDialogBuilder", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/S;)Lstepos/support/v7/app/U;", "showReGrantDialogAndUploadRecord", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/S;)Lstepos/support/v7/app/j;", "showReGrantDialog", "(Landroid/content/Context;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/S;)Lstepos/support/v7/app/j;", "dialogTitle", "isRecord", "", "customTerms", "btnNegative", "btnPositive", "showNewestDialogAndUploadRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;ZLjava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/S;)Lstepos/support/v7/app/j;", "customNegativeButtonText", "customPositiveButtonText", "operationType", "showDialogUploadRecordBuilder", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/S;)Lstepos/support/v7/app/U;", "checkButtonMessage", "Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;", "showWithdrawalAndCleanServiceDataDialog", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;)Lstepos/support/v7/app/j;", "hasLogin", "secondCheckButtonMessage", "showWithdrawalAndCleanServiceDataDialogByAccount", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;)Lstepos/support/v7/app/j;", "showDialogByCustomViewAndUploadRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/S;)Lstepos/support/v7/app/j;", "showDialogByCustomView", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/S;)Lstepos/support/v7/app/j;", "showDialogByCustomViewBuilder", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/S;)Lstepos/support/v7/app/U;", "theme", "showDialogByCustomThemeViewBuilder", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/S;)Lstepos/support/v7/app/U;", "showDialogByCustomViewBuilderRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lstepos/support/v7/app/S;)Lstepos/support/v7/app/U;", "createRecordRequest", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;", "reTryUploadRecord", Constants.JSON_KEY_SERVICE_NAME, "validateCode", "verifyType", "Ljava/util/ArrayList;", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "Lkotlin/collections/ArrayList;", "deleteInfoBeanList", "uploadRecordWithoutSecureService", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "uploadRecordByCustomRecordRequest", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;Lkotlin/jvm/functions/Function1;)V", "uploadRecordToCleanServiceData", "autoUploadRecord", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "permissionKey", "permissionSummary", "reminder", "showCustomPolicyDialogAndUploadRecord", "(Landroid/content/Context;Z[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;)Lstepos/support/v7/app/j;", "showCustomPolicyDialog", "(Landroid/content/Context;Z[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/stepos/policy/sdk/dialog/PolicyPermissionDialogBuilder$OnPermissionClickListener;)Lstepos/support/v7/app/j;", "isAutoRecord", "language", "checkNewestPolicy", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getPolicyNewestPathByCustom", "(Landroid/content/Context;Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicySdkResultBean;", "getPolicyNewestPath", "localPath", "initPolicyNewestPath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openPolicyDataByWebView", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicySdkResultBean;", "openPolicyMethod", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)Lcom/stepos/policy/sdk/bean/PolicySdkResultBean;", "openPolicyDataByBrowser", "", Constants.JSON_KEY_VERSION, "getPolicyData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getPolicyHistoryList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "versionId", "getPolicyByVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getPolicyHistoryUrl", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)Ljava/lang/String;", "dataStoreValue", "saveDataStoreString", "(Landroid/content/Context;LV/f;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mContext", "businessType", "deleteType", "getCommonDeleteInfoList", "(Landroid/content/Context;Ljava/lang/String;I)V", "Lkotlin/ParameterName;", "name", "deleteInfoBean", "getPrivateDeleteInfoList", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "Lcom/stepos/policy/sdk/bean/CustomDeleteInfoBean;", "customDeleteInfoList", "encryptCustomDeleteInfoListBySecure", "(Landroid/content/Context;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "Lcom/stepos/policy/sdk/bean/DeleteInfoEncryptMultiBean;", "encryptMultiDeleteListBySecure", "isSupportSecureService31", "(Landroid/content/Context;)Z", Constants.JSON_KEY_VERSION_CODE, "isSupportSecureService", "(Landroid/content/Context;I)Z", "md5", "saveLocalCategoryMd5", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "getLocalCategoryMd5", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "getPolicyServiceConfig", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "encryptDeleteInfoWithoutSecureService", "(Landroid/content/Context;Ljava/util/ArrayList;)Ljava/util/ArrayList;", "LZ2/F;", "lifecycleScope", "LZ2/F;", "getLifecycleScope", "()LZ2/F;", "mAppId", "Ljava/lang/String;", "getMAppId", "()Ljava/lang/String;", "setMAppId", "(Ljava/lang/String;)V", "mAppSecret", "getMAppSecret", "setMAppSecret", "mAppVersionName", "getMAppVersionName", "setMAppVersionName", "customPolicyCSSFileName", "getCustomPolicyCSSFileName", "setCustomPolicyCSSFileName", "syncLocalFileFinished", "Z", "getSyncLocalFileFinished", "()Z", "setSyncLocalFileFinished", "(Z)V", "localAssetsCategoryPathMap", "Ljava/util/HashMap;", "getLocalAssetsCategoryPathMap", "()Ljava/util/HashMap;", "setLocalAssetsCategoryPathMap", "(Ljava/util/HashMap;)V", Action.SCOPE_ATTRIBUTE, "getScope", "companyCode", "getCompanyCode", "setCompanyCode", "brand", "getBrand", "setBrand", "model", "getModel", "setModel", "osVersion", "getOsVersion", "setOsVersion", "initSDKByDeviceProtectedStorageContext", "getInitSDKByDeviceProtectedStorageContext", "setInitSDKByDeviceProtectedStorageContext", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "<init>", "()V", "policysdk_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPolicyManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PolicyManager.kt\ncom/stepos/policy/sdk/PolicyManager\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,2422:1\n47#2:2423\n49#2:2427\n47#2:2428\n49#2:2432\n47#2:2433\n49#2:2437\n47#2:2439\n49#2:2443\n50#3:2424\n55#3:2426\n50#3:2429\n55#3:2431\n50#3:2434\n55#3:2436\n50#3:2440\n55#3:2442\n106#4:2425\n106#4:2430\n106#4:2435\n106#4:2441\n1#5:2438\n49#6,4:2444\n*S KotlinDebug\n*F\n+ 1 PolicyManager.kt\ncom/stepos/policy/sdk/PolicyManager\n*L\n182#1:2423\n182#1:2427\n192#1:2428\n192#1:2432\n250#1:2433\n250#1:2437\n2146#1:2439\n2146#1:2443\n182#1:2424\n182#1:2426\n192#1:2429\n192#1:2431\n250#1:2434\n250#1:2436\n2146#1:2440\n2146#1:2442\n182#1:2425\n192#1:2430\n250#1:2435\n2146#1:2441\n275#1:2444,4\n*E\n"})
/* loaded from: classes.dex */
public final class PolicyManager {

    @NotNull
    public static final PolicyManager INSTANCE = new PolicyManager();

    @NotNull
    private static String brand;

    @NotNull
    private static String companyCode;

    @NotNull
    private static String customPolicyCSSFileName;

    @NotNull
    private static final CoroutineExceptionHandler exceptionHandler;
    private static boolean initSDKByDeviceProtectedStorageContext;

    @NotNull
    private static final Z2.F lifecycleScope;

    @NotNull
    private static HashMap<String, String> localAssetsCategoryPathMap;

    @NotNull
    private static String mAppId;

    @NotNull
    private static String mAppSecret;

    @NotNull
    private static String mAppVersionName;

    @NotNull
    private static String model;

    @NotNull
    private static String osVersion;

    @NotNull
    private static final Z2.F scope;
    private static boolean syncLocalFileFinished;

    static {
        E0 e0B = Z2.I.b();
        f3.d dVar = Z2.Q.f2189a;
        lifecycleScope = new d3.f(CoroutineContext.Element.DefaultImpls.plus(e0B, d3.q.f12477a));
        mAppId = "";
        mAppSecret = "";
        mAppVersionName = "";
        customPolicyCSSFileName = "";
        localAssetsCategoryPathMap = new HashMap<>();
        scope = Z2.G.a(CoroutineContext.Element.DefaultImpls.plus(Z2.I.b(), Z2.Q.f2190b));
        String channelToBrand = PolicySdkToolsUtils.INSTANCE.getChannelToBrand();
        companyCode = channelToBrand;
        brand = channelToBrand;
        model = "";
        osVersion = "";
        exceptionHandler = new S(Z2.B.f2163a);
    }

    private PolicyManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, com.stepos.policy.sdk.bean.PolicyRecordRequest] */
    @JvmStatic
    public static final void autoUploadRecord(@NotNull Context context, @NotNull String appId, @NotNull String appSecret, @NotNull String versionName, @NotNull String[] categoryList, @Nullable String userId, @NotNull String operationType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        Intrinsics.checkNotNullParameter(operationType, "operationType");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = createRecordRequest(context, categoryList, userId, operationType);
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            uploadPolicyOperateRecord(appId, appSecret, versionName, (PolicyRecordRequest) objectRef.element, new C0346b(3, objectRef, context));
            return;
        }
        CoroutineContext coroutineContext = exceptionHandler;
        C0517p c0517p = new C0517p(objectRef, context, null, 1);
        if ((2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContextA = AbstractC0149x.a(EmptyCoroutineContext.INSTANCE, coroutineContext, true);
        f3.d dVar = Z2.Q.f2189a;
        if (coroutineContextA != dVar && coroutineContextA.get(ContinuationInterceptor.INSTANCE) == null) {
            coroutineContextA = coroutineContextA.plus(dVar);
        }
        AbstractC0114a d02 = new D0(coroutineContextA, true);
        d02.Z(1, d02, c0517p);
    }

    @JvmStatic
    public static final void checkNewestPolicy(@NotNull Context context, boolean isAutoRecord, @NotNull String appId, @NotNull String appSecret, @NotNull String language, @NotNull String category, @NotNull String versionName, @NotNull Function1<? super PolicySdkResultBean, Unit> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        CoroutineContext coroutineContext = exceptionHandler;
        D d4 = new D(context, category, isAutoRecord, appId, appSecret, callBackPolicyResult, versionName, language, null);
        if ((2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContextA = AbstractC0149x.a(EmptyCoroutineContext.INSTANCE, coroutineContext, true);
        f3.d dVar = Z2.Q.f2189a;
        if (coroutineContextA != dVar && coroutineContextA.get(ContinuationInterceptor.INSTANCE) == null) {
            coroutineContextA = coroutineContextA.plus(dVar);
        }
        AbstractC0114a d02 = new D0(coroutineContextA, true);
        d02.Z(1, d02, d4);
    }

    @JvmStatic
    @NotNull
    public static final String copyPolicyFile(@NotNull Context context, @NotNull String category, @NotNull String toPath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(toPath, "toPath");
        PolicySdkFileUtils.Companion companion = PolicySdkFileUtils.INSTANCE;
        PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = companion.isNewestPolicyFileIsExists(context, category);
        PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
        companion2.d("copyPolicyFile", "policyNewestPathResultBean.isExists = " + policyNewestPathResultBeanIsNewestPolicyFileIsExists.getIsExists());
        String strCopyPolicyFile = policyNewestPathResultBeanIsNewestPolicyFileIsExists.getIsExists() ? companion.copyPolicyFile(policyNewestPathResultBeanIsNewestPolicyFileIsExists.getNewestPolicyPath(), toPath) : "";
        companion2.d("copyPolicyFile", "successPath = " + strCopyPolicyFile);
        return strCopyPolicyFile;
    }

    private final stepos.support.v7.app.U createReGrantDialogBuilder(Context context, boolean methodType, boolean secondaryConfirmation, String title, String privacyPolicyName, String category, stepos.support.v7.app.S permissionDialogClickListener) {
        stepos.support.v7.app.U u4 = new stepos.support.v7.app.U(context);
        u4.f14349m = privacyPolicyName;
        u4.f14339c = title;
        u4.f14346j = permissionDialogClickListener;
        u4.f14348l = secondaryConfirmation;
        u4.f14342f = new ViewOnClickListenerC0515n(context, methodType, privacyPolicyName, category, 0);
        return u4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createReGrantDialogBuilder$lambda$6(Context context, boolean z4, String privacyPolicyName, String category, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(privacyPolicyName, "$privacyPolicyName");
        Intrinsics.checkNotNullParameter(category, "$category");
        openPolicyMethod(context, z4, privacyPolicyName, category);
    }

    @JvmStatic
    @NotNull
    public static final PolicyRecordRequest createRecordRequest(@NotNull Context context, @NotNull String[] categoryList, @Nullable String userId, @NotNull String operationType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        Intrinsics.checkNotNullParameter(operationType, "operationType");
        String androidId = Settings.System.getString(context.getContentResolver(), "android_id");
        PolicyRecordRequest policyRecordRequest = new PolicyRecordRequest();
        Intrinsics.checkNotNullExpressionValue(androidId, "androidId");
        policyRecordRequest.setBusinessId(androidId);
        policyRecordRequest.setType("phone");
        if (userId != null) {
            policyRecordRequest.setUseId(userId);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : categoryList) {
            PolicyRecordBaseInfo policyRecordBaseInfo = new PolicyRecordBaseInfo(null, null, null, 7, null);
            policyRecordBaseInfo.setVersion(PolicySdkFileUtils.INSTANCE.getPolicyVersion(context, str));
            policyRecordBaseInfo.setCategory(str);
            arrayList.add(policyRecordBaseInfo);
        }
        policyRecordRequest.setBaseInfoList(arrayList);
        policyRecordRequest.setOperation(operationType);
        return policyRecordRequest;
    }

    @JvmStatic
    public static final void encryptCustomDeleteInfoListBySecure(@NotNull Context context, @NotNull ArrayList<CustomDeleteInfoBean> customDeleteInfoList, @NotNull Function1<? super ArrayList<DeleteInfoBean>, Unit> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customDeleteInfoList, "customDeleteInfoList");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        WithdrawalManager.INSTANCE.encryptCustomDeleteInfoListBySecure(context, customDeleteInfoList, new F(new ArrayList(), customDeleteInfoList, callBackPolicyResult, 0));
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<DeleteInfoBean> encryptDeleteInfoWithoutSecureService(@NotNull Context context, @NotNull ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customDeleteInfoList, "customDeleteInfoList");
        return WithdrawalManagerWithoutSecureService.INSTANCE.getEncryptByDeleteInfoList(context, customDeleteInfoList);
    }

    @JvmStatic
    public static final void encryptMultiDeleteListBySecure(@NotNull Context context, @NotNull ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList, @NotNull Function1<? super ArrayList<DeleteInfoBean>, Unit> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customDeleteInfoList, "customDeleteInfoList");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        WithdrawalManager.INSTANCE.encryptMultiCustomDeleteInfoListBySecure(context, customDeleteInfoList, new F(new ArrayList(), customDeleteInfoList, callBackPolicyResult, 1));
    }

    @JvmStatic
    public static final void getCommonDeleteInfoList(@NotNull Context mContext, @NotNull String businessType, int deleteType) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        WithdrawalManager.INSTANCE.getCommonDeleteInfoListBySecure(mContext, businessType, deleteType, new S.s(4, (Context) new WeakReference(mContext.getApplicationContext()).get()));
    }

    private final String getLocalCategoryMd5(Context context, String category) {
        return (String) t0.J.M(new C0517p(context, category, null));
    }

    @JvmStatic
    public static final void getPolicyByVersion(@NotNull String appId, @NotNull String appSecret, @NotNull String language, @Nullable Long versionId, @Nullable String versionName, @NotNull Function1<? super PolicySdkResultBean, PolicySdkResultBean> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        CoroutineContext coroutineContext = exceptionHandler;
        c0 c0Var = new c0(versionId, versionName, appId, appSecret, callBackPolicyResult, language, null);
        if ((2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContextA = AbstractC0149x.a(EmptyCoroutineContext.INSTANCE, coroutineContext, true);
        f3.d dVar = Z2.Q.f2189a;
        if (coroutineContextA != dVar && coroutineContextA.get(ContinuationInterceptor.INSTANCE) == null) {
            coroutineContextA = coroutineContextA.plus(dVar);
        }
        AbstractC0114a d02 = new D0(coroutineContextA, true);
        d02.Z(1, d02, c0Var);
    }

    @JvmStatic
    public static final void getPolicyData(@NotNull String appId, @NotNull String appSecret, @NotNull String language, @Nullable String category, @Nullable Long version, @Nullable String versionName, @NotNull Function1<? super PolicySdkResultBean, Unit> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        CoroutineContext coroutineContext = exceptionHandler;
        g0 g0Var = new g0(category, version, versionName, appId, appSecret, callBackPolicyResult, language, null);
        if ((2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContextA = AbstractC0149x.a(EmptyCoroutineContext.INSTANCE, coroutineContext, true);
        f3.d dVar = Z2.Q.f2189a;
        if (coroutineContextA != dVar && coroutineContextA.get(ContinuationInterceptor.INSTANCE) == null) {
            coroutineContextA = coroutineContextA.plus(dVar);
        }
        AbstractC0114a d02 = new D0(coroutineContextA, true);
        d02.Z(1, d02, g0Var);
    }

    @JvmStatic
    public static final void getPolicyHistoryList(@NotNull String appId, @NotNull String appSecret, @NotNull String language, @Nullable String category, long version, @Nullable String versionName, @NotNull Function1<? super PolicySdkResultBean, PolicySdkResultBean> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        CoroutineContext coroutineContext = exceptionHandler;
        k0 k0Var = new k0(category, versionName, appId, appSecret, callBackPolicyResult, language, version, null);
        if ((2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContextA = AbstractC0149x.a(EmptyCoroutineContext.INSTANCE, coroutineContext, true);
        f3.d dVar = Z2.Q.f2189a;
        if (coroutineContextA != dVar && coroutineContextA.get(ContinuationInterceptor.INSTANCE) == null) {
            coroutineContextA = coroutineContextA.plus(dVar);
        }
        AbstractC0114a d02 = new D0(coroutineContextA, true);
        d02.Z(1, d02, k0Var);
    }

    @JvmStatic
    @NotNull
    public static final String getPolicyHistoryUrl(@NotNull String appId, @NotNull String category, long version, @NotNull String language) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(language, "language");
        StringBuilder sb = new StringBuilder("https://policy-h5.stepos.com/?appId=");
        AbstractC0351g.C(sb, appId, "&category=", category, "&version=");
        sb.append(version);
        sb.append("&language=");
        sb.append(language);
        String string = sb.toString();
        PolicySdkLogUtils.INSTANCE.d("getPolicyHistoryUrl", string);
        return string;
    }

    @JvmStatic
    @NotNull
    public static final PolicySdkResultBean getPolicyNewestPath(@NotNull Context context, @NotNull String category) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(category, "category");
        PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
        PolicySdkFileUtils.Companion companion = PolicySdkFileUtils.INSTANCE;
        PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = companion.isNewestPolicyFileIsExists(context, category);
        PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
        companion2.d("getNewestPolicyPath", "getNewestPolicyPath");
        companion2.d("getNewestPolicyPath", " policyNewestPathResultBean.isExists " + policyNewestPathResultBeanIsNewestPolicyFileIsExists + ".isExists");
        if (!policyNewestPathResultBeanIsNewestPolicyFileIsExists.getIsExists()) {
            policySdkResultBean.setCode(-1);
            return policySdkResultBean;
        }
        policySdkResultBean.setPolicyNewestPath(companion.renameFileNameByMd5(policyNewestPathResultBeanIsNewestPolicyFileIsExists.getNewestPolicyPath()));
        companion2.d("getNewestPolicyPath", " policyNewestPath result= " + policySdkResultBean.getPolicyNewestPath());
        try {
            String name = new File(policySdkResultBean.getPolicyNewestPath()).getName();
            Intrinsics.checkNotNullExpressionValue(name, "myFile.name");
            PolicyFileDataResultBean policyDataFromFileName = companion.getPolicyDataFromFileName(name);
            Long lValueOf = policyDataFromFileName != null ? Long.valueOf(policyDataFromFileName.getVersion()) : null;
            policySdkResultBean.setCode(0);
            if (lValueOf != null) {
                policySdkResultBean.setPolicyNewestVersion(lValueOf.longValue());
            }
        } catch (Exception unused) {
            policySdkResultBean.setCode(-1);
        }
        return policySdkResultBean;
    }

    @JvmStatic
    @NotNull
    public static final PolicySdkResultBean getPolicyNewestPathByCustom(@NotNull Context context, @NotNull String category) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(category, "category");
        PolicySdkLogUtils.INSTANCE.d("getPolicyNewestPathByCustom", " initSDKByDeviceProtectedStorageContext= " + initSDKByDeviceProtectedStorageContext);
        if (initSDKByDeviceProtectedStorageContext) {
            context = context.createDeviceProtectedStorageContext();
            Intrinsics.checkNotNullExpressionValue(context, "context.createDeviceProtectedStorageContext()");
        }
        return getPolicyNewestPath(context, category);
    }

    @JvmStatic
    public static final void getPolicyServiceConfig(@NotNull Context context, @NotNull String appId, @NotNull String appSecret, @NotNull String language, @Nullable String versionName, @NotNull Function1<? super PolicySdkResultBean, PolicySdkResultBean> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        CoroutineContext coroutineContext = exceptionHandler;
        C0509h c0509h = new C0509h(versionName, appId, appSecret, callBackPolicyResult, language, context, null);
        if ((2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContextA = AbstractC0149x.a(EmptyCoroutineContext.INSTANCE, coroutineContext, true);
        f3.d dVar = Z2.Q.f2189a;
        if (coroutineContextA != dVar && coroutineContextA.get(ContinuationInterceptor.INSTANCE) == null) {
            coroutineContextA = coroutineContextA.plus(dVar);
        }
        AbstractC0114a d02 = new D0(coroutineContextA, true);
        d02.Z(1, d02, c0509h);
    }

    @JvmStatic
    public static final void getPrivateDeleteInfoList(@NotNull Context context, @NotNull String appId, @NotNull String businessType, int deleteType, @NotNull Function1<? super ArrayList<DeleteInfoBean>, Unit> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        WithdrawalManager.INSTANCE.getPrivateDeleteInfoListBySecure(context, appId, businessType, deleteType, new C0510i(callBackPolicyResult));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:11)(2:12|13))(14:14|(5:18|(1:20)(1:21)|22|(1:25)|26)|27|(2:29|(1:31)(1:32))|34|(1:(2:44|45)(3:39|(1:41)|42))(1:46)|43|47|58|48|(1:50)(1:51)|52|(1:54)|57)|33|34|(0)(0)|43|47|58|48|(0)(0)|52|(0)|57) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0150, code lost:
    
        r12.setCode(-1);
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0138 A[Catch: Exception -> 0x0150, TryCatch #0 {Exception -> 0x0150, blocks: (B:48:0x011e, B:50:0x0138, B:52:0x0142, B:54:0x0148), top: B:58:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0148 A[Catch: Exception -> 0x0150, TRY_LEAVE, TryCatch #0 {Exception -> 0x0150, blocks: (B:48:0x011e, B:50:0x0138, B:52:0x0142, B:54:0x0148), top: B:58:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object initPolicyNewestPath(@org.jetbrains.annotations.NotNull android.content.Context r9, @org.jetbrains.annotations.Nullable java.lang.String r10, @org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.stepos.policy.sdk.bean.PolicySdkResultBean> r12) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.initPolicyNewestPath(android.content.Context, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @JvmStatic
    public static final void initSDK(@NotNull Context context, @NotNull String appId, @NotNull String appSecret, @NotNull String versionName, @NotNull HashMap<String, String> policyCategoryMap) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(policyCategoryMap, "policyCategoryMap");
        PolicySdkRetrofitCreator.INSTANCE.init(context);
        mAppId = appId;
        mAppSecret = appSecret;
        mAppVersionName = versionName;
        PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.INSTANCE;
        model = companion.getSystemModel(context);
        osVersion = companion.getSystemVersion(context);
        localAssetsCategoryPathMap = policyCategoryMap;
        PolicySdkLogUtils.INSTANCE.d("initSDK", "policyCategoryMap  = " + policyCategoryMap);
        CoroutineContext coroutineContext = exceptionHandler;
        C0517p c0517p = new C0517p(policyCategoryMap, context, null, 0);
        if ((2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContextA = AbstractC0149x.a(EmptyCoroutineContext.INSTANCE, coroutineContext, true);
        f3.d dVar = Z2.Q.f2189a;
        if (coroutineContextA != dVar && coroutineContextA.get(ContinuationInterceptor.INSTANCE) == null) {
            coroutineContextA = coroutineContextA.plus(dVar);
        }
        AbstractC0114a d02 = new D0(coroutineContextA, true);
        d02.Z(1, d02, c0517p);
    }

    @JvmStatic
    public static final boolean isSupportSecureService(@NotNull Context context, int versionCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.getSecureServiceVersionCode(context) >= versionCode;
    }

    @JvmStatic
    public static final boolean isSupportSecureService31(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            int secureServiceVersionCode = INSTANCE.getSecureServiceVersionCode(context);
            PolicySdkLogUtils.INSTANCE.d(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "com.stepos.secureservice versionCode : " + secureServiceVersionCode + ' ');
            return secureServiceVersionCode >= 11000031;
        } catch (Exception e4) {
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder("exception : ");
            e4.getMessage();
            Unit unit = Unit.INSTANCE;
            sb.append(e4);
            companion.e(com.stepos.alphame.persona.privacy.PolicyManager.TAG, sb.toString());
            return false;
        }
    }

    @JvmStatic
    @SuppressLint({"SuspiciousIndentation"})
    @NotNull
    public static final PolicySdkResultBean openPolicyDataByBrowser(@NotNull Context context, @NotNull String category, @NotNull String title) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(title, "title");
        PolicySdkResultBean policyNewestPathByCustom = getPolicyNewestPathByCustom(context, category);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
        companion.d(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "openPolicyDataByBrowser " + policyNewestPathByCustom.getPolicyNewestPath() + '}');
        if (policyNewestPathByCustom.getCode() == 0) {
            String policyNewestPath = policyNewestPathByCustom.getPolicyNewestPath();
            companion.d(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "openPolicyDataByBrowser policyNewestPath path = " + policyNewestPath + ' ');
            Uri uriForFile = androidx.core.content.g.getUriForFile(context, context.getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath));
            if (uriForFile != null) {
                PolicySdkToolsUtils.INSTANCE.startBrowser(context, uriForFile);
            }
        }
        return policyNewestPathByCustom;
    }

    @JvmStatic
    @SuppressLint({"SuspiciousIndentation"})
    @NotNull
    public static final PolicySdkResultBean openPolicyDataByWebView(@NotNull Context context, @NotNull String category, @NotNull String title) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(title, "title");
        PolicySdkResultBean policyNewestPathByCustom = getPolicyNewestPathByCustom(context, category);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
        companion.d(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "openPolicyDataByWebView " + policyNewestPathByCustom.getPolicyNewestPath() + '}');
        if (policyNewestPathByCustom.getCode() == 0) {
            String policyNewestPath = policyNewestPathByCustom.getPolicyNewestPath();
            Uri uriForFile = androidx.core.content.g.getUriForFile(context, context.getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath));
            companion.d(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "save sucessful path = " + policyNewestPath + ' ');
            String string = uriForFile.toString();
            Intrinsics.checkNotNullExpressionValue(string, "contentUri.toString()");
            if (!syncLocalFileFinished && localAssetsCategoryPathMap.containsKey(category) && localAssetsCategoryPathMap.get(category) != null && !Intrinsics.areEqual("", localAssetsCategoryPathMap.get(category))) {
                string = String.valueOf(localAssetsCategoryPathMap.get(category));
            }
            companion.d("openPolicyDataByWebView", "initSDK syncLocalFileFinished " + syncLocalFileFinished + " |  policyPath = " + string);
            PolicyWebViewActivity.INSTANCE.startWebViewActivity(context, string, title);
        }
        return policyNewestPathByCustom;
    }

    @JvmStatic
    @NotNull
    public static final PolicySdkResultBean openPolicyMethod(@NotNull Context context, boolean methodType, @NotNull String title, @NotNull String category) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(category, "category");
        return methodType ? openPolicyDataByWebView(context, category, title) : openPolicyDataByBrowser(context, category, title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reTryUploadRecord(Context context) {
        CoroutineContext coroutineContext = exceptionHandler;
        r rVar = new r(context, this, null);
        if ((2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContextA = AbstractC0149x.a(EmptyCoroutineContext.INSTANCE, coroutineContext, true);
        f3.d dVar = Z2.Q.f2189a;
        if (coroutineContextA != dVar && coroutineContextA.get(ContinuationInterceptor.INSTANCE) == null) {
            coroutineContextA = coroutineContextA.plus(dVar);
        }
        AbstractC0114a d02 = new D0(coroutineContextA, true);
        d02.Z(1, d02, rVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveDataStoreString(Context context, V.f fVar, String str, Continuation<? super Unit> continuation) {
        PolicySdkLogUtils.INSTANCE.d("saveDataStoreString", AwarenessDataItem.PERMISSION_SPLITTER + fVar + " | dataStoreValue =" + str + ' ');
        Object objR = AbstractC0557a.r(b0.a(context), new C0520t(fVar, str, null), continuation);
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    private final void saveLocalCategoryMd5(Context context, String category, String md5) {
        CoroutineContext coroutineContext = exceptionHandler;
        C0522v c0522v = new C0522v(context, category, md5, null);
        if ((2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContextA = AbstractC0149x.a(EmptyCoroutineContext.INSTANCE, coroutineContext, true);
        f3.d dVar = Z2.Q.f2189a;
        if (coroutineContextA != dVar && coroutineContextA.get(ContinuationInterceptor.INSTANCE) == null) {
            coroutineContextA = coroutineContextA.plus(dVar);
        }
        AbstractC0114a d02 = new D0(coroutineContextA, true);
        d02.Z(1, d02, c0522v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object savePolicyOperate(android.content.Context r7, boolean r8, java.lang.String r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.stepos.policy.sdk.C0523w
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.policy.sdk.w r0 = (com.stepos.policy.sdk.C0523w) r0
            int r1 = r0.f12280f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12280f = r1
            goto L18
        L13:
            com.stepos.policy.sdk.w r0 = new com.stepos.policy.sdk.w
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r6 = r0.f12278d
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.f12280f
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L3f
            if (r1 == r3) goto L35
            if (r1 != r2) goto L2d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L97
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            boolean r8 = r0.f12277c
            java.lang.String r9 = r0.f12276b
            android.content.Context r7 = r0.f12275a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L77
        L3f:
            kotlin.ResultKt.throwOnFailure(r6)
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r5 = "isOperateSuccess ="
            r1.<init>(r5)
            r1.append(r8)
            java.lang.String r5 = " |operateJson = "
            r1.append(r5)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = "savePolicyOperate"
            r6.d(r5, r1)
            S.i r6 = com.stepos.policy.sdk.b0.a(r7)
            com.stepos.policy.sdk.y r1 = new com.stepos.policy.sdk.y
            r1.<init>(r8, r4)
            r0.f12275a = r7
            r0.f12276b = r9
            r0.f12277c = r8
            r0.f12280f = r3
            java.lang.Object r6 = f1.AbstractC0557a.r(r6, r1, r0)
            if (r6 != r10) goto L77
            return r10
        L77:
            if (r8 != 0) goto L9a
            if (r9 == 0) goto L9a
            int r6 = r9.length()
            if (r6 <= 0) goto L9a
            S.i r6 = com.stepos.policy.sdk.b0.a(r7)
            com.stepos.policy.sdk.z r7 = new com.stepos.policy.sdk.z
            r7.<init>(r9, r4)
            r0.f12275a = r4
            r0.f12276b = r4
            r0.f12280f = r2
            java.lang.Object r6 = f1.AbstractC0557a.r(r6, r7, r0)
            if (r6 != r10) goto L97
            return r10
        L97:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L9a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.savePolicyOperate(android.content.Context, boolean, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @JvmStatic
    @Nullable
    public static final DialogInterfaceC0865j showCustomPolicyDialog(@NotNull Context context, boolean secondaryConfirmation, @Nullable String[] permissionKey, @Nullable String[] permissionSummary, @NotNull String title, @Nullable CharSequence reminder, @NotNull CharSequence customTerms, @NotNull PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(customTerms, "customTerms");
        Intrinsics.checkNotNullParameter(permissionDialogClickListener, "permissionDialogClickListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new E(context, permissionDialogClickListener)).setSecondaryConfirmation(secondaryConfirmation).setCustomTerms(customTerms);
        if (reminder != null && !TextUtils.isEmpty(reminder)) {
            policyPermissionDialogBuilder.setReminder(reminder);
        }
        if (permissionKey != null && permissionSummary != null) {
            policyPermissionDialogBuilder.setPermission(permissionKey, permissionSummary);
        }
        return policyPermissionDialogBuilder.create();
    }

    @JvmStatic
    @Nullable
    public static final DialogInterfaceC0865j showCustomPolicyDialogAndUploadRecord(@NotNull Context context, boolean secondaryConfirmation, @Nullable String[] permissionKey, @Nullable String[] permissionSummary, @NotNull String title, @Nullable CharSequence reminder, @NotNull CharSequence customTerms, @NotNull String appId, @NotNull String appSecret, @NotNull String versionName, @NotNull String[] categoryList, @Nullable String userId, @NotNull PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(customTerms, "customTerms");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        Intrinsics.checkNotNullParameter(permissionDialogClickListener, "permissionDialogClickListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new G(context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener)).setSecondaryConfirmation(secondaryConfirmation).setCustomTerms(customTerms);
        if (reminder != null && !TextUtils.isEmpty(reminder)) {
            policyPermissionDialogBuilder.setReminder(reminder);
        }
        if (permissionKey != null && permissionSummary != null) {
            policyPermissionDialogBuilder.setPermission(permissionKey, permissionSummary);
        }
        return policyPermissionDialogBuilder.create();
    }

    @JvmStatic
    @Nullable
    public static final stepos.support.v7.app.U showDialogByCustomThemeViewBuilder(@NotNull Context context, int theme, @NotNull String title, @NotNull CharSequence customTerms, @NotNull String customNegativeButtonText, @NotNull String customPositiveButtonText, @NotNull stepos.support.v7.app.S permissionDialogClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(customTerms, "customTerms");
        Intrinsics.checkNotNullParameter(customNegativeButtonText, "customNegativeButtonText");
        Intrinsics.checkNotNullParameter(customPositiveButtonText, "customPositiveButtonText");
        Intrinsics.checkNotNullParameter(permissionDialogClickListener, "permissionDialogClickListener");
        stepos.support.v7.app.U u4 = new stepos.support.v7.app.U(context);
        u4.f14339c = title;
        u4.f14346j = permissionDialogClickListener;
        u4.f14347k = customTerms;
        u4.f14351o = customNegativeButtonText;
        u4.f14352p = customPositiveButtonText;
        return u4;
    }

    @JvmStatic
    @Nullable
    public static final DialogInterfaceC0865j showDialogByCustomView(@NotNull Context context, @NotNull String title, @NotNull CharSequence customTerms, @NotNull String customNegativeButtonText, @NotNull String customPositiveButtonText, @NotNull stepos.support.v7.app.S permissionDialogClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(customTerms, "customTerms");
        Intrinsics.checkNotNullParameter(customNegativeButtonText, "customNegativeButtonText");
        Intrinsics.checkNotNullParameter(customPositiveButtonText, "customPositiveButtonText");
        Intrinsics.checkNotNullParameter(permissionDialogClickListener, "permissionDialogClickListener");
        stepos.support.v7.app.U uShowDialogByCustomViewBuilder = showDialogByCustomViewBuilder(context, title, customTerms, customNegativeButtonText, customPositiveButtonText, "2", permissionDialogClickListener);
        if (uShowDialogByCustomViewBuilder != null) {
            return uShowDialogByCustomViewBuilder.a();
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final DialogInterfaceC0865j showDialogByCustomViewAndUploadRecord(@NotNull Context context, @NotNull String title, @NotNull CharSequence customTerms, @NotNull String customNegativeButtonText, @NotNull String customPositiveButtonText, @NotNull String appId, @NotNull String appSecret, @NotNull String versionName, @NotNull String[] categoryList, @Nullable String userId, @NotNull String operationType, @NotNull stepos.support.v7.app.S permissionDialogClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(customTerms, "customTerms");
        Intrinsics.checkNotNullParameter(customNegativeButtonText, "customNegativeButtonText");
        Intrinsics.checkNotNullParameter(customPositiveButtonText, "customPositiveButtonText");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        Intrinsics.checkNotNullParameter(operationType, "operationType");
        Intrinsics.checkNotNullParameter(permissionDialogClickListener, "permissionDialogClickListener");
        stepos.support.v7.app.U uShowDialogUploadRecordBuilder = showDialogUploadRecordBuilder(context, title, customTerms, customNegativeButtonText, customPositiveButtonText, appId, appSecret, versionName, categoryList, userId, operationType, permissionDialogClickListener);
        if (uShowDialogUploadRecordBuilder != null) {
            return uShowDialogUploadRecordBuilder.a();
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final stepos.support.v7.app.U showDialogByCustomViewBuilder(@NotNull Context context, @NotNull String title, @NotNull CharSequence customTerms, @NotNull String customNegativeButtonText, @NotNull String customPositiveButtonText, @NotNull String operationType, @NotNull stepos.support.v7.app.S permissionDialogClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(customTerms, "customTerms");
        Intrinsics.checkNotNullParameter(customNegativeButtonText, "customNegativeButtonText");
        Intrinsics.checkNotNullParameter(customPositiveButtonText, "customPositiveButtonText");
        Intrinsics.checkNotNullParameter(operationType, "operationType");
        Intrinsics.checkNotNullParameter(permissionDialogClickListener, "permissionDialogClickListener");
        stepos.support.v7.app.U u4 = new stepos.support.v7.app.U(context);
        u4.f14339c = title;
        u4.f14346j = new H(operationType, context, permissionDialogClickListener);
        u4.f14347k = customTerms;
        u4.f14351o = customNegativeButtonText;
        u4.f14352p = customPositiveButtonText;
        return u4;
    }

    @JvmStatic
    @Nullable
    public static final stepos.support.v7.app.U showDialogByCustomViewBuilderRecord(@NotNull Context context, @NotNull String title, @NotNull CharSequence customTerms, @NotNull String customNegativeButtonText, @NotNull String customPositiveButtonText, @NotNull String appId, @NotNull String appSecret, @NotNull String versionName, @NotNull String[] categoryList, @Nullable String userId, @NotNull stepos.support.v7.app.S permissionDialogClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(customTerms, "customTerms");
        Intrinsics.checkNotNullParameter(customNegativeButtonText, "customNegativeButtonText");
        Intrinsics.checkNotNullParameter(customPositiveButtonText, "customPositiveButtonText");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        Intrinsics.checkNotNullParameter(permissionDialogClickListener, "permissionDialogClickListener");
        stepos.support.v7.app.U u4 = new stepos.support.v7.app.U(context);
        u4.f14339c = title;
        u4.f14346j = new J(context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener, 0);
        u4.f14347k = customTerms;
        u4.f14351o = customNegativeButtonText;
        u4.f14352p = customPositiveButtonText;
        return u4;
    }

    @JvmStatic
    @Nullable
    public static final stepos.support.v7.app.U showDialogUploadRecordBuilder(@NotNull Context context, @NotNull String title, @NotNull CharSequence customTerms, @NotNull String customNegativeButtonText, @NotNull String customPositiveButtonText, @NotNull String appId, @NotNull String appSecret, @NotNull String versionName, @NotNull String[] categoryList, @Nullable String userId, @NotNull String operationType, @NotNull stepos.support.v7.app.S permissionDialogClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(customTerms, "customTerms");
        Intrinsics.checkNotNullParameter(customNegativeButtonText, "customNegativeButtonText");
        Intrinsics.checkNotNullParameter(customPositiveButtonText, "customPositiveButtonText");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        Intrinsics.checkNotNullParameter(operationType, "operationType");
        Intrinsics.checkNotNullParameter(permissionDialogClickListener, "permissionDialogClickListener");
        stepos.support.v7.app.U u4 = new stepos.support.v7.app.U(context);
        u4.f14339c = title;
        u4.f14346j = new K(operationType, context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener);
        u4.f14347k = customTerms;
        u4.f14351o = customNegativeButtonText;
        u4.f14352p = customPositiveButtonText;
        return u4;
    }

    @JvmStatic
    @Nullable
    public static final DialogInterfaceC0865j showNewestDialogAndUploadRecord(@NotNull Context context, @NotNull String dialogTitle, @NotNull String appId, @NotNull String appSecret, @NotNull String versionName, @NotNull String[] categoryList, @Nullable String userId, boolean isRecord, @NotNull CharSequence customTerms, @NotNull String btnNegative, @NotNull String btnPositive, @NotNull stepos.support.v7.app.S permissionDialogClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dialogTitle, "dialogTitle");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        Intrinsics.checkNotNullParameter(customTerms, "customTerms");
        Intrinsics.checkNotNullParameter(btnNegative, "btnNegative");
        Intrinsics.checkNotNullParameter(btnPositive, "btnPositive");
        Intrinsics.checkNotNullParameter(permissionDialogClickListener, "permissionDialogClickListener");
        stepos.support.v7.app.U u4 = new stepos.support.v7.app.U(context);
        u4.f14339c = dialogTitle;
        u4.f14346j = new L(isRecord, context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener);
        u4.f14347k = customTerms;
        u4.f14351o = btnNegative;
        u4.f14352p = btnPositive;
        return u4.a();
    }

    @JvmStatic
    @Nullable
    public static final DialogInterfaceC0865j showReGrantDialog(@NotNull Context context, boolean methodType, boolean secondaryConfirmation, @NotNull String title, @NotNull String privacyPolicyName, @NotNull String category, @NotNull stepos.support.v7.app.S permissionDialogClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(privacyPolicyName, "privacyPolicyName");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(permissionDialogClickListener, "permissionDialogClickListener");
        return INSTANCE.createReGrantDialogBuilder(context, methodType, secondaryConfirmation, title, privacyPolicyName, category, permissionDialogClickListener).a();
    }

    @JvmStatic
    @Nullable
    public static final DialogInterfaceC0865j showReGrantDialogAndUploadRecord(@NotNull Context context, boolean methodType, boolean secondaryConfirmation, @NotNull String title, @NotNull String privacyPolicyName, @NotNull String category, @NotNull String appId, @NotNull String appSecret, @NotNull String versionName, @NotNull String[] categoryList, @Nullable String userId, @NotNull stepos.support.v7.app.S permissionDialogClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(privacyPolicyName, "privacyPolicyName");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        Intrinsics.checkNotNullParameter(permissionDialogClickListener, "permissionDialogClickListener");
        return INSTANCE.createReGrantDialogBuilder(context, methodType, secondaryConfirmation, title, privacyPolicyName, category, new J(context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener, 1)).a();
    }

    @JvmStatic
    @Nullable
    public static final DialogInterfaceC0865j showReGrantTwoPolicyDialog(@NotNull Context context, boolean methodType, boolean secondaryConfirmation, @NotNull String title, @NotNull String userPrivacyPolicyName, @NotNull String userCategory, @NotNull String privacyPolicyName, @NotNull String category, @NotNull stepos.support.v7.app.S permissionDialogClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(userPrivacyPolicyName, "userPrivacyPolicyName");
        Intrinsics.checkNotNullParameter(userCategory, "userCategory");
        Intrinsics.checkNotNullParameter(privacyPolicyName, "privacyPolicyName");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(permissionDialogClickListener, "permissionDialogClickListener");
        stepos.support.v7.app.U uCreateReGrantDialogBuilder = INSTANCE.createReGrantDialogBuilder(context, methodType, secondaryConfirmation, title, privacyPolicyName, category, permissionDialogClickListener);
        uCreateReGrantDialogBuilder.f14350n = userPrivacyPolicyName;
        uCreateReGrantDialogBuilder.f14343g = new ViewOnClickListenerC0515n(context, methodType, userPrivacyPolicyName, userCategory, 2);
        return uCreateReGrantDialogBuilder.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReGrantTwoPolicyDialog$lambda$5(Context context, boolean z4, String userPrivacyPolicyName, String userCategory, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(userPrivacyPolicyName, "$userPrivacyPolicyName");
        Intrinsics.checkNotNullParameter(userCategory, "$userCategory");
        openPolicyMethod(context, z4, userPrivacyPolicyName, userCategory);
    }

    @JvmStatic
    @Nullable
    public static final DialogInterfaceC0865j showReGrantTwoPolicyDialogAndUploadRecord(@NotNull Context context, boolean methodType, boolean secondaryConfirmation, @NotNull String title, @NotNull String userPrivacyPolicyName, @NotNull String userCategory, @NotNull String privacyPolicyName, @NotNull String category, @NotNull String appId, @NotNull String appSecret, @NotNull String versionName, @NotNull String[] categoryList, @Nullable String userId, @NotNull stepos.support.v7.app.S permissionDialogClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(userPrivacyPolicyName, "userPrivacyPolicyName");
        Intrinsics.checkNotNullParameter(userCategory, "userCategory");
        Intrinsics.checkNotNullParameter(privacyPolicyName, "privacyPolicyName");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        Intrinsics.checkNotNullParameter(permissionDialogClickListener, "permissionDialogClickListener");
        stepos.support.v7.app.U uCreateReGrantDialogBuilder = INSTANCE.createReGrantDialogBuilder(context, methodType, secondaryConfirmation, title, privacyPolicyName, category, new J(context, appId, appSecret, versionName, categoryList, userId, permissionDialogClickListener, 2));
        uCreateReGrantDialogBuilder.f14350n = userPrivacyPolicyName;
        uCreateReGrantDialogBuilder.f14343g = new ViewOnClickListenerC0515n(context, methodType, userPrivacyPolicyName, userCategory, 1);
        return uCreateReGrantDialogBuilder.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReGrantTwoPolicyDialogAndUploadRecord$lambda$4(Context context, boolean z4, String userPrivacyPolicyName, String userCategory, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(userPrivacyPolicyName, "$userPrivacyPolicyName");
        Intrinsics.checkNotNullParameter(userCategory, "$userCategory");
        openPolicyMethod(context, z4, userPrivacyPolicyName, userCategory);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, stepos.support.v7.app.j] */
    /* JADX WARN: Type inference failed for: r4v8, types: [T, stepos.support.v7.app.j] */
    /* JADX WARN: Type inference failed for: r4v9, types: [T, stepos.support.v7.app.j] */
    @JvmStatic
    @Nullable
    public static final DialogInterfaceC0865j showWithdrawalAndCleanServiceDataDialog(@NotNull Context context, @NotNull String title, @NotNull CharSequence customTerms, @NotNull String customNegativeButtonText, @NotNull String customPositiveButtonText, @NotNull String checkButtonMessage, @NotNull PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(customTerms, "customTerms");
        Intrinsics.checkNotNullParameter(customNegativeButtonText, "customNegativeButtonText");
        Intrinsics.checkNotNullParameter(customPositiveButtonText, "customPositiveButtonText");
        Intrinsics.checkNotNullParameter(checkButtonMessage, "checkButtonMessage");
        Intrinsics.checkNotNullParameter(permissionDialogClickListener, "permissionDialogClickListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new O(objectRef, permissionDialogClickListener)).setCustomTerms(customTerms).setShowAlmostDenyBtn(true).setCustomNegativeButtonText(customNegativeButtonText).setCustomPositiveButtonText(customPositiveButtonText).setCancelable(true).setCheckEnableConfirmBtn(true);
        objectRef.element = policyPermissionDialogBuilder.create();
        ?? Create = policyPermissionDialogBuilder.create();
        objectRef.element = Create;
        ?? InitWithdrawalCleanDataOneCheckBox = PolicySdkToolsUtils.INSTANCE.initWithdrawalCleanDataOneCheckBox(context, Create, checkButtonMessage);
        objectRef.element = InitWithdrawalCleanDataOneCheckBox;
        return InitWithdrawalCleanDataOneCheckBox;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, stepos.support.v7.app.j] */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, stepos.support.v7.app.j] */
    @JvmStatic
    @Nullable
    public static final DialogInterfaceC0865j showWithdrawalAndCleanServiceDataDialogByAccount(@NotNull Context context, boolean hasLogin, @NotNull String title, @NotNull CharSequence customTerms, @NotNull String customNegativeButtonText, @NotNull String customPositiveButtonText, @NotNull String checkButtonMessage, @NotNull String secondCheckButtonMessage, @NotNull PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(customTerms, "customTerms");
        Intrinsics.checkNotNullParameter(customNegativeButtonText, "customNegativeButtonText");
        Intrinsics.checkNotNullParameter(customPositiveButtonText, "customPositiveButtonText");
        Intrinsics.checkNotNullParameter(checkButtonMessage, "checkButtonMessage");
        Intrinsics.checkNotNullParameter(secondCheckButtonMessage, "secondCheckButtonMessage");
        Intrinsics.checkNotNullParameter(permissionDialogClickListener, "permissionDialogClickListener");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new Q(objectRef, permissionDialogClickListener)).setCustomTerms(customTerms).setShowAlmostDenyBtn(true).setCustomNegativeButtonText(customNegativeButtonText).setCustomPositiveButtonText(customPositiveButtonText).setCancelable(true).setCheckEnableConfirmBtn(true);
        ?? Create = policyPermissionDialogBuilder.create();
        objectRef.element = Create;
        ?? InitWithdrawalCleanDataTwoCheckBox = PolicySdkToolsUtils.INSTANCE.initWithdrawalCleanDataTwoCheckBox(context, Create, hasLogin, checkButtonMessage, secondCheckButtonMessage);
        objectRef.element = InitWithdrawalCleanDataTwoCheckBox;
        return InitWithdrawalCleanDataTwoCheckBox;
    }

    @JvmStatic
    public static final void uploadPolicyOperateRecord(@NotNull String appId, @NotNull String appSecret, @NotNull String versionName, @NotNull PolicyRecordRequest policyRecordRequest, @NotNull Function1<? super PolicySdkResultBean, Unit> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(policyRecordRequest, "policyRecordRequest");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        CoroutineContext coroutineContext = exceptionHandler;
        W w4 = new W(appId, appSecret, policyRecordRequest, callBackPolicyResult, versionName, null);
        if ((2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContextA = AbstractC0149x.a(EmptyCoroutineContext.INSTANCE, coroutineContext, true);
        f3.d dVar = Z2.Q.f2189a;
        if (coroutineContextA != dVar && coroutineContextA.get(ContinuationInterceptor.INSTANCE) == null) {
            coroutineContextA = coroutineContextA.plus(dVar);
        }
        AbstractC0114a d02 = new D0(coroutineContextA, true);
        d02.Z(1, d02, w4);
    }

    @JvmStatic
    public static final void uploadRecordByCustomRecordRequest(@NotNull Context context, @NotNull String appId, @NotNull String appSecret, @NotNull String versionName, @NotNull PolicyRecordRequest policyRecordRequest, @NotNull Function1<? super PolicySdkResultBean, Unit> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(policyRecordRequest, "policyRecordRequest");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            uploadPolicyOperateRecord(appId, appSecret, versionName, policyRecordRequest, new X(callBackPolicyResult));
        }
    }

    @JvmStatic
    public static final void uploadRecordToCleanServiceData(@NotNull Context context, @NotNull String serviceName, @NotNull String validateCode, @NotNull String verifyType, @Nullable ArrayList<DeleteInfoBean> deleteInfoBeanList, @NotNull String appId, @NotNull String appSecret, @NotNull String versionName, @NotNull String[] categoryList, @Nullable String userId, @NotNull String operationType, @NotNull Function1<? super PolicySdkResultBean, Unit> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(validateCode, "validateCode");
        Intrinsics.checkNotNullParameter(verifyType, "verifyType");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        Intrinsics.checkNotNullParameter(operationType, "operationType");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        t0.J.y(scope, exceptionHandler, new Y(context, categoryList, userId, operationType, verifyType, serviceName, validateCode, deleteInfoBeanList, appId, appSecret, versionName, callBackPolicyResult, null), 2);
    }

    @JvmStatic
    public static final void uploadRecordWithoutSecureService(@NotNull Context context, @NotNull String serviceName, @NotNull String validateCode, @NotNull String verifyType, @Nullable ArrayList<DeleteInfoBean> deleteInfoBeanList, @NotNull String appId, @NotNull String appSecret, @NotNull String versionName, @NotNull String[] categoryList, @Nullable String userId, @NotNull String operationType, @NotNull Function1<? super PolicySdkResultBean, Unit> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(validateCode, "validateCode");
        Intrinsics.checkNotNullParameter(verifyType, "verifyType");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSecret, "appSecret");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        Intrinsics.checkNotNullParameter(operationType, "operationType");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        t0.J.y(scope, exceptionHandler, new Z(context, categoryList, userId, operationType, verifyType, serviceName, validateCode, deleteInfoBeanList, appId, appSecret, versionName, callBackPolicyResult, null), 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getAgreeStatus(@org.jetbrains.annotations.NotNull android.content.Context r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.policy.sdk.M
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.policy.sdk.M r0 = (com.stepos.policy.sdk.M) r0
            int r1 = r0.f12042c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12042c = r1
            goto L18
        L13:
            com.stepos.policy.sdk.M r0 = new com.stepos.policy.sdk.M
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.f12040a
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.f12042c
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            kotlin.ResultKt.throwOnFailure(r4)
            goto L4b
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r4)
            S.i r4 = com.stepos.policy.sdk.b0.a(r5)
            b3.h r4 = r4.b()
            S.y r5 = new S.y
            r1 = 4
            r5.<init>(r4, r1)
            r0.f12042c = r2
            java.lang.Object r4 = Z2.I.k(r5, r0)
            if (r4 != r6) goto L4b
            return r6
        L4b:
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 != 0) goto L54
            r4 = 0
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
        L54:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.getAgreeStatus(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final String getBrand() {
        return brand;
    }

    @NotNull
    public final String getCompanyCode() {
        return companyCode;
    }

    @NotNull
    public final String getCustomPolicyCSSFileName() {
        return customPolicyCSSFileName;
    }

    @Nullable
    public final Object getDataStoreString(@NotNull Context context, @NotNull V.f fVar, @NotNull Continuation<? super String> continuation) {
        return Z2.I.k(new T(b0.a(context).b(), fVar, 0), continuation);
    }

    @NotNull
    public final CoroutineExceptionHandler getExceptionHandler() {
        return exceptionHandler;
    }

    public final boolean getInitSDKByDeviceProtectedStorageContext() {
        return initSDKByDeviceProtectedStorageContext;
    }

    @NotNull
    public final Z2.F getLifecycleScope() {
        return lifecycleScope;
    }

    @NotNull
    public final HashMap<String, String> getLocalAssetsCategoryPathMap() {
        return localAssetsCategoryPathMap;
    }

    @NotNull
    public final String getMAppId() {
        return mAppId;
    }

    @NotNull
    public final String getMAppSecret() {
        return mAppSecret;
    }

    @NotNull
    public final String getMAppVersionName() {
        return mAppVersionName;
    }

    @NotNull
    public final String getModel() {
        return model;
    }

    @NotNull
    public final String getOsVersion() {
        return osVersion;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getPolicyOperate(@org.jetbrains.annotations.NotNull android.content.Context r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.policy.sdk.C0506e
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.policy.sdk.e r0 = (com.stepos.policy.sdk.C0506e) r0
            int r1 = r0.f12154c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12154c = r1
            goto L18
        L13:
            com.stepos.policy.sdk.e r0 = new com.stepos.policy.sdk.e
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.f12152a
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.f12154c
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            kotlin.ResultKt.throwOnFailure(r4)
            goto L4a
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r4)
            S.i r4 = com.stepos.policy.sdk.b0.a(r5)
            b3.h r4 = r4.b()
            S.y r5 = new S.y
            r5.<init>(r4, r2)
            r0.f12154c = r2
            java.lang.Object r4 = Z2.I.k(r5, r0)
            if (r4 != r6) goto L4a
            return r6
        L4a:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.getPolicyOperate(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Object getPolicyOperateJson(@NotNull Context context, @NotNull Continuation<? super String> continuation) {
        return Z2.I.k(new S.y(b0.a(context).b(), 2), continuation);
    }

    public final int getReadClipboardStatus(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ((Number) t0.J.M(new C0512k(context, (Continuation) null))).intValue();
    }

    @NotNull
    public final Z2.F getScope() {
        return scope;
    }

    public final int getSecureServiceVersionCode(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i4 = context.getApplicationContext().getPackageManager().getPackageInfo("com.stepos.secureservice", 128).versionCode;
        PolicySdkLogUtils.INSTANCE.d(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "com.stepos.secureservice versionCode : " + i4 + ' ');
        return i4;
    }

    public final boolean getSyncLocalFileFinished() {
        return syncLocalFileFinished;
    }

    public final void saveAgreeStatus(@NotNull Context context, int status) {
        Intrinsics.checkNotNullParameter(context, "context");
        CoroutineContext coroutineContext = exceptionHandler;
        C0519s c0519s = new C0519s(context, status, null);
        if ((2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContextA = AbstractC0149x.a(EmptyCoroutineContext.INSTANCE, coroutineContext, true);
        f3.d dVar = Z2.Q.f2189a;
        if (coroutineContextA != dVar && coroutineContextA.get(ContinuationInterceptor.INSTANCE) == null) {
            coroutineContextA = coroutineContextA.plus(dVar);
        }
        AbstractC0114a d02 = new D0(coroutineContextA, true);
        d02.Z(1, d02, c0519s);
    }

    public final void saveReadClipboardStatus(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE == getReadClipboardStatus(context)) {
            return;
        }
        CoroutineContext coroutineContext = exceptionHandler;
        C c4 = new C(context, null);
        if ((2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContextA = AbstractC0149x.a(EmptyCoroutineContext.INSTANCE, coroutineContext, true);
        f3.d dVar = Z2.Q.f2189a;
        if (coroutineContextA != dVar && coroutineContextA.get(ContinuationInterceptor.INSTANCE) == null) {
            coroutineContextA = coroutineContextA.plus(dVar);
        }
        AbstractC0114a d02 = new D0(coroutineContextA, true);
        d02.Z(1, d02, c4);
    }

    public final void setBrand(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        brand = str;
    }

    public final void setCompanyCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        companyCode = str;
    }

    public final void setCustomPolicyCSSFileName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        customPolicyCSSFileName = str;
    }

    public final void setInitSDKByDeviceProtectedStorageContext(boolean z4) {
        initSDKByDeviceProtectedStorageContext = z4;
    }

    public final void setLocalAssetsCategoryPathMap(@NotNull HashMap<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        localAssetsCategoryPathMap = map;
    }

    public final void setMAppId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mAppId = str;
    }

    public final void setMAppSecret(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mAppSecret = str;
    }

    public final void setMAppVersionName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mAppVersionName = str;
    }

    public final void setModel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        model = str;
    }

    public final void setOsVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        osVersion = str;
    }

    public final void setSyncLocalFileFinished(boolean z4) {
        syncLocalFileFinished = z4;
    }
}
