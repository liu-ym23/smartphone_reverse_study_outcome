package com.stepos.alphame.perfbinder;

import android.bluetooth.BluetoothClass;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import ch.qos.logback.core.joran.action.Action;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.appinfo.AppInfoDbHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p2.AbstractC0816a;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bq\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010u\u001a\u00020v2\b\u0010w\u001a\u0004\u0018\u00010x2\u0006\u0010y\u001a\u00020zH\u0007J\u0012\u0010{\u001a\u0004\u0018\u00010|2\u0006\u0010}\u001a\u00020\u0004H\u0007J\u0019\u0010~\u001a\u00020z2\u0006\u0010\u007f\u001a\u00020\u00042\u0007\u0010\u0080\u0001\u001a\u00020zH\u0007J\u0012\u0010\u0081\u0001\u001a\u00020v2\u0007\u0010\u0082\u0001\u001a\u00020vH\u0007J\t\u0010\u0083\u0001\u001a\u00020vH\u0007J\t\u0010\u0084\u0001\u001a\u00020vH\u0007J\t\u0010\u0085\u0001\u001a\u00020vH\u0007J\t\u0010\u0086\u0001\u001a\u00020vH\u0007J\t\u0010\u0087\u0001\u001a\u00020vH\u0007J\t\u0010\u0088\u0001\u001a\u00020vH\u0007J\n\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0007J\u001b\u0010\u008b\u0001\u001a\u00020v2\u0007\u0010\u008c\u0001\u001a\u00020\u00042\u0007\u0010\u008d\u0001\u001a\u00020vH\u0007J\u001f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u008c\u0001\u001a\u00020\u00042\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J\t\u0010\u008f\u0001\u001a\u00020zH\u0007J\u001d\u0010\u0090\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0092\u00010\u0091\u0001j\n\u0012\u0005\u0012\u00030\u0092\u0001`\u0093\u0001H\u0007J\t\u0010\u0094\u0001\u001a\u00020zH\u0007J\t\u0010\u0095\u0001\u001a\u00020vH\u0007J\u0015\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u00012\u0007\u0010\u0098\u0001\u001a\u00020vH\u0007J\u0014\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u009a\u0001\u001a\u00020zH\u0007J/\u0010\u009b\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00040\u0091\u0001j\t\u0012\u0004\u0012\u00020\u0004`\u0093\u00012\u0007\u0010\u009c\u0001\u001a\u00020z2\t\b\u0002\u0010\u009d\u0001\u001a\u00020zH\u0007J\u0012\u0010\u009e\u0001\u001a\u00020z2\u0007\u0010\u008d\u0001\u001a\u00020zH\u0007J\u001f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010 \u0001\u001a\u00020\u00042\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J\u001b\u0010¡\u0001\u001a\u00020v2\u0007\u0010 \u0001\u001a\u00020\u00042\u0007\u0010\u008d\u0001\u001a\u00020vH\u0007J\u001b\u0010¢\u0001\u001a\u00020z2\u0007\u0010 \u0001\u001a\u00020\u00042\u0007\u0010\u008d\u0001\u001a\u00020zH\u0007J\f\u0010£\u0001\u001a\u0005\u0018\u00010\u0092\u0001H\u0007J\n\u0010¤\u0001\u001a\u00030\u0092\u0001H\u0007J\n\u0010¥\u0001\u001a\u00030\u0092\u0001H\u0007J\u000b\u0010¦\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J\u001f\u0010§\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010¨\u0001\u001a\u00020z2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010ª\u0001\u001a\u00030\u0092\u0001H\u0007J\u000b\u0010«\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010¬\u0001\u001a\u00020z2\u0007\u0010\u008d\u0001\u001a\u00020zH\u0007J\u000b\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010®\u0001\u001a\u00030\u0092\u0001H\u0007J\u001f\u0010¯\u0001\u001a\u00030\u0092\u00012\u0007\u0010°\u0001\u001a\u00020\u00042\n\b\u0002\u0010±\u0001\u001a\u00030\u0092\u0001H\u0002J&\u0010²\u0001\u001a\u00020v2\u0007\u0010³\u0001\u001a\u00020\u00042\u0007\u0010\u009c\u0001\u001a\u00020z2\t\b\u0002\u0010\u009d\u0001\u001a\u00020zH\u0007J\t\u0010´\u0001\u001a\u00020vH\u0007J\u0012\u0010µ\u0001\u001a\u00020v2\u0007\u0010³\u0001\u001a\u00020\u0004H\u0007J\t\u0010¶\u0001\u001a\u00020vH\u0007J\u001a\u0010·\u0001\u001a\u00020v2\u0006\u0010}\u001a\u00020\u00042\u0007\u0010¸\u0001\u001a\u00020|H\u0007J\u0012\u0010¹\u0001\u001a\u00020v2\u0007\u0010º\u0001\u001a\u00020zH\u0007J\u0012\u0010»\u0001\u001a\u00020v2\u0007\u0010¼\u0001\u001a\u00020zH\u0007J\u0012\u0010½\u0001\u001a\u00020v2\u0007\u0010¾\u0001\u001a\u00020vH\u0007J\u001f\u0010¿\u0001\u001a\u00020v2\u0007\u0010À\u0001\u001a\u00020\u00042\u000b\b\u0002\u0010Á\u0001\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006Â\u0001"}, d2 = {"Lcom/stepos/alphame/perfbinder/PerfBinderHelper;", "", "()V", "ACCESS_IPC_SERVICE_PERMISSION", "", "ACTION_APP_EVENTS_FORWARD", "ACTION_APP_STATUS_FORWARD", "ACTION_NOTIFICATION_FORWARD", "ACTION_PACKAGE_CHANGED_FORWARD", "ACTION_SCENE_WORKING_STATE_FORWARD", "ACTION_WINDOW_MODE_FORWARD", PerfBinderHelper.ACTIVE_GPS_UIDS, PerfBinderHelper.APP_EXISTS, "AUTHORITY", PerfBinderHelper.BLUETOOTH_CLASS, PerfBinderHelper.BLUETOOTH_CLASS_MATCH, PerfBinderHelper.BLUETOOTH_PROFILE, PerfBinderHelper.BUILD_EXT_BOOL_DEFAULT, PerfBinderHelper.BUILD_EXT_BOOL_VALUE, PerfBinderHelper.BUILD_EXT_FIELD_NAME, PerfBinderHelper.BUILD_EXT_STRING_DEFAULT, PerfBinderHelper.BUILD_EXT_STRING_VALUE, "CALLBACK_STATE_CHANGED", "CALLBACK_WINDOW_MODE_CHANGED", PerfBinderHelper.CALL_STATE, PerfBinderHelper.CURRENT_USER_ID, PerfBinderHelper.DATA_ENABLED, "DISPLAY_ID", "EVENT_KIND_ACTIVITY", "EVENT_KIND_PROCESS", "EXTRA_CALLBACK", PerfBinderHelper.EXTRA_CLASS_NAME, PerfBinderHelper.EXTRA_DATA_BUNDLE, PerfBinderHelper.EXTRA_EVENT_KIND, PerfBinderHelper.EXTRA_EVENT_TYPE, "EXTRA_NEW_TYPE", "EXTRA_NEW_TYPE_STR", PerfBinderHelper.EXTRA_NOTI_EVENT, PerfBinderHelper.EXTRA_NOTI_FLAGS, PerfBinderHelper.EXTRA_NOTI_GROUP, PerfBinderHelper.EXTRA_NOTI_HAS_CONTENT, PerfBinderHelper.EXTRA_NOTI_ID, PerfBinderHelper.EXTRA_NOTI_ORIGINAL_PACKAGE, PerfBinderHelper.EXTRA_NOTI_PACKAGE, PerfBinderHelper.EXTRA_NOTI_TITLE, "EXTRA_OLD_TYPE", "EXTRA_OLD_TYPE_STR", PerfBinderHelper.EXTRA_ORIG_ACTION, PerfBinderHelper.EXTRA_PACKAGE, PerfBinderHelper.EXTRA_PROCESS_NAME, "EXTRA_TASK_ID", "EXTRA_WINDOWING_MODE", "EXTRA_WINDOW_MODE_STATE", "EXTRA_WINDOW_MODE_STATE_INT", PerfBinderHelper.FLAGS, PerfBinderHelper.IS_GUEST_USER, PerfBinderHelper.IS_MZ_APP, PerfBinderHelper.IS_PRODUCT_INTERNATIONAL, "KEY_PARALLEL_SPACE_USER_ID", "KEY_UID", "KEY_USER_HANDLE_ALL_ID", "KEY_USER_HANDLE_CURRENT_ID", "KEY_USER_HANDLE_OWNER_ID", "KEY_USER_HANDLE_SYSTEM_ID", "KEY_WAKELOCK_UIDS_ALL", "KEY_WAKELOCK_UIDS_AUDIO_IN", "KEY_WAKELOCK_UIDS_AUDIO_MIX", "KEY_WAKELOCK_UIDS_OTHERS", "KEY_WINDOW_MODE_FREEFORM", "KEY_WINDOW_MODE_PINNED", PerfBinderHelper.LOCATION_MODE, PerfBinderHelper.NETWORK_ID, "NOTI_EVENT_POSTED", "NOTI_EVENT_REMOVED", PerfBinderHelper.OWNER_PACKAGE_NAME, PerfBinderHelper.PACKAGE_NAME, PerfBinderHelper.PACKAGE_NAMES, "PARALLEL_SPACE_USER_ID", PerfBinderHelper.PERMISSION_NAME, PerfBinderHelper.PERMISSION_RESULT, PerfBinderHelper.RESULT, PerfBinderHelper.SCENE_CONFIG_CONTENT, PerfBinderHelper.SCENE_CONFIG_PATH, "SERVICE", PerfBinderHelper.SERVICE_BINDER, PerfBinderHelper.SERVICE_NAME, PerfBinderHelper.SMS_COMPONENT, PerfBinderHelper.SMS_UPDATE_IF_NEEDED, PerfBinderHelper.SYSTEM_PROPERTIES_BOOL_DEFAULT, PerfBinderHelper.SYSTEM_PROPERTIES_BOOL_VALUE, PerfBinderHelper.SYSTEM_PROPERTIES_DEFAULT, PerfBinderHelper.SYSTEM_PROPERTIES_INT_DEFAULT, PerfBinderHelper.SYSTEM_PROPERTIES_INT_VALUE, PerfBinderHelper.SYSTEM_PROPERTIES_KEY, PerfBinderHelper.SYSTEM_PROPERTIES_VALUE, PerfBinderHelper.TOP_ACTIVITY_BUNDLE, "UID", "USER_HANDLE_ALL_ID", "USER_HANDLE_CURRENT_ID", "USER_HANDLE_OWNER_ID", "USER_HANDLE_SYSTEM_ID", PerfBinderHelper.USER_ID, "WAKELOCK_UIDS_ALL", "WAKELOCK_UIDS_AUDIO_IN", "WAKELOCK_UIDS_AUDIO_MIX", "WAKELOCK_UIDS_OTHERS", PerfBinderHelper.WIFI_BSSID, PerfBinderHelper.WIFI_CONFIG_BSSIDS, PerfBinderHelper.WIFI_CONFIG_NETWORK_IDS, PerfBinderHelper.WIFI_CONFIG_SSIDS, PerfBinderHelper.WIFI_CREATOR_NAME, PerfBinderHelper.WIFI_DISABLE_SCAN, PerfBinderHelper.WIFI_MAC, PerfBinderHelper.WIFI_SCAN_ALWAYS_AVAILABLE, PerfBinderHelper.WIFI_SSID, "WINDOW_MODE_FREEFORM", "WINDOW_MODE_PINNED", "bluetoothClassDoesMatch", "", "btClass", "Landroid/bluetooth/BluetoothClass;", "profile", "", "checkAlphaMeService", "Landroid/os/IBinder;", Constants.JSON_KEY_SERVICE_NAME, "checkUidPermission", "permission", "uid", "disableWifiScanInterface", "disable", "enableAppEventsMonitor", "enableAppStatusMonitor", "enableCrossUserPackageMonitor", "enableNotificationMonitor", "enableSceneMonitor", "enableWindowModeMonitor", "getActiveGpsUids", "", "getBuildExtBoolean", "fieldName", "def", "getBuildExtString", "getCallState", "getConfiguredWifiNetworks", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "getCurrentUserId", "getDataEnabled", "getDefaultSmsApplication", "Landroid/content/ComponentName;", "updateIfNeeded", "getDisplayOwnerPackageName", "displayId", "getInstalledPackagesAsUser", "userId", "flags", "getLocationMode", "getSystemProperties", Action.KEY_ATTRIBUTE, "getSystemPropertiesBoolean", "getSystemPropertiesInt", "getTopActivityBundle", "getUserHandleConstants", "getWakeLockUidSets", "getWifiBssid", "getWifiConfigCreatorName", "networkId", "ssid", "getWifiConnectionInfo", "getWifiMac", "getWifiScanAlwaysAvailable", "getWifiSsid", "getWindowModeConstants", "ipc", "method", "params", "isAppExistAsUser", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "isGuestUser", "isMzApp", "isProductInternational", "publishAlphaMeService", "binder", "putLocationMode", "mode", "putWifiScanAlwaysAvailable", "value", "setDataEnabled", "enable", "writeSceneConfigFile", "content", "path", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPerfBinderHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PerfBinderHelper.kt\ncom/stepos/alphame/perfbinder/PerfBinderHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,447:1\n1#2:448\n*E\n"})
/* loaded from: classes.dex */
public final class PerfBinderHelper {

