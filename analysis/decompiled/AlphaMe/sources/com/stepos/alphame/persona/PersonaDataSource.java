package com.stepos.alphame.persona;

import android.database.Cursor;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.DataSource;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.utils.StringUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class PersonaDataSource extends DataSource {
    private static final byte[] ARGS_TYPE = {4, 6, 6, 6, 4, 6, 6, 6, 6, 5, 5, 5, 5, 5, 5, 5, 5};

    public PersonaDataSource(String str) {
        super(str);
    }

    @Override // com.stepos.alphame.data.DataSource
    public Storable createStorable() {
        return new PersonaStorable();
    }

    @Override // com.stepos.alphame.data.DataSource
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (strArr == null || strArr.length <= 2) {
            super.dump(fileDescriptor, printWriter, strArr);
            return;
        }
        if (this.mStorable == null) {
            super.dump(fileDescriptor, printWriter, strArr);
            return;
        }
        String str = strArr[2];
        if (str != null) {
            if ("delete".equals(str)) {
                ((PersonaStorable) this.mStorable).deleteLast();
                return;
            } else if ("rebuild".equals(strArr[2])) {
                return;
            }
        }
        store(true);
        try {
            DataItem dataItemCurrentItem = null;
            Cursor cursor = PersonaStorable.getCursor(null, null, "date desc", strArr[2]);
            if (cursor != null) {
                try {
                    if (cursor.getCount() != 0) {
                        String str2 = (strArr.length == 4 && "0".equals(strArr[3])) ? "】" : "";
                        cursor.moveToFirst();
                        do {
                            if (dataItemCurrentItem == null) {
                                dataItemCurrentItem = this.mStorable.currentItem(cursor);
                            } else {
                                this.mStorable.fillItem(cursor, dataItemCurrentItem);
                            }
                            PersonaDataItem personaDataItem = (PersonaDataItem) dataItemCurrentItem;
                            printWriter.println("--日期： " + StringUtil.formatDateWeek(personaDataItem.date) + str2);
                            printWriter.println("--天气： " + personaDataItem.weather + str2);
                            printWriter.println("--节日： " + personaDataItem.holiday + str2);
                            StringBuilder sb = new StringBuilder();
                            sb.append("--工作日： ");
                            sb.append(personaDataItem.day_off == 0 ? "是" : "否");
                            sb.append(str2);
                            printWriter.println(sb.toString());
                            printWriter.println("--家： " + personaDataItem.home + str2);
                            printWriter.println("--公司： " + personaDataItem.company + str2);
                            printWriter.println("--起床时间： " + StringUtil.formatDateFull(personaDataItem.rise_time) + str2);
                            printWriter.println("--出门时间： " + StringUtil.formatDateFull(personaDataItem.on_duty_time - personaDataItem.on_duty_cost) + str2);
                            printWriter.println("--上班时间： " + StringUtil.formatDateFull(personaDataItem.on_duty_time) + str2);
                            printWriter.println("--上班耗时： " + StringUtil.formatTimeMill(personaDataItem.on_duty_cost) + str2);
                            printWriter.println("--下班时间： " + StringUtil.formatDateFull(personaDataItem.off_duty_time) + str2);
                            printWriter.println("--下班耗时： " + StringUtil.formatTimeMill(personaDataItem.off_duty_cost) + str2);
                            printWriter.println("--回家时间： " + StringUtil.formatDateFull(personaDataItem.off_duty_time + personaDataItem.off_duty_cost) + str2);
                            printWriter.println("--睡眠时间： " + StringUtil.formatDateFull(personaDataItem.sleep_time) + str2);
                            printWriter.println("--睡眠耗时： " + StringUtil.formatTimeMill(personaDataItem.sleep_cost) + str2);
                            printWriter.println(str2);
                            printWriter.println("------------------------------------------------------------" + str2);
                            printWriter.println(str2);
                        } while (cursor.moveToNext());
                        cursor.close();
                        return;
                    }
                } finally {
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.stepos.alphame.data.DataSource
    public Class<? extends DataItem> getDataItemClass() {
        return PersonaDataItem.class;
    }

    @Override // com.stepos.alphame.data.DataSource
    public byte[] getFillArgsType() {
        return ARGS_TYPE;
    }
}
