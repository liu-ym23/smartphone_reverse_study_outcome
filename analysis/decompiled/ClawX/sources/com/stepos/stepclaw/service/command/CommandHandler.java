package com.stepos.stepclaw.service.command;

import android.content.Context;
import com.stepos.stepclaw.SecurePrefs;
import java.io.PrintWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/service/command/CommandHandler;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "Ljava/io/PrintWriter;", "writer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "args", "Lb5/a0;", "handle", "(Landroid/content/Context;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "printHelp", "(Ljava/io/PrintWriter;)V", "getCommandName", "()Ljava/lang/String;", "commandName", "getDescription", "description", "getUsage", "usage", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface CommandHandler {

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void printHelp(CommandHandler commandHandler, PrintWriter writer) {
            p.e(writer, "writer");
            CommandHandler.super.printHelp(writer);
        }
    }

    String getCommandName();

    String getDescription();

    String getUsage();

    void handle(Context context, PrintWriter writer, String[] args);

    default void printHelp(PrintWriter writer) {
        p.e(writer, "writer");
        writer.println(getCommandName() + ":");
        writer.println("   " + getDescription());
        writer.println("   Usage: " + getUsage());
        writer.println();
    }
}
