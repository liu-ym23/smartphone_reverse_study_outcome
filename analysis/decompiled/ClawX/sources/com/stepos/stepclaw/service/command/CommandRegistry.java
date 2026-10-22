package com.stepos.stepclaw.service.command;

import android.content.Context;
import c5.l;
import c5.m;
import c5.n;
import com.stepos.stepclaw.SecurePrefs;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\t\"\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0015\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r\u0018\u00010\t¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001b¢\u0006\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/stepclaw/service/command/CommandRegistry;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Lcom/stepos/stepclaw/service/command/CommandHandler;", "handler", "Lb5/a0;", "register", "(Lcom/stepos/stepclaw/service/command/CommandHandler;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "handlerList", "registerAll", "([Lcom/stepos/stepclaw/service/command/CommandHandler;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "command", "getHandler", "(Ljava/lang/String;)Lcom/stepos/stepclaw/service/command/CommandHandler;", "Landroid/content/Context;", "context", "Ljava/io/PrintWriter;", "writer", "args", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "execute", "(Landroid/content/Context;Ljava/io/PrintWriter;[Ljava/lang/String;)Z", "printHelp", "(Ljava/io/PrintWriter;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getRegisteredCommands", "()Ljava/util/Set;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "handlers", "Ljava/util/Map;", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CommandRegistry {
    private final Map<String, CommandHandler> handlers = new LinkedHashMap();

    public final boolean execute(Context context, PrintWriter writer, String[] args) {
        String str;
        p.e(context, "context");
        p.e(writer, "writer");
        if (args == null || (str = (String) l.f0(args, 0)) == null) {
            str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (str.length() == 0) {
            printHelp(writer);
            return true;
        }
        CommandHandler commandHandler = this.handlers.get(str);
        if (commandHandler != null) {
            commandHandler.handle(context, writer, args);
            return true;
        }
        writer.println("Unknown command: ".concat(str));
        printHelp(writer);
        return false;
    }

    public final CommandHandler getHandler(String command) {
        p.e(command, "command");
        return this.handlers.get(command);
    }

    public final Set<String> getRegisteredCommands() {
        return m.R0(this.handlers.keySet());
    }

    public final void printHelp(PrintWriter writer) {
        p.e(writer, "writer");
        writer.println("=== Lonicera Service Commands ===");
        writer.println();
        writer.println("Available commands:");
        writer.println();
        int i8 = 0;
        for (Object obj : this.handlers.values()) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                n.m0();
                throw null;
            }
            CommandHandler commandHandler = (CommandHandler) obj;
            writer.println(i9 + ". " + commandHandler.getCommandName());
            String description = commandHandler.getDescription();
            StringBuilder sb = new StringBuilder("   ");
            sb.append(description);
            writer.println(sb.toString());
            writer.println("   Usage: " + commandHandler.getUsage());
            writer.println();
            i8 = i9;
        }
        writer.flush();
    }

    public final void register(CommandHandler handler) {
        p.e(handler, "handler");
        this.handlers.put(handler.getCommandName(), handler);
    }

    public final void registerAll(CommandHandler... handlerList) {
        p.e(handlerList, "handlerList");
        for (CommandHandler commandHandler : handlerList) {
            register(commandHandler);
        }
    }
}