    @NotNull
    public static final String ACCESS_IPC_SERVICE_PERMISSION = "com.stepos.appplatform.permission.ACCESS_IPC_SERVICE";

    @NotNull
    public static final String ACTION_APP_EVENTS_FORWARD = "com.stepos.alphame.ACTION_APP_EVENTS_FORWARD";

    @NotNull
    public static final String ACTION_APP_STATUS_FORWARD = "com.stepos.alphame.ACTION_APP_STATUS_FORWARD";

    @NotNull
    public static final String ACTION_NOTIFICATION_FORWARD = "com.stepos.alphame.ACTION_NOTIFICATION_FORWARD";

    @NotNull
    public static final String ACTION_PACKAGE_CHANGED_FORWARD = "com.stepos.alphame.ACTION_PACKAGE_CHANGED_FORWARD";

    @NotNull
    public static final String ACTION_SCENE_WORKING_STATE_FORWARD = "com.stepos.alphame.ACTION_SCENE_WORKING_STATE_FORWARD";

    @NotNull
    public static final String ACTION_WINDOW_MODE_FORWARD = "com.stepos.alphame.ACTION_WINDOW_MODE_FORWARD";

    @NotNull
    private static final String ACTIVE_GPS_UIDS = "ACTIVE_GPS_UIDS";

