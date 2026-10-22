package com.android.server.am;

import android.app.ISysClient;
import android.os.DebugSmtEx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IAnrMonitor {
    default void monitorBroadcast(BroadcastRecord record) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void monitorBroadcast(BroadcastRecord record, int pid, int index, int timeout) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void monitorService(ServiceRecord record) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void monitorInput(int pid, String reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void monitorBindApp(int pid, int timeOut) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void cancelBindApp(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void monitorJobSchedule(int uid, String processName, long timeOut, int hashCode) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void cancelJobSchedule(int uid, String processName, int hashCode) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void cancelService(ServiceRecord record) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void cancelBroadcast(BroadcastRecord record) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void cancelBroadcast(BroadcastRecord record, int index) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notesBDTrack(String name, int track) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notesServiceTrack(ServiceRecord r, int track) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default String getMonitorInfo(String annotation, int pid, String processName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return "";
    }

    default void anrOccured(String annotation, int pid, String processName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void skipAnr(String annotation, int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void removeClient(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addClient(int pid, ISysClient client) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default ISysClient getClient(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default void getCpuTopInfo() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notesProcStatus(int pid, boolean interesting) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void noteProcBinderBlock(int pid, long binderStartTime, int count) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void checkSystemThreadsBinderBlock(List<Integer> threadsList) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifySWT(List<Integer> threadsIdList, List<String> threadNameList, String blockedSubject) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void handleUidSystemBinderProxys() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void registerObjectCountsMonitor(Class<?> clz, int counts, boolean recordCallStack, boolean recordCallUidPid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void unregisterObjectCountsMonitor(Class<?> clz) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyObjectCreate(Object obj) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void dumpObjectCounts(Class<?> clz, FileDescriptor fd, PrintWriter pw) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default long getDumpObjectCountsFlag() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default void dumpProcessThreadStack(int pid, int tid, boolean dumpLockOwnerTid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyAnrProcKilled(int clientPid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyInputFlingerTime(long elpaseTimeClocks) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyAppBindeDied(int pid, long elpaseTimeClocks) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyHangScreen(int pid, long logFlag, boolean notifyAnr, boolean killSelf, int hangType, ArrayList<String> filePathList) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyDataStorageLevel(int level) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
