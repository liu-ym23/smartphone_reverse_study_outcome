package ch.qos.logback.core.status;

import com.stepos.alphame.awareness.AwarenessDataItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class StatusBase implements Status {
    private static final List<Status> EMPTY_LIST = new ArrayList(0);
    List<Status> childrenList;
    long date;
    int level;
    final String message;
    final Object origin;
    Throwable throwable;

    public StatusBase(int i4, String str, Object obj) {
        this(i4, str, obj, null);
    }

    @Override // ch.qos.logback.core.status.Status
    public synchronized void add(Status status) {
        try {
            if (status == null) {
                throw new NullPointerException("Null values are not valid Status.");
            }
            if (this.childrenList == null) {
                this.childrenList = new ArrayList();
            }
            this.childrenList.add(status);
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StatusBase statusBase = (StatusBase) obj;
        if (this.level != statusBase.level) {
            return false;
        }
        String str = this.message;
        if (str == null) {
            if (statusBase.message != null) {
                return false;
            }
        } else if (!str.equals(statusBase.message)) {
            return false;
        }
        return true;
    }

    @Override // ch.qos.logback.core.status.Status
    public Long getDate() {
        return Long.valueOf(this.date);
    }

    @Override // ch.qos.logback.core.status.Status
    public synchronized int getEffectiveLevel() {
        int i4;
        i4 = this.level;
        Iterator<Status> it = iterator();
        while (it.hasNext()) {
            int effectiveLevel = it.next().getEffectiveLevel();
            if (effectiveLevel > i4) {
                i4 = effectiveLevel;
            }
        }
        return i4;
    }

    @Override // ch.qos.logback.core.status.Status
    public int getLevel() {
        return this.level;
    }

    @Override // ch.qos.logback.core.status.Status
    public String getMessage() {
        return this.message;
    }

    @Override // ch.qos.logback.core.status.Status
    public Object getOrigin() {
        return this.origin;
    }

    @Override // ch.qos.logback.core.status.Status
    public Throwable getThrowable() {
        return this.throwable;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000f  */
    @Override // ch.qos.logback.core.status.Status
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean hasChildren() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.List<ch.qos.logback.core.status.Status> r0 = r1.childrenList     // Catch: java.lang.Throwable -> Ld
            if (r0 == 0) goto Lf
            int r0 = r0.size()     // Catch: java.lang.Throwable -> Ld
            if (r0 <= 0) goto Lf
            r0 = 1
            goto L10
        Ld:
            r0 = move-exception
            goto L12
        Lf:
            r0 = 0
        L10:
            monitor-exit(r1)
            return r0
        L12:
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.core.status.StatusBase.hasChildren():boolean");
    }

    public int hashCode() {
        int i4 = (this.level + 31) * 31;
        String str = this.message;
        return i4 + (str == null ? 0 : str.hashCode());
    }

    @Override // ch.qos.logback.core.status.Status
    public synchronized Iterator<Status> iterator() {
        List<Status> list = this.childrenList;
        if (list != null) {
            return list.iterator();
        }
        return EMPTY_LIST.iterator();
    }

    @Override // ch.qos.logback.core.status.Status
    public synchronized boolean remove(Status status) {
        List<Status> list = this.childrenList;
        if (list == null) {
            return false;
        }
        return list.remove(status);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int effectiveLevel = getEffectiveLevel();
        if (effectiveLevel == 0) {
            sb.append("INFO");
        } else if (effectiveLevel == 1) {
            sb.append("WARN");
        } else if (effectiveLevel == 2) {
            sb.append("ERROR");
        }
        if (this.origin != null) {
            sb.append(" in ");
            sb.append(this.origin);
            sb.append(" -");
        }
        sb.append(AwarenessDataItem.PERMISSION_SPLITTER);
        sb.append(this.message);
        if (this.throwable != null) {
            sb.append(AwarenessDataItem.PERMISSION_SPLITTER);
            sb.append(this.throwable);
        }
        return sb.toString();
    }

    public StatusBase(int i4, String str, Object obj, Throwable th) {
        this.level = i4;
        this.message = str;
        this.origin = obj;
        this.throwable = th;
        this.date = System.currentTimeMillis();
    }
}