    @NotNull
    private static final String APP_EXISTS = "APP_EXISTS";

    @NotNull
    private static final String AUTHORITY = "com.stepos.appplatform";

    @NotNull
    private static final String BLUETOOTH_CLASS = "BLUETOOTH_CLASS";

    @NotNull
    private static final String BLUETOOTH_CLASS_MATCH = "BLUETOOTH_CLASS_MATCH";

    @NotNull
    private static final String BLUETOOTH_PROFILE = "BLUETOOTH_PROFILE";

    @NotNull
    private static final String BUILD_EXT_BOOL_DEFAULT = "BUILD_EXT_BOOL_DEFAULT";

    @NotNull
    private static final String BUILD_EXT_BOOL_VALUE = "BUILD_EXT_BOOL_VALUE";

    @NotNull
    private static final String BUILD_EXT_FIELD_NAME = "BUILD_EXT_FIELD_NAME";

    @NotNull
    private static final String BUILD_EXT_STRING_DEFAULT = "BUILD_EXT_STRING_DEFAULT";

    @NotNull
    private static final String BUILD_EXT_STRING_VALUE = "BUILD_EXT_STRING_VALUE";

    @NotNull
    public static final String CALLBACK_STATE_CHANGED = "onStateChanged";

    @NotNull
    public static final String CALLBACK_WINDOW_MODE_CHANGED = "onWindowModeChanged";

