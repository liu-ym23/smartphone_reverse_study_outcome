package com.android.server.power.teardown.swteardown;

import com.android.server.power.teardown.ComponentResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AlarmTeardownResult extends ComponentResult {
    public List<AlarmTeardownEntry> mEnterys;

    public static class AlarmTeardownEntry {
        public int mCount;

        /* JADX INFO: renamed from: mCurrentμA, reason: contains not printable characters */
        public int f0mCurrentA;
        public String mPackageName;
        public ArrayList<TagInfo> mTagInfoList;
        public int mUid;

        public static class TagInfo {
            public int mCount;
            public String mTag;

            TagInfo(String tag, int count) {
                this.mTag = tag;
                this.mCount = count;
            }
        }

        public AlarmTeardownEntry(int uid, String packageName, int count, int r5) {
            this.mTagInfoList = new ArrayList();
            this.mUid = uid;
            this.mPackageName = packageName;
            this.mCount = count;
            this.f0mCurrentA = r5;
        }

        public void addNewTagInfo(String tag, int count) {
            this.mTagInfoList.add(new TagInfo(tag, count));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Alarm [");
            sb.append("uid=");
            sb.append(this.mUid);
            sb.append(", packageName=");
            sb.append(this.mPackageName);
            sb.append(", count=");
            sb.append(this.mCount);
            sb.append(", current=");
            sb.append(this.f0mCurrentA);
            sb.append("μA]");
            boolean isFirst = true;
            Iterator<TagInfo> r3 = this.mTagInfoList.iterator();
        L4:
            if (r3.hasNext() == false) goto L9;
            TagInfo tagInfo = r3.next();
            if (isFirst == false) goto L8;
            sb.append(" Tag [");
        L8:
            sb.append("tag=");
            sb.append(tagInfo.mTag);
            sb.append(", count=");
            sb.append(tagInfo.mCount);
            sb.append(";");
            isFirst = false;
            goto L4
        L9:
            sb.append("]\n");
            return sb.toString();
        }
    }

    public AlarmTeardownResult(int r1, List<AlarmTeardownEntry> entrys) {
        this.mCurrent = r1;
        this.mEnterys = entrys;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Alarm]");
        sb.append("alarm current=");
        sb.append(this.mCurrent);
        sb.append("μA, \n");
        Iterator<AlarmTeardownEntry> r2 = this.mEnterys.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        AlarmTeardownEntry entry = r2.next();
        sb.append("[Alarm]");
        sb.append(entry.toString());
        goto L4
    L7:
        return sb.toString();
    }
}
