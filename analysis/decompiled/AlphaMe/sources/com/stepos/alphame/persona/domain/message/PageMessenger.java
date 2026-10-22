package com.stepos.alphame.persona.domain.message;

import androidx.lifecycle.G;
import com.stepos.alphame.persona.domain.event.Messages;
import com.stepos.alphame.screen.ScreenEventStorable;
import com.stepos.architecture.domain.dispatch.a;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/stepos/alphame/persona/domain/message/PageMessenger;", "Lcom/stepos/architecture/domain/dispatch/a;", "Lcom/stepos/alphame/persona/domain/event/Messages;", ScreenEventStorable.COLUMN_EVENT, "", "onHandle", "(Lcom/stepos/alphame/persona/domain/event/Messages;)V", "<init>", "()V", "app_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPageMessenger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PageMessenger.kt\ncom/stepos/alphame/persona/domain/message/PageMessenger\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,26:1\n1#2:27\n*E\n"})
/* loaded from: classes.dex */
public final class PageMessenger extends a {
    @Override // androidx.lifecycle.InterfaceC0315l
    public /* bridge */ /* synthetic */ void onCreate(@NotNull G g4) {
        super.onCreate(g4);
    }

    @Override // androidx.lifecycle.InterfaceC0315l
    public /* bridge */ /* synthetic */ void onPause(@NotNull G g4) {
        super.onPause(g4);
    }

    @Override // androidx.lifecycle.InterfaceC0315l
    public /* bridge */ /* synthetic */ void onResume(@NotNull G g4) {
        super.onResume(g4);
    }

    @Override // androidx.lifecycle.InterfaceC0315l
    public /* bridge */ /* synthetic */ void onStart(@NotNull G g4) {
        super.onStart(g4);
    }

    @Override // androidx.lifecycle.InterfaceC0315l
    public /* bridge */ /* synthetic */ void onStop(@NotNull G g4) {
        super.onStop(g4);
    }

    @Override // com.stepos.architecture.domain.dispatch.a
    public void onHandle(@Nullable Messages event) {
        if (event != null) {
            sendResult(event);
        }
    }
}