    @NotNull
    private static final String CALL_STATE = "CALL_STATE";

    @NotNull
    private static final String CURRENT_USER_ID = "CURRENT_USER_ID";

    @NotNull
    private static final String DATA_ENABLED = "DATA_ENABLED";

    @NotNull
    private static final String DISPLAY_ID = "DISPLAY_ID";

    @NotNull
    public static final String EVENT_KIND_ACTIVITY = "activity";

    @NotNull
    public static final String EVENT_KIND_PROCESS = "process";

    @NotNull
    public static final String EXTRA_CALLBACK = "EXTRA_CALLBACK";

    @NotNull
    public static final String EXTRA_CLASS_NAME = "EXTRA_CLASS_NAME";

    @NotNull
    public static final String EXTRA_DATA_BUNDLE = "EXTRA_DATA_BUNDLE";

    @NotNull
    public static final String EXTRA_EVENT_KIND = "EXTRA_EVENT_KIND";

    @NotNull
    public static final String EXTRA_EVENT_TYPE = "EXTRA_EVENT_TYPE";

    @NotNull
    public static final String EXTRA_NEW_TYPE = "EXTRA_NEW_TYPE";

    @NotNull
    public static final String EXTRA_NEW_TYPE_STR = "EXTRA_NEW_TYPE_STR";

    @NotNull
    public static final String EXTRA_NOTI_EVENT = "EXTRA_NOTI_EVENT";

    @NotNull
    public static final String EXTRA_NOTI_FLAGS = "EXTRA_NOTI_FLAGS";

    @NotNull
    public static final String EXTRA_NOTI_GROUP = "EXTRA_NOTI_GROUP";

    @NotNull
    public static final String EXTRA_NOTI_HAS_CONTENT = "EXTRA_NOTI_HAS_CONTENT";

    @NotNull
    public static final String EXTRA_NOTI_ID = "EXTRA_NOTI_ID";

    @NotNull
    public static final String EXTRA_NOTI_ORIGINAL_PACKAGE = "EXTRA_NOTI_ORIGINAL_PACKAGE";

    @NotNull
    public static final String EXTRA_NOTI_PACKAGE = "EXTRA_NOTI_PACKAGE";

    @NotNull
    public static final String EXTRA_NOTI_TITLE = "EXTRA_NOTI_TITLE";

    @NotNull
    public static final String EXTRA_OLD_TYPE = "EXTRA_OLD_TYPE";

    @NotNull
    public static final String EXTRA_OLD_TYPE_STR = "EXTRA_OLD_TYPE_STR";

    @NotNull
    public static final String EXTRA_ORIG_ACTION = "EXTRA_ORIG_ACTION";

    @NotNull
    public static final String EXTRA_PACKAGE = "EXTRA_PACKAGE";

    @NotNull
    public static final String EXTRA_PROCESS_NAME = "EXTRA_PROCESS_NAME";

    @NotNull
    public static final String EXTRA_TASK_ID = "EXTRA_TASK_ID";

    @NotNull
    public static final String EXTRA_WINDOWING_MODE = "EXTRA_WINDOWING_MODE";

    @NotNull
    public static final String EXTRA_WINDOW_MODE_STATE = "EXTRA_WINDOW_MODE_STATE";

    @NotNull
    public static final String EXTRA_WINDOW_MODE_STATE_INT = "EXTRA_WINDOW_MODE_STATE_INT";

    @NotNull
    private static final String FLAGS = "FLAGS";

    @NotNull
    public static final PerfBinderHelper INSTANCE = new PerfBinderHelper();

    @NotNull
    private static final String IS_GUEST_USER = "IS_GUEST_USER";

    @NotNull
    private static final String IS_MZ_APP = "IS_MZ_APP";

    @NotNull
    private static final String IS_PRODUCT_INTERNATIONAL = "IS_PRODUCT_INTERNATIONAL";

