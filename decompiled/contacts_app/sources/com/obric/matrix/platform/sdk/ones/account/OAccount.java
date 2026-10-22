package com.obric.matrix.platform.sdk.ones.account;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.android.contacts.ContactSaveService;
import com.android.contacts.vcard.ImportSimContacts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountBridge;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountManager;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener;
import com.obric.matrix.platform.sdk.ones.account.api.ILogger;
import com.obric.matrix.platform.sdk.ones.account.api.IUpdateAccountInfoCallback;
import com.obric.matrix.platform.sdk.ones.account.api.IUpdateTokenMapCallback;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OAccount.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0083\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\rJ\u0010\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%J\u001e\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\rJ\u009c\u0001\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u001c2\b\u0010/\u001a\u0004\u0018\u0001002\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001022\u0018\b\u0002\u00103\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000100\u0012\u0004\u0012\u00020\u001e\u0018\u0001042:\b\u0002\u00105\u001a4\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001e\u0018\u0001062\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u000102H\u0002JX\u0010=\u001a\u00020\u001e2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001e042:\u00105\u001a6\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001e\u0018\u000106H\u0002J\u0012\u0010?\u001a\u00020\u001e2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002J^\u0010@\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020\u00042\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001022<\b\u0002\u00105\u001a6\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001e\u0018\u000106J(\u0010B\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u001cH\u0002J\u0006\u0010C\u001a\u00020\u001eJK\u0010D\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010E\u001a\u00020\u001c2\b\u0010F\u001a\u0004\u0018\u00010G2'\u0010H\u001a#\u0012\u0017\u0012\u00150Ij\u0002`J¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u001e\u0018\u000104H\u0002J\u001e\u0010L\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\rJ\u0010\u0010L\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001cH\u0002J\u0006\u0010M\u001a\u00020\u0004J\u0010\u0010N\u001a\u00020\u001c2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u001a\u0010O\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010GJ0\u0010P\u001a\u0002072\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010R2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJf\u0010S\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001022<\b\u0002\u00105\u001a6\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001e\u0018\u000106JT\u0010U\u001a\u00020\u001e2\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001022:\b\u0002\u0010H\u001a4\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001e\u0018\u000106J\u0006\u0010W\u001a\u000207J{\u0010X\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020\u00042'\b\u0002\u0010V\u001a!\u0012\u0015\u0012\u0013\u0018\u000100¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u001e\u0018\u0001042:\b\u0002\u0010H\u001a4\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001e\u0018\u000106J\u000e\u0010Z\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%Jd\u0010[\u001a\u00020\u001e2\u0006\u0010\\\u001a\u00020\u00042\u0006\u0010]\u001a\u0002072\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001022:\b\u0002\u0010H\u001a4\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001e\u0018\u000106J^\u0010^\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020\u00042\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001022<\b\u0002\u00105\u001a6\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001e\u0018\u000106J\u000e\u0010_\u001a\u00020\u001e2\u0006\u0010`\u001a\u00020\u0004J\b\u0010a\u001a\u00020\u001eH\u0002J\u001f\u0010b\u001a\u00020\u001e2\u0006\u0010c\u001a\u00020d2\n\b\u0002\u0010e\u001a\u0004\u0018\u000107¢\u0006\u0002\u0010fJ\u001f\u0010g\u001a\u00020\u001e2\u0006\u0010c\u001a\u00020d2\n\b\u0002\u0010e\u001a\u0004\u0018\u000107¢\u0006\u0002\u0010fJ\u001e\u0010h\u001a\u00020\u001e2\u0006\u0010c\u001a\u00020d2\u0006\u0010i\u001a\u00020\u00042\u0006\u0010e\u001a\u000207Jf\u0010j\u001a\u00020\u001e2\u0006\u0010k\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001022<\b\u0002\u00105\u001a6\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001e\u0018\u000106J\u0006\u0010l\u001a\u00020\u001eJ\u0010\u0010m\u001a\u00020\u001e2\b\u0010n\u001a\u0004\u0018\u00010oJf\u0010p\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020\u00042\u0006\u0010r\u001a\u00020\u00042\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001022<\b\u0002\u00105\u001a6\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001e\u0018\u000106Jf\u0010s\u001a\u00020\u001e2\u0006\u0010t\u001a\u0002002\b\u0010u\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001022:\b\u0002\u0010H\u001a4\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001e\u0018\u000106J\u0006\u0010v\u001a\u00020\u001eJ\u0010\u0010w\u001a\u00020\u001e2\b\u0010n\u001a\u0004\u0018\u00010xJs\u0010y\u001a\u00020\u001e2\u0006\u0010z\u001a\u00020\u00042'\b\u0002\u0010V\u001a!\u0012\u0015\u0012\u0013\u0018\u000100¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u001e\u0018\u0001042:\b\u0002\u0010H\u001a4\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001e\u0018\u000106J}\u0010{\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042'\b\u0002\u00101\u001a!\u0012\u0015\u0012\u0013\u0018\u000100¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u001e\u0018\u0001042<\b\u0002\u00105\u001a6\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001e\u0018\u000106J}\u0010|\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042'\b\u0002\u00101\u001a!\u0012\u0015\u0012\u0013\u0018\u000100¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u001e\u0018\u0001042<\b\u0002\u00105\u001a6\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001e\u0018\u000106J\u0085\u0001\u0010}\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010]\u001a\u0002072'\b\u0002\u00101\u001a!\u0012\u0015\u0012\u0013\u0018\u000100¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u001e\u0018\u0001042<\b\u0002\u00105\u001a6\u0012\u0013\u0012\u001107¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u001e\u0018\u000106J\u0012\u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u007fJ\u0018\u0010\u0080\u0001\u001a\u000207*\u0004\u0018\u0001002\u0007\u0010\u0081\u0001\u001a\u000207H\u0002J\u0017\u0010\u0082\u0001\u001a\u00020\u0004*\u0004\u0018\u0001002\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0084\u0001"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/OAccount;", "", "()V", "TAG", "", "defaultErrorMsg", "getDefaultErrorMsg", "()Ljava/lang/String;", "defaultErrorMsg$delegate", "Lkotlin/Lazy;", "initCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "mAccountBridge", "Lcom/obric/matrix/platform/sdk/ones/account/api/IAccountBridge;", "mAccountManager", "Lcom/obric/matrix/platform/sdk/ones/account/api/IAccountManager;", "mAccountService", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountService;", "mAccountServiceCon", "Landroid/content/ServiceConnection;", "mCallbackHandler", "Landroid/os/Handler;", "mInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "accountBridge", "accountInfo", "Lcom/obric/matrix/platform/sdk/ones/account/AccountInfo;", "waitAccountInit", "", "accountLaunchIntent", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "addAccountStatusListener", "accountStatusListener", "Lcom/obric/matrix/platform/sdk/ones/account/api/IAccountStatusListener;", "asyncInit", "application", "Landroid/app/Application;", "logger", "Lcom/obric/matrix/platform/sdk/ones/account/api/ILogger;", "bridge", "asyncResultCallback", "method", "success", "extra", "Landroid/os/Bundle;", "onSuccess", "Lkotlin/Function0;", "onSuccessEx", "Lkotlin/Function1;", "onFailed", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", AccountConst.KEY_ERROR_CODE, AccountConst.KEY_ERROR_MSG, "onComplete", "callAccountService", "block", "checkInit", "checkPassword", "password", "doInit", "forceUpdateAccount", "goToHome", "newTask", "options", "Landroid/app/ActivityOptions;", "onFailedAction", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "init", "innerToken", "isLogin", "login", "loginWithCallback", ContactSaveService.EXTRA_CALLBACK_INTENT, "Landroid/app/PendingIntent;", "loginWithPassword", "mobile", "logout", "onSuccessAction", AccountInfoBundleKey.LOGOUT_SCENE, "quickLogin", "code", "removeAccountStatusListener", "sendCode", ImportSimContacts.EXTRA_ACCOUNT, "scene", "setInitPassword", AccountConst.METHOD_SET_LOGIN_PHONE_NUMBER, "phoneNumber", "startBindService", "startLogoutActivity", "activity", "Landroid/app/Activity;", "requestCode", "(Landroid/app/Activity;Ljava/lang/Integer;)V", "startSetInitPassword", "startVerifyActivity", "verifyReason", "ticketResetPassword", AccountConst.KEY_TICKET, "updateAccountInfo", "updateAccountInfoAsync", "callback", "Lcom/obric/matrix/platform/sdk/ones/account/api/IUpdateAccountInfoCallback;", "updatePassword", "oldPassword", "newPassword", "updateUserInfo", "updateInfo", "customizedParams", "updateXttTokenMap", "updateXttTokenMapAsync", "Lcom/obric/matrix/platform/sdk/ones/account/api/IUpdateTokenMapCallback;", "uploadAvatar", "path", "verifyPassword", "verifyPasswordWithoutLogin", "verifySmsCode", "xttTokenMap", "", "getErrorCode", "defaultErrorCode", "getErrorMsg", "AsyncResultCallback", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAccount {
    public static final OAccount INSTANCE = null;
    private static final String TAG = "AccountSDK_OAccount";
    private static final Lazy defaultErrorMsg$delegate = null;
    private static final CountDownLatch initCountDownLatch = null;
    private static IAccountBridge mAccountBridge;
    private static IAccountManager mAccountManager;
    private static IAccountService mAccountService;
    private static final ServiceConnection mAccountServiceCon = null;
    private static Handler mCallbackHandler;
    private static volatile AtomicBoolean mInit;

    /* JADX INFO: compiled from: OAccount.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00128\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016R@\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/OAccount$AsyncResultCallback;", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountActionCallback$Stub;", "methodName", "", "onSuccess", "Lkotlin/Function0;", "", "onFailed", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", AccountConst.KEY_ERROR_CODE, AccountConst.KEY_ERROR_MSG, "onSuccessEx", "Lkotlin/Function1;", "Landroid/os/Bundle;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "_onFailed", "_onSuccess", "_onSuccessEx", "onResult", "success", "", "extra", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AsyncResultCallback extends IAccountActionCallback.Stub {
        private Function2<? super Integer, ? super String, Unit> _onFailed;
        private Function0<Unit> _onSuccess;
        private Function1<? super Bundle, Unit> _onSuccessEx;
        private final String methodName;

        public /* synthetic */ AsyncResultCallback(String r1, Function0 r2, Function2 r3, Function1 r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 8) == 0) goto L5;
            r4 = null;
        L5:
            this(r1, r2, r3, r4);
        }

        public static final /* synthetic */ void access$set_onFailed$p(AsyncResultCallback r0, Function2 r1) {
            r0._onFailed = r1;
        }

        public static final /* synthetic */ void access$set_onSuccess$p(AsyncResultCallback r0, Function0 r1) {
            r0._onSuccess = r1;
        }

        public static final /* synthetic */ void access$set_onSuccessEx$p(AsyncResultCallback r0, Function1 r1) {
            r0._onSuccessEx = r1;
        }

        public AsyncResultCallback(String r2, Function0<Unit> r3, Function2<? super Integer, ? super String, Unit> r4, Function1<? super Bundle, Unit> r5) {
            Intrinsics.checkNotNullParameter(r2, "methodName");
            this.methodName = r2;
            this._onSuccess = r3;
            this._onFailed = r4;
            this._onSuccessEx = r5;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback
        public void onResult(boolean r9, Bundle r10) {
            OAccount.access$asyncResultCallback(OAccount.INSTANCE, this.methodName, r9, r10, this._onSuccess, this._onSuccessEx, this._onFailed, new OAccount$AsyncResultCallback$onResult$1(this));
        }
    }

    public static /* synthetic */ void $r8$lambda$Uj7gYQS9vxlfq2GVEzMuNIIeVbU(boolean r0, String r1, Function1 r2, Bundle r3, Function0 r4, Function0 r5, Function2 r6) {
        m354asyncResultCallback$lambda3(r0, r1, r2, r3, r4, r5, r6);
    }

    private OAccount() {
    }

    public static final /* synthetic */ void access$asyncResultCallback(OAccount r0, String r1, boolean r2, Bundle r3, Function0 r4, Function1 r5, Function2 r6, Function0 r7) {
        r0.asyncResultCallback(r1, r2, r3, r4, r5, r6, r7);
    }

    public static final /* synthetic */ void access$setMAccountService$p(IAccountService r0) {
        mAccountService = r0;
    }

    public static final /* synthetic */ void access$startBindService(OAccount r0) {
        r0.startBindService();
    }

    static {
        INSTANCE = new OAccount();
        mInit = new AtomicBoolean(false);
        initCountDownLatch = new CountDownLatch(1);
        mCallbackHandler = new Handler(Looper.getMainLooper());
        mAccountServiceCon = new OAccount$mAccountServiceCon$1();
        defaultErrorMsg$delegate = LazyKt.lazy(OAccount$defaultErrorMsg$2.INSTANCE);
    }

    private final String getDefaultErrorMsg() {
        return (String) defaultErrorMsg$delegate.getValue();
    }

    public final IAccountBridge accountBridge() throws AccountException {
        checkInit$default(this, false, 1, null);
        IAccountBridge r3 = mAccountBridge;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountBridge");
        return null;
    L6:
        return r3;
    }

    public final void asyncInit(Application r2, ILogger r3, IAccountBridge r4) {
        Intrinsics.checkNotNullParameter(r2, "application");
        Intrinsics.checkNotNullParameter(r3, "logger");
        Intrinsics.checkNotNullParameter(r4, "bridge");
        doInit(r2, r3, r4, true);
    }

    public final void init(Application r2, ILogger r3, IAccountBridge r4) {
        Intrinsics.checkNotNullParameter(r2, "application");
        Intrinsics.checkNotNullParameter(r3, "logger");
        Intrinsics.checkNotNullParameter(r4, "bridge");
        doInit(r2, r3, r4, false);
    }

    private final void doInit(Application r2, ILogger r3, IAccountBridge r4, boolean r5) {
        OLog.i(TAG, "init, asyncInit: " + r5);
        AtomicBoolean r1 = mInit;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (mInit.get() == false) goto L9;
        OLog.w(TAG, "Init already.");     // Catch: Throwable -> L12
        monitor-exit(r1);
        return;
    L9:
        OLog.INSTANCE.setLoggerProxy(r3);     // Catch: Throwable -> L12
        OAccount r6 = INSTANCE;     // Catch: Throwable -> L12
        mAccountBridge = r4;     // Catch: Throwable -> L12
        mAccountManager = OAccountManager.INSTANCE;     // Catch: Throwable -> L12
        r6.init(r5);     // Catch: Throwable -> L12
        mInit.set(true);     // Catch: Throwable -> L12
        initCountDownLatch.countDown();     // Catch: Throwable -> L12
        r6.startBindService();     // Catch: Throwable -> L12
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r1);
    }

    private final void init(boolean r1) {
        IAccountManager r0 = mAccountManager;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
        r0 = null;
    L5:
        r0.init(r1);
    }

    public static /* synthetic */ void login$default(OAccount r0, Context r1, ActivityOptions r2, int r3, Object r4) throws AccountException {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.login(r1, r2);
    }

    public final void login(Context r11, ActivityOptions r12) throws AccountException {
        Intrinsics.checkNotNullParameter(r11, "context");
        checkInit$default(this, false, 1, null);
        loginWithCallback$default(this, r11, r12, null, false, 8, null);
    }

    public final void accountLaunchIntent(Context r4, Intent r5) throws AccountException {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, MemorySourceLinkType.INTENT);
        if (isLogin$default(this, false, 1, null) == false) goto L5;
        r5.setClassName("com.obric.account", "com.obric.account.ui.home.HomeActivity");
    L6:
        r5.setPackage("com.obric.account");
        r5.addFlags(268435456);
        r5.putExtra("enter_from", r4.getPackageName());
        return;
    L5:
        r5.setClassName("com.obric.account", "com.obric.account.ui.login.LoginActivity");
        goto L6
    }

    public static /* synthetic */ void startLogoutActivity$default(OAccount r0, Activity r1, Integer r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.startLogoutActivity(r1, r2);
    }

    public final void startLogoutActivity(Activity r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intent r2 = new Intent();
        r2.setClassName("com.obric.account", "com.obric.account.ui.security.LogoutActivity2");
        r2.setPackage("com.obric.account");
        r2.putExtra("enter_from", r3.getPackageName());
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L6:
        r3.startActivityForResult(r2, r5);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public final void startVerifyActivity(Activity r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "verifyReason");
        Intent r2 = new Intent();
        r2.setClassName("com.obric.account", "com.obric.account.ui.security.VerifyPasswordActivity");
        r2.setPackage("com.obric.account");
        r2.putExtra("enter_from", r3.getPackageName());
        r2.putExtra("extra_key_verify_reason", r4);
        r3.startActivityForResult(r2, r5);
    }

    public static /* synthetic */ void startSetInitPassword$default(OAccount r0, Activity r1, Integer r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.startSetInitPassword(r1, r2);
    }

    public final void startSetInitPassword(Activity r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intent r2 = new Intent();
        r2.setClassName("com.obric.account", "com.obric.account.ui.security.SetInitPasswordActivity");
        r2.setPackage("com.obric.account");
        r2.addFlags(268435456);
        r2.putExtra("enter_from", r3.getPackageName());
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L6:
        r3.startActivityForResult(r2, r5);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    private final void goToHome(Context r3, boolean r4, ActivityOptions r5, Function1<? super Exception, Unit> r6) {
        Intent r0 = new Intent("com.obric.account.action.OBRIC_ACCOUNT_ACTION");     // Catch: Exception -> L11
        r0.setClassName("com.obric.account", "com.obric.account.AccountMainActivity");     // Catch: Exception -> L11
        r0.setPackage("com.obric.account");     // Catch: Exception -> L11
        r0.putExtra("destination", "account_main");     // Catch: Exception -> L11
        if (r4 == false) goto L6;
        r0.addFlags(270532608);     // Catch: Exception -> L11
    L6:
        if (r5 == null) goto L8;
        Bundle r2 = r5.toBundle();     // Catch: Exception -> L11
    L9:
        r3.startActivity(r0, r2);     // Catch: Exception -> L11
        return;
    L8:
        r2 = null;
    L11:
        e = move-exception;
        MLog.e(TAG, "login error.", e);
        if (r6 == null) goto L18;
        r6.invoke(e);
        return;
    }

    public static /* synthetic */ int loginWithCallback$default(OAccount r1, Context r2, ActivityOptions r3, PendingIntent r4, boolean r5, int r6, Object r7) throws AccountException {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = true;
    L12:
        return r1.loginWithCallback(r2, r3, r4, r5);
    }

    public final int loginWithCallback(Context r1, ActivityOptions r2, PendingIntent r3, boolean r4) throws AccountException {
        Intrinsics.checkNotNullParameter(r1, "context");
        checkInit(r4);
        if (isLogin$default(this, false, 1, null) == false) goto L6;
        OLog.e(TAG, "login failed, login already.");
        return 1003;
    L6:
        IAccountService r5 = mAccountService;
        if (r5 != null) goto L10;
        OLog.e(TAG, "AccountService is null.");
        startBindService();
        return 1002;
    L10:
        Intrinsics.checkNotNull(r5);
        r5.login(r3);
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void logout$default(OAccount r1, Function0 r2, Function2 r3, int r4, Object r5) throws AccountException {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        r1.logout(r2, r3);
    }

    public final void logout(Function0<Unit> r9, Function2<? super Integer, ? super String, Unit> r10) throws AccountException {
        checkInit$default(this, false, 1, null);
        IAccountService r0 = mAccountService;
        if (r0 != null) goto L9;
        OLog.e(TAG, "AccountService is null.");
        if (r10 == null) goto L7;
        r10.invoke(1002, "");
    L7:
        startBindService();
        return;
    L9:
        Intrinsics.checkNotNull(r0);
        r0.logout(new AsyncResultCallback("logout", r9, r10, null, 8, null));
    }

    public final void forceUpdateAccount() throws AccountException {
        checkInit$default(this, false, 1, null);
        IAccountService r0 = mAccountService;
        if (r0 != null) goto L6;
        OLog.e(TAG, "AccountService is null.");
        startBindService();
        return;
    L6:
        Intrinsics.checkNotNull(r0);
        r0.forceUpdateAccount();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendCode$default(OAccount r1, String r2, int r3, Function0 r4, Function2 r5, int r6, Object r7) throws AccountException {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.sendCode(r2, r3, r4, r5);
    }

    public final void sendCode(String r9, int r10, Function0<Unit> r11, Function2<? super Integer, ? super String, Unit> r12) throws AccountException {
        Intrinsics.checkNotNullParameter(r9, ImportSimContacts.EXTRA_ACCOUNT);
        checkInit$default(this, false, 1, null);
        IAccountService r0 = mAccountService;
        if (r0 != null) goto L8;
        OLog.e(TAG, "AccountService is null.");
        startBindService();
        if (r12 == null) goto L10;
        r12.invoke(1002, "");
        return;
    L10:
        return;
    L8:
        Intrinsics.checkNotNull(r0);
        r0.sendCode(r9, r10, new AsyncResultCallback("sendCode", r11, r12, null, 8, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void quickLogin$default(OAccount r1, String r2, String r3, Function1 r4, Function2 r5, int r6, Object r7) throws AccountException {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.quickLogin(r2, r3, r4, r5);
    }

    public final void quickLogin(String r4, String r5, Function1<? super Bundle, Unit> r6, Function2<? super Integer, ? super String, Unit> r7) throws AccountException {
        Intrinsics.checkNotNullParameter(r4, "mobile");
        Intrinsics.checkNotNullParameter(r5, "code");
        checkInit$default(this, false, 1, null);
        IAccountService r0 = mAccountService;
        if (r0 != null) goto L9;
        OLog.e(TAG, "AccountService is null.");
        if (r7 == null) goto L7;
        r7.invoke(1002, "");
    L7:
        startBindService();
        return;
    L9:
        Intrinsics.checkNotNull(r0);
        r0.quickLogin(r4, r5, new AsyncResultCallback("quickLogin", null, r7, r6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateUserInfo$default(OAccount r1, Bundle r2, String r3, Function0 r4, Function2 r5, int r6, Object r7) throws AccountException {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.updateUserInfo(r2, r3, r4, r5);
    }

    public final void updateUserInfo(Bundle r9, String r10, Function0<Unit> r11, Function2<? super Integer, ? super String, Unit> r12) throws AccountException {
        Intrinsics.checkNotNullParameter(r9, "updateInfo");
        checkInit$default(this, false, 1, null);
        IAccountService r0 = mAccountService;
        if (r0 != null) goto L9;
        OLog.e(TAG, "AccountService is null.");
        if (r12 == null) goto L7;
        r12.invoke(1002, "");
    L7:
        startBindService();
        return;
    L9:
        Intrinsics.checkNotNull(r0);
        r0.updateUserInfo(r9, r10, new AsyncResultCallback("updateUserInfo", r11, r12, null, 8, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void uploadAvatar$default(OAccount r1, String r2, Function1 r3, Function2 r4, int r5, Object r6) throws AccountException {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.uploadAvatar(r2, r3, r4);
    }

    public final void uploadAvatar(String r4, Function1<? super Bundle, Unit> r5, Function2<? super Integer, ? super String, Unit> r6) throws AccountException {
        Intrinsics.checkNotNullParameter(r4, "path");
        checkInit$default(this, false, 1, null);
        IAccountService r0 = mAccountService;
        if (r0 != null) goto L9;
        OLog.e(TAG, "AccountService is null.");
        if (r6 == null) goto L7;
        r6.invoke(1002, "");
    L7:
        startBindService();
        return;
    L9:
        Intrinsics.checkNotNull(r0);
        r0.uploadAvatar(r4, new AsyncResultCallback("uploadAvatar", null, r6, r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loginWithPassword$default(OAccount r1, String r2, String r3, Function0 r4, Function2 r5, int r6, Object r7) throws AccountException {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.loginWithPassword(r2, r3, r4, r5);
    }

    public final void loginWithPassword(final String r3, final String r4, final Function0<Unit> r5, final Function2<? super Integer, ? super String, Unit> r6) throws AccountException {
        Intrinsics.checkNotNullParameter(r3, "mobile");
        Intrinsics.checkNotNullParameter(r4, "password");
        OLog.d(TAG, "loginWithPassword");
        callAccountService(new C02941(r3, r4, r5, r6), r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void verifySmsCode$default(OAccount r7, String r8, String r9, int r10, Function1 r11, Function2 r12, int r13, Object r14) throws AccountException {
        if ((r13 & 8) == 0) goto L5;
        Function1 r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        Function2 r6 = null;
    L10:
        r7.verifySmsCode(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }

    public final void verifySmsCode(final String r9, final String r10, final int r11, final Function1<? super Bundle, Unit> r12, final Function2<? super Integer, ? super String, Unit> r13) throws AccountException {
        Intrinsics.checkNotNullParameter(r9, "mobile");
        Intrinsics.checkNotNullParameter(r10, "code");
        OLog.d(TAG, "verifySmsCode");
        callAccountService(new C03001(r9, r10, r11, r13, r12), r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ticketResetPassword$default(OAccount r1, String r2, String r3, Function0 r4, Function2 r5, int r6, Object r7) throws AccountException {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.ticketResetPassword(r2, r3, r4, r5);
    }

    public final void ticketResetPassword(final String r3, final String r4, final Function0<Unit> r5, final Function2<? super Integer, ? super String, Unit> r6) throws AccountException {
        Intrinsics.checkNotNullParameter(r3, AccountConst.KEY_TICKET);
        Intrinsics.checkNotNullParameter(r4, "password");
        OLog.d(TAG, "ticketResetPassword");
        callAccountService(new C02961(r3, r4, r5, r6), r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setInitPassword$default(OAccount r1, String r2, Function0 r3, Function2 r4, int r5, Object r6) throws AccountException {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.setInitPassword(r2, r3, r4);
    }

    public final void setInitPassword(final String r3, final Function0<Unit> r4, final Function2<? super Integer, ? super String, Unit> r5) throws AccountException {
        Intrinsics.checkNotNullParameter(r3, "password");
        OLog.d(TAG, "setInitPassword");
        callAccountService(new C02951(r3, r4, r5), r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkPassword$default(OAccount r1, String r2, Function0 r3, Function2 r4, int r5, Object r6) throws AccountException {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.checkPassword(r2, r3, r4);
    }

    public final void checkPassword(final String r3, final Function0<Unit> r4, final Function2<? super Integer, ? super String, Unit> r5) throws AccountException {
        Intrinsics.checkNotNullParameter(r3, "password");
        OLog.d(TAG, "checkPassword");
        callAccountService(new AnonymousClass1(r3, r4, r5), r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updatePassword$default(OAccount r1, String r2, String r3, Function0 r4, Function2 r5, int r6, Object r7) throws AccountException {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.updatePassword(r2, r3, r4, r5);
    }

    public final void updatePassword(final String r3, final String r4, final Function0<Unit> r5, final Function2<? super Integer, ? super String, Unit> r6) throws AccountException {
        Intrinsics.checkNotNullParameter(r3, "oldPassword");
        Intrinsics.checkNotNullParameter(r4, "newPassword");
        OLog.d(TAG, "updatePassword");
        callAccountService(new C02971(r3, r4, r5, r6), r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void verifyPassword$default(OAccount r1, String r2, String r3, Function1 r4, Function2 r5, int r6, Object r7) throws AccountException {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.verifyPassword(r2, r3, r4, r5);
    }

    public final void verifyPassword(final String r3, final String r4, final Function1<? super Bundle, Unit> r5, final Function2<? super Integer, ? super String, Unit> r6) throws AccountException {
        Intrinsics.checkNotNullParameter(r3, "mobile");
        Intrinsics.checkNotNullParameter(r4, "password");
        OLog.d(TAG, "verifyPassword");
        callAccountService(new C02981(r3, r4, r6, r5), r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void verifyPasswordWithoutLogin$default(OAccount r1, String r2, String r3, Function1 r4, Function2 r5, int r6, Object r7) throws AccountException {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.verifyPasswordWithoutLogin(r2, r3, r4, r5);
    }

    public final void verifyPasswordWithoutLogin(final String r3, final String r4, final Function1<? super Bundle, Unit> r5, final Function2<? super Integer, ? super String, Unit> r6) throws AccountException {
        Intrinsics.checkNotNullParameter(r3, "mobile");
        Intrinsics.checkNotNullParameter(r4, "password");
        OLog.d(TAG, "verifyPasswordWithoutLogin in OAccount");
        callAccountService(new C02991(r3, r4, r6, r5), r6);
    }

    public static /* synthetic */ boolean isLogin$default(OAccount r0, boolean r1, int r2, Object r3) throws AccountException {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return r0.isLogin(r1);
    }

    public final boolean isLogin(boolean r1) throws AccountException {
        checkInit(r1);
        IAccountManager r0 = mAccountManager;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
        r0 = null;
    L6:
        return r0.isLogin();
    }

    public final int logoutScene() throws AccountException {
        IAccountManager r2 = null;
        checkInit$default(this, false, 1, null);
        IAccountManager r3 = mAccountManager;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
    L7:
        return r2.logoutScene();
    L5:
        r2 = r3;
        goto L7
    }

    public final String innerToken() throws AccountException {
        IAccountManager r2 = null;
        checkInit$default(this, false, 1, null);
        IAccountManager r3 = mAccountManager;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
    L7:
        return r2.innerToken();
    L5:
        r2 = r3;
        goto L7
    }

    public static /* synthetic */ AccountInfo accountInfo$default(OAccount r0, boolean r1, int r2, Object r3) throws AccountException {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return r0.accountInfo(r1);
    }

    public final AccountInfo accountInfo(boolean r3) throws AccountException {
        IAccountManager r1 = null;
        checkInit$default(this, false, 1, null);
        IAccountManager r2 = mAccountManager;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
    L7:
        return r1.accountInfo();
    L5:
        r1 = r2;
        goto L7
    }

    public final void updateAccountInfo() throws AccountException {
        IAccountManager r2 = null;
        checkInit$default(this, false, 1, null);
        IAccountManager r3 = mAccountManager;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
    L6:
        r2.updateAccountInfo();
        return;
    L5:
        r2 = r3;
        goto L6
    }

    public final void updateAccountInfoAsync(IUpdateAccountInfoCallback r4) throws AccountException {
        IAccountManager r2 = null;
        checkInit$default(this, false, 1, null);
        IAccountManager r3 = mAccountManager;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
    L6:
        r2.updateAccountInfoAsync(r4);
        return;
    L5:
        r2 = r3;
        goto L6
    }

    public final Map<String, String> xttTokenMap() throws AccountException {
        IAccountManager r2 = null;
        checkInit$default(this, false, 1, null);
        IAccountManager r3 = mAccountManager;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
    L7:
        return r2.xttTokenMap();
    L5:
        r2 = r3;
        goto L7
    }

    public final void updateXttTokenMap() throws AccountException {
        IAccountManager r2 = null;
        checkInit$default(this, false, 1, null);
        IAccountManager r3 = mAccountManager;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
    L6:
        r2.updateXttTokenMap();
        return;
    L5:
        r2 = r3;
        goto L6
    }

    public final void updateXttTokenMapAsync(IUpdateTokenMapCallback r4) throws AccountException {
        IAccountManager r2 = null;
        checkInit$default(this, false, 1, null);
        IAccountManager r3 = mAccountManager;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
    L6:
        r2.updateXttTokenMapAsync(r4);
        return;
    L5:
        r2 = r3;
        goto L6
    }

    public final void addAccountStatusListener(IAccountStatusListener r1) {
        Intrinsics.checkNotNullParameter(r1, "accountStatusListener");
        IAccountManager r0 = mAccountManager;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
        r0 = null;
    L5:
        r0.addAccountStatusListener(r1);
    }

    public final void removeAccountStatusListener(IAccountStatusListener r1) {
        Intrinsics.checkNotNullParameter(r1, "accountStatusListener");
        IAccountManager r0 = mAccountManager;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
        r0 = null;
    L5:
        r0.removeAccountStatusListener(r1);
    }

    public final void setLoginPhoneNumber(String r4) {
        Intrinsics.checkNotNullParameter(r4, "phoneNumber");
        IAccountManager r2 = null;
        checkInit$default(this, false, 1, null);
        OLog.i(TAG, AccountConst.METHOD_SET_LOGIN_PHONE_NUMBER);
        IAccountManager r0 = mAccountManager;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
    L6:
        r2.setLoginPhoneNumber(r4);
        OLog.i(TAG, "setLoginPhoneNumber updateAccountInfo");
        updateAccountInfo();
        return;
    L5:
        r2 = r0;
        goto L6
    }

    private final void startBindService() {
        checkInit$default(this, false, 1, null);
        OLog.i(TAG, "startBindService: ");
        Intent r0 = new Intent();
        r0.setClassName("com.obric.matrix", AccountConst.ACCOUNT_SERVICE_NAME);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        OAccount r5 = this;     // Catch: Throwable -> L8
        if (AppGlobals.INSTANCE.getApplicationContext().bindService(r0, mAccountServiceCon, 1) == true) goto L6;
        OLog.e(TAG, "startBindService: failed");     // Catch: Throwable -> L8
    L6:
        Object r6 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r7 = Result.m806exceptionOrNullimpl(r6);
        if (r7 == null) goto L16;
        OLog.INSTANCE.e(TAG, "onFailure startBindService: failed", r7);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    static /* synthetic */ void checkInit$default(OAccount r0, boolean r1, int r2, Object r3) throws AccountException {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.checkInit(r1);
    }

    private final void checkInit(boolean r9) throws AccountException {
        if (r9 == false) goto L11;
        if (mInit.get() == false) goto L15;
        return;
    L15:
        initCountDownLatch.await(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS);     // Catch: Exception -> L8
        return;
    L9:
        throw new AccountException(1002, "account init timeout", null, 4, null);
    L11:
        if (mInit.get() == false) goto L14;
        return;
    L14:
        throw new AccountException(1001, "please call init first ", null, 4, null);
    }

    private final void callAccountService(Function1<? super IAccountService, Unit> r4, Function2<? super Integer, ? super String, Unit> r5) throws AccountException {
        checkInit$default(this, false, 1, null);
        IAccountService r0 = mAccountService;
        if (r0 != null) goto L8;
        OLog.w(TAG, "AccountService is null.");
        if (r5 == null) goto L7;
        r5.invoke(1002, "");
    L7:
        startBindService();
        return;
    L8:
        r4.invoke(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void asyncResultCallback$default(OAccount r10, String r11, boolean r12, Bundle r13, Function0 r14, Function1 r15, Function2 r16, Function0 r17, int r18, Object r19) {
        if ((r18 & 8) == 0) goto L5;
        Function0 r6 = null;
    L7:
        if ((r18 & 16) == 0) goto L9;
        Function1 r7 = null;
    L11:
        if ((r18 & 32) == 0) goto L13;
        Function2 r8 = null;
    L15:
        if ((r18 & 64) == 0) goto L17;
        Function0 r9 = null;
    L18:
        r10.asyncResultCallback(r11, r12, r13, r6, r7, r8, r9);
        return;
    L17:
        r9 = r17;
        goto L18
    L13:
        r8 = r16;
        goto L15
    L9:
        r7 = r15;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }

    private final void asyncResultCallback(final String r11, final boolean r12, final Bundle r13, final Function0<Unit> r14, final Function1<? super Bundle, Unit> r15, final Function2<? super Integer, ? super String, Unit> r16, final Function0<Unit> r17) {
        mCallbackHandler.post(new OAccount$$ExternalSyntheticLambda0(r12, r11, r15, r13, r14, r17, r16));
    }

    /* JADX INFO: renamed from: asyncResultCallback$lambda-3, reason: not valid java name */
    private static final void m354asyncResultCallback$lambda3(boolean r3, String r4, Function1 r5, Bundle r6, Function0 r7, Function0 r8, Function2 r9) {
        Intrinsics.checkNotNullParameter(r4, "$method");
        if (r3 == false) goto L11;
        OLog.d(TAG, "asyncResult, " + r4 + ", success");
        if (r5 == null) goto L7;
        r5.invoke(r6);
    L9:
        if (r8 == null) goto L17;
        r8.invoke();
        return;
    L17:
        return;
    L7:
        if (r7 == null) goto L9;
        r7.invoke();
        goto L9
    L11:
        OAccount r10 = INSTANCE;
        int r11 = r10.getErrorCode(r6, -1);
        String r12 = r10.getDefaultErrorMsg();
        Intrinsics.checkNotNullExpressionValue(r12, "defaultErrorMsg");
        String r13 = r10.getErrorMsg(r6, r12);
        OLog.e(TAG, "asyncResult, " + r4 + " failed. errorCode: " + r11 + " errorMsg: " + r13 + '.');
        if (r9 == null) goto L14;
        r9.invoke(Integer.valueOf(r11), r13);
    L14:
        if (r8 == null) goto L19;
        r8.invoke();
        return;
    }

    private final int getErrorCode(Bundle r1, int r2) {
        if (r1 != null) goto L4;
        return r2;
    L4:
        return r1.getInt(AccountConst.KEY_ERROR_CODE, r2);
    }

    private final String getErrorMsg(Bundle r1, String r2) {
        if (r1 == null) goto L4;
        String r0 = r1.getString(AccountConst.KEY_ERROR_MSG, r2);
    L5:
        if (r0 != null) goto L8;
        return r2;
    L8:
        return r0;
    L4:
        r0 = null;
        goto L5
    }
}
