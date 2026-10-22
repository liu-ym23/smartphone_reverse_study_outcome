package com.stepos.stepclaw.service.command;

import a6.f0;
import a6.i0;
import a6.r0;
import android.content.Context;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import f5.c;
import g5.a;
import h5.e;
import h5.i;
import h6.d;
import java.io.PrintWriter;
import kotlin.Metadata;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/stepos/stepclaw/service/command/DumpCommandHandler;", "Lcom/stepos/stepclaw/service/command/CommandHandler;", "<init>", "()V", "Landroid/content/Context;", "context", "Ljava/io/PrintWriter;", "writer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "args", "Lb5/a0;", "handle", "(Landroid/content/Context;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "commandName", "Ljava/lang/String;", "getCommandName", "()Ljava/lang/String;", "description", "getDescription", "usage", "getUsage", "Companion", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DumpCommandHandler implements CommandHandler {
    private static final String TAG = "DumpCommandHandler";
    private final String commandName = "dump";
    private final String description = "Display service status and statistics";
    private final String usage = "adb shell dumpsys activity service com.stepos.stepclaw/com.stepos.stepclaw.service.StepClawService dump";

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.service.command.DumpCommandHandler$handle$1", f = "DumpCommandHandler.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.service.command.DumpCommandHandler$handle$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ PrintWriter $writer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PrintWriter printWriter, c cVar) {
            super(2, cVar);
            this.$writer = printWriter;
        }

        @Override // h5.a
        public final c create(Object obj, c cVar) {
            return new AnonymousClass1(this.$writer, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, c cVar) {
            return ((AnonymousClass1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            a aVar = a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            try {
                this.$writer.println("\n--- Configuration ---");
                this.$writer.println("\n--- Statistics ---");
                this.$writer.flush();
            } catch (Exception e9) {
                this.$writer.println("Error during dump: " + e9.getMessage());
                e9.printStackTrace(this.$writer);
            }
            return a0.f883a;
        }
    }

    @Override // com.stepos.stepclaw.service.command.CommandHandler
    public String getCommandName() {
        return this.commandName;
    }

    @Override // com.stepos.stepclaw.service.command.CommandHandler
    public String getDescription() {
        return this.description;
    }

    @Override // com.stepos.stepclaw.service.command.CommandHandler
    public String getUsage() {
        return this.usage;
    }

    @Override // com.stepos.stepclaw.service.command.CommandHandler
    public void handle(Context context, PrintWriter writer, String[] args) {
        kotlin.jvm.internal.p.e(context, "context");
        kotlin.jvm.internal.p.e(writer, "writer");
        writer.println("=== StepClaw Service Dump ===");
        writer.println("Service Status: Running");
        writer.println("Current Time: " + System.currentTimeMillis());
        h6.e eVar = r0.f210a;
        i0.q(i0.b(d.f3059c), null, new AnonymousClass1(writer, null), 3);
    }

    @Override // com.stepos.stepclaw.service.command.CommandHandler
    public /* bridge */ void printHelp(PrintWriter printWriter) {
        super.printHelp(printWriter);
    }
}