    @NotNull
    public static final String KEY_PARALLEL_SPACE_USER_ID = "PARALLEL_SPACE_USER_ID";

    @NotNull
    public static final String KEY_UID = "UID";

    @NotNull
    public static final String KEY_USER_HANDLE_ALL_ID = "USER_HANDLE_ALL_ID";

    @NotNull
    public static final String KEY_USER_HANDLE_CURRENT_ID = "USER_HANDLE_CURRENT_ID";

    @NotNull
    public static final String KEY_USER_HANDLE_OWNER_ID = "USER_HANDLE_OWNER_ID";

    @NotNull
    public static final String KEY_USER_HANDLE_SYSTEM_ID = "USER_HANDLE_SYSTEM_ID";

    @NotNull
    public static final String KEY_WAKELOCK_UIDS_ALL = "WAKELOCK_UIDS_ALL";

    @NotNull
    public static final String KEY_WAKELOCK_UIDS_AUDIO_IN = "WAKELOCK_UIDS_AUDIO_IN";

    @NotNull
    public static final String KEY_WAKELOCK_UIDS_AUDIO_MIX = "WAKELOCK_UIDS_AUDIO_MIX";

    @NotNull
    public static final String KEY_WAKELOCK_UIDS_OTHERS = "WAKELOCK_UIDS_OTHERS";

    @NotNull
    public static final String KEY_WINDOW_MODE_FREEFORM = "WINDOW_MODE_FREEFORM";

    @NotNull
    public static final String KEY_WINDOW_MODE_PINNED = "WINDOW_MODE_PINNED";

    @NotNull
    private static final String LOCATION_MODE = "LOCATION_MODE";

    @NotNull
    private static final String NETWORK_ID = "NETWORK_ID";

    @NotNull
    public static final String NOTI_EVENT_POSTED = "posted";

    @NotNull
    public static final String NOTI_EVENT_REMOVED = "removed";

    @NotNull
    private static final String OWNER_PACKAGE_NAME = "OWNER_PACKAGE_NAME";

    @NotNull
    private static final String PACKAGE_NAME = "PACKAGE_NAME";

    @NotNull
    private static final String PACKAGE_NAMES = "PACKAGE_NAMES";

    @NotNull
    private static final String PARALLEL_SPACE_USER_ID = "PARALLEL_SPACE_USER_ID";

    @NotNull
    private static final String PERMISSION_NAME = "PERMISSION_NAME";

    @NotNull
    private static final String PERMISSION_RESULT = "PERMISSION_RESULT";

    @NotNull
    private static final String RESULT = "RESULT";

    @NotNull
    private static final String SCENE_CONFIG_CONTENT = "SCENE_CONFIG_CONTENT";

    @NotNull
    private static final String SCENE_CONFIG_PATH = "SCENE_CONFIG_PATH";

    @NotNull
    private static final String SERVICE = "com.stepos.appplatform.alphame.AlphaMeSettingsSystem";

    @NotNull
    private static final String SERVICE_BINDER = "SERVICE_BINDER";

    @NotNull
    private static final String SERVICE_NAME = "SERVICE_NAME";

    @NotNull
    private static final String SMS_COMPONENT = "SMS_COMPONENT";

    @NotNull
    private static final String SMS_UPDATE_IF_NEEDED = "SMS_UPDATE_IF_NEEDED";

    @NotNull
    private static final String SYSTEM_PROPERTIES_BOOL_DEFAULT = "SYSTEM_PROPERTIES_BOOL_DEFAULT";

    @NotNull
    private static final String SYSTEM_PROPERTIES_BOOL_VALUE = "SYSTEM_PROPERTIES_BOOL_VALUE";

    @NotNull
    private static final String SYSTEM_PROPERTIES_DEFAULT = "SYSTEM_PROPERTIES_DEFAULT";

    @NotNull
    private static final String SYSTEM_PROPERTIES_INT_DEFAULT = "SYSTEM_PROPERTIES_INT_DEFAULT";

    @NotNull
    private static final String SYSTEM_PROPERTIES_INT_VALUE = "SYSTEM_PROPERTIES_INT_VALUE";

    @NotNull
    private static final String SYSTEM_PROPERTIES_KEY = "SYSTEM_PROPERTIES_KEY";

    @NotNull
    private static final String SYSTEM_PROPERTIES_VALUE = "SYSTEM_PROPERTIES_VALUE";

    @NotNull
    private static final String TOP_ACTIVITY_BUNDLE = "TOP_ACTIVITY_BUNDLE";

    @NotNull
    private static final String UID = "UID";

    @NotNull
    private static final String USER_HANDLE_ALL_ID = "USER_HANDLE_ALL_ID";

    @NotNull
    private static final String USER_HANDLE_CURRENT_ID = "USER_HANDLE_CURRENT_ID";

    @NotNull
    private static final String USER_HANDLE_OWNER_ID = "USER_HANDLE_OWNER_ID";

    @NotNull
    private static final String USER_HANDLE_SYSTEM_ID = "USER_HANDLE_SYSTEM_ID";

    @NotNull
    private static final String USER_ID = "USER_ID";

