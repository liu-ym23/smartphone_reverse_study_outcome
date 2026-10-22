package com.stepos.ailauncher.chat.adapter;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.adapter.S;
import com.stepos.ailauncher.chat.adapter.S.f;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000f*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/g0;", "Lcom/stepos/ailauncher/chat/adapter/S$f;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "<init>", "()V", "oldItem", "newItem", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/chat/adapter/S$f;Lcom/stepos/ailauncher/chat/adapter/S$f;)Z", Const.INTENT_KEY_APIKEY, "", "c", "(Lcom/stepos/ailauncher/chat/adapter/S$f;Lcom/stepos/ailauncher/chat/adapter/S$f;)Ljava/lang/Object;", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g0<T extends S.f> extends DiffUtil.ItemCallback<T> {
    private static final a Companion = new a(null);
    private static final Object PAYLOAD_REBIND = new Object();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/g0$a;", "", "<init>", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(T oldItem, T newItem) {
        kotlin.jvm.internal.p.i(oldItem, "oldItem");
        kotlin.jvm.internal.p.i(newItem, "newItem");
        return kotlin.jvm.internal.p.d(oldItem, newItem);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(T oldItem, T newItem) {
        kotlin.jvm.internal.p.i(oldItem, "oldItem");
        kotlin.jvm.internal.p.i(newItem, "newItem");
        return kotlin.jvm.internal.p.d(oldItem.a(), newItem.a());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Object getChangePayload(T oldItem, T newItem) {
        kotlin.jvm.internal.p.i(oldItem, "oldItem");
        kotlin.jvm.internal.p.i(newItem, "newItem");
        return PAYLOAD_REBIND;
    }
}
