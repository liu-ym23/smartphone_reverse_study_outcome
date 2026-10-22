package com.stepos.alphame.bluetooth;

import androidx.room.AbstractC0351g;
import com.alibaba.fastjson.JSON;
import com.stepos.alphame.scene.SceneDetectorEngine;
import com.stepos.alphame.utils.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class BluetoothRecord {
    private static final String FAILED = "FAILED";
    private String address;
    private String name;
    private String parkingAddress;
    private String parkingLocation;
    private long parkingTime;
    private String startAddress;
    private String startLocation;
    private long startTime;
    private int startStepCount = -1;
    private int parkingStepCount = -1;
    private int possibility = 0;
    private List<String> updateRecord = new ArrayList();
    private List<AppRecord> appRecords = new ArrayList();

    public class AppRecord {
        String pkgName;
        long startTime;

        public AppRecord(String str, long j4) {
            this.pkgName = str;
            this.startTime = j4;
        }
    }

    public static BluetoothRecord fromJsonString(String str) {
        return (BluetoothRecord) JSON.parseObject(str).toJavaObject(BluetoothRecord.class);
    }

    public synchronized void addAppRecord(String str, long j4) {
        this.appRecords.add(new AppRecord(str, j4));
    }

    public void addUpdateRecord(String str) {
        this.updateRecord.add(str);
    }

    public void addUpdateRecords(List<String> list) {
        this.updateRecord.addAll(0, list);
    }

    public String getAddress() {
        return this.address;
    }

    public String getName() {
        return this.name;
    }

    public String getParkingAddress() {
        return this.parkingAddress;
    }

    public String getParkingLocation() {
        return this.parkingLocation;
    }

    public int getParkingStepCount() {
        return this.parkingStepCount;
    }

    public long getParkingTime() {
        return this.parkingTime;
    }

    public synchronized long getPlayTime() {
        long j4;
        AppRecord appRecord = null;
        j4 = 0;
        for (AppRecord appRecord2 : this.appRecords) {
            if (appRecord != null && !SceneDetectorEngine.isScreenOff(appRecord.pkgName) && !SceneDetectorEngine.isScreenLocked(appRecord.pkgName) && !SceneDetectorEngine.getInstance().isNavi(appRecord.pkgName)) {
                j4 += appRecord2.startTime - appRecord.startTime;
            }
            appRecord = appRecord2;
        }
        return j4;
    }

    public int getPossibility() {
        return this.possibility;
    }

    public String getStartAddress() {
        return this.startAddress;
    }

    public String getStartLocation() {
        return this.startLocation;
    }

    public int getStartStepCount() {
        return this.startStepCount;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setFailed() {
        setParkingAddress(FAILED);
        setParkingLocation(null);
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setParkingAddress(String str) {
        this.parkingAddress = str;
    }

    public void setParkingLocation(String str) {
        this.parkingLocation = str;
    }

    public void setParkingStepCount(int i4) {
        this.parkingStepCount = i4;
    }

    public void setParkingTime(long j4) {
        this.parkingTime = j4;
    }

    public void setPossibility(int i4) {
        this.possibility = i4;
    }

    public void setStartAddress(String str) {
        this.startAddress = str;
    }

    public void setStartLocation(String str) {
        this.startLocation = str;
    }

    public void setStartStepCount(int i4) {
        this.startStepCount = i4;
    }

    public void setStartTime(long j4) {
        this.startTime = j4;
    }

    public String toDetailString() {
        String string = toString();
        Iterator<String> it = this.updateRecord.iterator();
        while (it.hasNext()) {
            string = AbstractC0351g.q(string, "\n**  ", it.next());
        }
        return string;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public String toString() {
        return "name = " + this.name + ", address = " + this.address + ", possibility = " + this.possibility + ", start = " + this.startAddress + " at " + StringUtil.formatDateFull(this.startTime) + ", parking = " + this.parkingAddress + " at " + StringUtil.formatDateFull(this.parkingTime) + ", playTime = " + StringUtil.formatTimeMill(getPlayTime()) + "/" + StringUtil.formatTimeMill(this.parkingTime - this.startTime);
    }

    public void addUpdateRecords(BluetoothRecord bluetoothRecord) {
        this.updateRecord.addAll(0, bluetoothRecord.updateRecord);
    }
}