    @NotNull
    private static final String WAKELOCK_UIDS_ALL = "WAKELOCK_UIDS_ALL";

    @NotNull
    private static final String WAKELOCK_UIDS_AUDIO_IN = "WAKELOCK_UIDS_AUDIO_IN";

    @NotNull
    private static final String WAKELOCK_UIDS_AUDIO_MIX = "WAKELOCK_UIDS_AUDIO_MIX";

    @NotNull
    private static final String WAKELOCK_UIDS_OTHERS = "WAKELOCK_UIDS_OTHERS";

    @NotNull
    private static final String WIFI_BSSID = "WIFI_BSSID";

    @NotNull
    private static final String WIFI_CONFIG_BSSIDS = "WIFI_CONFIG_BSSIDS";

    @NotNull
    private static final String WIFI_CONFIG_NETWORK_IDS = "WIFI_CONFIG_NETWORK_IDS";

    @NotNull
    private static final String WIFI_CONFIG_SSIDS = "WIFI_CONFIG_SSIDS";

    @NotNull
    private static final String WIFI_CREATOR_NAME = "WIFI_CREATOR_NAME";

    @NotNull
    private static final String WIFI_DISABLE_SCAN = "WIFI_DISABLE_SCAN";

    @NotNull
    private static final String WIFI_MAC = "WIFI_MAC";

    @NotNull
    private static final String WIFI_SCAN_ALWAYS_AVAILABLE = "WIFI_SCAN_ALWAYS_AVAILABLE";

    @NotNull
    private static final String WIFI_SSID = "WIFI_SSID";

    @NotNull
    private static final String WINDOW_MODE_FREEFORM = "WINDOW_MODE_FREEFORM";

    @NotNull
    private static final String WINDOW_MODE_PINNED = "WINDOW_MODE_PINNED";

    private PerfBinderHelper() {
    }

    @JvmStatic
    public static final boolean bluetoothClassDoesMatch(@Nullable BluetoothClass btClass, int profile) {
        if (btClass == null) {
            return false;
        }
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putParcelable(BLUETOOTH_CLASS, btClass);
        bundle.putInt(BLUETOOTH_PROFILE, profile);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("bluetoothClassDoesMatch", bundle).getBoolean(BLUETOOTH_CLASS_MATCH, false);
    }

    @JvmStatic
    @Nullable
    public static final IBinder checkAlphaMeService(@NotNull String serviceName) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(SERVICE_NAME, serviceName);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("checkAlphaMeService", bundle).getBinder(SERVICE_BINDER);
    }

    @JvmStatic
    public static final int checkUidPermission(@NotNull String permission, int uid) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(PERMISSION_NAME, permission);
        bundle.putInt("UID", uid);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("checkUidPermission", bundle).getInt(PERMISSION_RESULT, -1);
    }

    @JvmStatic
    public static final boolean disableWifiScanInterface(boolean disable) {
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putBoolean(WIFI_DISABLE_SCAN, disable);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("disableWifiScanInterface", bundle).getBoolean(RESULT, false);
    }

    @JvmStatic
    public static final boolean enableAppEventsMonitor() {
        return ipc$default(INSTANCE, "enableAppEventsMonitor", null, 2, null).getBoolean(RESULT, false);
    }

    @JvmStatic
    public static final boolean enableAppStatusMonitor() {
        return ipc$default(INSTANCE, "enableAppStatusMonitor", null, 2, null).getBoolean(RESULT, false);
    }

    @JvmStatic
    public static final boolean enableCrossUserPackageMonitor() {
        return ipc$default(INSTANCE, "enableCrossUserPackageMonitor", null, 2, null).getBoolean(RESULT, false);
    }

    @JvmStatic
    public static final boolean enableNotificationMonitor() {
        return ipc$default(INSTANCE, "enableNotificationMonitor", null, 2, null).getBoolean(RESULT, false);
    }

    @JvmStatic
    public static final boolean enableSceneMonitor() {
        return ipc$default(INSTANCE, "enableSceneMonitor", null, 2, null).getBoolean(RESULT, false);
    }

    @JvmStatic
    public static final boolean enableWindowModeMonitor() {
        return ipc$default(INSTANCE, "enableWindowModeMonitor", null, 2, null).getBoolean(RESULT, false);
    }

    @JvmStatic
    @NotNull
    public static final int[] getActiveGpsUids() {
        int[] intArray = ipc$default(INSTANCE, "getActiveGpsUids", null, 2, null).getIntArray(ACTIVE_GPS_UIDS);
        return intArray == null ? new int[0] : intArray;
    }

    @JvmStatic
    public static final boolean getBuildExtBoolean(@NotNull String fieldName, boolean def) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(BUILD_EXT_FIELD_NAME, fieldName);
        bundle.putBoolean(BUILD_EXT_BOOL_DEFAULT, def);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("getBuildExtBoolean", bundle).getBoolean(BUILD_EXT_BOOL_VALUE, def);
    }

    @JvmStatic
    @Nullable
    public static final String getBuildExtString(@NotNull String fieldName, @Nullable String def) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(BUILD_EXT_FIELD_NAME, fieldName);
        bundle.putString(BUILD_EXT_STRING_DEFAULT, def);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("getBuildExtString", bundle).getString(BUILD_EXT_STRING_VALUE, def);
    }

    @JvmStatic
    public static final int getCallState() {
        return ipc$default(INSTANCE, "getCallState", null, 2, null).getInt(CALL_STATE, 0);
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<Bundle> getConfiguredWifiNetworks() {
        Bundle bundleIpc$default = ipc$default(INSTANCE, "getConfiguredWifiNetworks", null, 2, null);
        int[] intArray = bundleIpc$default.getIntArray(WIFI_CONFIG_NETWORK_IDS);
        if (intArray == null) {
            intArray = new int[0];
        }
        ArrayList<String> stringArrayList = bundleIpc$default.getStringArrayList(WIFI_CONFIG_SSIDS);
        if (stringArrayList == null) {
            stringArrayList = new ArrayList<>();
        }
        ArrayList<String> stringArrayList2 = bundleIpc$default.getStringArrayList(WIFI_CONFIG_BSSIDS);
        if (stringArrayList2 == null) {
            stringArrayList2 = new ArrayList<>();
        }
        int iMin = Math.min(intArray.length, Math.min(stringArrayList.size(), stringArrayList2.size()));
        ArrayList<Bundle> arrayList = new ArrayList<>(iMin);
        for (int i4 = 0; i4 < iMin; i4++) {
            Bundle bundle = new Bundle();
            bundle.putInt("networkId", intArray[i4]);
            bundle.putString("ssid", stringArrayList.get(i4));
            bundle.putString("bssid", stringArrayList2.get(i4));
            arrayList.add(bundle);
        }
        return arrayList;
    }

    @JvmStatic
    public static final int getCurrentUserId() {
        return ipc$default(INSTANCE, "getCurrentUserId", null, 2, null).getInt(CURRENT_USER_ID, -1);
    }

    @JvmStatic
    public static final boolean getDataEnabled() {
        return ipc$default(INSTANCE, "getDataEnabled", null, 2, null).getBoolean(DATA_ENABLED, false);
    }

    @JvmStatic
    @Nullable
    public static final ComponentName getDefaultSmsApplication(boolean updateIfNeeded) {
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putBoolean(SMS_UPDATE_IF_NEEDED, updateIfNeeded);
        Unit unit = Unit.INSTANCE;
        return (ComponentName) perfBinderHelper.ipc("getDefaultSmsApplication", bundle).getParcelable(SMS_COMPONENT, ComponentName.class);
    }

    @JvmStatic
    @Nullable
    public static final String getDisplayOwnerPackageName(int displayId) {
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putInt("DISPLAY_ID", displayId);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("getDisplayOwnerPackageName", bundle).getString(OWNER_PACKAGE_NAME);
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<String> getInstalledPackagesAsUser(int userId, int flags) {
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putInt(USER_ID, userId);
        bundle.putInt(FLAGS, flags);
        Unit unit = Unit.INSTANCE;
        ArrayList<String> stringArrayList = perfBinderHelper.ipc("getInstalledPackagesAsUser", bundle).getStringArrayList(PACKAGE_NAMES);
        return stringArrayList == null ? new ArrayList<>() : stringArrayList;
    }

    public static /* synthetic */ ArrayList getInstalledPackagesAsUser$default(int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 1;
        }
        return getInstalledPackagesAsUser(i4, i5);
    }

    @JvmStatic
    public static final int getLocationMode(int def) {
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putInt(LOCATION_MODE, def);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("getLocationMode", bundle).getInt(LOCATION_MODE, def);
    }

    @JvmStatic
    @Nullable
    public static final String getSystemProperties(@NotNull String key, @Nullable String def) {
        Intrinsics.checkNotNullParameter(key, "key");
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(SYSTEM_PROPERTIES_KEY, key);
        bundle.putString(SYSTEM_PROPERTIES_DEFAULT, def);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("getSystemProperties", bundle).getString(SYSTEM_PROPERTIES_VALUE, def);
    }

    @JvmStatic
    public static final boolean getSystemPropertiesBoolean(@NotNull String key, boolean def) {
        Intrinsics.checkNotNullParameter(key, "key");
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(SYSTEM_PROPERTIES_KEY, key);
        bundle.putBoolean(SYSTEM_PROPERTIES_BOOL_DEFAULT, def);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("getSystemPropertiesBoolean", bundle).getBoolean(SYSTEM_PROPERTIES_BOOL_VALUE, def);
    }

    @JvmStatic
    public static final int getSystemPropertiesInt(@NotNull String key, int def) {
        Intrinsics.checkNotNullParameter(key, "key");
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(SYSTEM_PROPERTIES_KEY, key);
        bundle.putInt(SYSTEM_PROPERTIES_INT_DEFAULT, def);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("getSystemPropertiesInt", bundle).getInt(SYSTEM_PROPERTIES_INT_VALUE, def);
    }

    @JvmStatic
    @Nullable
    public static final Bundle getTopActivityBundle() {
        return (Bundle) ipc$default(INSTANCE, "getTopActivityBundle", null, 2, null).getParcelable(TOP_ACTIVITY_BUNDLE, Bundle.class);
    }

    @JvmStatic
    @NotNull
    public static final Bundle getUserHandleConstants() {
        return ipc$default(INSTANCE, "getUserHandleConstants", null, 2, null);
    }

    @JvmStatic
    @NotNull
    public static final Bundle getWakeLockUidSets() {
        return ipc$default(INSTANCE, "getWakeLockUidSets", null, 2, null);
    }

    @JvmStatic
    @Nullable
    public static final String getWifiBssid() {
        return getWifiConnectionInfo().getString(WIFI_BSSID);
    }

    @JvmStatic
    @Nullable
    public static final String getWifiConfigCreatorName(int networkId, @Nullable String ssid) {
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putInt(NETWORK_ID, networkId);
        bundle.putString(WIFI_SSID, ssid);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("getWifiConfigCreatorName", bundle).getString(WIFI_CREATOR_NAME);
    }

    @JvmStatic
    @NotNull
    public static final Bundle getWifiConnectionInfo() {
        return ipc$default(INSTANCE, "getWifiConnectionInfo", null, 2, null);
    }

    @JvmStatic
    @Nullable
    public static final String getWifiMac() {
        return getWifiConnectionInfo().getString(WIFI_MAC);
    }

    @JvmStatic
    public static final int getWifiScanAlwaysAvailable(int def) {
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putInt(WIFI_SCAN_ALWAYS_AVAILABLE, def);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("getWifiScanAlwaysAvailable", bundle).getInt(WIFI_SCAN_ALWAYS_AVAILABLE, def);
    }

    @JvmStatic
    @Nullable
    public static final String getWifiSsid() {
        return getWifiConnectionInfo().getString(WIFI_SSID);
    }

    @JvmStatic
    @NotNull
    public static final Bundle getWindowModeConstants() {
        return ipc$default(INSTANCE, "getWindowModeConstants", null, 2, null);
    }

    private final Bundle ipc(String method, Bundle params) {
        return AbstractC0816a.a(method, params);
    }

    public static /* synthetic */ Bundle ipc$default(PerfBinderHelper perfBinderHelper, String str, Bundle bundle, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            bundle = new Bundle();
        }
        return perfBinderHelper.ipc(str, bundle);
    }

    @JvmStatic
    public static final boolean isAppExistAsUser(@NotNull String packageName, int userId, int flags) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(PACKAGE_NAME, packageName);
        bundle.putInt(USER_ID, userId);
        bundle.putInt(FLAGS, flags);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("getApplicationInfoAsUser", bundle).getBoolean(APP_EXISTS, false);
    }

    public static /* synthetic */ boolean isAppExistAsUser$default(String str, int i4, int i5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i5 = 128;
        }
        return isAppExistAsUser(str, i4, i5);
    }

    @JvmStatic
    public static final boolean isGuestUser() {
        return ipc$default(INSTANCE, "isGuestUser", null, 2, null).getBoolean(IS_GUEST_USER, false);
    }

    @JvmStatic
    public static final boolean isMzApp(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(PACKAGE_NAME, packageName);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("isMzApp", bundle).getBoolean(IS_MZ_APP, true);
    }

    @JvmStatic
    public static final boolean isProductInternational() {
        return ipc$default(INSTANCE, "isProductInternational", null, 2, null).getBoolean(IS_PRODUCT_INTERNATIONAL, false);
    }

    @JvmStatic
    public static final boolean publishAlphaMeService(@NotNull String serviceName, @NotNull IBinder binder) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(binder, "binder");
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(SERVICE_NAME, serviceName);
        bundle.putBinder(SERVICE_BINDER, binder);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("publishAlphaMeService", bundle).getBoolean(RESULT, false);
    }

    @JvmStatic
    public static final boolean putLocationMode(int mode) {
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putInt(LOCATION_MODE, mode);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("putLocationMode", bundle).getBoolean(RESULT, false);
    }

    @JvmStatic
    public static final boolean putWifiScanAlwaysAvailable(int value) {
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putInt(WIFI_SCAN_ALWAYS_AVAILABLE, value);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("putWifiScanAlwaysAvailable", bundle).getBoolean(RESULT, false);
    }

    @JvmStatic
    public static final boolean setDataEnabled(boolean enable) {
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putBoolean(DATA_ENABLED, enable);
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("setDataEnabled", bundle).getBoolean(RESULT, false);
    }

    @JvmStatic
    public static final boolean writeSceneConfigFile(@NotNull String content, @Nullable String path) {
        Intrinsics.checkNotNullParameter(content, "content");
        PerfBinderHelper perfBinderHelper = INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putString(SCENE_CONFIG_CONTENT, content);
        if (path != null) {
            bundle.putString(SCENE_CONFIG_PATH, path);
        }
        Unit unit = Unit.INSTANCE;
        return perfBinderHelper.ipc("writeSceneConfigFile", bundle).getBoolean(RESULT, false);
    }

    public static /* synthetic */ boolean writeSceneConfigFile$default(String str, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str2 = null;
        }
        return writeSceneConfigFile(str, str2);
    }
}
